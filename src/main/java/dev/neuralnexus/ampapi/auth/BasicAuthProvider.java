package dev.neuralnexus.ampapi.auth;

import dev.neuralnexus.ampapi.HTTPReq;
import dev.neuralnexus.ampapi.types.LoginResult;
import dev.neuralnexus.ampapi.types.ModuleInfo;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * AuthProvider implementation for basic single-session logins
 */
public class BasicAuthProvider implements AuthProvider {
    private final String dataSource;
    private final String requestMethod;
    private final String username;
    private final String password;
    private String token;
    private String sessionId;
    private String instanceName = "";
    private UUID instanceId = null;

    BasicAuthProvider(String dataSource, String requestMethod, String username, String password, String token, String sessionId) {
        this.dataSource = dataSource;
        this.requestMethod = requestMethod;
        this.username = username;
        this.password = password;
        this.token = token;
        this.sessionId = sessionId;
    }

    @Override
    public String dataSource() {
        return this.dataSource;
    }

    @Override
    public String username() {
        return this.username;
    }

    @Override
    public String password() {
        return this.password;
    }

    @Override
    public String token() {
        return this.token;
    }

    @Override
    public String sessionId() {
        return this.sessionId;
    }

    private void UpdateModuleInfo() {
        ModuleInfo info = this.APICall("Core/GetModuleInfo", ModuleInfo.class);
        this.instanceName = info.InstanceName;
        this.instanceId = info.InstanceId;
    }

    @Override
    public String instanceName() {
        if (this.instanceName.isEmpty()) {
            this.UpdateModuleInfo();
        }
        return this.instanceName;
    }

    @Override
    public UUID instanceId() {
        if (this.instanceId == null) {
            this.UpdateModuleInfo();
        }
        return this.instanceId;
    }

    @Override
    public <T> T APICall(String endpoint, Map<String, Object> args, Type returnType) {
        if (this.sessionId.isEmpty()) {
            this.Login();
        }
        args.put("SESSIONID", this.sessionId);
        return HTTPReq.APICall(this.dataSource + endpoint, requestMethod, args, returnType);
    }

    @Override
    public LoginResult Login(boolean rememberMe) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", this.username);
        args.put("password", this.password);
        args.put("token", this.token);
        args.put("rememberMe", rememberMe);

        LoginResult loginResult = HTTPReq.APICall(this.dataSource + "Core/Login", requestMethod, args, LoginResult.class);

        if (loginResult != null && loginResult.success) {
            this.token = loginResult.rememberMeToken;
            this.sessionId = loginResult.sessionID;
        }
        return loginResult;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder implements AuthProvider.Builder {
        private String dataSource = "";
        private String requestMethod = "POST";
        private String username = "";
        private String password = "";
        private String token = "";
        private String sessionId = "";

        @Override
        public AuthProvider.Builder panelUrl(String panelUrl) {
            if (!panelUrl.endsWith("/")) {
                panelUrl += "/";
            }
            this.dataSource = panelUrl + "API/";
            return this;
        }

        @Override
        public AuthProvider.Builder panelUrl(URL panelUrl) {
            this.panelUrl(panelUrl.toString());
            return this;
        }

        @Override
        public AuthProvider.Builder requestMethod(String requestMethod) {
            this.requestMethod = requestMethod;
            return this;
        }

        public AuthProvider.Builder username(String username) {
            this.username = username;
            return this;
        }

        @Override
        public AuthProvider.Builder password(String password) {
            this.password = password;
            return this;
        }

        @Override
        public AuthProvider.Builder token(String token) {
            this.token = token;
            return this;
        }

        @Override
        public AuthProvider.Builder token(UUID token) {
            this.token = token.toString();
            return this;
        }

        @Override
        public AuthProvider.Builder token(int token) {
            this.token = Integer.toString(token);
            return this;
        }

        @Override
        public AuthProvider.Builder sessionId(String sessionId) {
            this.sessionId = sessionId;
            return this;
        }

        @Override
        public AuthProvider.Builder sessionId(UUID sessionId) {
            this.sessionId = sessionId.toString();
            return this;
        }

        @Override
        public AuthProvider build() {
            if (this.dataSource.isEmpty()) {
                throw new IllegalStateException("Base panel URL must be defined");
            }
            if (this.username.isEmpty() && this.sessionId.isEmpty()) {
                throw new IllegalStateException("Username must be defined");
            }
            if (this.password.isEmpty() && this.token.isEmpty() && this.sessionId.isEmpty()) {
                throw new IllegalStateException("You must provide a Password, Token, or a SessionId");
            }
            return new BasicAuthProvider(this.dataSource, this.requestMethod, this.username, this.password, this.token, this.sessionId);
        }
    }
}
