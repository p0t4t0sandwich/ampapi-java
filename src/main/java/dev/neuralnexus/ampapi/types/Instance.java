package dev.neuralnexus.ampapi.types;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

/**
 * Instance - An instance object
 *
 * @author p0t4t0sandwich
 */
public class Instance {
    /**
     * InstanceID - The instance ID <br>
     * TargetID - The target ID <br>
     * InstanceName - The instance name <br>
     * FriendlyName - The friendly name <br>
     * Description - The description <br>
     * Module - The module <br>
     * ModuleDisplayName - The module display name <br>
     * {@link AMPVersion AMPVersion} - The AMP version <br>
     * IsHTTPS - Whether HTTPS is enabled IP - The IP address <br>
     * Port - The port <br>
     * Daemon - Whether the instance is a daemon <br>
     * DaemonAutostart - Whether the daemon autostarts <br>
     * ExcludeFromFirewall - Whether the instance is excluded from the firewall <br>
     * Running - Whether the instance is running <br>
     * AppState - The application state <br>
     * Tags - The tags <br>
     * DiskUsageMB - The disk usage in MB <br>
     * ReleaseStream - The release stream <br>
     * ManagementMode - The management mode Suspended - Whether the instance is suspended
     * IsContainerInstance - Whether the instance is a container instance <br>
     * ContainerMemoryMB - The container memory in MB <br>
     * ContainerMemoryPolicy - The container memory policy <br>
     * ContainerCPUs - The container CPUs <br>
     * SpecificDockerImage - The specific Docker image <br>
     * {@link Metric Metrics} - The metrics <br>
     * {@link EndpointInfo ApplicationEndpoints} - The application endpoints <br>
     * DeploymentArgs - The deployment arguments <br>
     * DisplayImageSource - The display image source
     */
    public UUID InstanceID;

    public UUID TargetID;
    public String InstanceName;
    public String FriendlyName;
    public String Description;
    public String Module;
    public String ModuleDisplayName;
    public AMPVersion AMPVersion;
    public boolean IsHTTPS;
    public String IP;
    public double Port;
    public boolean Daemon;
    public boolean DaemonAutostart;
    public boolean ExcludeFromFirewall;
    public boolean Running;
    public State AppState;
    public String[] Tags;
    public double DiskUsageMB;
    public double ReleaseStream;
    public double ManagementMode;
    public boolean Suspended;
    public boolean IsContainerInstance;
    public double ContainerMemoryMB;
    public double ContainerMemoryPolicy;
    public double ContainerCPUs;
    public String SpecificDockerImage;
    public Map<String, Metric> Metrics;
    public EndpointInfo[] ApplicationEndpoints;
    public Map<String, String> DeploymentArgs;
    public String DisplayImageSource;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    @Override
    public String toString() {
        return "Instance{InstanceID="
                + this.InstanceID
                + ", TargetID="
                + this.TargetID
                + ", InstanceName="
                + this.InstanceName
                + ", FriendlyName="
                + this.FriendlyName
                + ", Description="
                + this.Description
                + ", Module="
                + this.Module
                + ", ModuleDisplayName="
                + this.ModuleDisplayName
                + ", AMPVersion="
                + this.AMPVersion
                + ", IsHTTPS="
                + this.IsHTTPS
                + ", IP="
                + this.IP
                + ", Port="
                + this.Port
                + ", Daemon="
                + this.Daemon
                + ", DaemonAutostart="
                + this.DaemonAutostart
                + ", ExcludeFromFirewall="
                + this.ExcludeFromFirewall
                + ", Running="
                + this.Running
                + ", AppState="
                + this.AppState
                + ", Tags="
                + Arrays.toString(this.Tags)
                + ", DiskUsageMB="
                + this.DiskUsageMB
                + ", ReleaseStream="
                + this.ReleaseStream
                + ", ManagementMode="
                + this.ManagementMode
                + ", Suspended="
                + this.Suspended
                + ", IsContainerInstance="
                + this.IsContainerInstance
                + ", ContainerMemoryMB="
                + this.ContainerMemoryMB
                + ", ContainerMemoryPolicy="
                + this.ContainerMemoryPolicy
                + ", ContainerCPUs="
                + this.ContainerCPUs
                + ", SpecificDockerImage="
                + this.SpecificDockerImage
                + ", Metrics="
                + this.Metrics
                + ", ApplicationEndpoints="
                + Arrays.toString(this.ApplicationEndpoints)
                + ", DeploymentArgs="
                + this.DeploymentArgs
                + ", DisplayImageSource="
                + this.DisplayImageSource
                + "}";
    }
}
