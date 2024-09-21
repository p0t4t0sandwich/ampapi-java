/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi-java/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.Arrays;

/**
 * Response type for API.Core.Login
 *
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.plugins.Core#Login(String, String, String, Boolean)
 */
public class LoginResult {
    /**
     * success - Whether the login was successful <br>
     * permissions - An array of permissions the user has <br>
     * sessionID - The session ID of the user <br>
     * rememberMeToken - The remember-me token of the user <br>
     * {@link UserInfo userInfo} - Information about the user <br>
     * resultReason - The reason for the result <br>
     * result - The result of the login
     */
    public boolean success;

    public String[] permissions;
    public String sessionID;
    public String rememberMeToken;
    public UserInfo userInfo;
    public String resultReason;
    public double result;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    @Override
    public String toString() {
        return "LoginResult{success="
                + this.success
                + ", permissions="
                + Arrays.toString(this.permissions)
                + ", sessionID="
                + this.sessionID
                + ", rememberMeToken="
                + this.rememberMeToken
                + ", userInfo="
                + this.userInfo
                + ", resultReason="
                + this.resultReason
                + ", result="
                + this.result
                + "}";
    }
}
