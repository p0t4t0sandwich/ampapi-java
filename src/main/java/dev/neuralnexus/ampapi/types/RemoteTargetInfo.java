package dev.neuralnexus.ampapi.types;

import java.util.Arrays;

/**
 * RemoteTargetInfo - A remote target info object
 *
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.apimodules.ADSModule#GetTargetInfo()
 */
public class RemoteTargetInfo {
    /**
     * IPAddressList - The IP address list <br>
     * {@link PlatformInfo PlatformInfo} - PlatformInfo information object <br>
     * {@link InstanceDatastore Datastores} - The datastores <br>
     * DeploysInContainers - Whether the instance deploys in containers
     */
    public String[] IPAddressList;

    public PlatformInfo PlatformInfo;
    public InstanceDatastore[] Datastores;
    public boolean DeploysInContainers;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    @Override
    public String toString() {
        return "RemoteTargetInfo{IPAddressList="
                + Arrays.toString(this.IPAddressList)
                + ", PlatformInfo="
                + this.PlatformInfo
                + ", Datastores="
                + Arrays.toString(this.Datastores)
                + ", DeploysInContainers="
                + this.DeploysInContainers
                + "}";
    }
}
