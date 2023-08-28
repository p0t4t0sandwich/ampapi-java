package dev.neuralnexus.ampapi.types;

import java.util.Arrays;

/**
 * Response type for API.Core.GetUpdates
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.apimodules.Core#GetUpdates()
 */
public class Updates {
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
        return "Updates{Status=" + this.Status + ", ConsoleEntries=" + Arrays.toString(this.ConsoleEntries) + ", Messages=" + Arrays.toString(this.Messages) + ", Tasks=" + Arrays.toString(this.Tasks) + ", Ports=" + Arrays.toString(this.Ports) + "}";
    }

    /**
     * Message type for API.Core.Updates status messages
     * @author p0t4t0sandwich
     * @see Updates
     * @see dev.neuralnexus.ampapi.apimodules.Core#GetUpdates()
     */
    public static class Message {
        /**
         * Id - The ID of the message
         * Expired - Whether the message has expired
         * Source - The source of the message
         * Message - The message
         * AgeMinutes - The age of the message in minutes
         */
        public String Id;
        public boolean Expired;
        public String Source;
        public String Message;
        public double AgeMinutes;

        /**
         * toString
         * @return A string representation of the object
         */
        public String toString() {
            return "Message{Id=" + this.Id + ", Expired=" + this.Expired + ", Source=" + this.Source + ", Message=" + this.Message + ", AgeMinutes=" + this.AgeMinutes + "}";
        }
    }
}
