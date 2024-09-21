/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * PlatformInfo - A platform object
 *
 * @author p0t4t0sandwich
 */
public class PlatformInfo {
    /**
     * {@link CPUInfo CPUInfo} - CPU information object <br>
     * InstalledRAMMB - Installed RAM in MB <br>
     * OS - The OS <br>
     * PlatformName - The platform name <br>
     * SystemType - The system type <br>
     * Virtualization - The virtualization
     */
    public CPUInfo CPUInfo;

    public double InstalledRAMMB;
    public int OS;
    public String PlatformName;
    public double SystemType;
    public double Virtualization;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    @Override
    public String toString() {
        return "PlatformInfo{CPUInfo="
                + this.CPUInfo
                + ", InstalledRAMMB="
                + this.InstalledRAMMB
                + ", OS="
                + this.OS
                + ", PlatformName="
                + this.PlatformName
                + ", SystemType="
                + this.SystemType
                + ", Virtualization="
                + this.Virtualization
                + "}";
    }

    /**
     * CPUInfo - CPU information object
     *
     * @author p0t4t0sandwich
     */
    public static class CPUInfo {
        /**
         * Sockets - Number of CPU sockets Cores - Number of CPU cores Threads - Number of CPU
         * threads Vendor - CPU vendor ModelName - CPU model name TotalCores - Total number of CPU
         * cores TotalThreads - Total number of CPU threads
         */
        public double Sockets;

        public double Cores;
        public double Threads;
        public String Vendor;
        public String ModelName;
        public double TotalCores;
        public double TotalThreads;

        /**
         * toString
         *
         * @return A string representation of the object
         */
        public String toString() {
            return "CPUInfo{Sockets="
                    + this.Sockets
                    + ", Cores="
                    + this.Cores
                    + ", Threads="
                    + this.Threads
                    + ", Vendor="
                    + this.Vendor
                    + ", ModelName="
                    + this.ModelName
                    + ", TotalCores="
                    + this.TotalCores
                    + ", TotalThreads="
                    + this.TotalThreads
                    + "}";
        }
    }
}
