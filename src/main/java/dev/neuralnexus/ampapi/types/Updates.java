package dev.neuralnexus.ampapi.types;

import java.util.Arrays;

/**
 * Response type for API.Core.GetUpdates
 *
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.apimodules.Core#GetUpdates()
 */
public class Updates {
    /**
     * {@link Status Status} - The status of the server {@link ConsoleEntry ConsoleEntries} - The
     * console entries of the server {@link Message Messages} - The messages of the server Tasks -
     * The tasks of the server Ports - The ports of the server
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
