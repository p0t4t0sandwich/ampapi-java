package dev.neuralnexus.ampapi.apimodules;

import dev.neuralnexus.ampapi.AMPAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalFileBackupPlugin extends AMPAPI {
    public LocalFileBackupPlugin(AMPAPI ampapi) {
        super(ampapi);
    }

    /**
     * Name Description Optional
     * @param BackupId  False
     * @return Map
     */
    public Map DeleteFromS3(String BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("LocalFileBackupPlugin/DeleteFromS3", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param BackupId  False
     * @return Void
     */
    public Void DeleteLocalBackup(String BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("LocalFileBackupPlugin/DeleteLocalBackup", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param BackupId  False
     * @return Map
     */
    public Map DownloadFromS3(String BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("LocalFileBackupPlugin/DownloadFromS3", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return List
     */
    public List GetBackups() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("LocalFileBackupPlugin/GetBackups", args, List.class);
    }

    /**
     * Name Description Optional
     * @param BackupId  False
     * @param DeleteExistingData  True
     * @return Map
     */
    public Map RestoreBackup(String BackupId, boolean DeleteExistingData) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        args.put("DeleteExistingData", DeleteExistingData);
        return this.APICall("LocalFileBackupPlugin/RestoreBackup", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param BackupId  False
     * @param Sticky  False
     * @return Void
     */
    public Void SetBackupSticky(String BackupId, boolean Sticky) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        args.put("Sticky", Sticky);
        return this.APICall("LocalFileBackupPlugin/SetBackupSticky", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param Title  False
     * @param Description  False
     * @param Sticky  False
     * @return Map
     */
    public Map TakeBackup(String Title, String Description, boolean Sticky) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Title", Title);
        args.put("Description", Description);
        args.put("Sticky", Sticky);
        return this.APICall("LocalFileBackupPlugin/TakeBackup", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param BackupId  False
     * @return Map
     */
    public Map UploadToS3(String BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("LocalFileBackupPlugin/UploadToS3", args, Map.class);
    }

}
