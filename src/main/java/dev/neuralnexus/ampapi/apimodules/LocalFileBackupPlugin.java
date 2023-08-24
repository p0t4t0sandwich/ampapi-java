package dev.neuralnexus.ampapi.apimodules;

import dev.neuralnexus.ampapi.AMPAPIBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalFileBackupPlugin extends AMPAPIBase {
    public LocalFileBackupPlugin(AMPAPIBase ampapiBase) {
        super(ampapiBase);
    }

    /**
     * Name TypeName Description Optional
     * @param BackupId String AMPType: Guid 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> DeleteFromS3(String BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("LocalFileBackupPlugin/DeleteFromS3", args);
    }

    /**
     * Name TypeName Description Optional
     * @param BackupId String AMPType: Guid 
     * @return void AMPType: Void
     */
    public Map<?, ?> DeleteLocalBackup(String BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("LocalFileBackupPlugin/DeleteLocalBackup", args);
    }

    /**
     * Name TypeName Description Optional
     * @param BackupId String AMPType: Guid 
     * @return  AMPType: RunningTask
     */
    public Map<?, ?> DownloadFromS3(String BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("LocalFileBackupPlugin/DownloadFromS3", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<Map<?, ?>> AMPType: IEnumerable<BackupManifest>
     */
    public Map<?, ?> GetBackups() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("LocalFileBackupPlugin/GetBackups", args);
    }

    /**
     * Name TypeName Description Optional
     * @param BackupId String AMPType: Guid 
     * @param DeleteExistingData boolean AMPType: Boolean 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> RestoreBackup(String BackupId, boolean DeleteExistingData) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        args.put("DeleteExistingData", DeleteExistingData);
        return this.APICall("LocalFileBackupPlugin/RestoreBackup", args);
    }

    /**
     * Name TypeName Description Optional
     * @param BackupId String AMPType: Guid 
     * @param Sticky boolean AMPType: Boolean 
     * @return void AMPType: Void
     */
    public Map<?, ?> SetBackupSticky(String BackupId, boolean Sticky) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        args.put("Sticky", Sticky);
        return this.APICall("LocalFileBackupPlugin/SetBackupSticky", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Title String AMPType: String 
     * @param Description String AMPType: String 
     * @param Sticky boolean AMPType: Boolean 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> TakeBackup(String Title, String Description, boolean Sticky) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Title", Title);
        args.put("Description", Description);
        args.put("Sticky", Sticky);
        return this.APICall("LocalFileBackupPlugin/TakeBackup", args);
    }

    /**
     * Name TypeName Description Optional
     * @param BackupId String AMPType: Guid 
     * @return  AMPType: RunningTask
     */
    public Map<?, ?> UploadToS3(String BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("LocalFileBackupPlugin/UploadToS3", args);
    }

}
