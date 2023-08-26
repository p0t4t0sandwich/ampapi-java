package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.apimodules.*;
import dev.neuralnexus.ampapi.responses.Core.LoginResult;

public class CommonAPI extends AMPAPI {
    public final Core Core = new Core(this);
    public final EmailSenderPlugin EmailSenderPlugin = new EmailSenderPlugin(this);
    public final FileManagerPlugin FileManagerPlugin = new FileManagerPlugin(this);
    public final LocalFileBackupPlugin LocalFileBackupPlugin = new LocalFileBackupPlugin(this);

    /**
     * Constructor
     * @param baseUri The base URI of the AMP instance
     */
    public CommonAPI(String baseUri) {
        super(baseUri);
    }

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
    public CommonAPI(String baseUri, String username, String password, String rememberMeToken, String sessionId) {
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
            this.Core.sessionId = this.sessionId;
            this.Core.rememberMeToken = this.rememberMeToken;
            this.EmailSenderPlugin.sessionId = this.sessionId;
            this.EmailSenderPlugin.rememberMeToken = this.rememberMeToken;
            this.FileManagerPlugin.sessionId = this.sessionId;
            this.FileManagerPlugin.rememberMeToken = this.rememberMeToken;
            this.LocalFileBackupPlugin.sessionId = this.sessionId;
            this.LocalFileBackupPlugin.rememberMeToken = this.rememberMeToken;
        }

        return loginResult;
    }
}
