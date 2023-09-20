package dev.neuralnexus.ampapi.types;

/**
 * UserInfo - Information about the user
 * @author p0t4t0sandwich
 */
public class UserInfo {
    /**
     * ID - The ID of the user
     * Username - The username of the user
     * EmailAddress - The email address of the user
     * IsTwoFactorEnabled - Whether 2FA is enabled for the user
     * Disabled - Whether the user is disabled
     * LastLogin - The last time the user logged in
     * GravatarHash - The Gravatar hash of the user
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
    public String toString() {
        return "UserInfo{ID=" + this.ID + ", Username=" + this.Username + ", EmailAddress=" + this.EmailAddress + ", IsTwoFactorEnabled=" + this.IsTwoFactorEnabled + ", Disabled=" + this.Disabled + ", LastLogin=" + this.LastLogin + ", GravatarHash=" + this.GravatarHash + ", IsLDAPUser=" + this.IsLDAPUser + "}";
    }
}
