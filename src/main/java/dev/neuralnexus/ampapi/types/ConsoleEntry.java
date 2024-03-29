package dev.neuralnexus.ampapi.types;

/**
 * Interface for the result of API.Core#GetUpdates.ConsoleEntries
 *
 * @see dev.neuralnexus.ampapi.apimodules.Core#GetUpdates()
 * @author p0t4t0sandwich
 */
public class ConsoleEntry {
    /**
     * Timestamp - The timestamp of the entry <br>
     * Source - The source of the entry <br>
     * SourceId - The source ID of the entry <br>
     * Type - The type of the entry <br>
     * Contents - The contents of the entry
     */
    public String Timestamp;

    public String Source;
    public String SourceId;
    public String Type;
    public String Contents;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    @Override
    public String toString() {
        return "ConsoleEntry{Timestamp="
                + this.Timestamp
                + ", Source="
                + this.Source
                + ", SourceId="
                + this.SourceId
                + ", Type="
                + this.Type
                + ", Contents="
                + this.Contents
                + "}";
    }
}
