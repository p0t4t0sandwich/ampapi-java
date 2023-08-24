package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.AMPAPIBase;
import dev.neuralnexus.ampapi.apimodules.*;

import java.util.Map;

public class GenericModule extends AMPAPIBase {
    public final CommonCorePlugin CommonCorePlugin = new CommonCorePlugin(this);
    public final Core Core = new Core(this);
    public final EmailSenderPlugin EmailSenderPlugin = new EmailSenderPlugin(this);
    public final FileManagerPlugin FileManagerPlugin = new FileManagerPlugin(this);
    public final LocalFileBackupPlugin LocalFileBackupPlugin = new LocalFileBackupPlugin(this);
    public final RCONPlugin RCONPlugin = new RCONPlugin(this);
    public final steamcmdplugin steamcmdplugin = new steamcmdplugin(this);

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
    public GenericModule(String baseUri, String username, String password, String rememberMeToken, String sessionId) {
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
        this.RCONPlugin.sessionId = sessionId;
        this.RCONPlugin.rememberMeToken = rememberMeToken;
        this.steamcmdplugin.sessionId = sessionId;
        this.steamcmdplugin.rememberMeToken = rememberMeToken;

        return loginResult;
    }
}
