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
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({
    "rawtypes",
    "unchecked",
    "unused",
    "DataFlowIssue",
    "JavadocBlankLines",
    "RedundantCast",
    "UnusedReturnValue"
})
public class FileManagerPlugin extends AMPAPI {
    public FileManagerPlugin(AuthProvider authProvider) {
        super(authProvider);
    }

    /**
     * Name Description Optional
     *
     * @param Filename False
     * @param Data False
     * @param Delete False
     * @return Void
     */
    public Void AppendFileChunk(String Filename, String Data, Boolean Delete) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Data", Data);
        args.put("Delete", Delete);
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("FileManagerPlugin/AppendFileChunk", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param FilePath False
     * @return ActionResult<String>
     */
    public ActionResult<String> CalculateFileMD5Sum(String FilePath) {
        Map<String, Object> args = new HashMap<>();
        args.put("FilePath", FilePath);
        Type type = new TypeToken<ActionResult<String>>() {}.getType();
        return (ActionResult<String>)
                this.APICall("FileManagerPlugin/CalculateFileMD5Sum", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param ModifyPath False
     * @param AsDirectory False
     * @param Exclude False
     * @return ActionResult
     */
    public ActionResult ChangeExclusion(String ModifyPath, Boolean AsDirectory, Boolean Exclude) {
        Map<String, Object> args = new HashMap<>();
        args.put("ModifyPath", ModifyPath);
        args.put("AsDirectory", AsDirectory);
        args.put("Exclude", Exclude);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("FileManagerPlugin/ChangeExclusion", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Origin False
     * @param TargetDirectory False
     * @return ActionResult
     */
    public ActionResult CopyFile(String Origin, String TargetDirectory) {
        Map<String, Object> args = new HashMap<>();
        args.put("Origin", Origin);
        args.put("TargetDirectory", TargetDirectory);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("FileManagerPlugin/CopyFile", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param PathToArchive False
     * @return ActionResult
     */
    public ActionResult CreateArchive(String PathToArchive) {
        Map<String, Object> args = new HashMap<>();
        args.put("PathToArchive", PathToArchive);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("FileManagerPlugin/CreateArchive", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param NewPath False
     * @return ActionResult
     */
    public ActionResult CreateDirectory(String NewPath) {
        Map<String, Object> args = new HashMap<>();
        args.put("NewPath", NewPath);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("FileManagerPlugin/CreateDirectory", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Source False
     * @param TargetDirectory False
     * @return ActionResult
     */
    public ActionResult DownloadFileFromURL(URL Source, String TargetDirectory) {
        Map<String, Object> args = new HashMap<>();
        args.put("Source", Source);
        args.put("TargetDirectory", TargetDirectory);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("FileManagerPlugin/DownloadFileFromURL", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return Void
     */
    public Void Dummy() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("FileManagerPlugin/Dummy", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param TrashDirectoryName False
     * @return ActionResult
     */
    public ActionResult EmptyTrash(String TrashDirectoryName) {
        Map<String, Object> args = new HashMap<>();
        args.put("TrashDirectoryName", TrashDirectoryName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("FileManagerPlugin/EmptyTrash", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param ArchivePath False
     * @param DestinationPath True
     * @return ActionResult
     */
    public ActionResult ExtractArchive(String ArchivePath, String DestinationPath) {
        Map<String, Object> args = new HashMap<>();
        args.put("ArchivePath", ArchivePath);
        args.put("DestinationPath", DestinationPath);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("FileManagerPlugin/ExtractArchive", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Dir False
     * @return List<FileDirectory>
     */
    public List<FileDirectory> GetDirectoryListing(String Dir) {
        Map<String, Object> args = new HashMap<>();
        args.put("Dir", Dir);
        Type type = new TypeToken<List<FileDirectory>>() {}.getType();
        return (List<FileDirectory>)
                this.APICall("FileManagerPlugin/GetDirectoryListing", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Filename False
     * @param Position False
     * @param Length False
     * @return FileChunkData
     */
    public FileChunkData GetFileChunk(String Filename, Integer Position, Integer Length) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Position", Position);
        args.put("Length", Length);
        Type type = new TypeToken<FileChunkData>() {}.getType();
        return (FileChunkData) this.APICall("FileManagerPlugin/GetFileChunk", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Filename False
     * @param Offset False
     * @param ChunkSize True
     * @return ActionResult<String>
     */
    public ActionResult<String> ReadFileChunk(String Filename, Integer Offset, Integer ChunkSize) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Offset", Offset);
        args.put("ChunkSize", ChunkSize);
        Type type = new TypeToken<ActionResult<String>>() {}.getType();
        return (ActionResult<String>) this.APICall("FileManagerPlugin/ReadFileChunk", args, type);
    }

    /**
     * The name component of the new directory (not the full path)
     *
     * <p>Name Description Optional
     *
     * @param oldDirectory The full path to the old directory False
     * @param NewDirectoryName The name component of the new directory (not the full path) False
     * @return ActionResult
     */
    public ActionResult RenameDirectory(String oldDirectory, String NewDirectoryName) {
        Map<String, Object> args = new HashMap<>();
        args.put("oldDirectory", oldDirectory);
        args.put("NewDirectoryName", NewDirectoryName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("FileManagerPlugin/RenameDirectory", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Filename False
     * @param NewFilename False
     * @return ActionResult
     */
    public ActionResult RenameFile(String Filename, String NewFilename) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("NewFilename", NewFilename);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("FileManagerPlugin/RenameFile", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param DirectoryName False
     * @return ActionResult
     */
    public ActionResult TrashDirectory(String DirectoryName) {
        Map<String, Object> args = new HashMap<>();
        args.put("DirectoryName", DirectoryName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("FileManagerPlugin/TrashDirectory", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Filename False
     * @return ActionResult
     */
    public ActionResult TrashFile(String Filename) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("FileManagerPlugin/TrashFile", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Filename False
     * @param Data False
     * @param Offset False
     * @param FinalChunk False
     * @return ActionResult
     */
    public ActionResult WriteFileChunk(
            String Filename, String Data, Integer Offset, Boolean FinalChunk) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Data", Data);
        args.put("Offset", Offset);
        args.put("FinalChunk", FinalChunk);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("FileManagerPlugin/WriteFileChunk", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Filename False
     * @return ActionResult
     */
    public ActionResult ReleaseFileUploadLock(String Filename) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("FileManagerPlugin/ReleaseFileUploadLock", args, type);
    }
}
