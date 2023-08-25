package dev.neuralnexus.ampapi.types;

/**
 * CPUInfo - CPU information object
 * @author p0t4t0sandwich
 */
public class CPUInfo {
    /**
     * Sockets - Number of CPU sockets
     * Cores - Number of CPU cores
     * Threads - Number of CPU threads
     * Vendor - CPU vendor
     * ModelName - CPU model name
     * TotalCores - Total number of CPU cores
     * TotalThreads - Total number of CPU threads
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
     * @return A string representation of the object
     */
    public String toString() {
        return "CPUInfo{Sockets=" + this.Sockets + ", Cores=" + this.Cores + ", Threads=" + this.Threads + ", Vendor=" + this.Vendor + ", ModelName=" + this.ModelName + ", TotalCores=" + this.TotalCores + ", TotalThreads=" + this.TotalThreads + "}";
    }
}
