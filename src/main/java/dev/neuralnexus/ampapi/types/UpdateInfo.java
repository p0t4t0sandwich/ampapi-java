package dev.neuralnexus.ampapi.types;

/**
 * Response type for API.Core.GetUpdateInfo
 *
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.apimodules.Core#GetUpdateInfo()
 */
public class UpdateInfo {
    /**
     * UpdateAvailable - Whether an update is available Version - The version of the update Build -
     * The build of the update ReleaseNotesURL - The URL to the release notes ToolsVersion - The
     * version of the tools PatchOnly - Whether the update is a patch
     */
    public boolean UpdateAvailable;

    public String Version;
    public String Build;
    public String ReleaseNotesURL;
    public String ToolsVersion;
    public boolean PatchOnly;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    public String toString() {
        return "UpdateInfo{UpdateAvailable="
                + this.UpdateAvailable
                + ", Version="
                + this.Version
                + ", Build="
                + this.Build
                + ", ReleaseNotesURL="
                + this.ReleaseNotesURL
                + ", ToolsVersion="
                + this.ToolsVersion
                + ", PatchOnly="
                + this.PatchOnly
                + "}";
    }
}
