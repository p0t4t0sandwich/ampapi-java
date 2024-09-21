/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi-java/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * AMPVersion - AMP version information
 *
 * @author p0t4t0sandwich
 */
public class AMPVersion {
    /**
     * Major - The major version number <br>
     * Minor - The minor version number <br>
     * Build - The build number Revision - The revision number <br>
     * MajorRevision - The major revision number <br>
     * MinorRevision - The minor revision number
     */
    public int Major;

    public int Minor;
    public int Build;
    public int Revision;
    public int MajorRevision;
    public int MinorRevision;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    @Override
    public String toString() {
        return "AMPVersion{Major="
                + this.Major
                + ", Minor="
                + this.Minor
                + ", Build="
                + this.Build
                + ", Revision="
                + this.Revision
                + ", MajorRevision="
                + this.MajorRevision
                + ", MinorRevision="
                + this.MinorRevision
                + "}";
    }
}
