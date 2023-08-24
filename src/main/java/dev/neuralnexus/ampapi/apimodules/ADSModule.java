package dev.neuralnexus.ampapi.apimodules;

import dev.neuralnexus.ampapi.AMPAPIBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ADSModule extends AMPAPIBase {
    public ADSModule(AMPAPIBase ampapiBase) {
        super(ampapiBase);
    }

    /**
     * Name TypeName Description Optional
     * @param newDatastore  AMPType: InstanceDatastore 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> AddDatastore(Object newDatastore) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("newDatastore", newDatastore);
        return this.APICall("ADSModule/AddDatastore", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceID String AMPType: Guid 
     * @param Args Map<String, String> AMPType: Dictionary<String, String> 
     * @param RebuildConfiguration boolean AMPType: Boolean 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> ApplyInstanceConfiguration(String InstanceID, Map<String, String> Args, boolean RebuildConfiguration) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceID", InstanceID);
        args.put("Args", Args);
        args.put("RebuildConfiguration", RebuildConfiguration);
        return this.APICall("ADSModule/ApplyInstanceConfiguration", args);
    }

    /**
     * Overlays an existing template on an existing instance. Used to perform package reconfigurations. Do not use this to 'transform' an existing application into another. The instance should be deleted and re-created in that situation.
     * Name TypeName Description Optional
     * @param InstanceID String AMPType: Guid 
     * @param TemplateID Integer AMPType: Int32 
     * @param NewFriendlyName String AMPType: String 
     * @param Secret String AMPType: String 
     * @param RestartIfPreviouslyRunning boolean AMPType: Boolean 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> ApplyTemplate(String InstanceID, Integer TemplateID, String NewFriendlyName, String Secret, boolean RestartIfPreviouslyRunning) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceID", InstanceID);
        args.put("TemplateID", TemplateID);
        args.put("NewFriendlyName", NewFriendlyName);
        args.put("Secret", Secret);
        args.put("RestartIfPreviouslyRunning", RestartIfPreviouslyRunning);
        return this.APICall("ADSModule/ApplyTemplate", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Friendly String AMPType: String 
     * @param IsHTTPS boolean AMPType: Boolean 
     * @param Host String AMPType: String 
     * @param Port Integer AMPType: Int32 
     * @param InstanceID String AMPType: Guid 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> AttachADS(String Friendly, boolean IsHTTPS, String Host, Integer Port, String InstanceID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Friendly", Friendly);
        args.put("IsHTTPS", IsHTTPS);
        args.put("Host", Host);
        args.put("Port", Port);
        args.put("InstanceID", InstanceID);
        return this.APICall("ADSModule/AttachADS", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Id Integer AMPType: Int32 
     * @param NewName String AMPType: String 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> CloneTemplate(Integer Id, String NewName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("NewName", NewName);
        return this.APICall("ADSModule/CloneTemplate", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceName String AMPType: String 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> ConvertToManaged(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("ADSModule/ConvertToManaged", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Name String AMPType: String 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> CreateDeploymentTemplate(String Name) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        return this.APICall("ADSModule/CreateDeploymentTemplate", args);
    }

    /**
     * Name TypeName Description Optional
     * @param TargetADSInstance String AMPType: Guid 
     * @param NewInstanceId String AMPType: Guid 
     * @param Module String AMPType: String 
     * @param InstanceName String AMPType: String 
     * @param FriendlyName String AMPType: String 
     * @param IPBinding String AMPType: String 
     * @param PortNumber Integer AMPType: Int32 
     * @param AdminUsername String AMPType: String 
     * @param AdminPassword String AMPType: String 
     * @param ProvisionSettings Map<String, String> AMPType: Dictionary<String, String> 
     * @param AutoConfigure boolean AMPType: Boolean When enabled, all settings other than the Module, Target and FriendlyName are ignored and replaced with automatically generated values.
     * @param PostCreate  AMPType: PostCreateActions 
     * @param StartOnBoot boolean AMPType: Boolean 
     * @param DisplayImageSource String AMPType: String 
     * @param TargetDatastore Integer AMPType: Int32 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> CreateInstance(String TargetADSInstance, String NewInstanceId, String Module, String InstanceName, String FriendlyName, String IPBinding, Integer PortNumber, String AdminUsername, String AdminPassword, Map<String, String> ProvisionSettings, boolean AutoConfigure, Object PostCreate, boolean StartOnBoot, String DisplayImageSource, Integer TargetDatastore) {
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
        return this.APICall("ADSModule/CreateInstance", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Instance  AMPType: LocalAMPInstance 
     * @param PostCreate  AMPType: PostCreateActions 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> CreateLocalInstance(Object Instance, Object PostCreate) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Instance", Instance);
        args.put("PostCreate", PostCreate);
        return this.APICall("ADSModule/CreateLocalInstance", args);
    }

    /**
     * Name TypeName Description Optional
     * @param id Integer AMPType: Int32 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> DeleteDatastore(Integer id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return this.APICall("ADSModule/DeleteDatastore", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Id Integer AMPType: Int32 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> DeleteDeploymentTemplate(Integer Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("ADSModule/DeleteDeploymentTemplate", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceName String AMPType: String 
     * @return  AMPType: RunningTask
     */
    public Map<?, ?> DeleteInstance(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("ADSModule/DeleteInstance", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceId String AMPType: Guid 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> DeleteInstanceUsers(String InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("ADSModule/DeleteInstanceUsers", args);
    }

    /**
     * Name TypeName Description Optional
     * @param TemplateID Integer AMPType: Int32 The ID of the template to be deployed, as per the Template Management UI in AMP itself.
     * @param NewUsername String AMPType: String If specified, AMP will create a new user with this name for this instance. Must be unique. If this user already exists, this will be ignored but the new instance will be assigned to this user.
     * @param NewPassword String AMPType: String If 'NewUsername' is specified and the user doesn't already exist, the password that will be assigned to this user.
     * @param NewEmail String AMPType: String If 'NewUsername' is specified and the user doesn't already exist, the email address that will be assigned to this user.
     * @param RequiredTags List<String> AMPType: List<String> If specified, AMP will only deploy this template to targets that have every single 'tag' specified in their target configuration. You can adjust this via the controller by clicking 'Edit' on the target settings.
     * @param Tag String AMPType: String Unrelated to RequiredTags. This is to uniquely identify this instance to your own systems. It may be something like an order ID or service ID so you can find the associated instance again at a later time. If 'UseTagAsInstanceName' is enabled, then this will also be used as the instance name for the created instance - but it must be unique.
     * @param FriendlyName String AMPType: String A friendly name for this instance. If left blank, AMP will generate one for you.
     * @param Secret String AMPType: String Must be a non-empty strong in order to get a callback on deployment state change. This secret will be passed back to you in the callback so you can verify the request.
     * @param PostCreate  AMPType: PostCreateActions 0: Do nothing, 1: Start instance only, 2: Start instance and update application, 3: Full application startup.
     * @param ExtraProvisionSettings Map<String, String> AMPType: Dictionary<String, String> A dictionary of setting nodes and values to create the new instance with. Identical in function to the provisioning arguments in the template itself.
     * @return  AMPType: RunningTask
     */
    public Map<?, ?> DeployTemplate(Integer TemplateID, String NewUsername, String NewPassword, String NewEmail, List<String> RequiredTags, String Tag, String FriendlyName, String Secret, Object PostCreate, Map<String, String> ExtraProvisionSettings) {
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
        return this.APICall("ADSModule/DeployTemplate", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Id String AMPType: Guid 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> DetatchTarget(String Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("ADSModule/DetatchTarget", args);
    }

    /**
     * Name TypeName Description Optional
     * @param SourceArchive String AMPType: String 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> ExtractEverywhere(String SourceArchive) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("SourceArchive", SourceArchive);
        return this.APICall("ADSModule/ExtractEverywhere", args);
    }

    /**
     * Name TypeName Description Optional
     * @param instanceId String AMPType: Guid 
     * @return List<?> AMPType: IEnumerable<EndpointInfo>
     */
    public Map<?, ?> GetApplicationEndpoints(String instanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        return this.APICall("ADSModule/GetApplicationEndpoints", args);
    }

    /**
     * Name TypeName Description Optional
     * @param id Integer AMPType: Int32 
     * @return  AMPType: InstanceDatastore
     */
    public Map<?, ?> GetDatastore(Integer id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return this.APICall("ADSModule/GetDatastore", args);
    }

    /**
     * Name TypeName Description Optional
     * @param datastoreId Integer AMPType: Int32 
     * @return List<Map<?, ?>> AMPType: IEnumerable<JObject>
     */
    public Map<?, ?> GetDatastoreInstances(Integer datastoreId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("datastoreId", datastoreId);
        return this.APICall("ADSModule/GetDatastoreInstances", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<?> AMPType: IEnumerable<InstanceDatastore>
     */
    public Map<?, ?> GetDatastores() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetDatastores", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<?> AMPType: IEnumerable<DeploymentTemplate>
     */
    public Map<?, ?> GetDeploymentTemplates() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetDeploymentTemplates", args);
    }

    /**
     * Name TypeName Description Optional
     * @param GroupId String AMPType: Guid 
     * @return bool AMPType: IADSInstance
     */
    public Map<?, ?> GetGroup(String GroupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("GroupId", GroupId);
        return this.APICall("ADSModule/GetGroup", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceId String AMPType: Guid 
     * @return Map<?, ?> AMPType: JObject
     */
    public Map<?, ?> GetInstance(String InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("ADSModule/GetInstance", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceName String AMPType: String 
     * @return List<?> AMPType: IEnumerable<PortUsage>
     */
    public Map<?, ?> GetInstanceNetworkInfo(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("ADSModule/GetInstanceNetworkInfo", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<Map<?, ?>> AMPType: IEnumerable<JObject>
     */
    public Map<?, ?> GetInstanceStatuses() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetInstanceStatuses", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<?> AMPType: IEnumerable<IADSInstance>
     */
    public Map<?, ?> GetInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetInstances", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<Map<?, ?>> AMPType: IEnumerable<JObject>
     */
    public Map<?, ?> GetLocalInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetLocalInstances", args);
    }

    /**
     * Name TypeName Description Optional
     * @param ModuleName String AMPType: String 
     * @return List<Map<?, ?>> AMPType: IEnumerable<JObject>
     */
    public Map<?, ?> GetProvisionArguments(String ModuleName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ModuleName", ModuleName);
        return this.APICall("ADSModule/GetProvisionArguments", args);
    }

    /**
     * Name TypeName Description Optional
     * @return Map<?, ?> AMPType: JObject
     */
    public Map<?, ?> GetProvisionFitness() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetProvisionFitness", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<?> AMPType: IEnumerable<ApplicationSpec>
     */
    public Map<?, ?> GetSupportedApplications() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetSupportedApplications", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: RemoteTargetInfo
     */
    public Map<?, ?> GetTargetInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetTargetInfo", args);
    }

    /**
     * Name TypeName Description Optional
     * @param ForModule String AMPType: String 
     * @param SettingNode String AMPType: String 
     * @param Values List<String> AMPType: List<String> 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> HandoutInstanceConfigs(String ForModule, String SettingNode, List<String> Values) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ForModule", ForModule);
        args.put("SettingNode", SettingNode);
        args.put("Values", Values);
        return this.APICall("ADSModule/HandoutInstanceConfigs", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceId String AMPType: Guid 
     * @return  AMPType: ActionResult<String>
     */
    public Map<?, ?> ManageInstance(String InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("ADSModule/ManageInstance", args);
    }

    /**
     * Name TypeName Description Optional
     * @param instanceId String AMPType: Guid 
     * @param PortNumber Integer AMPType: Int32 
     * @param Range Integer AMPType: Int32 
     * @param Protocol String AMPType: PortProtocol 
     * @param Description String AMPType: String 
     * @param Open boolean AMPType: Boolean 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> ModifyCustomFirewallRule(String instanceId, Integer PortNumber, Integer Range, String Protocol, String Description, boolean Open) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        args.put("PortNumber", PortNumber);
        args.put("Range", Range);
        args.put("Protocol", Protocol);
        args.put("Description", Description);
        args.put("Open", Open);
        return this.APICall("ADSModule/ModifyCustomFirewallRule", args);
    }

    /**
     * Name TypeName Description Optional
     * @param instanceId String AMPType: Guid 
     * @param datastoreId Integer AMPType: Int32 
     * @return  AMPType: Task<RunningTask>
     */
    public Map<?, ?> MoveInstanceDatastore(String instanceId, Integer datastoreId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        args.put("datastoreId", datastoreId);
        return this.APICall("ADSModule/MoveInstanceDatastore", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: RunningTask
     */
    public Map<?, ?> ReactivateLocalInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/ReactivateLocalInstances", args);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> RefreshAppCache() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/RefreshAppCache", args);
    }

    /**
     * Name TypeName Description Optional
     * @param GroupId String AMPType: Guid 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> RefreshGroup(String GroupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("GroupId", GroupId);
        return this.APICall("ADSModule/RefreshGroup", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceId String AMPType: String 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> RefreshInstanceConfig(String InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("ADSModule/RefreshInstanceConfig", args);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> RefreshRemoteConfigStores() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/RefreshRemoteConfigStores", args);
    }

    /**
     * Name TypeName Description Optional
     * @param controllerUrl String AMPType: String 
     * @param myUrl String AMPType: String 
     * @param username String AMPType: String 
     * @param password String AMPType: String 
     * @param twoFactorToken String AMPType: String 
     * @param friendlyName String AMPType: String 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> RegisterTarget(String controllerUrl, String myUrl, String username, String password, String twoFactorToken, String friendlyName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("controllerUrl", controllerUrl);
        args.put("myUrl", myUrl);
        args.put("username", username);
        args.put("password", password);
        args.put("twoFactorToken", twoFactorToken);
        args.put("friendlyName", friendlyName);
        return this.APICall("ADSModule/RegisterTarget", args);
    }

    /**
     * Name TypeName Description Optional
     * @param id Integer AMPType: Int32 
     * @return  AMPType: RunningTask
     */
    public Map<?, ?> RepairDatastore(Integer id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return this.APICall("ADSModule/RepairDatastore", args);
    }

    /**
     * Name TypeName Description Optional
     * @param datastoreId Integer AMPType: Int32 
     * @return  AMPType: RunningTask
     */
    public Map<?, ?> RequestDatastoreSizeCalculation(Integer datastoreId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("datastoreId", datastoreId);
        return this.APICall("ADSModule/RequestDatastoreSizeCalculation", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceName String AMPType: String 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> RestartInstance(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("ADSModule/RestartInstance", args);
    }

    /**
     * Name TypeName Description Optional
     * @param id String AMPType: String 
     * @param REQ_RAWJSON String AMPType: String 
     * @return  AMPType: Task<JObject>
     */
    public Map<?, ?> Servers(String id, String REQ_RAWJSON) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        args.put("REQ_RAWJSON", REQ_RAWJSON);
        return this.APICall("ADSModule/Servers", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceName String AMPType: String 
     * @param SettingNode String AMPType: String 
     * @param Value String AMPType: String 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> SetInstanceConfig(String InstanceName, String SettingNode, String Value) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        args.put("SettingNode", SettingNode);
        args.put("Value", Value);
        return this.APICall("ADSModule/SetInstanceConfig", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceId String AMPType: Guid 
     * @param PortMappings Map<String, Integer> AMPType: Dictionary<String, Int32> 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> SetInstanceNetworkInfo(String InstanceId, Map<String, Integer> PortMappings) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        args.put("PortMappings", PortMappings);
        return this.APICall("ADSModule/SetInstanceNetworkInfo", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceName String AMPType: String 
     * @param Suspended boolean AMPType: Boolean 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> SetInstanceSuspended(String InstanceName, boolean Suspended) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        args.put("Suspended", Suspended);
        return this.APICall("ADSModule/SetInstanceSuspended", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> StartAllInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/StartAllInstances", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceName String AMPType: String 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> StartInstance(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("ADSModule/StartInstance", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> StopAllInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/StopAllInstances", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceName String AMPType: String 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> StopInstance(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("ADSModule/StopInstance", args);
    }

    /**
     * Name TypeName Description Optional
     * @param url String AMPType: String 
     * @param username String AMPType: String 
     * @param password String AMPType: String 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> TestADSLoginDetails(String url, String username, String password) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("url", url);
        args.put("username", username);
        args.put("password", password);
        return this.APICall("ADSModule/TestADSLoginDetails", args);
    }

    /**
     * Name TypeName Description Optional
     * @param updatedDatastore  AMPType: InstanceDatastore 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> UpdateDatastore(Object updatedDatastore) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("updatedDatastore", updatedDatastore);
        return this.APICall("ADSModule/UpdateDatastore", args);
    }

    /**
     * Name TypeName Description Optional
     * @param templateToUpdate  AMPType: DeploymentTemplate 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> UpdateDeploymentTemplate(Object templateToUpdate) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("templateToUpdate", templateToUpdate);
        return this.APICall("ADSModule/UpdateDeploymentTemplate", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceId String AMPType: String 
     * @param FriendlyName String AMPType: String 
     * @param Description String AMPType: String 
     * @param StartOnBoot boolean AMPType: Boolean 
     * @param Suspended boolean AMPType: Boolean 
     * @param ExcludeFromFirewall boolean AMPType: Boolean 
     * @param RunInContainer boolean AMPType: Boolean 
     * @param ContainerMemory Integer AMPType: Int32 
     * @param MemoryPolicy  AMPType: ContainerMemoryPolicy 
     * @param ContainerMaxCPU  AMPType: Single 
     * @param ContainerImage String AMPType: String 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> UpdateInstanceInfo(String InstanceId, String FriendlyName, String Description, boolean StartOnBoot, boolean Suspended, boolean ExcludeFromFirewall, boolean RunInContainer, Integer ContainerMemory, Object MemoryPolicy, Object ContainerMaxCPU, String ContainerImage) {
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
        return this.APICall("ADSModule/UpdateInstanceInfo", args);
    }

    /**
     * Name TypeName Description Optional
     * @param TargetID String AMPType: Guid 
     * @return void AMPType: Void
     */
    public Map<?, ?> UpdateTarget(String TargetID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TargetID", TargetID);
        return this.APICall("ADSModule/UpdateTarget", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Id String AMPType: Guid 
     * @param FriendlyName String AMPType: String 
     * @param Url String AMPType: Uri 
     * @param Description String AMPType: String 
     * @param Tags List<String> AMPType: List<String> 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> UpdateTargetInfo(String Id, String FriendlyName, String Url, String Description, List<String> Tags) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("FriendlyName", FriendlyName);
        args.put("Url", Url);
        args.put("Description", Description);
        args.put("Tags", Tags);
        return this.APICall("ADSModule/UpdateTargetInfo", args);
    }

    /**
     * Name TypeName Description Optional
     * @param RestartRunning boolean AMPType: Boolean 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> UpgradeAllInstances(boolean RestartRunning) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RestartRunning", RestartRunning);
        return this.APICall("ADSModule/UpgradeAllInstances", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceName String AMPType: String 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> UpgradeInstance(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("ADSModule/UpgradeInstance", args);
    }

}
