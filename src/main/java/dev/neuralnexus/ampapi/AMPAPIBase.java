package dev.neuralnexus.ampapi;

import java.util.HashMap;
import java.util.Map;

public class AMPAPIBase extends APIHandler {
    public String username;
    public String password;
    public String rememberMeToken;
    public String sessionId;

    /**
     * Constructor for AMPAPIHandler
     * @param baseUri The base URI of the AMP instance
     */
    public AMPAPIBase(String baseUri) {
        super(baseUri);
    }

    /**
     * Constructor for AMPAPIHandler
     * @param apiBase The APIBase to copy
     */
    public AMPAPIBase(AMPAPIBase apiBase) {
        super(apiBase.baseUri);
        this.username = apiBase.username;
        this.password = apiBase.password;
        this.rememberMeToken = apiBase.rememberMeToken;
        this.sessionId = apiBase.sessionId;
    }

    /**
     * Constructor for AMPAPIHandler
     * @param baseUri The base URI of the AMP instance
     * @param username The username to log in with
     * @param password The password to log in with
     * @param rememberMeToken The rememberMeToken to log in with
     *                        (if you don't have one, use an empty string)
     * @param sessionId The session ID to log in with
     *                  (if you don't have one, use an empty string)
     */
    public AMPAPIBase(String baseUri, String username, String password, String rememberMeToken, String sessionId) {
        super(baseUri);
        if (!this.baseUri.endsWith("/")) {
            this.baseUri += "/";
        }
        this.username = username;
        this.password = password;
        this.rememberMeToken = rememberMeToken;
        this.sessionId = sessionId;
    }

    /**
     * General API call method.
     * @param endpoint The endpoint to call.
     * @param data The data to send.
     */
    public <T> T APICall(String endpoint, Map<String, Object> data, Class<T> returnClass) {
        data.put("SESSIONID", this.sessionId);
        return this.APICall(endpoint, "POST", data, returnClass);
    }

    /**
     * General API call method.
     * @param endpoint The endpoint to call.
     * @param data The data to send.
     */
    public Map<?,?> APICall(String endpoint, Map<String, Object> data) {
        return this.APICall(endpoint, data, Map.class);
    }

    /**
     * General API call method.
     * @param endpoint The endpoint to call.
     */
    public Map<?,?> APICall(String endpoint) {
        return (Map<?, ?>) this.APICall(endpoint, new HashMap<>(), Map.class);
    }

    /**
     * Simplified login function
     * @return The result of the login
     */
    public Map<?, ?> Login() {
        Map<String, Object> args = new HashMap<>();
        args.put("username", this.username);
        args.put("password", this.password);
        args.put("token", this.rememberMeToken);
        args.put("rememberMe", true);
        Map<String, Object> loginResult = (Map<String, Object>) this.APICall("Core/Login", args);
        if (loginResult != null && loginResult.containsKey("success") && (boolean) loginResult.get("success")) {
            this.rememberMeToken = (String) loginResult.get("rememberMeToken");
            this.sessionId = (String) loginResult.get("sessionID");
        }
        return loginResult;
    }
}
