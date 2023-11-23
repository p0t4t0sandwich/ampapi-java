package dev.neuralnexus.ampapi.types;

/**
 * Response type for ADSModule.GetLicenceInfo
 *
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.apimodules.Core#ActivateAMPLicence(String, Boolean)
 */
public class LicenceInfo {
    /**
     * LicenceKey - The licence key Grade - The grade GradeName - The grade name Product - The
     * product ProductName - The product name Expires - The expiry date Usage - The usage
     */
    public String LicenceKey;

    public String Grade;
    public String GradeName;
    public String Product;
    public String ProductName;
    public String Expires;
    public int Usage;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    public String toString() {
        return "LicenceInfo{LicenceKey="
                + this.LicenceKey
                + ", Grade="
                + this.Grade
                + ", GradeName="
                + this.GradeName
                + ", Product="
                + this.Product
                + ", ProductName="
                + this.ProductName
                + ", Expires="
                + this.Expires
                + ", Usage="
                + this.Usage
                + "}";
    }
}
