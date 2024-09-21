/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * UserInfo - Information about the user
 *
 * @author p0t4t0sandwich
 */
public class UserInfo {
    /**
     * ID - The ID of the user <br>
     * Username - The username of the user <br>
     * EmailAddress - The email address of the user <br>
     * IsTwoFactorEnabled - Whether 2FA is enabled for the user <br>
     * Disabled - Whether the user is disabled <br>
     * LastLogin - The last time the user logged in <br>
     * GravatarHash - The Gravatar hash of the user <br>
     * IsLDAPUser - Whether the user is an LDAP user
     */
    public String ID;

    public String Username;
    public String EmailAddress;
    public boolean IsTwoFactorEnabled;
    public boolean Disabled;
    public String LastLogin;
    public String GravatarHash;
    public boolean IsLDAPUser;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    @Override
    public String toString() {
        return "UserInfo{ID="
                + this.ID
                + ", Username="
                + this.Username
                + ", EmailAddress="
                + this.EmailAddress
                + ", IsTwoFactorEnabled="
                + this.IsTwoFactorEnabled
                + ", Disabled="
                + this.Disabled
                + ", LastLogin="
                + this.LastLogin
                + ", GravatarHash="
                + this.GravatarHash
                + ", IsLDAPUser="
                + this.IsLDAPUser
                + "}";
    }
}
