package dev.neuralnexus.ampapi.types;

import java.util.Arrays;
import java.util.UUID;

/**
 * IADSInstance - An ADS instance object
 *
 * @author p0t4t0sandwich
 */
public class IADSInstance {
    /**
     * Id - The ADS instance ID <br>
     * InstanceId - The instance ID <br>
     * FriendlyName - The friendly name <br>
     * Description - The description <br>
     * Disabled - Whether the instance is disabled <br>
     * isRemote - Whether the instance is remote <br>
     * {@link PlatformInfo Platform} - Platform information object <br>
     * {@link InstanceDatastore Datastores} - The datastores <br>
     * CreatesInContainers - Whether the instance creates in containers <br>
     * State - The state <br>
     * StateReason - The state reason <br>
     * CanCreate - Whether the instance can create <br>
     * LastUpdated - The last updated <br>
     * {@link Instance AvailableInstances} - The available instances <br>
     * AvailableIPs - The available IPs
     */
    public double Id;

    public UUID InstanceId;
    public String FriendlyName;
    public String Description;
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
     *
     * @return A string representation of the object
     */
    @Override
    public String toString() {
        return "IADSInstance{Id="
                + this.Id
                + ", InstanceId="
                + this.InstanceId
                + ", FriendlyName="
                + this.FriendlyName
                + ", Description="
                + this.Description
                + ", Disabled="
                + this.Disabled
                + ", isRemote="
                + this.isRemote
                + ", Platform="
                + this.Platform
                + ", Datastores="
                + Arrays.toString(this.Datastores)
                + ", CreatesInContainers="
                + this.CreatesInContainers
                + ", State="
                + this.State
                + ", StateReason="
                + this.StateReason
                + ", CanCreate="
                + this.CanCreate
                + ", LastUpdated="
                + this.LastUpdated
                + ", AvailableInstances="
                + Arrays.toString(this.AvailableInstances)
                + ", AvailableIPs="
                + Arrays.toString(this.AvailableIPs)
                + ", URL="
                + this.URL
                + ", Tags="
                + Arrays.toString(this.Tags)
                + ", TagNames="
                + Arrays.toString(this.TagNames)
                + "}";
    }
}
