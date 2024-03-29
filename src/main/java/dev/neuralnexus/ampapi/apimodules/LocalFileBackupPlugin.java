package dev.neuralnexus.ampapi.apimodules;

import com.google.gson.reflect.TypeToken;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.types.*;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class LocalFileBackupPlugin extends AMPAPI {
    public LocalFileBackupPlugin(AMPAPI ampapi) {
        super(ampapi);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param BackupId  False
     * @return ActionResult
     */
    public ActionResult DeleteFromS3(UUID BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.APICall("LocalFileBackupPlugin/DeleteFromS3", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param BackupId  False
     * @return Void
     */
    public Void DeleteLocalBackup(UUID BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.APICall("LocalFileBackupPlugin/DeleteLocalBackup", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param BackupId  False
     * @return RunningTask
     */
    public RunningTask DownloadFromS3(UUID BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        Type type = new TypeToken<RunningTask>(){}.getType();
        return (RunningTask) this.APICall("LocalFileBackupPlugin/DownloadFromS3", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<Object>
     */
    public List<Object> GetBackups() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Object>>(){}.getType();
        return (List<Object>) this.APICall("LocalFileBackupPlugin/GetBackups", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param BackupId  False
     * @param DeleteExistingData  True
     * @return ActionResult
     */
    public ActionResult RestoreBackup(UUID BackupId, Boolean DeleteExistingData) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        args.put("DeleteExistingData", DeleteExistingData);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.APICall("LocalFileBackupPlugin/RestoreBackup", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param BackupId  False
     * @param Sticky  False
     * @return Void
     */
    public Void SetBackupSticky(UUID BackupId, Boolean Sticky) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        args.put("Sticky", Sticky);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.APICall("LocalFileBackupPlugin/SetBackupSticky", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Title  False
     * @param Description  False
     * @param Sticky  False
     * @return ActionResult
     */
    public ActionResult TakeBackup(String Title, String Description, Boolean Sticky) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Title", Title);
        args.put("Description", Description);
        args.put("Sticky", Sticky);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.APICall("LocalFileBackupPlugin/TakeBackup", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param BackupId  False
     * @return RunningTask
     */
    public RunningTask UploadToS3(UUID BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        Type type = new TypeToken<RunningTask>(){}.getType();
        return (RunningTask) this.APICall("LocalFileBackupPlugin/UploadToS3", args, type);
    }

}
