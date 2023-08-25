package dev.neuralnexus.ampapi.types;

/**
 * Datastore - A datastore object
 * @author p0t4t0sandwich
 */
public class Datastore {
    /**
     * Id - The datastore ID
     * FriendlyName - The friendly name
     */
    public String Id;
    public String FriendlyName;

    /**
     * toString
     * @return A string representation of the object
     */
    public String toString() {
        return "Datastore{Id=" + this.Id + ", FriendlyName=" + this.FriendlyName + "}";
    }
}
