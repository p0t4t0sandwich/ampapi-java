package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.apimodules.*;
import dev.neuralnexus.ampapi.types.LoginResult;

public class GenericModule extends CommonAPI {
    public RCONPlugin RCONPlugin = new RCONPlugin(this);
    public steamcmdplugin steamcmdplugin = new steamcmdplugin(this);

    /**
     * Constructor
     *
     * @param baseUri The base URI of the AMP instance
     * @param username The username to log in with
     * @param password The password to log in with
     * @param rememberMeToken The rememberMeToken to log in with (if you don't have one, use an
     *     empty string)
     * @param sessionId The session ID to log in with (if you don't have one, use an empty string)
     */
    public GenericModule(
            String baseUri,
            String username,
            String password,
            String rememberMeToken,
            String sessionId) {
        super(baseUri, username, password, rememberMeToken, sessionId);
        this.Login();
    }

    /**
     * Simplified login function
     *
     * @return The result of the login
     */
    public LoginResult Login() {
        LoginResult loginResult = super.Login();

        if (loginResult != null && loginResult.success) {
            this.rememberMeToken = loginResult.rememberMeToken;
            this.sessionId = loginResult.sessionID;

            // Update the session ID and remember me token of submodules
            if (this.RCONPlugin == null) {
                this.RCONPlugin = new RCONPlugin(this);
            }
            if (this.steamcmdplugin == null) {
                this.steamcmdplugin = new steamcmdplugin(this);
            }

            this.RCONPlugin.sessionId = this.sessionId;
            this.RCONPlugin.rememberMeToken = this.rememberMeToken;
            this.steamcmdplugin.sessionId = this.sessionId;
            this.steamcmdplugin.rememberMeToken = this.rememberMeToken;
        }

        return loginResult;
    }
}
