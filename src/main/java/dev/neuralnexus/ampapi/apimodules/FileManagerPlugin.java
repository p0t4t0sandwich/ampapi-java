package dev.neuralnexus.ampapi.apimodules;

import dev.neuralnexus.ampapi.AMPAPIBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileManagerPlugin extends AMPAPIBase {
    public FileManagerPlugin(AMPAPIBase ampapiBase) {
        super(ampapiBase);
    }

    /**
     * Name TypeName Description Optional
     * @param Filename String AMPType: String 
     * @param Data String AMPType: String 
     * @param Delete boolean AMPType: Boolean 
     * @return void AMPType: Void
     */
    public Map<?, ?> AppendFileChunk(String Filename, String Data, boolean Delete) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Data", Data);
        args.put("Delete", Delete);
        return this.APICall("FileManagerPlugin/AppendFileChunk", args);
    }

    /**
     * Name TypeName Description Optional
     * @param FilePath String AMPType: String 
     * @return  AMPType: ActionResult<String>
     */
    public Map<?, ?> CalculateFileMD5Sum(String FilePath) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("FilePath", FilePath);
        return this.APICall("FileManagerPlugin/CalculateFileMD5Sum", args);
    }

    /**
     * Name TypeName Description Optional
     * @param ModifyPath String AMPType: String 
     * @param AsDirectory boolean AMPType: Boolean 
     * @param Exclude boolean AMPType: Boolean 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> ChangeExclusion(String ModifyPath, boolean AsDirectory, boolean Exclude) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ModifyPath", ModifyPath);
        args.put("AsDirectory", AsDirectory);
        args.put("Exclude", Exclude);
        return this.APICall("FileManagerPlugin/ChangeExclusion", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Origin String AMPType: String 
     * @param TargetDirectory String AMPType: String 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> CopyFile(String Origin, String TargetDirectory) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Origin", Origin);
        args.put("TargetDirectory", TargetDirectory);
        return this.APICall("FileManagerPlugin/CopyFile", args);
    }

    /**
     * Name TypeName Description Optional
     * @param PathToArchive String AMPType: String 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> CreateArchive(String PathToArchive) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("PathToArchive", PathToArchive);
        return this.APICall("FileManagerPlugin/CreateArchive", args);
    }

    /**
     * Creates a new directory. The parent directory must already exist.
     * Name TypeName Description Optional
     * @param NewPath String AMPType: String 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> CreateDirectory(String NewPath) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("NewPath", NewPath);
        return this.APICall("FileManagerPlugin/CreateDirectory", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Source String AMPType: Uri 
     * @param TargetDirectory String AMPType: String 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> DownloadFileFromURL(String Source, String TargetDirectory) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Source", Source);
        args.put("TargetDirectory", TargetDirectory);
        return this.APICall("FileManagerPlugin/DownloadFileFromURL", args);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> Dummy() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("FileManagerPlugin/Dummy", args);
    }

    /**
     * Empties a trash bin
     * Name TypeName Description Optional
     * @param TrashDirectoryName String AMPType: String 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> EmptyTrash(String TrashDirectoryName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TrashDirectoryName", TrashDirectoryName);
        return this.APICall("FileManagerPlugin/EmptyTrash", args);
    }

    /**
     * Name TypeName Description Optional
     * @param ArchivePath String AMPType: String 
     * @param DestinationPath String AMPType: String 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> ExtractArchive(String ArchivePath, String DestinationPath) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ArchivePath", ArchivePath);
        args.put("DestinationPath", DestinationPath);
        return this.APICall("FileManagerPlugin/ExtractArchive", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Dir String AMPType: String 
     * @return List<Map<?, ?>> AMPType: IEnumerable<JObject>
     */
    public Map<?, ?> GetDirectoryListing(String Dir) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Dir", Dir);
        return this.APICall("FileManagerPlugin/GetDirectoryListing", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Filename String AMPType: String 
     * @param Position Integer AMPType: Int64 
     * @param Length Integer AMPType: Int32 
     * @return  AMPType: FileChunkData
     */
    public Map<?, ?> GetFileChunk(String Filename, Integer Position, Integer Length) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Position", Position);
        args.put("Length", Length);
        return this.APICall("FileManagerPlugin/GetFileChunk", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Filename String AMPType: String 
     * @param Offset Integer AMPType: Int64 
     * @param ChunkSize Integer AMPType: Int64 
     * @return  AMPType: ActionResult<String>
     */
    public Map<?, ?> ReadFileChunk(String Filename, Integer Offset, Integer ChunkSize) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Offset", Offset);
        args.put("ChunkSize", ChunkSize);
        return this.APICall("FileManagerPlugin/ReadFileChunk", args);
    }

    /**
     * Renames a directory
     * Name TypeName Description Optional
     * @param oldDirectory String AMPType: String The full path to the old directory
     * @param NewDirectoryName String AMPType: String The name component of the new directory (not the full path)
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> RenameDirectory(String oldDirectory, String NewDirectoryName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("oldDirectory", oldDirectory);
        args.put("NewDirectoryName", NewDirectoryName);
        return this.APICall("FileManagerPlugin/RenameDirectory", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Filename String AMPType: String 
     * @param NewFilename String AMPType: String 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> RenameFile(String Filename, String NewFilename) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("NewFilename", NewFilename);
        return this.APICall("FileManagerPlugin/RenameFile", args);
    }

    /**
     * Moves a directory to trash, files must be trashed before they can be deleted.
     * Name TypeName Description Optional
     * @param DirectoryName String AMPType: String 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> TrashDirectory(String DirectoryName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("DirectoryName", DirectoryName);
        return this.APICall("FileManagerPlugin/TrashDirectory", args);
    }

    /**
     * Moves a file to trash, files must be trashed before they can be deleted.
     * Name TypeName Description Optional
     * @param Filename String AMPType: String 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> TrashFile(String Filename) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        return this.APICall("FileManagerPlugin/TrashFile", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Filename String AMPType: String 
     * @param Data String AMPType: String 
     * @param Offset Integer AMPType: Int64 
     * @param FinalChunk boolean AMPType: Boolean 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> WriteFileChunk(String Filename, String Data, Integer Offset, boolean FinalChunk) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Data", Data);
        args.put("Offset", Offset);
        args.put("FinalChunk", FinalChunk);
        return this.APICall("FileManagerPlugin/WriteFileChunk", args);
    }

}
