package dev.neuralnexus.ampapi.types;

/**
 * InstanceDatastore - A datastore object
 * @author p0t4t0sandwich
 */
public class InstanceDatastore {
    /**
     * Id - The datastore ID
     * FriendlyName - The friendly name
     */
    public int Id;
    public String FriendlyName;

    /**
     * toString
     * @return A string representation of the object
     */
    public String toString() {
        return "InstanceDatastore{Id=" + this.Id + ", FriendlyName=" + this.FriendlyName + "}";
    }
}
