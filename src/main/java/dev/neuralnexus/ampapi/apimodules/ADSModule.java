package dev.neuralnexus.ampapi.apimodules;

import dev.neuralnexus.ampapi.AMPAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ADSModule extends AMPAPI {
    public ADSModule(AMPAPI ampapi) {
        super(ampapi);
    }

    /**
     * Name Description Optional
     * @param newDatastore  False
     * @return Object
     */
    public Object AddDatastore(Object newDatastore) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("newDatastore", newDatastore);
        return this.APICall("ADSModule/AddDatastore", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param InstanceID  False
     * @param Args  False
     * @param RebuildConfiguration  True
     * @return Object
     */
    public Object ApplyInstanceConfiguration(String InstanceID, Map Args, boolean RebuildConfiguration) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceID", InstanceID);
        args.put("Args", Args);
        args.put("RebuildConfiguration", RebuildConfiguration);
        return this.APICall("ADSModule/ApplyInstanceConfiguration", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param InstanceID  False
     * @param TemplateID  False
     * @param NewFriendlyName  True
     * @param Secret  True
     * @param RestartIfPreviouslyRunning  True
     * @return Object
     */
    public Object ApplyTemplate(String InstanceID, Integer TemplateID, String NewFriendlyName, String Secret, boolean RestartIfPreviouslyRunning) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceID", InstanceID);
        args.put("TemplateID", TemplateID);
        args.put("NewFriendlyName", NewFriendlyName);
        args.put("Secret", Secret);
        args.put("RestartIfPreviouslyRunning", RestartIfPreviouslyRunning);
        return this.APICall("ADSModule/ApplyTemplate", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param Friendly  False
     * @param IsHTTPS  False
     * @param Host  False
     * @param Port  False
     * @param InstanceID  False
     * @return Object
     */
    public Object AttachADS(String Friendly, boolean IsHTTPS, String Host, Integer Port, String InstanceID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Friendly", Friendly);
        args.put("IsHTTPS", IsHTTPS);
        args.put("Host", Host);
        args.put("Port", Port);
        args.put("InstanceID", InstanceID);
        return this.APICall("ADSModule/AttachADS", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param Id  False
     * @param NewName  False
     * @return Object
     */
    public Object CloneTemplate(Integer Id, String NewName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("NewName", NewName);
        return this.APICall("ADSModule/CloneTemplate", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param InstanceName  False
     * @return Object
     */
    public Object ConvertToManaged(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("ADSModule/ConvertToManaged", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param Name  False
     * @return Object
     */
    public Object CreateDeploymentTemplate(String Name) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        return this.APICall("ADSModule/CreateDeploymentTemplate", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param TargetADSInstance  False
     * @param NewInstanceId  False
     * @param Module  False
     * @param InstanceName  False
     * @param FriendlyName  False
     * @param IPBinding  False
     * @param PortNumber  False
     * @param AdminUsername  False
     * @param AdminPassword  False
     * @param ProvisionSettings  False
     * @param AutoConfigure When enabled, all settings other than the Module, Target and FriendlyName are ignored and replaced with automatically generated values. True
     * @param PostCreate  True
     * @param StartOnBoot  True
     * @param DisplayImageSource  True
     * @param TargetDatastore  True
     * @return Object
     */
    public Object CreateInstance(String TargetADSInstance, String NewInstanceId, String Module, String InstanceName, String FriendlyName, String IPBinding, Integer PortNumber, String AdminUsername, String AdminPassword, Map ProvisionSettings, boolean AutoConfigure, Object PostCreate, boolean StartOnBoot, String DisplayImageSource, Integer TargetDatastore) {
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
        return this.APICall("ADSModule/CreateInstance", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param Instance  False
     * @param PostCreate  True
     * @return Object
     */
    public Object CreateLocalInstance(Object Instance, Object PostCreate) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Instance", Instance);
        args.put("PostCreate", PostCreate);
        return this.APICall("ADSModule/CreateLocalInstance", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param id  False
     * @return Object
     */
    public Object DeleteDatastore(Integer id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return this.APICall("ADSModule/DeleteDatastore", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param Id  False
     * @return Object
     */
    public Object DeleteDeploymentTemplate(Integer Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("ADSModule/DeleteDeploymentTemplate", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param InstanceName  False
     * @return Object
     */
    public Object DeleteInstance(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("ADSModule/DeleteInstance", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param InstanceId  False
     * @return Object
     */
    public Object DeleteInstanceUsers(String InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("ADSModule/DeleteInstanceUsers", args, Object.class);
    }

    /**A dictionary of setting nodes and values to create the new instance with. Identical in function to the provisioning arguments in the template itself.
     * Name Description Optional
     * @param TemplateID The ID of the template to be deployed, as per the Template Management UI in AMP itself. False
     * @param NewUsername If specified, AMP will create a new user with this name for this instance. Must be unique. If this user already exists, this will be ignored but the new instance will be assigned to this user. True
     * @param NewPassword If 'NewUsername' is specified and the user doesn't already exist, the password that will be assigned to this user. True
     * @param NewEmail If 'NewUsername' is specified and the user doesn't already exist, the email address that will be assigned to this user. True
     * @param RequiredTags If specified, AMP will only deploy this template to targets that have every single 'tag' specified in their target configuration. You can adjust this via the controller by clicking 'Edit' on the target settings. True
     * @param Tag Unrelated to RequiredTags. This is to uniquely identify this instance to your own systems. It may be something like an order ID or service ID so you can find the associated instance again at a later time. If 'UseTagAsInstanceName' is enabled, then this will also be used as the instance name for the created instance - but it must be unique. True
     * @param FriendlyName A friendly name for this instance. If left blank, AMP will generate one for you. True
     * @param Secret Must be a non-empty strong in order to get a callback on deployment state change. This secret will be passed back to you in the callback so you can verify the request. True
     * @param PostCreate 0: Do nothing, 1: Start instance only, 2: Start instance and update application, 3: Full application startup. True
     * @param ExtraProvisionSettings A dictionary of setting nodes and values to create the new instance with. Identical in function to the provisioning arguments in the template itself. True
     * @return Object
     */
    public Object DeployTemplate(Integer TemplateID, String NewUsername, String NewPassword, String NewEmail, List RequiredTags, String Tag, String FriendlyName, String Secret, Object PostCreate, Map ExtraProvisionSettings) {
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
        return this.APICall("ADSModule/DeployTemplate", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param Id  False
     * @return Object
     */
    public Object DetatchTarget(String Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("ADSModule/DetatchTarget", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param SourceArchive  False
     * @return Object
     */
    public Object ExtractEverywhere(String SourceArchive) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("SourceArchive", SourceArchive);
        return this.APICall("ADSModule/ExtractEverywhere", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param instanceId  False
     * @return List
     */
    public List GetApplicationEndpoints(String instanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        return this.APICall("ADSModule/GetApplicationEndpoints", args, List.class);
    }

    /**
     * Name Description Optional
     * @param id  False
     * @return Object
     */
    public Object GetDatastore(Integer id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return this.APICall("ADSModule/GetDatastore", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param datastoreId  False
     * @return List
     */
    public List GetDatastoreInstances(Integer datastoreId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("datastoreId", datastoreId);
        return this.APICall("ADSModule/GetDatastoreInstances", args, List.class);
    }

    /**
     * Name Description Optional
     * @return List
     */
    public List GetDatastores() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetDatastores", args, List.class);
    }

    /**
     * Name Description Optional
     * @return List
     */
    public List GetDeploymentTemplates() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetDeploymentTemplates", args, List.class);
    }

    /**
     * Name Description Optional
     * @param GroupId  False
     * @return boolean
     */
    public boolean GetGroup(String GroupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("GroupId", GroupId);
        return this.APICall("ADSModule/GetGroup", args, boolean.class);
    }

    /**
     * Name Description Optional
     * @param InstanceId  False
     * @return Map
     */
    public Map GetInstance(String InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("ADSModule/GetInstance", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param InstanceName  False
     * @return List
     */
    public List GetInstanceNetworkInfo(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("ADSModule/GetInstanceNetworkInfo", args, List.class);
    }

    /**
     * Name Description Optional
     * @return List
     */
    public List GetInstanceStatuses() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetInstanceStatuses", args, List.class);
    }

    /**
     * Name Description Optional
     * @return List
     */
    public List GetInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetInstances", args, List.class);
    }

    /**
     * Name Description Optional
     * @return List
     */
    public List GetLocalInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetLocalInstances", args, List.class);
    }

    /**
     * Name Description Optional
     * @param ModuleName  False
     * @return List
     */
    public List GetProvisionArguments(String ModuleName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ModuleName", ModuleName);
        return this.APICall("ADSModule/GetProvisionArguments", args, List.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map GetProvisionFitness() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetProvisionFitness", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return List
     */
    public List GetSupportedApplications() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetSupportedApplications", args, List.class);
    }

    /**
     * Name Description Optional
     * @return Object
     */
    public Object GetTargetInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetTargetInfo", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param ForModule  False
     * @param SettingNode  False
     * @param Values  False
     * @return Object
     */
    public Object HandoutInstanceConfigs(String ForModule, String SettingNode, List Values) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ForModule", ForModule);
        args.put("SettingNode", SettingNode);
        args.put("Values", Values);
        return this.APICall("ADSModule/HandoutInstanceConfigs", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param InstanceId  False
     * @return Object
     */
    public Object ManageInstance(String InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("ADSModule/ManageInstance", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param instanceId  False
     * @param PortNumber  False
     * @param Range  False
     * @param Protocol  False
     * @param Description  False
     * @param Open  False
     * @return Object
     */
    public Object ModifyCustomFirewallRule(String instanceId, Integer PortNumber, Integer Range, String Protocol, String Description, boolean Open) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        args.put("PortNumber", PortNumber);
        args.put("Range", Range);
        args.put("Protocol", Protocol);
        args.put("Description", Description);
        args.put("Open", Open);
        return this.APICall("ADSModule/ModifyCustomFirewallRule", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param instanceId  False
     * @param datastoreId  False
     * @return Object
     */
    public Object MoveInstanceDatastore(String instanceId, Integer datastoreId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        args.put("datastoreId", datastoreId);
        return this.APICall("ADSModule/MoveInstanceDatastore", args, Object.class);
    }

    /**
     * Name Description Optional
     * @return Object
     */
    public Object ReactivateLocalInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/ReactivateLocalInstances", args, Object.class);
    }

    /**
     * Name Description Optional
     * @return Void
     */
    public Void RefreshAppCache() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/RefreshAppCache", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param GroupId  False
     * @return Object
     */
    public Object RefreshGroup(String GroupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("GroupId", GroupId);
        return this.APICall("ADSModule/RefreshGroup", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param InstanceId  False
     * @return Object
     */
    public Object RefreshInstanceConfig(String InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("ADSModule/RefreshInstanceConfig", args, Object.class);
    }

    /**
     * Name Description Optional
     * @return Void
     */
    public Void RefreshRemoteConfigStores() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/RefreshRemoteConfigStores", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param controllerUrl  False
     * @param myUrl  False
     * @param username  False
     * @param password  False
     * @param twoFactorToken  False
     * @param friendlyName  False
     * @return Object
     */
    public Object RegisterTarget(String controllerUrl, String myUrl, String username, String password, String twoFactorToken, String friendlyName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("controllerUrl", controllerUrl);
        args.put("myUrl", myUrl);
        args.put("username", username);
        args.put("password", password);
        args.put("twoFactorToken", twoFactorToken);
        args.put("friendlyName", friendlyName);
        return this.APICall("ADSModule/RegisterTarget", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param id  False
     * @return Object
     */
    public Object RepairDatastore(Integer id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return this.APICall("ADSModule/RepairDatastore", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param datastoreId  False
     * @return Object
     */
    public Object RequestDatastoreSizeCalculation(Integer datastoreId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("datastoreId", datastoreId);
        return this.APICall("ADSModule/RequestDatastoreSizeCalculation", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param InstanceName  False
     * @return Object
     */
    public Object RestartInstance(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("ADSModule/RestartInstance", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param id  False
     * @param REQ_RAWJSON  False
     * @return Object
     */
    public Object Servers(String id, String REQ_RAWJSON) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        args.put("REQ_RAWJSON", REQ_RAWJSON);
        return this.APICall("ADSModule/Servers", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param InstanceName  False
     * @param SettingNode  False
     * @param Value  False
     * @return Object
     */
    public Object SetInstanceConfig(String InstanceName, String SettingNode, String Value) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        args.put("SettingNode", SettingNode);
        args.put("Value", Value);
        return this.APICall("ADSModule/SetInstanceConfig", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param InstanceId  False
     * @param PortMappings  False
     * @return Object
     */
    public Object SetInstanceNetworkInfo(String InstanceId, Map PortMappings) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        args.put("PortMappings", PortMappings);
        return this.APICall("ADSModule/SetInstanceNetworkInfo", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param InstanceName  False
     * @param Suspended  False
     * @return Object
     */
    public Object SetInstanceSuspended(String InstanceName, boolean Suspended) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        args.put("Suspended", Suspended);
        return this.APICall("ADSModule/SetInstanceSuspended", args, Object.class);
    }

    /**
     * Name Description Optional
     * @return Object
     */
    public Object StartAllInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/StartAllInstances", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param InstanceName  False
     * @return Object
     */
    public Object StartInstance(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("ADSModule/StartInstance", args, Object.class);
    }

    /**
     * Name Description Optional
     * @return Object
     */
    public Object StopAllInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/StopAllInstances", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param InstanceName  False
     * @return Object
     */
    public Object StopInstance(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("ADSModule/StopInstance", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param url  False
     * @param username  False
     * @param password  False
     * @return Object
     */
    public Object TestADSLoginDetails(String url, String username, String password) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("url", url);
        args.put("username", username);
        args.put("password", password);
        return this.APICall("ADSModule/TestADSLoginDetails", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param updatedDatastore  False
     * @return Object
     */
    public Object UpdateDatastore(Object updatedDatastore) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("updatedDatastore", updatedDatastore);
        return this.APICall("ADSModule/UpdateDatastore", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param templateToUpdate  False
     * @return Object
     */
    public Object UpdateDeploymentTemplate(Object templateToUpdate) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("templateToUpdate", templateToUpdate);
        return this.APICall("ADSModule/UpdateDeploymentTemplate", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param InstanceId  False
     * @param FriendlyName  False
     * @param Description  False
     * @param StartOnBoot  False
     * @param Suspended  False
     * @param ExcludeFromFirewall  False
     * @param RunInContainer  False
     * @param ContainerMemory  False
     * @param MemoryPolicy  False
     * @param ContainerMaxCPU  False
     * @param ContainerImage  False
     * @return Object
     */
    public Object UpdateInstanceInfo(String InstanceId, String FriendlyName, String Description, boolean StartOnBoot, boolean Suspended, boolean ExcludeFromFirewall, boolean RunInContainer, Integer ContainerMemory, Object MemoryPolicy, Object ContainerMaxCPU, String ContainerImage) {
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
        args.put("ContainerImage", ContainerImage);
        return this.APICall("ADSModule/UpdateInstanceInfo", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param TargetID  False
     * @return Void
     */
    public Void UpdateTarget(String TargetID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TargetID", TargetID);
        return this.APICall("ADSModule/UpdateTarget", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param Id  False
     * @param FriendlyName  False
     * @param Url  False
     * @param Description  False
     * @param Tags  False
     * @return Object
     */
    public Object UpdateTargetInfo(String Id, String FriendlyName, String Url, String Description, List Tags) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("FriendlyName", FriendlyName);
        args.put("Url", Url);
        args.put("Description", Description);
        args.put("Tags", Tags);
        return this.APICall("ADSModule/UpdateTargetInfo", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param RestartRunning  False
     * @return Object
     */
    public Object UpgradeAllInstances(boolean RestartRunning) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RestartRunning", RestartRunning);
        return this.APICall("ADSModule/UpgradeAllInstances", args, Object.class);
    }

    /**
     * Name Description Optional
     * @param InstanceName  False
     * @return Object
     */
    public Object UpgradeInstance(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("ADSModule/UpgradeInstance", args, Object.class);
    }

}
