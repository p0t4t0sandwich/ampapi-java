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
     * InstanceID - The instance ID TargetID - The target ID InstanceName - The instance name
     * FriendlyName - The friendly name Description - The description Module - The module
     * ModuleDisplayName - The module display name {@link AMPVersion AMPVersion} - The AMP version
     * IsHTTPS - Whether HTTPS is enabled IP - The IP address Port - The port Daemon - Whether the
     * instance is a daemon DaemonAutostart - Whether the daemon autostarts ExcludeFromFirewall -
     * Whether the instance is excluded from the firewall Running - Whether the instance is running
     * AppState - The application state Tags - The tags DiskUsageMB - The disk usage in MB
     * ReleaseStream - The release stream ManagementMode - The management mode Suspended - Whether
     * the instance is suspended IsContainerInstance - Whether the instance is a container instance
     * ContainerMemoryMB - The container memory in MB ContainerMemoryPolicy - The container memory
     * policy ContainerCPUs - The container CPUs SpecificDockerImage - The specific Docker image
     * {@link Metric Metrics} - The metrics {@link EndpointInfo ApplicationEndpoints} - The
     * application endpoints DeploymentArgs - The deployment arguments DisplayImageSource - The
     * display image source
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
