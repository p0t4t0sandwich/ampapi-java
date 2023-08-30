package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.apimodules.*;
import dev.neuralnexus.ampapi.types.LoginResult;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ADS extends CommonAPI {
    public ADSModule ADSModule = new ADSModule(this);

    /**
     * Constructor
     * @param baseUri The base URI of the AMP instance
     * @param username The username to log in with
     * @param password The password to log in with
     * @param rememberMeToken The rememberMeToken to log in with
     *                        (if you don't have one, use an empty string)
     * @param sessionId The session ID to log in with
     *                  (if you don't have one, use an empty string)
     */
    public ADS(String baseUri, String username, String password, String rememberMeToken, String sessionId) {
        super(baseUri, username, password, rememberMeToken, sessionId);
        this.Login();
    }

    /**
     * Simplified login function
     * @return The result of the login
     */
    public LoginResult Login() {
        LoginResult loginResult = super.Login();

        if (loginResult != null && loginResult.success) {
            this.rememberMeToken = loginResult.rememberMeToken;
            this.sessionId = loginResult.sessionID;

            // Update the session ID and remember me token of submodules
            if (this.ADSModule == null) {
                this.ADSModule = new ADSModule(this);
            }

            this.ADSModule.sessionId = this.sessionId;
            this.ADSModule.rememberMeToken = this.rememberMeToken;
        }

        return loginResult;
    }

    /**
     * Proxies a login request to an instance and returns a new AMPAPIHandler for that instance.
     * @param instanceId The instance ID of the instance to log in to
     * @return A new AMPAPIHandler for the instance
     */
    public CommonAPI InstanceLogin(UUID instanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", this.username);
        args.put("password", this.password);
        args.put("token", "");
        args.put("rememberMe", true);
        LoginResult loginResult = (LoginResult) this.APICall("ADSModule/Servers/" + instanceId + "/API/Core/Login", args, LoginResult.class);

        if (loginResult != null && loginResult.success) {
            return new CommonAPI(this.baseUri + "API/ADSModule/Servers/" + instanceId, this.username, "", loginResult.rememberMeToken, loginResult.sessionID);
        } else {
            return null;
        }
    }

    /**
     * Proxies a login request to an instance and returns a new AMPAPIHandler for that instance.
     * @param instanceId The instance ID of the instance to log in to
     * @param moduleClass The class of the module to return
     * @return A new AMPAPIHandler for the instance
     */
    public <T> T InstanceLogin(UUID instanceId, Class<T> moduleClass) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", this.username);
        args.put("password", this.password);
        args.put("token", "");
        args.put("rememberMe", true);

        LoginResult loginResult = (LoginResult) this.APICall("ADSModule/Servers/" + instanceId + "/API/Core/Login", args, LoginResult.class);

        if (loginResult != null && loginResult.success) {
            // Prepare the parameters for the instance
            String newBaseUri = this.baseUri + "API/ADSModule/Servers/" + instanceId;
            String rememberMeToken = loginResult.rememberMeToken;
            String sessionId = loginResult.sessionID;

            // Return the correct module
            if (ADS.class.equals(moduleClass)) {
                return (T) new ADS(newBaseUri, this.username, "", rememberMeToken, sessionId);
            } else if (Minecraft.class.equals(moduleClass)) {
                return (T) new Minecraft(newBaseUri, this.username, "", rememberMeToken, sessionId);
            } else if (GenericModule.class.equals(moduleClass)) {
                return (T) new GenericModule(newBaseUri, this.username, "", rememberMeToken, sessionId);
            }
            return (T) new CommonAPI(newBaseUri, this.username, "", rememberMeToken, sessionId);
        } else {
            return null;
        }
    }

    /**
     * Proxies a login request to an instance and returns a new AMPAPIHandler for that instance.
     * @param instanceId The instance ID of the instance to log in to
     * @param module The module to log in to
     * @return A new AMPAPIHandler for the instance
     */
    public CommonAPI InstanceLogin(UUID instanceId, String module) {
        switch (module) {
            case "ADS":
                return this.InstanceLogin(instanceId, ADS.class);
            case "GenericModule":
                return this.InstanceLogin(instanceId, GenericModule.class);
            case "Minecraft":
                return this.InstanceLogin(instanceId, Minecraft.class);
            default:
                return this.InstanceLogin(instanceId);
        }
    }
}
