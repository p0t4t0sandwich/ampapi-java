package dev.neuralnexus.ampapi.types;

import java.util.Arrays;
import java.util.UUID;

/**
 * IADSInstance - An ADS instance object
 * @author p0t4t0sandwich
 */
public class IADSInstance {
    /**
     * Id - The ADS instance ID
     * InstanceId - The instance ID
     * FriendlyName - The friendly name
     * Disabled - Whether the instance is disabled
     * isRemote - Whether the instance is remote
     * {@link PlatformInfo PlatformInfo} - PlatformInfo information object
     * {@link InstanceDatastore Datastores} - The datastores
     * CreatesInContainers - Whether the instance creates in containers
     * State - The state
     * StateReason - The state reason
     * CanCreate - Whether the instance can create
     * LastUpdated - The last updated
     * {@link Instance AvailableInstances} - The available instances
     * AvailableIPs - The available IPs
     */
    public double Id;
    public UUID InstanceId;
    public String FriendlyName;
    public boolean Disabled;
    public boolean isRemote;
    public PlatformInfo Platform;
    public InstanceDatastore[] Datastores;
    public boolean CreatesInContainers;
    public State State;
    public String StateReason;
    public boolean CanCreate;
    public String LastUpdated;
    public Instance[] AvailableInstances;
    public String[] AvailableIPs;
    public String URL;
    public String[] Tags;
    public String[] TagNames;

    /**
     * toString
     * @return A string representation of the object
     */
    public String toString() {
        return "IADSInstance{Id=" + this.Id + ", InstanceId=" + this.InstanceId + ", FriendlyName=" + this.FriendlyName + ", Disabled=" + this.Disabled + ", isRemote=" + this.isRemote + ", PlatformInfo=" + this.Platform + ", Datastores=" + Arrays.toString(this.Datastores) + ", CreatesInContainers=" + this.CreatesInContainers + ", State=" + this.State + ", StateReason=" + this.StateReason + ", CanCreate=" + this.CanCreate + ", LastUpdated=" + this.LastUpdated + ", AvailableInstances=" + Arrays.toString(this.AvailableInstances) + ", AvailableIPs=" + Arrays.toString(this.AvailableIPs) + ", URL=" + this.URL + ", Tags=" + Arrays.toString(this.Tags) + ", TagNames=" + Arrays.toString(this.TagNames) + "}";
    }
}
