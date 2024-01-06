package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.apimodules.*;
import dev.neuralnexus.ampapi.types.LoginResult;

public class Minecraft extends CommonAPI {
    public MinecraftModule MinecraftModule = new MinecraftModule(this);

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
    public Minecraft(
            String baseUri,
            String username,
            String password,
            String rememberMeToken,
            String sessionId) {
        super(baseUri, username, password, rememberMeToken, sessionId);
        this.Login();
    }

    /**
     * Constructor
     *
     * @param baseUri The base URI of the AMP instance
     * @param username The username to log in with
     * @param password The password to log in with
     */
    public Minecraft(String baseUri, String username, String password) {
        super(baseUri, username, password, "", "");
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
            if (this.MinecraftModule == null) {
                this.MinecraftModule = new MinecraftModule(this);
            }

            this.MinecraftModule.sessionId = this.sessionId;
            this.MinecraftModule.rememberMeToken = this.rememberMeToken;
        }

        return loginResult;
    }
}
