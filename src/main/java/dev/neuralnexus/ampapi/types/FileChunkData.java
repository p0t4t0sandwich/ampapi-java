package dev.neuralnexus.ampapi.types;

/**
 * File - A file chunk object
 *
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.apimodules.FileManagerPlugin#GetFileChunk(String, Integer, Integer)
 */
public class FileChunkData {
    /**
     * Base64Data - The base64 encoded data <br>
     * BytesLength - The length of the data in bytes
     */
    public String Base64Data;

    public double BytesLength;
}
