package dev.neuralnexus.ampapi.types;

import java.util.Arrays;

/**
 * ADSInstance - An ADS instance object
 * @author p0t4t0sandwich
 */
public class ADSInstance {
    /**
     * Id - The instance ID
     * InstanceId - The instance ID
     * FriendlyName - The friendly name
     * Disabled - Whether the instance is disabled
     * isRemote - Whether the instance is remote
     * {@link Platform Platform} - Platform information object
     * {@link Datastore Datastores} - The datastores
     * CreatesInContainers - Whether the instance creates in containers
     * State - The state
     * StateReason - The state reason
     * CanCreate - Whether the instance can create
     * LastUpdated - The last updated
     * {@link Instance AvailableInstances} - The available instances
     * AvailableIPs - The available IPs
     */
    public double Id;
    public String InstanceId;
    public String FriendlyName;
    public boolean Disabled;
    public boolean isRemote;
    public Platform Platform;
    public Datastore[] Datastores;
    public boolean CreatesInContainers;
    public double State;
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
        return "ADSInstance{Id=" + this.Id + ", InstanceId=" + this.InstanceId + ", FriendlyName=" + this.FriendlyName + ", Disabled=" + this.Disabled + ", isRemote=" + this.isRemote + ", Platform=" + this.Platform + ", Datastores=" + Arrays.toString(this.Datastores) + ", CreatesInContainers=" + this.CreatesInContainers + ", State=" + this.State + ", StateReason=" + this.StateReason + ", CanCreate=" + this.CanCreate + ", LastUpdated=" + this.LastUpdated + ", AvailableInstances=" + Arrays.toString(this.AvailableInstances) + ", AvailableIPs=" + Arrays.toString(this.AvailableIPs) + ", URL=" + this.URL + ", Tags=" + Arrays.toString(this.Tags) + ", TagNames=" + Arrays.toString(this.TagNames) + "}";
    }
}
