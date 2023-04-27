package ca.sperrer.p0t4t0sandwich.ampapi;

import java.util.HashMap;
import java.util.Map;

public class AMPAPIHandler extends AMPAPI {
    String username;
    String password;
    String rememberMeToken;

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
    public AMPAPIHandler(String baseUri, String username, String password, String rememberMeToken, String sessionId) {
        super(baseUri);
        this.username = username;
        this.password = password;
        this.rememberMeToken = rememberMeToken;
        this.sessionId = sessionId;
    }

    /**
     * Simplified login function
     * @return The result of the login
     */
    public Map<?, ?> Login() {
        Map<Object, Object> loginResult = (Map<Object, Object>) this.Core_Login(this.username, this.password, this.rememberMeToken, true);
        if (loginResult != null && (boolean) loginResult.get("success")) {
            this.rememberMeToken = (String) loginResult.get("rememberMeToken");
            this.sessionId = (String) loginResult.get("sessionID");
        }
        return loginResult;
    }

    /**
     * Proxies a login request to an instance and returns a new AMPAPIHandler for that instance.
     * @param instance_id The instance ID of the instance to log in to
     * @return A new AMPAPIHandler for the instance
     */
    public AMPAPIHandler InstanceLogin(String instance_id) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", this.username);
        args.put("password", this.password);
        args.put("token", "");
        args.put("rememberMe", true);
        Map<String, Object> loginResult = (Map<String, Object>) this.APICall("/ADSModule/Servers/" + instance_id + "/API/Core/Login", args);

        if (loginResult != null && (boolean) loginResult.get("success")) {
            return new AMPAPIHandler(this.baseUri + "API/ADSModule/Servers/" + instance_id, this.username, "", (String) loginResult.get("rememberMeToken"), (String) loginResult.get("sessionID"));
        } else {
            return null;
        }
    }
}