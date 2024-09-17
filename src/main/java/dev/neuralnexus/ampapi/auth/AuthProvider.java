package dev.neuralnexus.ampapi.auth;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.Map;
import java.util.UUID;

/**
 * Generalized Auth Provider for working with AMP instances
 */
public interface AuthProvider {

    Object APICall(String endpoint, String requestMethod, Map<String, Object> data, Type returnType);

    /**
     * Simplified login function
     */
    void Login(boolean rememberMe);

    default void Login() {
        this.Login(false);
    }

    interface Builder {
        /**
         * Sets the panelUrl property (required)
         * @param panelUrl The panel URL to connect to
         */
        Builder panelUrl(String panelUrl);

        /**
         * Sets the panelUrl property (required)
         * @param panelUrl The panel URL to connect to
         */
        Builder panelUrl(URL panelUrl);

        /**
         * Sets the username property (required)
         * @param username The username to use
         */
        Builder username(String username);

        /**
         * Sets the password property (required when not using a one-use or rememberMe token)
         * @param password The password to use
         */
        Builder password(String password);

        /**
         * Sets the token property (required when not using a password, or for 2FA)
         * @param token The token to use
         */
        Builder token(String token);

        /**
         * Sets the token property (required when not using a password, or for 2FA)
         * @param token The token to use
         */
        Builder token(UUID token);

        /**
         * Sets the token property (required when not using a password, or for 2FA)
         * @param token The token to use
         */
        Builder token(int token);

        /**
         * Sets the sessionId property (optional)
         * @param sessionId The sessionId to use
         */
        AuthProvider.Builder sessionId(String sessionId);

        /**
         * Sets the sessionId property (optional)
         * @param sessionId The sessionId to use
         */
        AuthProvider.Builder sessionId(UUID sessionId);

        AuthProvider build();
    }
}
