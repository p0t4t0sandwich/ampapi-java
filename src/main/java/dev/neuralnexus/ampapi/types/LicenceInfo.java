/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi-java/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * Response type for ADSModule.GetLicenceInfo
 *
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.plugins.Core#ActivateAMPLicence(String, Boolean)
 */
public class LicenceInfo {
    /**
     * LicenceKey - The licence key <br>
     * Grade - The grade <br>
     * GradeName - The grade name <br>
     * Product - The product <br>
     * ProductName - The product name <br>
     * Expires - The expiry date Usage - The usage
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
    @Override
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
