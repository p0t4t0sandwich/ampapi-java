package dev.neuralnexus.ampapi.apimodules;

import com.google.gson.reflect.TypeToken;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.auth.AuthStore;
import dev.neuralnexus.ampapi.types.*;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class FileManagerPlugin extends AMPAPI {
    public FileManagerPlugin(AuthStore authStore, String instanceName) {
        super(authStore, instanceName);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Filename  False
     * @param Data  False
     * @param Delete  False
     * @return Void
     */
    public Void AppendFileChunk(String Filename, String Data, Boolean Delete) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Data", Data);
        args.put("Delete", Delete);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param FilePath  False
     * @return ActionResult<String>
     */
    public ActionResult<String> CalculateFileMD5Sum(String FilePath) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("FilePath", FilePath);
        Type type = new TypeToken<ActionResult<String>>(){}.getType();
        return (ActionResult<String>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param ModifyPath  False
     * @param AsDirectory  False
     * @param Exclude  False
     * @return ActionResult
     */
    public ActionResult ChangeExclusion(String ModifyPath, Boolean AsDirectory, Boolean Exclude) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ModifyPath", ModifyPath);
        args.put("AsDirectory", AsDirectory);
        args.put("Exclude", Exclude);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Origin  False
     * @param TargetDirectory  False
     * @return ActionResult
     */
    public ActionResult CopyFile(String Origin, String TargetDirectory) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Origin", Origin);
        args.put("TargetDirectory", TargetDirectory);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param PathToArchive  False
     * @return ActionResult
     */
    public ActionResult CreateArchive(String PathToArchive) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("PathToArchive", PathToArchive);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param NewPath  False
     * @return ActionResult
     */
    public ActionResult CreateDirectory(String NewPath) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("NewPath", NewPath);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Source  False
     * @param TargetDirectory  False
     * @return ActionResult
     */
    public ActionResult DownloadFileFromURL(URL Source, String TargetDirectory) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Source", Source);
        args.put("TargetDirectory", TargetDirectory);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Void
     */
    public Void Dummy() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param TrashDirectoryName  False
     * @return ActionResult
     */
    public ActionResult EmptyTrash(String TrashDirectoryName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TrashDirectoryName", TrashDirectoryName);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param ArchivePath  False
     * @param DestinationPath  True
     * @return ActionResult
     */
    public ActionResult ExtractArchive(String ArchivePath, String DestinationPath) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ArchivePath", ArchivePath);
        args.put("DestinationPath", DestinationPath);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Dir  False
     * @return List<FileDirectory>
     */
    public List<FileDirectory> GetDirectoryListing(String Dir) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Dir", Dir);
        Type type = new TypeToken<List<FileDirectory>>(){}.getType();
        return (List<FileDirectory>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Filename  False
     * @param Position  False
     * @param Length  False
     * @return FileChunkData
     */
    public FileChunkData GetFileChunk(String Filename, Integer Position, Integer Length) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Position", Position);
        args.put("Length", Length);
        Type type = new TypeToken<FileChunkData>(){}.getType();
        return (FileChunkData) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Filename  False
     * @param Offset  False
     * @param ChunkSize  True
     * @return ActionResult<String>
     */
    public ActionResult<String> ReadFileChunk(String Filename, Integer Offset, Integer ChunkSize) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Offset", Offset);
        args.put("ChunkSize", ChunkSize);
        Type type = new TypeToken<ActionResult<String>>(){}.getType();
        return (ActionResult<String>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * The name component of the new directory (not the full path)
     *
     * Name Description Optional
     * @param oldDirectory The full path to the old directory False
     * @param NewDirectoryName The name component of the new directory (not the full path) False
     * @return ActionResult
     */
    public ActionResult RenameDirectory(String oldDirectory, String NewDirectoryName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("oldDirectory", oldDirectory);
        args.put("NewDirectoryName", NewDirectoryName);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Filename  False
     * @param NewFilename  False
     * @return ActionResult
     */
    public ActionResult RenameFile(String Filename, String NewFilename) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("NewFilename", NewFilename);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param DirectoryName  False
     * @return ActionResult
     */
    public ActionResult TrashDirectory(String DirectoryName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("DirectoryName", DirectoryName);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Filename  False
     * @return ActionResult
     */
    public ActionResult TrashFile(String Filename) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Filename  False
     * @param Data  False
     * @param Offset  False
     * @param FinalChunk  False
     * @return ActionResult
     */
    public ActionResult WriteFileChunk(String Filename, String Data, Integer Offset, Boolean FinalChunk) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Data", Data);
        args.put("Offset", Offset);
        args.put("FinalChunk", FinalChunk);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Filename  False
     * @return ActionResult
     */
    public ActionResult ReleaseFileUploadLock(String Filename) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

}
