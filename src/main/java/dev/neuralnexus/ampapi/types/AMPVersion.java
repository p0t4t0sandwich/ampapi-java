package dev.neuralnexus.ampapi.types;

/**
 * AMPVersion - AMP version information
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.responses.ADSModule.GetInstanceResult
 */
public class AMPVersion {
    /**
     * Major - The major version number
     * Minor - The minor version number
     * Build - The build number
     * Revision - The revision number
     * MajorRevision - The major revision number
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
     * @return A string representation of the object
     */
    public String toString() {
        return "AMPVersion{Major=" + this.Major + ", Minor=" + this.Minor + ", Build=" + this.Build + ", Revision=" + this.Revision + ", MajorRevision=" + this.MajorRevision + ", MinorRevision=" + this.MinorRevision + "}";
    }
}
