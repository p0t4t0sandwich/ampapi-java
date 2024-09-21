/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

import java.util.Arrays;

/**
 * Response type for API.Core.GetUpdates
 *
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.plugins.Core#GetUpdates()
 */
public class Updates {
    /**
     * {@link Status Status} - The status of the server <br>
     * {@link ConsoleEntry ConsoleEntries} - The console entries of the server <br>
     * {@link Message Messages} - The messages of the server <br>
     * Tasks - The tasks of the server <br>
     * Ports - The ports of the server
     */
    public Status Status;

    public ConsoleEntry[] ConsoleEntries;
    public Message[] Messages;
    public String[] Tasks;
    public String[] Ports;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    @Override
    public String toString() {
        return "Updates{Status="
                + this.Status
                + ", ConsoleEntries="
                + Arrays.toString(this.ConsoleEntries)
                + ", Messages="
                + Arrays.toString(this.Messages)
                + ", Tasks="
                + Arrays.toString(this.Tasks)
                + ", Ports="
                + Arrays.toString(this.Ports)
                + "}";
    }
}
