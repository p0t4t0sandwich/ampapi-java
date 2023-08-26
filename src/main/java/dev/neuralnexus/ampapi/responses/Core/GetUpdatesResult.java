package dev.neuralnexus.ampapi.responses.Core;

import dev.neuralnexus.ampapi.responses.RunningTask;
import dev.neuralnexus.ampapi.types.Message;
import dev.neuralnexus.ampapi.types.Status;

import java.util.Arrays;

/**
 * Response type for API.Core.GetUpdates
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.apimodules.Core#GetUpdates()
 */
public class GetUpdatesResult {
    /**
     * {@link Status Status} - The status of the server
     * ConsoleEntries - The console entries of the server
     * {@link Message Messages} - The messages of the server
     * Tasks - The tasks of the server
     * Ports - The ports of the server
     */
    public Status Status;
    public String[] ConsoleEntries;
    public Message[] Messages;
    public String[] Tasks;
    public String[] Ports;

    /**
     * toString
     * @return A string representation of the object
     */
    public String toString() {
        return "GetUpdatesResult{Status=" + this.Status + ", ConsoleEntries=" + Arrays.toString(this.ConsoleEntries) + ", Messages=" + Arrays.toString(this.Messages) + ", Tasks=" + Arrays.toString(this.Tasks) + ", Ports=" + Arrays.toString(this.Ports) + "}";
    }
}
