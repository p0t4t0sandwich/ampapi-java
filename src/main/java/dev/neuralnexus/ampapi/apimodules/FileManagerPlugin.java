package dev.neuralnexus.ampapi.apimodules;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.responses.FileManagerPlugin.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileManagerPlugin extends AMPAPI {
    public FileManagerPlugin(AMPAPI ampapi) {
        super(ampapi);
    }

    /**
     * Name Description Optional
     * @param Filename  False
     * @param Data  False
     * @param Delete  False
     * @return Void
     */
    public Void AppendFileChunk(String Filename, String Data, boolean Delete) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Data", Data);
        args.put("Delete", Delete);
        return this.APICall("FileManagerPlugin/AppendFileChunk", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param FilePath  False
     * @return Object
     */
    public Object CalculateFileMD5Sum(String FilePath) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("FilePath", FilePath);
        return this.APICall("FileManagerPlugin/CalculateFileMD5Sum", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param ModifyPath  False
     * @param AsDirectory  False
     * @param Exclude  False
     * @return Object
     */
    public Object ChangeExclusion(String ModifyPath, boolean AsDirectory, boolean Exclude) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ModifyPath", ModifyPath);
        args.put("AsDirectory", AsDirectory);
        args.put("Exclude", Exclude);
        return this.APICall("FileManagerPlugin/ChangeExclusion", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param Origin  False
     * @param TargetDirectory  False
     * @return Object
     */
    public Object CopyFile(String Origin, String TargetDirectory) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Origin", Origin);
        args.put("TargetDirectory", TargetDirectory);
        return this.APICall("FileManagerPlugin/CopyFile", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param PathToArchive  False
     * @return Object
     */
    public Object CreateArchive(String PathToArchive) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("PathToArchive", PathToArchive);
        return this.APICall("FileManagerPlugin/CreateArchive", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param NewPath  False
     * @return Object
     */
    public Object CreateDirectory(String NewPath) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("NewPath", NewPath);
        return this.APICall("FileManagerPlugin/CreateDirectory", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param Source  False
     * @param TargetDirectory  False
     * @return Object
     */
    public Object DownloadFileFromURL(String Source, String TargetDirectory) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Source", Source);
        args.put("TargetDirectory", TargetDirectory);
        return this.APICall("FileManagerPlugin/DownloadFileFromURL", args, Object.class);
    }

    /**
     * Name Description Optional
     * @return Void
     */
    public Void Dummy() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("FileManagerPlugin/Dummy", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param TrashDirectoryName  False
     * @return Object
     */
    public Object EmptyTrash(String TrashDirectoryName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TrashDirectoryName", TrashDirectoryName);
        return this.APICall("FileManagerPlugin/EmptyTrash", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param ArchivePath  False
     * @param DestinationPath  True
     * @return Object
     */
    public Object ExtractArchive(String ArchivePath, String DestinationPath) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ArchivePath", ArchivePath);
        args.put("DestinationPath", DestinationPath);
        return this.APICall("FileManagerPlugin/ExtractArchive", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param Dir  False
     * @return List
     */
    public List GetDirectoryListing(String Dir) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Dir", Dir);
        return this.APICall("FileManagerPlugin/GetDirectoryListing", args, List.class);
    }

    /**
     * Name Description Optional
     * @param Filename  False
     * @param Position  False
     * @param Length  False
     * @return Object
     */
    public Object GetFileChunk(String Filename, Integer Position, Integer Length) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Position", Position);
        args.put("Length", Length);
        return this.APICall("FileManagerPlugin/GetFileChunk", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param Filename  False
     * @param Offset  False
     * @param ChunkSize  True
     * @return Object
     */
    public Object ReadFileChunk(String Filename, Integer Offset, Integer ChunkSize) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Offset", Offset);
        args.put("ChunkSize", ChunkSize);
        return this.APICall("FileManagerPlugin/ReadFileChunk", args, Object.class);
    }

    /**The name component of the new directory (not the full path)
     * Name Description Optional
     * @param oldDirectory The full path to the old directory False
     * @param NewDirectoryName The name component of the new directory (not the full path) False
     * @return Object
     */
    public Object RenameDirectory(String oldDirectory, String NewDirectoryName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("oldDirectory", oldDirectory);
        args.put("NewDirectoryName", NewDirectoryName);
        return this.APICall("FileManagerPlugin/RenameDirectory", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param Filename  False
     * @param NewFilename  False
     * @return Object
     */
    public Object RenameFile(String Filename, String NewFilename) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("NewFilename", NewFilename);
        return this.APICall("FileManagerPlugin/RenameFile", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param DirectoryName  False
     * @return Object
     */
    public Object TrashDirectory(String DirectoryName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("DirectoryName", DirectoryName);
        return this.APICall("FileManagerPlugin/TrashDirectory", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param Filename  False
     * @return Object
     */
    public Object TrashFile(String Filename) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        return this.APICall("FileManagerPlugin/TrashFile", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param Filename  False
     * @param Data  False
     * @param Offset  False
     * @param FinalChunk  False
     * @return Object
     */
    public Object WriteFileChunk(String Filename, String Data, Integer Offset, boolean FinalChunk) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Data", Data);
        args.put("Offset", Offset);
        args.put("FinalChunk", FinalChunk);
        return this.APICall("FileManagerPlugin/WriteFileChunk", args, Object.class);
    }

}
