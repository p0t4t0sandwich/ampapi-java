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
import java.util.Map;

public class AMPAPI {
    final String baseUri;
    private final String dataSource;
    String sessionId = "";

    public AMPAPI(String baseURI) {
        this.baseUri = baseURI;

        if (baseURI.charAt(baseURI.length()-1) == '/') {
            this.dataSource = this.baseUri + "API";
        } else {
            this.dataSource = this.baseUri + "/API";
        }
    }

    Map APICall(String endpoint, Map<String, Object> data) {
        try {
            data.put("SESSIONID", this.sessionId);

            Gson gson = new GsonBuilder().create();
            String data_json = gson.toJson(data);

            URL url = new URL(this.dataSource + endpoint);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Accept", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream());
            osw.write(data_json);
            osw.flush();
            osw.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            return gson.fromJson(br.readLine(), Map.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Map ADSModule_AddDatastore(Object newDatastore) {
        Map<String, Object> args = new HashMap<>();
        args.put("newDatastore", newDatastore);
        return this.APICall("/ADSModule/AddDatastore", args);
    }

    Map ADSModule_DeleteDatastore(Object id) {
        Map<String, Object> args = new HashMap<>();
        args.put("id", id);
        return this.APICall("/ADSModule/DeleteDatastore", args);
    }

    Map ADSModule_UpdateDatastore(Object updatedDatastore) {
        Map<String, Object> args = new HashMap<>();
        args.put("updatedDatastore", updatedDatastore);
        return this.APICall("/ADSModule/UpdateDatastore", args);
    }

    Map ADSModule_GetDatastores() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetDatastores", args);
    }

    Map ADSModule_RequestDatastoreSizeCalculation(Object datastoreId) {
        Map<String, Object> args = new HashMap<>();
        args.put("datastoreId", datastoreId);
        return this.APICall("/ADSModule/RequestDatastoreSizeCalculation", args);
    }

    Map ADSModule_GetDatastore(Object id) {
        Map<String, Object> args = new HashMap<>();
        args.put("id", id);
        return this.APICall("/ADSModule/GetDatastore", args);
    }

    Map ADSModule_GetDatastoreInstances(Object datastoreId) {
        Map<String, Object> args = new HashMap<>();
        args.put("datastoreId", datastoreId);
        return this.APICall("/ADSModule/GetDatastoreInstances", args);
    }

    Map ADSModule_MoveInstanceDatastore(Object instanceId, Object datastoreId) {
        Map<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        args.put("datastoreId", datastoreId);
        return this.APICall("/ADSModule/MoveInstanceDatastore", args);
    }

    Map ADSModule_GetDeploymentTemplates() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetDeploymentTemplates", args);
    }

    Map ADSModule_CreateDeploymentTemplate(Object Name) {
        Map<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        return this.APICall("/ADSModule/CreateDeploymentTemplate", args);
    }

    Map ADSModule_UpdateDeploymentTemplate(Object templateToUpdate) {
        Map<String, Object> args = new HashMap<>();
        args.put("templateToUpdate", templateToUpdate);
        return this.APICall("/ADSModule/UpdateDeploymentTemplate", args);
    }

    Map ADSModule_DeleteDeploymentTemplate(Object Id) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("/ADSModule/DeleteDeploymentTemplate", args);
    }

