package ca.sperrer.p0t4t0sandwich.ampapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class AMPAPI {
    final String baseUri;
    private final String dataSource;
    String sessionId = "";

    /**
     * Creates a new AMPAPI instance.
     * @param baseURI The base URI of the AMP instance to connect to.
     */
    public AMPAPI(String baseURI) {
        this.baseUri = baseURI;

        if (baseURI.charAt(baseURI.length() - 1) == '/') {
            this.dataSource = this.baseUri + "API";
        } else {
            this.dataSource = this.baseUri + "/API";
        }
    }

    /**
     * General API call method.
     * @param endpoint The endpoint to call.
     * @param data The data to send.
     */
    public HashMap<?,?> APICall(String endpoint, HashMap<String, Object> data) {
        try {
            data.put("SESSIONID", this.sessionId);

            Gson gson = new GsonBuilder().create();
            String data_json = gson.toJson(data);

            URL url = new URL(this.dataSource + endpoint);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("User-Agent", "ampapi-java");
            con.setConnectTimeout(5000);
            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream());
            osw.write(data_json);
            osw.flush();
            osw.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            return gson.fromJson(br.readLine(), HashMap.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public HashMap<?, ?> ADSModule_AddDatastore(Object newDatastore) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("newDatastore", newDatastore);
        return this.APICall("/ADSModule/AddDatastore", args);
    }

    public HashMap<?, ?> ADSModule_DeleteDatastore(Object id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return this.APICall("/ADSModule/DeleteDatastore", args);
    }

    public HashMap<?, ?> ADSModule_UpdateDatastore(Object updatedDatastore) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("updatedDatastore", updatedDatastore);
        return this.APICall("/ADSModule/UpdateDatastore", args);
    }

    public HashMap<?, ?> ADSModule_GetDatastores() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetDatastores", args);
    }

    public HashMap<?, ?> ADSModule_RequestDatastoreSizeCalculation(Object datastoreId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("datastoreId", datastoreId);
        return this.APICall("/ADSModule/RequestDatastoreSizeCalculation", args);
    }

    public HashMap<?, ?> ADSModule_GetDatastore(Object id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return this.APICall("/ADSModule/GetDatastore", args);
    }

    public HashMap<?, ?> ADSModule_RepairDatastore(Object id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return this.APICall("/ADSModule/RepairDatastore", args);
    }

    public HashMap<?, ?> ADSModule_GetDatastoreInstances(Object datastoreId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("datastoreId", datastoreId);
        return this.APICall("/ADSModule/GetDatastoreInstances", args);
    }

    public HashMap<?, ?> ADSModule_MoveInstanceDatastore(Object instanceId, Object datastoreId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        args.put("datastoreId", datastoreId);
        return this.APICall("/ADSModule/MoveInstanceDatastore", args);
    }

    public HashMap<?, ?> ADSModule_GetDeploymentTemplates() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetDeploymentTemplates", args);
    }

    public HashMap<?, ?> ADSModule_CreateDeploymentTemplate(Object Name) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        return this.APICall("/ADSModule/CreateDeploymentTemplate", args);
    }

    public HashMap<?, ?> ADSModule_UpdateDeploymentTemplate(Object templateToUpdate) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("templateToUpdate", templateToUpdate);
        return this.APICall("/ADSModule/UpdateDeploymentTemplate", args);
    }

    public HashMap<?, ?> ADSModule_DeleteDeploymentTemplate(Object Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("/ADSModule/DeleteDeploymentTemplate", args);
    }

    public HashMap<?, ?> ADSModule_CloneTemplate(Object Id, Object NewName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("NewName", NewName);
        return this.APICall("/ADSModule/CloneTemplate", args);
    }

    public HashMap<?, ?> ADSModule_ApplyTemplate(Object InstanceID, Object TemplateID, Object NewFriendlyName, Object Secret, Object RestartIfPreviouslyRunning) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceID", InstanceID);
        args.put("TemplateID", TemplateID);
        args.put("NewFriendlyName", NewFriendlyName);
        args.put("Secret", Secret);
        args.put("RestartIfPreviouslyRunning", RestartIfPreviouslyRunning);
        return this.APICall("/ADSModule/ApplyTemplate", args);
    }

    public HashMap<?, ?> ADSModule_DeployTemplate(Object TemplateID, Object NewUsername, Object NewPassword, Object NewEmail, Object RequiredTags, Object Tag, Object FriendlyName, Object Secret, Object PostCreate, Object ExtraProvisionSettings) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TemplateID", TemplateID);
        args.put("NewUsername", NewUsername);
        args.put("NewPassword", NewPassword);
        args.put("NewEmail", NewEmail);
        args.put("RequiredTags", RequiredTags);
        args.put("Tag", Tag);
        args.put("FriendlyName", FriendlyName);
        args.put("Secret", Secret);
        args.put("PostCreate", PostCreate);
        args.put("ExtraProvisionSettings", ExtraProvisionSettings);
        return this.APICall("/ADSModule/DeployTemplate", args);
    }

    public HashMap<?, ?> ADSModule_GetTargetInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetTargetInfo", args);
    }

    public HashMap<?, ?> ADSModule_GetSupportedApplications() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetSupportedApplications", args);
    }

    public HashMap<?, ?> ADSModule_RefreshAppCache() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/RefreshAppCache", args);
    }

    public HashMap<?, ?> ADSModule_RefreshRemoteConfigStores() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/RefreshRemoteConfigStores", args);
    }

    public HashMap<?, ?> ADSModule_GetApplicationEndpoints(Object instanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        return this.APICall("/ADSModule/GetApplicationEndpoints", args);
    }

    public HashMap<?, ?> ADSModule_ReactivateLocalInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/ReactivateLocalInstances", args);
    }

    public HashMap<?, ?> ADSModule_GetInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetInstances", args);
    }

    public HashMap<?, ?> ADSModule_GetInstance(Object InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("/ADSModule/GetInstance", args);
    }

    public HashMap<?, ?> ADSModule_ModifyCustomFirewallRule(Object instanceId, Object PortNumber, Object Range, Object Protocol, Object Description, Object Open) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        args.put("PortNumber", PortNumber);
        args.put("Range", Range);
        args.put("Protocol", Protocol);
        args.put("Description", Description);
        args.put("Open", Open);
        return this.APICall("/ADSModule/ModifyCustomFirewallRule", args);
    }

    public HashMap<?, ?> ADSModule_ManageInstance(Object InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("/ADSModule/ManageInstance", args);
    }

    public HashMap<?, ?> ADSModule_GetGroup(Object GroupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("GroupId", GroupId);
        return this.APICall("/ADSModule/GetGroup", args);
    }

    public HashMap<?, ?> ADSModule_RefreshGroup(Object GroupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("GroupId", GroupId);
        return this.APICall("/ADSModule/RefreshGroup", args);
    }

    public HashMap<?, ?> ADSModule_GetLocalInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetLocalInstances", args);
    }

    public HashMap<?, ?> ADSModule_GetInstanceStatuses() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetInstanceStatuses", args);
    }

    public HashMap<?, ?> ADSModule_GetProvisionFitness() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetProvisionFitness", args);
    }

    public HashMap<?, ?> ADSModule_AttachADS(Object Friendly, Object IsHTTPS, Object Host, Object Port, Object InstanceID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Friendly", Friendly);
        args.put("IsHTTPS", IsHTTPS);
        args.put("Host", Host);
        args.put("Port", Port);
        args.put("InstanceID", InstanceID);
        return this.APICall("/ADSModule/AttachADS", args);
    }

    public HashMap<?, ?> ADSModule_DetatchTarget(Object Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("/ADSModule/DetatchTarget", args);
    }

    public HashMap<?, ?> ADSModule_UpdateTargetInfo(Object Id, Object FriendlyName, Object Url, Object Description, Object Tags) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("FriendlyName", FriendlyName);
        args.put("Url", Url);
        args.put("Description", Description);
        args.put("Tags", Tags);
        return this.APICall("/ADSModule/UpdateTargetInfo", args);
    }

    public HashMap<?, ?> ADSModule_ConvertToManaged(Object InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("/ADSModule/ConvertToManaged", args);
    }

    public HashMap<?, ?> ADSModule_GetInstanceNetworkInfo(Object InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("/ADSModule/GetInstanceNetworkInfo", args);
    }

    public HashMap<?, ?> ADSModule_SetInstanceNetworkInfo(Object InstanceId, Object PortMappings) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        args.put("PortMappings", PortMappings);
        return this.APICall("/ADSModule/SetInstanceNetworkInfo", args);
    }

    public HashMap<?, ?> ADSModule_ApplyInstanceConfiguration(Object InstanceID, Object Args, Object RebuildConfiguration) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceID", InstanceID);
        args.put("Args", Args);
        args.put("RebuildConfiguration", RebuildConfiguration);
        return this.APICall("/ADSModule/ApplyInstanceConfiguration", args);
    }

    public HashMap<?, ?> ADSModule_CreateLocalInstance(Object Instance, Object PostCreate) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Instance", Instance);
        args.put("PostCreate", PostCreate);
        return this.APICall("/ADSModule/CreateLocalInstance", args);
    }

    public HashMap<?, ?> ADSModule_CreateInstance(Object TargetADSInstance, Object NewInstanceId, Object Module, Object InstanceName, Object FriendlyName, Object IPBinding, Object PortNumber, Object AdminUsername, Object AdminPassword, Object ProvisionSettings, Object AutoConfigure, Object PostCreate, Object StartOnBoot, Object DisplayImageSource, Object TargetDatastore) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TargetADSInstance", TargetADSInstance);
        args.put("NewInstanceId", NewInstanceId);
        args.put("Module", Module);
        args.put("InstanceName", InstanceName);
        args.put("FriendlyName", FriendlyName);
        args.put("IPBinding", IPBinding);
        args.put("PortNumber", PortNumber);
        args.put("AdminUsername", AdminUsername);
        args.put("AdminPassword", AdminPassword);
        args.put("ProvisionSettings", ProvisionSettings);
        args.put("AutoConfigure", AutoConfigure);
        args.put("PostCreate", PostCreate);
        args.put("StartOnBoot", StartOnBoot);
        args.put("DisplayImageSource", DisplayImageSource);
        args.put("TargetDatastore", TargetDatastore);
        return this.APICall("/ADSModule/CreateInstance", args);
    }

    public HashMap<?, ?> ADSModule_SetInstanceConfig(Object InstanceName, Object SettingNode, Object Value) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        args.put("SettingNode", SettingNode);
        args.put("Value", Value);
        return this.APICall("/ADSModule/SetInstanceConfig", args);
    }

    public HashMap<?, ?> ADSModule_RefreshInstanceConfig(Object InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("/ADSModule/RefreshInstanceConfig", args);
    }

    public HashMap<?, ?> ADSModule_HandoutInstanceConfigs(Object ForModule, Object SettingNode, Object Values) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ForModule", ForModule);
        args.put("SettingNode", SettingNode);
        args.put("Values", Values);
        return this.APICall("/ADSModule/HandoutInstanceConfigs", args);
    }

    public HashMap<?, ?> ADSModule_GetProvisionArguments(Object ModuleName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ModuleName", ModuleName);
        return this.APICall("/ADSModule/GetProvisionArguments", args);
    }

    public HashMap<?, ?> ADSModule_TestADSLoginDetails(Object url, Object username, Object password) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("url", url);
        args.put("username", username);
        args.put("password", password);
        return this.APICall("/ADSModule/TestADSLoginDetails", args);
    }

    public HashMap<?, ?> ADSModule_RegisterTarget(Object controllerUrl, Object myUrl, Object username, Object password, Object twoFactorToken, Object friendlyName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("controllerUrl", controllerUrl);
        args.put("myUrl", myUrl);
        args.put("username", username);
        args.put("password", password);
        args.put("twoFactorToken", twoFactorToken);
        args.put("friendlyName", friendlyName);
        return this.APICall("/ADSModule/RegisterTarget", args);
    }

    public HashMap<?, ?> ADSModule_UpdateTarget(Object TargetID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TargetID", TargetID);
        return this.APICall("/ADSModule/UpdateTarget", args);
    }

    public HashMap<?, ?> ADSModule_UpdateInstanceInfo(Object InstanceId, Object FriendlyName, Object Description, Object StartOnBoot, Object Suspended, Object ExcludeFromFirewall, Object RunInContainer, Object ContainerMemory, Object MemoryPolicy, Object ContainerMaxCPU) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        args.put("FriendlyName", FriendlyName);
        args.put("Description", Description);
        args.put("StartOnBoot", StartOnBoot);
        args.put("Suspended", Suspended);
        args.put("ExcludeFromFirewall", ExcludeFromFirewall);
        args.put("RunInContainer", RunInContainer);
        args.put("ContainerMemory", ContainerMemory);
        args.put("MemoryPolicy", MemoryPolicy);
        args.put("ContainerMaxCPU", ContainerMaxCPU);
        return this.APICall("/ADSModule/UpdateInstanceInfo", args);
    }

    public HashMap<?, ?> ADSModule_SetInstanceSuspended(Object InstanceName, Object Suspended) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        args.put("Suspended", Suspended);
        return this.APICall("/ADSModule/SetInstanceSuspended", args);
    }

    public HashMap<?, ?> ADSModule_UpgradeInstance(Object InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("/ADSModule/UpgradeInstance", args);
    }

    public HashMap<?, ?> ADSModule_StartAllInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/StartAllInstances", args);
    }

    public HashMap<?, ?> ADSModule_StopAllInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/StopAllInstances", args);
    }

    public HashMap<?, ?> ADSModule_UpgradeAllInstances(Object RestartRunning) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RestartRunning", RestartRunning);
        return this.APICall("/ADSModule/UpgradeAllInstances", args);
    }

    public HashMap<?, ?> ADSModule_StartInstance(Object InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("/ADSModule/StartInstance", args);
    }

    public HashMap<?, ?> ADSModule_RestartInstance(Object InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("/ADSModule/RestartInstance", args);
    }

    public HashMap<?, ?> ADSModule_StopInstance(Object InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("/ADSModule/StopInstance", args);
    }

    public HashMap<?, ?> ADSModule_DeleteInstanceUsers(Object InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("/ADSModule/DeleteInstanceUsers", args);
    }

    public HashMap<?, ?> ADSModule_DeleteInstance(Object InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("/ADSModule/DeleteInstance", args);
    }

    public HashMap<?, ?> ADSModule_ExtractEverywhere(Object SourceArchive) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("SourceArchive", SourceArchive);
        return this.APICall("/ADSModule/ExtractEverywhere", args);
    }

    public HashMap<?, ?> ADSModule_Servers(Object id, Object REQ_RAWJSON) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        args.put("REQ_RAWJSON", REQ_RAWJSON);
        return this.APICall("/ADSModule/Servers", args);
    }

    public HashMap<?, ?> FileManagerPlugin_Dummy() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/FileManagerPlugin/Dummy", args);
    }

    public HashMap<?, ?> FileManagerPlugin_CalculateFileMD5Sum(Object FilePath) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("FilePath", FilePath);
        return this.APICall("/FileManagerPlugin/CalculateFileMD5Sum", args);
    }

    public HashMap<?, ?> FileManagerPlugin_ChangeExclusion(Object ModifyPath, Object AsDirectory, Object Exclude) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ModifyPath", ModifyPath);
        args.put("AsDirectory", AsDirectory);
        args.put("Exclude", Exclude);
        return this.APICall("/FileManagerPlugin/ChangeExclusion", args);
    }

    public HashMap<?, ?> FileManagerPlugin_CreateArchive(Object PathToArchive) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("PathToArchive", PathToArchive);
        return this.APICall("/FileManagerPlugin/CreateArchive", args);
    }

    public HashMap<?, ?> FileManagerPlugin_ExtractArchive(Object ArchivePath, Object DestinationPath) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ArchivePath", ArchivePath);
        args.put("DestinationPath", DestinationPath);
        return this.APICall("/FileManagerPlugin/ExtractArchive", args);
    }

    public HashMap<?, ?> FileManagerPlugin_GetDirectoryListing(Object Dir) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Dir", Dir);
        return this.APICall("/FileManagerPlugin/GetDirectoryListing", args);
    }

    public HashMap<?, ?> FileManagerPlugin_GetFileChunk(Object Filename, Object Position, Object Length) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Position", Position);
        args.put("Length", Length);
        return this.APICall("/FileManagerPlugin/GetFileChunk", args);
    }

    public HashMap<?, ?> FileManagerPlugin_AppendFileChunk(Object Filename, Object Data, Object Delete) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Data", Data);
        args.put("Delete", Delete);
        return this.APICall("/FileManagerPlugin/AppendFileChunk", args);
    }

    public HashMap<?, ?> FileManagerPlugin_WriteFileChunk(Object Filename, Object Position, Object Data) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Position", Position);
        args.put("Data", Data);
        return this.APICall("/FileManagerPlugin/WriteFileChunk", args);
    }

    public HashMap<?, ?> FileManagerPlugin_DownloadFileFromURL(Object Source, Object TargetDirectory) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Source", Source);
        args.put("TargetDirectory", TargetDirectory);
        return this.APICall("/FileManagerPlugin/DownloadFileFromURL", args);
    }

    public HashMap<?, ?> FileManagerPlugin_RenameFile(Object Filename, Object NewFilename) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("NewFilename", NewFilename);
        return this.APICall("/FileManagerPlugin/RenameFile", args);
    }

    public HashMap<?, ?> FileManagerPlugin_CopyFile(Object Origin, Object TargetDirectory) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Origin", Origin);
        args.put("TargetDirectory", TargetDirectory);
        return this.APICall("/FileManagerPlugin/CopyFile", args);
    }

    public HashMap<?, ?> FileManagerPlugin_TrashFile(Object Filename) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        return this.APICall("/FileManagerPlugin/TrashFile", args);
    }

    public HashMap<?, ?> FileManagerPlugin_TrashDirectory(Object DirectoryName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("DirectoryName", DirectoryName);
        return this.APICall("/FileManagerPlugin/TrashDirectory", args);
    }

    public HashMap<?, ?> FileManagerPlugin_EmptyTrash(Object TrashDirectoryName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TrashDirectoryName", TrashDirectoryName);
        return this.APICall("/FileManagerPlugin/EmptyTrash", args);
    }

    public HashMap<?, ?> FileManagerPlugin_CreateDirectory(Object NewPath) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("NewPath", NewPath);
        return this.APICall("/FileManagerPlugin/CreateDirectory", args);
    }

    public HashMap<?, ?> FileManagerPlugin_RenameDirectory(Object oldDirectory, Object NewDirectoryName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("oldDirectory", oldDirectory);
        args.put("NewDirectoryName", NewDirectoryName);
        return this.APICall("/FileManagerPlugin/RenameDirectory", args);
    }

    public HashMap<?, ?> EmailSenderPlugin_TestSMTPSettings() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/EmailSenderPlugin/TestSMTPSettings", args);
    }

    public HashMap<?, ?> LocalFileBackupPlugin_UploadToS3(Object BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("/LocalFileBackupPlugin/UploadToS3", args);
    }

    public HashMap<?, ?> LocalFileBackupPlugin_DownloadFromS3(Object BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("/LocalFileBackupPlugin/DownloadFromS3", args);
    }

    public HashMap<?, ?> LocalFileBackupPlugin_DeleteFromS3(Object BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("/LocalFileBackupPlugin/DeleteFromS3", args);
    }

    public HashMap<?, ?> LocalFileBackupPlugin_GetBackups() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/LocalFileBackupPlugin/GetBackups", args);
    }

    public HashMap<?, ?> LocalFileBackupPlugin_RestoreBackup(Object BackupId, Object DeleteExistingData) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        args.put("DeleteExistingData", DeleteExistingData);
        return this.APICall("/LocalFileBackupPlugin/RestoreBackup", args);
    }

    public HashMap<?, ?> LocalFileBackupPlugin_DeleteLocalBackup(Object BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("/LocalFileBackupPlugin/DeleteLocalBackup", args);
    }

    public HashMap<?, ?> LocalFileBackupPlugin_SetBackupSticky(Object BackupId, Object Sticky) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        args.put("Sticky", Sticky);
        return this.APICall("/LocalFileBackupPlugin/SetBackupSticky", args);
    }

    public HashMap<?, ?> LocalFileBackupPlugin_TakeBackup(Object Title, Object Description, Object Sticky) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Title", Title);
        args.put("Description", Description);
        args.put("Sticky", Sticky);
        return this.APICall("/LocalFileBackupPlugin/TakeBackup", args);
    }

    public HashMap<?, ?> Core_GetAuditLogEntries(Object Before, Object Count) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Before", Before);
        args.put("Count", Count);
        return this.APICall("/Core/GetAuditLogEntries", args);
    }

    public HashMap<?, ?> Core_GetSettingsSpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetSettingsSpec", args);
    }

    public HashMap<?, ?> Core_RefreshSettingValueList(Object Node) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Node", Node);
        return this.APICall("/Core/RefreshSettingValueList", args);
    }

    public HashMap<?, ?> Core_RefreshSettingsSourceCache() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/RefreshSettingsSourceCache", args);
    }

    public HashMap<?, ?> Core_GetSettingValues(Object SettingNode, Object WithRefresh) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("SettingNode", SettingNode);
        args.put("WithRefresh", WithRefresh);
        return this.APICall("/Core/GetSettingValues", args);
    }

    public HashMap<?, ?> Core_GetProvisionSpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetProvisionSpec", args);
    }

    public HashMap<?, ?> Core_GetConfig(Object node) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("node", node);
        return this.APICall("/Core/GetConfig", args);
    }

    public HashMap<?, ?> Core_GetConfigs(Object nodes) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("nodes", nodes);
        return this.APICall("/Core/GetConfigs", args);
    }

    public HashMap<?, ?> Core_SetConfigs(Object data) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("data", data);
        return this.APICall("/Core/SetConfigs", args);
    }

    public HashMap<?, ?> Core_SetConfig(Object node, Object value) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("node", node);
        args.put("value", value);
        return this.APICall("/Core/SetConfig", args);
    }

    public HashMap<?, ?> Core_GetRoleData() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetRoleData", args);
    }

    public HashMap<?, ?> Core_GetRoleIds() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetRoleIds", args);
    }

    public HashMap<?, ?> Core_GetRole(Object RoleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        return this.APICall("/Core/GetRole", args);
    }

    public HashMap<?, ?> Core_CreateRole(Object Name, Object AsCommonRole) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        args.put("AsCommonRole", AsCommonRole);
        return this.APICall("/Core/CreateRole", args);
    }

    public HashMap<?, ?> Core_DeleteRole(Object RoleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        return this.APICall("/Core/DeleteRole", args);
    }

    public HashMap<?, ?> Core_RenameRole(Object RoleId, Object NewName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("NewName", NewName);
        return this.APICall("/Core/RenameRole", args);
    }

    public HashMap<?, ?> Core_SetAMPRolePermission(Object RoleId, Object PermissionNode, Object Enabled) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("PermissionNode", PermissionNode);
        args.put("Enabled", Enabled);
        return this.APICall("/Core/SetAMPRolePermission", args);
    }

    public HashMap<?, ?> Core_GetAMPRolePermissions(Object RoleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        return this.APICall("/Core/GetAMPRolePermissions", args);
    }

    public HashMap<?, ?> Core_GetScheduleData() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetScheduleData", args);
    }

    public HashMap<?, ?> Core_AddEventTrigger(Object triggerId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        return this.APICall("/Core/AddEventTrigger", args);
    }

    public HashMap<?, ?> Core_RunEventTriggerImmediately(Object triggerId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        return this.APICall("/Core/RunEventTriggerImmediately", args);
    }

    public HashMap<?, ?> Core_AddIntervalTrigger(Object months, Object days, Object hours, Object minutes, Object daysOfMonth, Object description) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("months", months);
        args.put("days", days);
        args.put("hours", hours);
        args.put("minutes", minutes);
        args.put("daysOfMonth", daysOfMonth);
        args.put("description", description);
        return this.APICall("/Core/AddIntervalTrigger", args);
    }

    public HashMap<?, ?> Core_GetTimeIntervalTrigger(Object Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("/Core/GetTimeIntervalTrigger", args);
    }

    public HashMap<?, ?> Core_EditIntervalTrigger(Object Id, Object months, Object days, Object hours, Object minutes, Object daysOfMonth, Object description) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("months", months);
        args.put("days", days);
        args.put("hours", hours);
        args.put("minutes", minutes);
        args.put("daysOfMonth", daysOfMonth);
        args.put("description", description);
        return this.APICall("/Core/EditIntervalTrigger", args);
    }

    public HashMap<?, ?> Core_SetTriggerEnabled(Object Id, Object Enabled) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("Enabled", Enabled);
        return this.APICall("/Core/SetTriggerEnabled", args);
    }

    public HashMap<?, ?> Core_AddTask(Object TriggerID, Object MethodID, Object ParameterMapping) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("MethodID", MethodID);
        args.put("ParameterMapping", ParameterMapping);
        return this.APICall("/Core/AddTask", args);
    }

    public HashMap<?, ?> Core_EditTask(Object TriggerID, Object TaskID, Object ParameterMapping) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        args.put("ParameterMapping", ParameterMapping);
        return this.APICall("/Core/EditTask", args);
    }

    public HashMap<?, ?> Core_ChangeTaskOrder(Object TriggerID, Object TaskID, Object NewOrder) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        args.put("NewOrder", NewOrder);
        return this.APICall("/Core/ChangeTaskOrder", args);
    }

    public HashMap<?, ?> Core_DeleteTask(Object TriggerID, Object TaskID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        return this.APICall("/Core/DeleteTask", args);
    }

    public HashMap<?, ?> Core_DeleteTrigger(Object TriggerID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        return this.APICall("/Core/DeleteTrigger", args);
    }

    public HashMap<?, ?> Core_GetActiveAMPSessions() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetActiveAMPSessions", args);
    }

    public HashMap<?, ?> Core_EndUserSession(Object Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("/Core/EndUserSession", args);
    }

    public HashMap<?, ?> Core_GetAMPUsersSummary() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetAMPUsersSummary", args);
    }

    public HashMap<?, ?> Core_GetAMPUserInfo(Object Username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        return this.APICall("/Core/GetAMPUserInfo", args);
    }

    public HashMap<?, ?> Core_GetAllAMPUserInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetAllAMPUserInfo", args);
    }

    public HashMap<?, ?> Core_SetAMPUserRoleMembership(Object UserId, Object RoleId, Object IsMember) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UserId", UserId);
        args.put("RoleId", RoleId);
        args.put("IsMember", IsMember);
        return this.APICall("/Core/SetAMPUserRoleMembership", args);
    }

    public HashMap<?, ?> Core_GetPermissionsSpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetPermissionsSpec", args);
    }

    public HashMap<?, ?> Core_CreateUser(Object Username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        return this.APICall("/Core/CreateUser", args);
    }

    public HashMap<?, ?> Core_DeleteUser(Object Username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        return this.APICall("/Core/DeleteUser", args);
    }

    public HashMap<?, ?> Core_UpdateUserInfo(Object Username, Object Disabled, Object PasswordExpires, Object CannotChangePassword, Object MustChangePassword, Object EmailAddress) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("Disabled", Disabled);
        args.put("PasswordExpires", PasswordExpires);
        args.put("CannotChangePassword", CannotChangePassword);
        args.put("MustChangePassword", MustChangePassword);
        args.put("EmailAddress", EmailAddress);
        return this.APICall("/Core/UpdateUserInfo", args);
    }

    public HashMap<?, ?> Core_GetWebauthnChallenge() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetWebauthnChallenge", args);
    }

    public HashMap<?, ?> Core_GetWebauthnCredentialIDs(Object username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("username", username);
        return this.APICall("/Core/GetWebauthnCredentialIDs", args);
    }

    public HashMap<?, ?> Core_WebauthnRegister(Object attestationObject, Object clientDataJSON, Object description) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("attestationObject", attestationObject);
        args.put("clientDataJSON", clientDataJSON);
        args.put("description", description);
        return this.APICall("/Core/WebauthnRegister", args);
    }

    public HashMap<?, ?> Core_GetWebauthnCredentialSummaries() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetWebauthnCredentialSummaries", args);
    }

    public HashMap<?, ?> Core_RevokeWebauthnCredential(Object ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        return this.APICall("/Core/RevokeWebauthnCredential", args);
    }

    public HashMap<?, ?> Core_UpdateAccountInfo(Object EmailAddress, Object TwoFactorPIN) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("EmailAddress", EmailAddress);
        args.put("TwoFactorPIN", TwoFactorPIN);
        return this.APICall("/Core/UpdateAccountInfo", args);
    }

    public HashMap<?, ?> Core_EnableTwoFactor(Object Username, Object Password) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("Password", Password);
        return this.APICall("/Core/EnableTwoFactor", args);
    }

    public HashMap<?, ?> Core_ConfirmTwoFactorSetup(Object Username, Object TwoFactorCode) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("TwoFactorCode", TwoFactorCode);
        return this.APICall("/Core/ConfirmTwoFactorSetup", args);
    }

    public HashMap<?, ?> Core_DisableTwoFactor(Object Password, Object TwoFactorCode) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Password", Password);
        args.put("TwoFactorCode", TwoFactorCode);
        return this.APICall("/Core/DisableTwoFactor", args);
    }

    public HashMap<?, ?> Core_ResetUserPassword(Object Username, Object NewPassword) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("NewPassword", NewPassword);
        return this.APICall("/Core/ResetUserPassword", args);
    }

    public HashMap<?, ?> Core_DeleteInstanceUsers(Object InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("/Core/DeleteInstanceUsers", args);
    }

    public HashMap<?, ?> Core_ChangeUserPassword(Object Username, Object OldPassword, Object NewPassword, Object TwoFactorPIN) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("OldPassword", OldPassword);
        args.put("NewPassword", NewPassword);
        args.put("TwoFactorPIN", TwoFactorPIN);
        return this.APICall("/Core/ChangeUserPassword", args);
    }

    public HashMap<?, ?> Core_GetUpdates() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetUpdates", args);
    }

    public HashMap<?, ?> Core_GetNewGuid() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetNewGuid", args);
    }

    public HashMap<?, ?> Core_GetUserList() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetUserList", args);
    }

    public HashMap<?, ?> Core_CurrentSessionHasPermission(Object PermissionNode) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("PermissionNode", PermissionNode);
        return this.APICall("/Core/CurrentSessionHasPermission", args);
    }

    public HashMap<?, ?> Core_GetTasks() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetTasks", args);
    }

    public HashMap<?, ?> Core_GetStatus() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetStatus", args);
    }

    public HashMap<?, ?> Core_CancelTask(Object TaskId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        return this.APICall("/Core/CancelTask", args);
    }

    public HashMap<?, ?> Core_DismissTask(Object TaskId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        return this.APICall("/Core/DismissTask", args);
    }

    public HashMap<?, ?> Core_DismissAllTasks() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/DismissAllTasks", args);
    }

    public HashMap<?, ?> Core_GetUserInfo(Object UID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UID", UID);
        return this.APICall("/Core/GetUserInfo", args);
    }

    public HashMap<?, ?> Core_Start() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Start", args);
    }

    public HashMap<?, ?> Core_Suspend() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Suspend", args);
    }

    public HashMap<?, ?> Core_Resume() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Resume", args);
    }

    public HashMap<?, ?> Core_Stop() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Stop", args);
    }

    public HashMap<?, ?> Core_Restart() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Restart", args);
    }

    public HashMap<?, ?> Core_Kill() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Kill", args);
    }

    public HashMap<?, ?> Core_Sleep() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Sleep", args);
    }

    public HashMap<?, ?> Core_UpdateApplication() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/UpdateApplication", args);
    }

    public HashMap<?, ?> Core_AcknowledgeAMPUpdate() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/AcknowledgeAMPUpdate", args);
    }

    public HashMap<?, ?> Core_GetModuleInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetModuleInfo", args);
    }

    public HashMap<?, ?> Core_GetAPISpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetAPISpec", args);
    }

    public HashMap<?, ?> Core_GetUserActionsSpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetUserActionsSpec", args);
    }

    public HashMap<?, ?> Core_Login(Object username, Object password, Object token, Object rememberMe) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("username", username);
        args.put("password", password);
        args.put("token", token);
        args.put("rememberMe", rememberMe);
        return this.APICall("/Core/Login", args);
    }

    public HashMap<?, ?> Core_GetRemoteLoginToken(Object Description, Object IsTemporary) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Description", Description);
        args.put("IsTemporary", IsTemporary);
        return this.APICall("/Core/GetRemoteLoginToken", args);
    }

    public HashMap<?, ?> Core_SendConsoleMessage(Object message) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("message", message);
        return this.APICall("/Core/SendConsoleMessage", args);
    }

    public HashMap<?, ?> Core_UpdateAMPInstance() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/UpdateAMPInstance", args);
    }

    public HashMap<?, ?> Core_GetUpdateInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetUpdateInfo", args);
    }

    public HashMap<?, ?> Core_Logout() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Logout", args);
    }

    public HashMap<?, ?> Core_RestartAMP() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/RestartAMP", args);
    }

    public HashMap<?, ?> Core_UpgradeAMP() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/UpgradeAMP", args);
    }

    public HashMap<?, ?> Core_GetDiagnosticsInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetDiagnosticsInfo", args);
    }

    public HashMap<?, ?> Core_CreateTestTask() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/CreateTestTask", args);
    }

    public HashMap<?, ?> Core_AsyncTest() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/AsyncTest", args);
    }
}
