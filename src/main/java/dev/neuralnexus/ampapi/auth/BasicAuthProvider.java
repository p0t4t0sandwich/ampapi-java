package dev.neuralnexus.ampapi.auth;

import dev.neuralnexus.ampapi.HTTPReq;
import dev.neuralnexus.ampapi.types.LoginResult;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * AuthProvider implementation for basic single-session logins
 */
public class BasicAuthProvider implements AuthProvider {
    public final String dataSource;
    public final String username;
    public final String password;
    public String token;
    public String sessionId;

    BasicAuthProvider(String dataSource, String username, String password, String token, String sessionId) {
        this.dataSource = dataSource;
        this.username = username;
        this.password = password;
        this.token = token;
        this.sessionId = sessionId;
    }

    @Override
    public Object APICall(String endpoint, String requestMethod, Map<String, Object> data, Type returnType) {
        if (this.sessionId.isEmpty()) {
            this.Login();
        }
        data.put("SESSIONID", this.sessionId);
        return HTTPReq.APICall(endpoint, requestMethod, data, returnType);
    }

    @Override
    public void Login(boolean rememberMe) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", this.username);
        args.put("password", this.password);
        args.put("token", this.token);
        args.put("rememberMe", rememberMe);

        LoginResult loginResult = HTTPReq.APICall("Core/Login", "POST", args, LoginResult.class);

        if (loginResult != null && loginResult.success) {
            this.token = loginResult.rememberMeToken;
            this.sessionId = loginResult.sessionID;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder implements AuthProvider.Builder {
        private String dataSource = "";
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
            if (this.username.isEmpty()) {
                throw new IllegalStateException("Username must be defined");
            }
            if (this.password.isEmpty() && this.token.isEmpty()) {
                throw new IllegalStateException("You must user either a Password or a Token");
            }
            return new BasicAuthProvider(this.dataSource, this.username, this.password, this.token, this.sessionId);
        }
    }
}
