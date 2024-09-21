/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi-java/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * InstanceDatastore - A datastore object
 *
 * @author p0t4t0sandwich
 */
public class InstanceDatastore {
    /**
     * Id - The datastore ID <br>
     * FriendlyName - The friendly name
     */
    public int Id;

    public String FriendlyName;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    @Override
    public String toString() {
        return "InstanceDatastore{Id=" + this.Id + ", FriendlyName=" + this.FriendlyName + "}";
    }
}
