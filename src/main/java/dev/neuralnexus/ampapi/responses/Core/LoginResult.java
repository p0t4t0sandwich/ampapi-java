package dev.neuralnexus.ampapi.responses.Core;

import java.util.Arrays;

/**
 * Response type for API.Core.Login
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.apimodules.Core#Login(String, String, String, boolean)
 */
public class LoginResult {
    /**
     * success - Whether the login was successful
     * permissions - An array of permissions the user has
     * sessionID - The session ID of the user
     * rememberMeToken - The remember-me token of the user
     * userInfo - Information about the user
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

    /**
     * UserInfo - Information about the user
     * ID - The ID of the user
     * Username - The username of the user
     * IsTwoFactorEnabled - Whether 2FA is enabled for the user
     * Disabled - Whether the user is disabled
     * LastLogin - The last time the user logged in
     * GravatarHash - The Gravatar hash of the user
     * IsLDAPUser - Whether the user is an LDAP user
     * @see LoginResult
     */
    public static class UserInfo {
        public String ID;
        public String Username;
        public boolean IsTwoFactorEnabled;
        public boolean Disabled;
        public String LastLogin;
        public String GravatarHash;
        public boolean IsLDAPUser;

        public String toString() {
            return "UserInfo{ID=" + this.ID + ", Username=" + this.Username + ", IsTwoFactorEnabled=" + this.IsTwoFactorEnabled + ", Disabled=" + this.Disabled + ", LastLogin=" + this.LastLogin + ", GravatarHash=" + this.GravatarHash + ", IsLDAPUser=" + this.IsLDAPUser + "}";
        }
    }
}
