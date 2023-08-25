package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.apimodules.*;

import java.util.HashMap;
import java.util.Map;

public class ADS extends AMPAPI {
    public final ADSModule ADSModule = new ADSModule(this);
    public final CommonCorePlugin CommonCorePlugin = new CommonCorePlugin(this);
    public final Core Core = new Core(this);
    public final EmailSenderPlugin EmailSenderPlugin = new EmailSenderPlugin(this);
    public final FileManagerPlugin FileManagerPlugin = new FileManagerPlugin(this);
    public final LocalFileBackupPlugin LocalFileBackupPlugin = new LocalFileBackupPlugin(this);

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
    public Map<?,?> Login() {
        Map<?, ?> loginResult = super.Login();
        String rememberMeToken = "";
        String sessionId = "";

        if (loginResult != null && loginResult.containsKey("success") && (boolean) loginResult.get("success")) {
            rememberMeToken = (String) loginResult.get("rememberMeToken");
            sessionId = (String) loginResult.get("sessionID");
        }

        // Update the session ID and remember me token of submodules
        this.ADSModule.sessionId = sessionId;
        this.ADSModule.rememberMeToken = rememberMeToken;
        this.CommonCorePlugin.sessionId = sessionId;
        this.CommonCorePlugin.rememberMeToken = rememberMeToken;
        this.Core.sessionId = sessionId;
        this.Core.rememberMeToken = rememberMeToken;
        this.EmailSenderPlugin.sessionId = sessionId;
        this.EmailSenderPlugin.rememberMeToken = rememberMeToken;
        this.FileManagerPlugin.sessionId = sessionId;
        this.FileManagerPlugin.rememberMeToken = rememberMeToken;
        this.LocalFileBackupPlugin.sessionId = sessionId;
        this.LocalFileBackupPlugin.rememberMeToken = rememberMeToken;

        return loginResult;
    }

    /**
     * Proxies a login request to an instance and returns a new AMPAPIHandler for that instance.
     * @param instance_id The instance ID of the instance to log in to
     * @return A new AMPAPIHandler for the instance
     */
    public AMPAPI InstanceLogin(String instance_id) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", this.username);
        args.put("password", this.password);
        args.put("token", "");
        args.put("rememberMe", true);
        Map<String, Object> loginResult = (Map<String, Object>) this.APICall("ADSModule/Servers/" + instance_id + "/API/Core/Login", args);

        if (loginResult != null && (boolean) loginResult.get("success")) {
            return new AMPAPI(this.baseUri + "API/ADSModule/Servers/" + instance_id, this.username, "", (String) loginResult.get("rememberMeToken"), (String) loginResult.get("sessionID"));
        } else {
            return null;
        }
    }

    /**
     * Proxies a login request to an instance and returns a new AMPAPIHandler for that instance.
     * @param instance_id The instance ID of the instance to log in to
     * @param moduleClass The class of the module to return
     * @return A new AMPAPIHandler for the instance
     */
    public <T> T InstanceLogin(String instance_id, Class<T> moduleClass) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", this.username);
        args.put("password", this.password);
        args.put("token", "");
        args.put("rememberMe", true);

        Map<String, Object> loginResult = (Map<String, Object>) this.APICall("ADSModule/Servers/" + instance_id + "/API/Core/Login", args);

        if (loginResult != null && (boolean) loginResult.get("success")) {
            // Prepare the parameters for the instance
            String newBaseUri = this.baseUri + "API/ADSModule/Servers/" + instance_id;
            String rememberMeToken = (String) loginResult.get("rememberMeToken");
            String sessionId = (String) loginResult.get("sessionID");

            // Return the correct module
            if (Minecraft.class.equals(moduleClass)) {
                return (T) new Minecraft(newBaseUri, this.username, "", rememberMeToken, sessionId);
            } else if (GenericModule.class.equals(moduleClass)) {
                return (T) new GenericModule(newBaseUri, this.username, "", rememberMeToken, sessionId);
            }
            return (T) new AMPAPI(newBaseUri, this.username, "", rememberMeToken, sessionId);
        } else {
            return null;
        }
    }

    /**
     * Proxies a login request to an instance and returns a new AMPAPIHandler for that instance.
     * @param instance_id The instance ID of the instance to log in to
     * @param module The module to log in to
     * @return A new AMPAPIHandler for the instance
     */
    public AMPAPI InstanceLogin(String instance_id, String module) {
        if (module.equals("GenericModule")) {
            return this.InstanceLogin(instance_id, GenericModule.class);
        } else if (module.equals("Minecraft")) {
            return this.InstanceLogin(instance_id, Minecraft.class);
        } else {
            return this.InstanceLogin(instance_id);
        }
    }
}
