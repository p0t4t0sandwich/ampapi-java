package dev.neuralnexus.ampapi.types;

/**
 * File - A file chunk object
 *
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.plugins.FileManagerPlugin#GetFileChunk(String, Integer, Integer)
 */
public class FileChunkData {
    /**
     * Base64Data - The base64 encoded data <br>
     * BytesLength - The length of the data in bytes
     */
    public String Base64Data;

    public double BytesLength;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    @Override
    public String toString() {
        return "FileChunkData{Base64Data="
                + this.Base64Data
                + ", BytesLength="
                + this.BytesLength
                + "}";
    }
}
