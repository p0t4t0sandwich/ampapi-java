package dev.neuralnexus.ampapi.auth;

import dev.neuralnexus.ampapi.HTTPReq;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * AuthProvider implementation for refreshing auth sessions with long-running processes
 */
public class RefreshingAuthProvider extends BasicAuthProvider {
    private final int relogInterval;
    private long lastCall = System.currentTimeMillis();

    RefreshingAuthProvider(String dataSource, String requestMethod, String username, String password, String token, boolean rememberMe, String sessionId, int relogInterval) {
        super(dataSource, requestMethod, username, password, token, rememberMe, sessionId);
        this.relogInterval = relogInterval;
    }

    @Override
    public <T> T APICall(String endpoint, Map<String, Object> args, Type returnType) {
        long now = System.currentTimeMillis();
        if (now - this.lastCall > this.relogInterval) {
            this.Login();
            //
            System.out.println("RefreshingAuthProvider.APICall: Relogging");
            //
        }
        //
        System.out.println("RefreshingAuthProvider.APICall: " + endpoint);
        System.out.println("RefreshingAuthProvider.APICall session: " + this.sessionId);
        //
        this.lastCall = now;
        if (this.sessionId.isEmpty()) {
            this.Login();
        }
        args.put("SESSIONID", this.sessionId);
        return HTTPReq.APICall(this.dataSource + endpoint, this.requestMethod, args, returnType);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends BasicAuthProvider.Builder {
        private boolean rememberMe = true;
        private int relogInterval = 1000 * 60 * 5;

        public Builder relogInterval(int relogInterval) {
            this.relogInterval = relogInterval;
            return this;
        }

        @Override
        public Builder rememberMe(boolean rememberMe) {
            this.rememberMe = rememberMe;
            return this;
        }

        @Override
        public AuthProvider build() {
            if (this.dataSource.isEmpty()) {
                throw new IllegalStateException("Base panel URL must be defined");
            }
            if (this.username.isEmpty()) {
                throw new IllegalStateException("Username must be defined for refreshing auth");
            }
            if (this.password.isEmpty() && this.token.isEmpty()) {
                throw new IllegalStateException("You must provide a Password or a valid RememberMe Token for refreshing auth");
            }
            return new RefreshingAuthProvider(this.dataSource, this.requestMethod, this.username, this.password, this.token, this.rememberMe, this.sessionId, this.relogInterval);
        }
    }
}
