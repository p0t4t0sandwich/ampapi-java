package dev.neuralnexus.ampapi.types;

/**
 * File - A file object
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.apimodules.FileManagerPlugin#GetDirectoryListing(String)
 */
public class FileDirectory {
    /**
     * IsDirectory - Whether the file is a directory
     * IsVirtualDirectory - Whether the file is a virtual directory
     * Filename - The name of the file
     * SizeBytes - The size of the file in bytes
     * Created - The date the file was created
     * Modified - The date the file was last modified
     * IsDownloadable - Whether the file is downloadable
     * IsEditable - Whether the file is editable
     * IsArchive - Whether the file is an archive
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
     * @return A string representation of the object
     */
    public String toString() {
        return "File{IsDirectory=" + this.IsDirectory + ", IsVirtualDirectory=" + this.IsVirtualDirectory + ", Filename=" + this.Filename + ", SizeBytes=" + this.SizeBytes + ", Created=" + this.Created + ", Modified=" + this.Modified + ", IsDownloadable=" + this.IsDownloadable + ", IsEditable=" + this.IsEditable + ", IsArchive=" + this.IsArchive + ", IsExcludedFromBackups=" + this.IsExcludedFromBackups + "}";
    }
}
