package dev.neuralnexus.ampapi.types;

import java.util.UUID;

/**
 * Message type for API.Core.GetUpdates status messages (along with WS keep alive)
 *
 * @author p0t4t0sandwich
 * @see Updates
 * @see dev.neuralnexus.ampapi.apimodules.Core#GetUpdates()
 */
public class Message {
    /**
     * Id - The ID of the message <br>
     * Expired - Whether the message has expired <br>
     * Source - The source of the message <br>
     * Message - The message <br>
     * AgeMinutes - The age of the message in minutes
     */
    public UUID Id;

    public boolean Expired;
    public String Source;
    public String Message;
    public double AgeMinutes;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    @Override
    public String toString() {
        return "Message{Id="
                + this.Id
                + ", Expired="
                + this.Expired
                + ", Source="
                + this.Source
                + ", Message="
                + this.Message
                + ", AgeMinutes="
                + this.AgeMinutes
                + "}";
    }
}
