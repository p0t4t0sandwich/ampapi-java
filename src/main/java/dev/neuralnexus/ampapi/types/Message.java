package dev.neuralnexus.ampapi.types;

/**
 * Message type for API.Core.GetUpdatesResult status messages
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.responses.Core.GetUpdatesResult
 * @see dev.neuralnexus.ampapi.apimodules.Core#GetUpdates()
 */
public class Message {
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
