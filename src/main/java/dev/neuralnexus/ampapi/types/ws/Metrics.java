package dev.neuralnexus.ampapi.types.ws;

import dev.neuralnexus.ampapi.types.Status;

import java.util.UUID;

/**
 * Metrics information from the websocket keep-alive messages
 * @author p0t4t0sandwich
 */
public class Metrics {
    /**
     * Id - unique identifier for the message
     * Expired - true if the message has expired
     * Source - source of the message
     * Message - message
     * {@link Status} - status of the message
     * AgeMinutes - age of the message in minutes
     */
    public UUID Id;
    public boolean Expired;
    public String Source;
    public String Message;
    public Status Parameters;
    public int AgeMinutes;

    /**
     * toString
     * @return A string representation of the object
     */
    public String toString() {
        return "Metrics{Id=" + this.Id + ", Expired=" + this.Expired + ", Source=" + this.Source + ", Message=" + this.Message + ", Parameters=" + this.Parameters + ", AgeMinutes=" + this.AgeMinutes + "}";
    }
}