    Map ADSModule_CloneTemplate(Object Id, Object NewName) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("NewName", NewName);
        return this.APICall("/ADSModule/CloneTemplate", args);
    }

    Map ADSModule_ApplyTemplate(Object InstanceID, Object TemplateID, Object NewFriendlyName, Object Secret, Object RestartIfPreviouslyRunning) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceID", InstanceID);
        args.put("TemplateID", TemplateID);
        args.put("NewFriendlyName", NewFriendlyName);
        args.put("Secret", Secret);
        args.put("RestartIfPreviouslyRunning", RestartIfPreviouslyRunning);
        return this.APICall("/ADSModule/ApplyTemplate", args);
    }

    Map ADSModule_DeployTemplate(Object TemplateID, Object NewUsername, Object NewPassword, Object NewEmail, Object RequiredTags, Object Tag, Object FriendlyName, Object Secret, Object PostCreate, Object ExtraProvisionSettings) {
        Map<String, Object> args = new HashMap<>();
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

    Map ADSModule_GetTargetInfo() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetTargetInfo", args);
    }

    Map ADSModule_GetSupportedApplications() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetSupportedApplications", args);
    }

    Map ADSModule_RefreshAppCache() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/RefreshAppCache", args);
    }

    Map ADSModule_RefreshRemoteConfigStores() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/RefreshRemoteConfigStores", args);
    }

    Map ADSModule_GetApplicationEndpoints(Object instanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        return this.APICall("/ADSModule/GetApplicationEndpoints", args);
    }

    Map ADSModule_ReactivateLocalInstances() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/ReactivateLocalInstances", args);
    }

    Map ADSModule_GetInstances() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetInstances", args);
    }

    Map ADSModule_GetInstance(Object InstanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("/ADSModule/GetInstance", args);
    }

    Map ADSModule_ModifyCustomFirewallRule(Object instanceId, Object PortNumber, Object Range, Object Protocol, Object Description, Object Open) {
        Map<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        args.put("PortNumber", PortNumber);
        args.put("Range", Range);
        args.put("Protocol", Protocol);
        args.put("Description", Description);
        args.put("Open", Open);
        return this.APICall("/ADSModule/ModifyCustomFirewallRule", args);
    }

    Map ADSModule_ManageInstance(Object InstanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("/ADSModule/ManageInstance", args);
    }

    Map ADSModule_GetGroup(Object GroupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("GroupId", GroupId);
        return this.APICall("/ADSModule/GetGroup", args);
    }

    Map ADSModule_RefreshGroup(Object GroupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("GroupId", GroupId);
        return this.APICall("/ADSModule/RefreshGroup", args);
    }

    Map ADSModule_GetLocalInstances() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetLocalInstances", args);
    }

    Map ADSModule_GetInstanceStatuses() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetInstanceStatuses", args);
    }

    Map ADSModule_GetProvisionFitness() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetProvisionFitness", args);
    }

    Map ADSModule_AttachADS(Object Friendly, Object IsHTTPS, Object Host, Object Port, Object InstanceID) {
        Map<String, Object> args = new HashMap<>();
        args.put("Friendly", Friendly);
        args.put("IsHTTPS", IsHTTPS);
        args.put("Host", Host);
        args.put("Port", Port);
        args.put("InstanceID", InstanceID);
        return this.APICall("/ADSModule/AttachADS", args);
    }

    Map ADSModule_DetatchTarget(Object Id) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("/ADSModule/DetatchTarget", args);
    }

    Map ADSModule_UpdateTargetInfo(Object Id, Object FriendlyName, Object Url, Object Description, Object Tags) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("FriendlyName", FriendlyName);
        args.put("Url", Url);
        args.put("Description", Description);
        args.put("Tags", Tags);
        return this.APICall("/ADSModule/UpdateTargetInfo", args);
    }

    Map ADSModule_ConvertToManaged(Object InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("/ADSModule/ConvertToManaged", args);
    }

    Map ADSModule_GetInstanceNetworkInfo(Object InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("/ADSModule/GetInstanceNetworkInfo", args);
    }

    Map ADSModule_SetInstanceNetworkInfo(Object InstanceId, Object PortMappings) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        args.put("PortMappings", PortMappings);
        return this.APICall("/ADSModule/SetInstanceNetworkInfo", args);
    }

    Map ADSModule_ApplyInstanceConfiguration(Object InstanceID, Object Flags) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceID", InstanceID);
        args.put("Flags", Flags);
        return this.APICall("/ADSModule/ApplyInstanceConfiguration", args);
    }

    Map ADSModule_CreateLocalInstance(Object Instance, Object PostCreate) {
        Map<String, Object> args = new HashMap<>();
        args.put("Instance", Instance);
        args.put("PostCreate", PostCreate);
        return this.APICall("/ADSModule/CreateLocalInstance", args);
    }

    Map ADSModule_CreateInstance(Object TargetADSInstance, Object NewInstanceId, Object Module, Object InstanceName, Object FriendlyName, Object IPBinding, Object PortNumber, Object AdminUsername, Object AdminPassword, Object ProvisionSettings, Object AutoConfigure, Object PostCreate, Object StartOnBoot, Object DisplayImageSource, Object TargetDatastore) {
        Map<String, Object> args = new HashMap<>();
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

    Map ADSModule_SetInstanceConfig(Object InstanceName, Object SettingNode, Object Value) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        args.put("SettingNode", SettingNode);
        args.put("Value", Value);
        return this.APICall("/ADSModule/SetInstanceConfig", args);
    }

    Map ADSModule_RefreshInstanceConfig(Object InstanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("/ADSModule/RefreshInstanceConfig", args);
    }

    Map ADSModule_HandoutInstanceConfigs(Object ForModule, Object SettingNode, Object Values) {
        Map<String, Object> args = new HashMap<>();
        args.put("ForModule", ForModule);
        args.put("SettingNode", SettingNode);
        args.put("Values", Values);
        return this.APICall("/ADSModule/HandoutInstanceConfigs", args);
    }

    Map ADSModule_GetProvisionArguments(Object ModuleName) {
        Map<String, Object> args = new HashMap<>();
        args.put("ModuleName", ModuleName);
        return this.APICall("/ADSModule/GetProvisionArguments", args);
    }

    Map ADSModule_TestADSLoginDetails(Object url, Object username, Object password) {
        Map<String, Object> args = new HashMap<>();
        args.put("url", url);
        args.put("username", username);
        args.put("password", password);
        return this.APICall("/ADSModule/TestADSLoginDetails", args);
    }

    Map ADSModule_RegisterTarget(Object controllerUrl, Object myUrl, Object username, Object password, Object twoFactorToken, Object friendlyName) {
        Map<String, Object> args = new HashMap<>();
        args.put("controllerUrl", controllerUrl);
        args.put("myUrl", myUrl);
        args.put("username", username);
        args.put("password", password);
        args.put("twoFactorToken", twoFactorToken);
        args.put("friendlyName", friendlyName);
        return this.APICall("/ADSModule/RegisterTarget", args);
    }

    Map ADSModule_UpdateTarget(Object TargetID) {
        Map<String, Object> args = new HashMap<>();
        args.put("TargetID", TargetID);
        return this.APICall("/ADSModule/UpdateTarget", args);
    }

    Map ADSModule_UpdateInstanceInfo(Object InstanceId, Object FriendlyName, Object Description, Object StartOnBoot, Object Suspended, Object ExcludeFromFirewall, Object RunInContainer, Object ContainerMemory, Object MemoryPolicy, Object ContainerMaxCPU) {
        Map<String, Object> args = new HashMap<>();
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

    Map ADSModule_SetInstanceSuspended(Object InstanceName, Object Suspended) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        args.put("Suspended", Suspended);
        return this.APICall("/ADSModule/SetInstanceSuspended", args);
    }

    Map ADSModule_UpgradeInstance(Object InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("/ADSModule/UpgradeInstance", args);
    }

    Map ADSModule_StartAllInstances() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/StartAllInstances", args);
    }

    Map ADSModule_StopAllInstances() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/StopAllInstances", args);
    }

    Map ADSModule_UpgradeAllInstances(Object RestartRunning) {
        Map<String, Object> args = new HashMap<>();
        args.put("RestartRunning", RestartRunning);
        return this.APICall("/ADSModule/UpgradeAllInstances", args);
    }

    Map ADSModule_StartInstance(Object InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("/ADSModule/StartInstance", args);
    }

    Map ADSModule_RestartInstance(Object InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("/ADSModule/RestartInstance", args);
    }

    Map ADSModule_StopInstance(Object InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("/ADSModule/StopInstance", args);
    }

    Map ADSModule_DeleteInstanceUsers(Object InstanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("/ADSModule/DeleteInstanceUsers", args);
    }

    Map ADSModule_DeleteInstance(Object InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("/ADSModule/DeleteInstance", args);
    }

    Map ADSModule_ExtractEverywhere(Object SourceArchive) {
        Map<String, Object> args = new HashMap<>();
        args.put("SourceArchive", SourceArchive);
        return this.APICall("/ADSModule/ExtractEverywhere", args);
    }

    Map ADSModule_Servers(Object id, Object REQ_RAWJSON) {
        Map<String, Object> args = new HashMap<>();
        args.put("id", id);
        args.put("REQ_RAWJSON", REQ_RAWJSON);
        return this.APICall("/ADSModule/Servers", args);
    }

    Map FileManagerPlugin_Dummy() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/FileManagerPlugin/Dummy", args);
    }

    Map FileManagerPlugin_CalculateFileMD5Sum(Object FilePath) {
        Map<String, Object> args = new HashMap<>();
        args.put("FilePath", FilePath);
        return this.APICall("/FileManagerPlugin/CalculateFileMD5Sum", args);
    }

    Map FileManagerPlugin_ChangeExclusion(Object ModifyPath, Object AsDirectory, Object Exclude) {
        Map<String, Object> args = new HashMap<>();
        args.put("ModifyPath", ModifyPath);
        args.put("AsDirectory", AsDirectory);
        args.put("Exclude", Exclude);
        return this.APICall("/FileManagerPlugin/ChangeExclusion", args);
    }

    Map FileManagerPlugin_CreateArchive(Object PathToArchive) {
        Map<String, Object> args = new HashMap<>();
        args.put("PathToArchive", PathToArchive);
        return this.APICall("/FileManagerPlugin/CreateArchive", args);
    }

    Map FileManagerPlugin_ExtractArchive(Object ArchivePath, Object DestinationPath) {
        Map<String, Object> args = new HashMap<>();
        args.put("ArchivePath", ArchivePath);
        args.put("DestinationPath", DestinationPath);
        return this.APICall("/FileManagerPlugin/ExtractArchive", args);
    }

    Map FileManagerPlugin_GetDirectoryListing(Object Dir) {
        Map<String, Object> args = new HashMap<>();
        args.put("Dir", Dir);
        return this.APICall("/FileManagerPlugin/GetDirectoryListing", args);
    }

    Map FileManagerPlugin_GetFileChunk(Object Filename, Object Position, Object Length) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Position", Position);
        args.put("Length", Length);
        return this.APICall("/FileManagerPlugin/GetFileChunk", args);
    }

    Map FileManagerPlugin_AppendFileChunk(Object Filename, Object Data, Object Delete) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Data", Data);
        args.put("Delete", Delete);
        return this.APICall("/FileManagerPlugin/AppendFileChunk", args);
    }

    Map FileManagerPlugin_WriteFileChunk(Object Filename, Object Position, Object Data) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Position", Position);
        args.put("Data", Data);
        return this.APICall("/FileManagerPlugin/WriteFileChunk", args);
    }

    Map FileManagerPlugin_DownloadFileFromURL(Object Source, Object TargetDirectory) {
        Map<String, Object> args = new HashMap<>();
        args.put("Source", Source);
        args.put("TargetDirectory", TargetDirectory);
        return this.APICall("/FileManagerPlugin/DownloadFileFromURL", args);
    }

    Map FileManagerPlugin_RenameFile(Object Filename, Object NewFilename) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("NewFilename", NewFilename);
        return this.APICall("/FileManagerPlugin/RenameFile", args);
    }

    Map FileManagerPlugin_CopyFile(Object Origin, Object TargetDirectory) {
        Map<String, Object> args = new HashMap<>();
        args.put("Origin", Origin);
        args.put("TargetDirectory", TargetDirectory);
        return this.APICall("/FileManagerPlugin/CopyFile", args);
    }

    Map FileManagerPlugin_TrashFile(Object Filename) {
        Map<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        return this.APICall("/FileManagerPlugin/TrashFile", args);
    }

    Map FileManagerPlugin_TrashDirectory(Object DirectoryName) {
        Map<String, Object> args = new HashMap<>();
        args.put("DirectoryName", DirectoryName);
        return this.APICall("/FileManagerPlugin/TrashDirectory", args);
    }

    Map FileManagerPlugin_EmptyTrash(Object TrashDirectoryName) {
        Map<String, Object> args = new HashMap<>();
        args.put("TrashDirectoryName", TrashDirectoryName);
        return this.APICall("/FileManagerPlugin/EmptyTrash", args);
    }

    Map FileManagerPlugin_CreateDirectory(Object NewPath) {
        Map<String, Object> args = new HashMap<>();
        args.put("NewPath", NewPath);
        return this.APICall("/FileManagerPlugin/CreateDirectory", args);
    }

    Map FileManagerPlugin_RenameDirectory(Object oldDirectory, Object NewDirectoryName) {
        Map<String, Object> args = new HashMap<>();
        args.put("oldDirectory", oldDirectory);
        args.put("NewDirectoryName", NewDirectoryName);
        return this.APICall("/FileManagerPlugin/RenameDirectory", args);
    }

    Map EmailSenderPlugin_TestSMTPSettings() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/EmailSenderPlugin/TestSMTPSettings", args);
    }

    Map LocalFileBackupPlugin_UploadToS3(Object BackupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("/LocalFileBackupPlugin/UploadToS3", args);
    }

    Map LocalFileBackupPlugin_DownloadFromS3(Object BackupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("/LocalFileBackupPlugin/DownloadFromS3", args);
    }

    Map LocalFileBackupPlugin_DeleteFromS3(Object BackupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("/LocalFileBackupPlugin/DeleteFromS3", args);
    }

    Map LocalFileBackupPlugin_GetBackups() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/LocalFileBackupPlugin/GetBackups", args);
    }

    Map LocalFileBackupPlugin_RestoreBackup(Object BackupId, Object DeleteExistingData) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        args.put("DeleteExistingData", DeleteExistingData);
        return this.APICall("/LocalFileBackupPlugin/RestoreBackup", args);
    }

    Map LocalFileBackupPlugin_DeleteLocalBackup(Object BackupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("/LocalFileBackupPlugin/DeleteLocalBackup", args);
    }

    Map LocalFileBackupPlugin_SetBackupSticky(Object BackupId, Object Sticky) {
        Map<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        args.put("Sticky", Sticky);
        return this.APICall("/LocalFileBackupPlugin/SetBackupSticky", args);
    }

    Map LocalFileBackupPlugin_TakeBackup(Object Title, Object Description, Object Sticky) {
        Map<String, Object> args = new HashMap<>();
        args.put("Title", Title);
        args.put("Description", Description);
        args.put("Sticky", Sticky);
        return this.APICall("/LocalFileBackupPlugin/TakeBackup", args);
    }

    Map Core_GetAuditLogEntries(Object Before, Object Count) {
        Map<String, Object> args = new HashMap<>();
        args.put("Before", Before);
        args.put("Count", Count);
        return this.APICall("/Core/GetAuditLogEntries", args);
    }

    Map Core_GetSettingsSpec() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetSettingsSpec", args);
    }

    Map Core_RefreshSettingValueList(Object Node) {
        Map<String, Object> args = new HashMap<>();
        args.put("Node", Node);
        return this.APICall("/Core/RefreshSettingValueList", args);
    }

    Map Core_RefreshSettingsSourceCache() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/RefreshSettingsSourceCache", args);
    }

    Map Core_GetSettingValues(Object SettingNode, Object WithRefresh) {
        Map<String, Object> args = new HashMap<>();
        args.put("SettingNode", SettingNode);
        args.put("WithRefresh", WithRefresh);
        return this.APICall("/Core/GetSettingValues", args);
    }

    Map Core_GetProvisionSpec() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetProvisionSpec", args);
    }

    Map Core_GetConfig(Object node) {
        Map<String, Object> args = new HashMap<>();
        args.put("node", node);
        return this.APICall("/Core/GetConfig", args);
    }

    Map Core_GetConfigs(Object nodes) {
        Map<String, Object> args = new HashMap<>();
        args.put("nodes", nodes);
        return this.APICall("/Core/GetConfigs", args);
    }

    Map Core_SetConfigs(Object data) {
        Map<String, Object> args = new HashMap<>();
        args.put("data", data);
        return this.APICall("/Core/SetConfigs", args);
    }

    Map Core_SetConfig(Object node, Object value) {
        Map<String, Object> args = new HashMap<>();
        args.put("node", node);
        args.put("value", value);
        return this.APICall("/Core/SetConfig", args);
    }

    Map Core_GetRoleData() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetRoleData", args);
    }

    Map Core_GetRoleIds() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetRoleIds", args);
    }

    Map Core_GetRole(Object RoleId) {
        Map<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        return this.APICall("/Core/GetRole", args);
    }

    Map Core_CreateRole(Object Name, Object AsCommonRole) {
        Map<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        args.put("AsCommonRole", AsCommonRole);
        return this.APICall("/Core/CreateRole", args);
    }

    Map Core_DeleteRole(Object RoleId) {
        Map<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        return this.APICall("/Core/DeleteRole", args);
    }

    Map Core_RenameRole(Object RoleId, Object NewName) {
        Map<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("NewName", NewName);
        return this.APICall("/Core/RenameRole", args);
    }

    Map Core_SetAMPRolePermission(Object RoleId, Object PermissionNode, Object Enabled) {
        Map<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("PermissionNode", PermissionNode);
        args.put("Enabled", Enabled);
        return this.APICall("/Core/SetAMPRolePermission", args);
    }

    Map Core_GetAMPRolePermissions(Object RoleId) {
        Map<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        return this.APICall("/Core/GetAMPRolePermissions", args);
    }

    Map Core_GetScheduleData() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetScheduleData", args);
    }

    Map Core_AddEventTrigger(Object triggerId) {
        Map<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        return this.APICall("/Core/AddEventTrigger", args);
    }

    Map Core_RunEventTriggerImmediately(Object triggerId) {
        Map<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        return this.APICall("/Core/RunEventTriggerImmediately", args);
    }

    Map Core_AddIntervalTrigger(Object months, Object days, Object hours, Object minutes, Object daysOfMonth, Object description) {
        Map<String, Object> args = new HashMap<>();
        args.put("months", months);
        args.put("days", days);
        args.put("hours", hours);
        args.put("minutes", minutes);
        args.put("daysOfMonth", daysOfMonth);
        args.put("description", description);
        return this.APICall("/Core/AddIntervalTrigger", args);
    }

    Map Core_GetTimeIntervalTrigger(Object Id) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("/Core/GetTimeIntervalTrigger", args);
    }

    Map Core_EditIntervalTrigger(Object Id, Object months, Object days, Object hours, Object minutes, Object daysOfMonth, Object description) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("months", months);
        args.put("days", days);
        args.put("hours", hours);
        args.put("minutes", minutes);
        args.put("daysOfMonth", daysOfMonth);
        args.put("description", description);
        return this.APICall("/Core/EditIntervalTrigger", args);
    }

    Map Core_AddTask(Object TriggerID, Object MethodID, Object ParameterMapping) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("MethodID", MethodID);
        args.put("ParameterMapping", ParameterMapping);
        return this.APICall("/Core/AddTask", args);
    }

    Map Core_EditTask(Object TriggerID, Object TaskID, Object ParameterMapping) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        args.put("ParameterMapping", ParameterMapping);
        return this.APICall("/Core/EditTask", args);
    }

    Map Core_ChangeTaskOrder(Object TriggerID, Object TaskID, Object NewOrder) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        args.put("NewOrder", NewOrder);
        return this.APICall("/Core/ChangeTaskOrder", args);
    }

    Map Core_DeleteTask(Object TriggerID, Object TaskID) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        return this.APICall("/Core/DeleteTask", args);
    }

    Map Core_DeleteTrigger(Object TriggerID) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        return this.APICall("/Core/DeleteTrigger", args);
    }

    Map Core_GetActiveAMPSessions() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetActiveAMPSessions", args);
    }

    Map Core_EndUserSession(Object Id) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("/Core/EndUserSession", args);
    }

    Map Core_GetAMPUsersSummary() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetAMPUsersSummary", args);
    }

    Map Core_GetAMPUserInfo(Object Username) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        return this.APICall("/Core/GetAMPUserInfo", args);
    }

    Map Core_GetAllAMPUserInfo() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetAllAMPUserInfo", args);
    }

    Map Core_SetAMPUserRoleMembership(Object UserId, Object RoleId, Object IsMember) {
        Map<String, Object> args = new HashMap<>();
        args.put("UserId", UserId);
        args.put("RoleId", RoleId);
        args.put("IsMember", IsMember);
        return this.APICall("/Core/SetAMPUserRoleMembership", args);
    }

    Map Core_GetPermissionsSpec() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetPermissionsSpec", args);
    }

    Map Core_CreateUser(Object Username) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        return this.APICall("/Core/CreateUser", args);
    }

    Map Core_DeleteUser(Object Username) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        return this.APICall("/Core/DeleteUser", args);
    }

    Map Core_UpdateUserInfo(Object Username, Object Disabled, Object PasswordExpires, Object CannotChangePassword, Object MustChangePassword, Object EmailAddress) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("Disabled", Disabled);
        args.put("PasswordExpires", PasswordExpires);
        args.put("CannotChangePassword", CannotChangePassword);
        args.put("MustChangePassword", MustChangePassword);
        args.put("EmailAddress", EmailAddress);
        return this.APICall("/Core/UpdateUserInfo", args);
    }

    Map Core_GetWebauthnChallenge() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetWebauthnChallenge", args);
    }

    Map Core_GetWebauthnCredentialIDs(Object username) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", username);
        return this.APICall("/Core/GetWebauthnCredentialIDs", args);
    }

    Map Core_WebauthnRegister(Object attestationObject, Object clientDataJSON, Object description) {
        Map<String, Object> args = new HashMap<>();
        args.put("attestationObject", attestationObject);
        args.put("clientDataJSON", clientDataJSON);
        args.put("description", description);
        return this.APICall("/Core/WebauthnRegister", args);
    }

    Map Core_GetWebauthnCredentialSummaries() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetWebauthnCredentialSummaries", args);
    }

    Map Core_RevokeWebauthnCredential(Object ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        return this.APICall("/Core/RevokeWebauthnCredential", args);
    }

    Map Core_UpdateAccountInfo(Object EmailAddress, Object TwoFactorPIN) {
        Map<String, Object> args = new HashMap<>();
        args.put("EmailAddress", EmailAddress);
        args.put("TwoFactorPIN", TwoFactorPIN);
        return this.APICall("/Core/UpdateAccountInfo", args);
    }

    Map Core_EnableTwoFactor(Object Username, Object Password) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("Password", Password);
        return this.APICall("/Core/EnableTwoFactor", args);
    }

    Map Core_ConfirmTwoFactorSetup(Object Username, Object TwoFactorCode) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("TwoFactorCode", TwoFactorCode);
        return this.APICall("/Core/ConfirmTwoFactorSetup", args);
    }

    Map Core_DisableTwoFactor(Object Password, Object TwoFactorCode) {
        Map<String, Object> args = new HashMap<>();
        args.put("Password", Password);
        args.put("TwoFactorCode", TwoFactorCode);
        return this.APICall("/Core/DisableTwoFactor", args);
    }

    Map Core_ResetUserPassword(Object Username, Object NewPassword) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("NewPassword", NewPassword);
        return this.APICall("/Core/ResetUserPassword", args);
    }

    Map Core_DeleteInstanceUsers(Object InstanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("/Core/DeleteInstanceUsers", args);
    }

    Map Core_ChangeUserPassword(Object Username, Object OldPassword, Object NewPassword, Object TwoFactorPIN) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("OldPassword", OldPassword);
        args.put("NewPassword", NewPassword);
        args.put("TwoFactorPIN", TwoFactorPIN);
        return this.APICall("/Core/ChangeUserPassword", args);
    }

    Map Core_GetUpdates() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetUpdates", args);
    }

    Map Core_GetNewGuid() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetNewGuid", args);
    }

    Map Core_GetUserList() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetUserList", args);
    }

    Map Core_CurrentSessionHasPermission(Object PermissionNode) {
        Map<String, Object> args = new HashMap<>();
        args.put("PermissionNode", PermissionNode);
        return this.APICall("/Core/CurrentSessionHasPermission", args);
    }

    Map Core_GetTasks() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetTasks", args);
    }

    Map Core_GetStatus() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetStatus", args);
    }

    Map Core_CancelTask(Object TaskId) {
        Map<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        return this.APICall("/Core/CancelTask", args);
    }

    Map Core_DismissTask(Object TaskId) {
        Map<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        return this.APICall("/Core/DismissTask", args);
    }

    Map Core_GetUserInfo(Object UID) {
        Map<String, Object> args = new HashMap<>();
        args.put("UID", UID);
        return this.APICall("/Core/GetUserInfo", args);
    }

    Map Core_Start() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Start", args);
    }

    Map Core_Suspend() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Suspend", args);
    }

    Map Core_Resume() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Resume", args);
    }

    Map Core_Stop() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Stop", args);
    }

    Map Core_Restart() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Restart", args);
    }

    Map Core_Kill() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Kill", args);
    }

    Map Core_Sleep() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Sleep", args);
    }

    Map Core_UpdateApplication() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/UpdateApplication", args);
    }

    Map Core_AcknowledgeAMPUpdate() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/AcknowledgeAMPUpdate", args);
    }

    Map Core_GetModuleInfo() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetModuleInfo", args);
    }

    Map Core_GetAPISpec() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetAPISpec", args);
    }

    Map Core_GetUserActionsSpec() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetUserActionsSpec", args);
    }

    Map Core_Login(Object username, Object password, Object token, Object rememberMe) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", username);
        args.put("password", password);
        args.put("token", token);
        args.put("rememberMe", rememberMe);
        return this.APICall("/Core/Login", args);
    }

    Map Core_GetRemoteLoginToken(Object Description, Object IsTemporary) {
        Map<String, Object> args = new HashMap<>();
        args.put("Description", Description);
        args.put("IsTemporary", IsTemporary);
        return this.APICall("/Core/GetRemoteLoginToken", args);
    }

    Map Core_SendConsoleMessage(Object message) {
        Map<String, Object> args = new HashMap<>();
        args.put("message", message);
        return this.APICall("/Core/SendConsoleMessage", args);
    }

    Map Core_UpdateAMPInstance() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/UpdateAMPInstance", args);
    }

    Map Core_GetUpdateInfo() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetUpdateInfo", args);
    }

    Map Core_Logout() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Logout", args);
    }

    Map Core_RestartAMP() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/RestartAMP", args);
    }

    Map Core_UpgradeAMP() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/UpgradeAMP", args);
    }

    Map Core_GetDiagnosticsInfo() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetDiagnosticsInfo", args);
    }

    Map Core_CreateTestTask() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/CreateTestTask", args);
    }

    Map Core_AsyncTest() {
        Map<String, Object> args = new HashMap<>();
        return this.APICall("/Core/AsyncTest", args);
    }
}
