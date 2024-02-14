package dev.neuralnexus.ampapi.types;

import java.util.UUID;

/**
 * InstanceStatus - An object to represent the object returned by the
 * ADSModule#GetInstanceStatuses() method
 *
 * @author p0t4t0sandwich
 */
public class InstanceStatus {
    /**
     * InstanceID - The instance ID <br>
     * Running - Whether the instance is running
     */
    public UUID InstanceID;

    public boolean Running;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    @Override
    public String toString() {
        return "InstanceStatus{InstanceID=" + this.InstanceID + ", Running=" + this.Running + "}";
    }
}
