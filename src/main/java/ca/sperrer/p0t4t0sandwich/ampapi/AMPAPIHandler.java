package ca.sperrer.p0t4t0sandwich.ampapi;

import java.util.HashMap;
import java.util.Map;

public class AMPAPIHandler extends AMPAPI {
    String username = "";
    String password = "";
    String rememberMeToken = "";

    public AMPAPIHandler(String baseUri, String username, String password, String rememberMeToken, String sessionId) {
        super(baseUri);
        this.username = username;
        this.password = password;
        this.rememberMeToken = rememberMeToken;
        this.sessionId = username;

    }

    public Map Login() {
        Map loginResult = this.Core_Login(this.username, this.password, this.rememberMeToken, true);
        if (loginResult != null && (boolean) loginResult.get("success")) {
            this.rememberMeToken = (String) loginResult.get("rememberMeToken");
            this.sessionId = (String) loginResult.get("sessionID");
        }
        return loginResult;
    }

    public Map InstanceAPICall(String instance_id, String endpoint, Map args) {
        return this.APICall("/ADSModule/Servers/" + instance_id + endpoint, args);
    }

    public AMPAPIHandler InstanceLogin(String instance_id) {
        Map args = new HashMap<>();
        args.put("username", this.username);
        args.put("password", this.password);
        args.put("token", "");
        args.put("rememberMe", true);
        Map loginResult = this.InstanceAPICall(instance_id, "/API/Core/Login", args);

        if (loginResult != null && (boolean) loginResult.get("success")) {
            return new AMPAPIHandler(this.baseUri + "API/ADSModule/Servers/" + instance_id, this.username, "", (String) loginResult.get("rememberMeToken"), (String) loginResult.get("sessionID"));
        } else {
            return null;
        }
    }
}