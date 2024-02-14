package dev.neuralnexus.ampapi.types;

/**
 * File - A file directory object
 *
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.apimodules.FileManagerPlugin#GetDirectoryListing(String)
 */
public class FileDirectory {
    /**
     * IsDirectory - Whether the file is a directory <br>
     * IsVirtualDirectory - Whether the file is a virtual directory <br>
     * Filename - The name of the file <br>
     * SizeBytes - The size of the file in bytes <br>
     * Created - The date the file was created <br>
     * Modified - The date the file was last modified <br>
     * IsDownloadable - Whether the file is downloadable <br>
     * IsEditable - Whether the file is editable <br>
     * IsArchive - Whether the file is an archive <br>
     * IsExcludedFromBackups - Whether the file is excluded from backups
     */
    public Boolean IsDirectory;

    public Boolean IsVirtualDirectory;
    public String Filename;
    public Double SizeBytes;
    public String Created;
    public String Modified;
    public Boolean IsDownloadable;
    public Boolean IsEditable;
    public Boolean IsArchive;
    public Boolean IsExcludedFromBackups;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    @Override
    public String toString() {
        return "File{IsDirectory="
                + this.IsDirectory
                + ", IsVirtualDirectory="
                + this.IsVirtualDirectory
                + ", Filename="
                + this.Filename
                + ", SizeBytes="
                + this.SizeBytes
                + ", Created="
                + this.Created
                + ", Modified="
                + this.Modified
                + ", IsDownloadable="
                + this.IsDownloadable
                + ", IsEditable="
                + this.IsEditable
                + ", IsArchive="
                + this.IsArchive
                + ", IsExcludedFromBackups="
                + this.IsExcludedFromBackups
                + "}";
    }
}
