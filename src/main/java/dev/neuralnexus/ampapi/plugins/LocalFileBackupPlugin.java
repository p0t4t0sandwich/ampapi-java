/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi-java/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.plugins;

import com.google.gson.reflect.TypeToken;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.types.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings({
    "rawtypes",
    "unchecked",
    "unused",
    "DataFlowIssue",
    "JavadocBlankLines",
    "RedundantCast",
    "UnusedReturnValue"
})
public class LocalFileBackupPlugin extends AMPAPI {
    public LocalFileBackupPlugin(AuthProvider authProvider) {
        super(authProvider);
    }

    /**
     * Name Description Optional
     *
     * @param BackupId False
     * @return ActionResult
     */
    public ActionResult DeleteFromS3(UUID BackupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("LocalFileBackupPlugin/DeleteFromS3", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param BackupId False
     * @return Void
     */
    public Void DeleteLocalBackup(UUID BackupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("LocalFileBackupPlugin/DeleteLocalBackup", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param BackupId False
     * @return RunningTask
     */
    public RunningTask DownloadFromS3(UUID BackupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        Type type = new TypeToken<RunningTask>() {}.getType();
        return (RunningTask) this.APICall("LocalFileBackupPlugin/DownloadFromS3", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return List<Object>
     */
    public List<Object> GetBackups() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Object>>() {}.getType();
        return (List<Object>) this.APICall("LocalFileBackupPlugin/GetBackups", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param BackupId False
     * @param DeleteExistingData True
     * @return ActionResult
     */
    public ActionResult RestoreBackup(UUID BackupId, Boolean DeleteExistingData) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        args.put("DeleteExistingData", DeleteExistingData);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("LocalFileBackupPlugin/RestoreBackup", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param BackupId False
     * @param Sticky False
     * @return Void
     */
    public Void SetBackupSticky(UUID BackupId, Boolean Sticky) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        args.put("Sticky", Sticky);
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("LocalFileBackupPlugin/SetBackupSticky", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Title False
     * @param Description False
     * @param Sticky False
     * @param WasCreatedAutomatically True
     * @return ActionResult
     */
    public ActionResult TakeBackup(
            String Title, String Description, Boolean Sticky, Boolean WasCreatedAutomatically) {
        Map<String, Object> args = new HashMap<>();
        args.put("Title", Title);
        args.put("Description", Description);
        args.put("Sticky", Sticky);
        args.put("WasCreatedAutomatically", WasCreatedAutomatically);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("LocalFileBackupPlugin/TakeBackup", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param BackupId False
     * @return RunningTask
     */
    public RunningTask UploadToS3(UUID BackupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        Type type = new TypeToken<RunningTask>() {}.getType();
        return (RunningTask) this.APICall("LocalFileBackupPlugin/UploadToS3", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return Void
     */
    public Void RefreshBackupList() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("LocalFileBackupPlugin/RefreshBackupList", args, type);
    }
}
