package dev.neuralnexus.ampapi.responses.Core;

import dev.neuralnexus.ampapi.types.UserInfo;

import java.util.Arrays;

/**
 * Response type for API.Core.Login
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.apimodules.Core#Login(String, String, String, Boolean)
 */
public class LoginResult {
    /**
     * success - Whether the login was successful
     * permissions - An array of permissions the user has
     * sessionID - The session ID of the user
     * rememberMeToken - The remember-me token of the user
     * {@link UserInfo userInfo} - Information about the user
     * result - The result of the login
     */
    public boolean success;
    public String[] permissions;
    public String sessionID;
    public String rememberMeToken;
    public UserInfo userInfo;
    public double result;

    /**
     * toString
     * @return A string representation of the object
     */
    public String toString() {
        return "LoginResult{success=" + this.success + ", permissions=" + Arrays.toString(this.permissions) + ", sessionID=" + this.sessionID + ", rememberMeToken=" + this.rememberMeToken + ", userInfo=" + this.userInfo + ", result=" + this.result + "}";
    }
}
