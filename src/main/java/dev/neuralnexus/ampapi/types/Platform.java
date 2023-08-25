package dev.neuralnexus.ampapi.types;

/**
 * Platform - A platform object
 * @author p0t4t0sandwich
 */
public class Platform {
    /**
     * {@link CPUInfo CPUInfo} - CPU information object
     * InstalledRAMMB - Installed RAM in MB
     * OS - The OS
     * PlatformName - The platform name
     * SystemType - The system type
     * Virtualization - The virtualization
     */
    public CPUInfo CPUInfo;
    public double InstalledRAMMB;
    public double OS;
    public String PlatformName;
    public double SystemType;
    public double Virtualization;

    /**
     * toString
     * @return A string representation of the object
     */
    public String toString() {
        return "Platform{CPUInfo=" + this.CPUInfo + ", InstalledRAMMB=" + this.InstalledRAMMB + ", OS=" + this.OS + ", PlatformName=" + this.PlatformName + ", SystemType=" + this.SystemType + ", Virtualization=" + this.Virtualization + "}";
    }
}
