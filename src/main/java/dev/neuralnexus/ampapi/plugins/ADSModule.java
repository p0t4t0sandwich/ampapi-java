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
import java.util.UUID;

@SuppressWarnings({"rawtypes", "unchecked", "unused", "DataFlowIssue", "JavadocBlankLines", "RedundantCast", "UnusedReturnValue"})
public class ADSModule extends AMPAPI {
    public ADSModule(AuthProvider authProvider) {
        super(authProvider);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param newDatastore  False
     * @return ActionResult
     */
    public ActionResult AddDatastore(InstanceDatastore newDatastore) {
        Map<String, Object> args = new HashMap<>();
        args.put("newDatastore", newDatastore);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/AddDatastore", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceID  False
     * @param Args  False
     * @param RebuildConfiguration  True
     * @return ActionResult
     */
    public ActionResult ApplyInstanceConfiguration(UUID InstanceID, Map<String, String> Args, Boolean RebuildConfiguration) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceID", InstanceID);
        args.put("Args", Args);
        args.put("RebuildConfiguration", RebuildConfiguration);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/ApplyInstanceConfiguration", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceID  False
     * @param TemplateID  False
     * @param NewFriendlyName  True
     * @param Secret  True
     * @param RestartIfPreviouslyRunning  True
     * @return ActionResult
     */
    public ActionResult ApplyTemplate(UUID InstanceID, Integer TemplateID, String NewFriendlyName, String Secret, Boolean RestartIfPreviouslyRunning) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceID", InstanceID);
        args.put("TemplateID", TemplateID);
        args.put("NewFriendlyName", NewFriendlyName);
        args.put("Secret", Secret);
        args.put("RestartIfPreviouslyRunning", RestartIfPreviouslyRunning);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/ApplyTemplate", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Friendly  False
     * @param IsHTTPS  False
     * @param Host  False
     * @param Port  False
     * @param InstanceID  False
     * @return ActionResult
     */
    public ActionResult AttachADS(String Friendly, Boolean IsHTTPS, String Host, Integer Port, UUID InstanceID) {
        Map<String, Object> args = new HashMap<>();
        args.put("Friendly", Friendly);
        args.put("IsHTTPS", IsHTTPS);
        args.put("Host", Host);
        args.put("Port", Port);
        args.put("InstanceID", InstanceID);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/AttachADS", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Id  False
     * @param NewName  False
     * @return ActionResult
     */
    public ActionResult CloneTemplate(Integer Id, String NewName) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("NewName", NewName);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/CloneTemplate", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceName  False
     * @return ActionResult
     */
    public ActionResult ConvertToManaged(String InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/ConvertToManaged", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Name  False
     * @return ActionResult
     */
    public ActionResult CreateDeploymentTemplate(String Name) {
        Map<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/CreateDeploymentTemplate", args, type);
    }

    /**
     * 
     *
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
     * @param StartOnBoot  True
     * @param DisplayImageSource  True
     * @param TargetDatastore  True
     * @param PostCreate  True
     * @return ActionResult
     */
    public ActionResult CreateInstance(UUID TargetADSInstance, UUID NewInstanceId, String Module, String InstanceName, String FriendlyName, String IPBinding, Integer PortNumber, String AdminUsername, String AdminPassword, Map<String, String> ProvisionSettings, Boolean AutoConfigure, Boolean StartOnBoot, String DisplayImageSource, Integer TargetDatastore, Object PostCreate) {
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
        args.put("StartOnBoot", StartOnBoot);
        args.put("DisplayImageSource", DisplayImageSource);
        args.put("TargetDatastore", TargetDatastore);
        args.put("PostCreate", PostCreate);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/CreateInstance", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Instance  False
     * @param PostCreate  True
     * @return ActionResult
     */
    public ActionResult CreateLocalInstance(Object Instance, Object PostCreate) {
        Map<String, Object> args = new HashMap<>();
        args.put("Instance", Instance);
        args.put("PostCreate", PostCreate);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/CreateLocalInstance", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param id  False
     * @return ActionResult
     */
    public ActionResult DeleteDatastore(Integer id) {
        Map<String, Object> args = new HashMap<>();
        args.put("id", id);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/DeleteDatastore", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Id  False
     * @return ActionResult
     */
    public ActionResult DeleteDeploymentTemplate(Integer Id) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/DeleteDeploymentTemplate", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceName  False
     * @return RunningTask
     */
    public RunningTask DeleteInstance(String InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<RunningTask>(){}.getType();
        return (RunningTask) this.authProvider.APICall("ADSModule/DeleteInstance", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceId  False
     * @return ActionResult
     */
    public ActionResult DeleteInstanceUsers(UUID InstanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/DeleteInstanceUsers", args, type);
    }

    /**
     * 0: Do Nothing, 1: Update Once, 2: Update Always, 3: Update and Start Once, 4: Update and Start Always, 5. Start Always
     *
     * Name Description Optional
     * @param TemplateID The ID of the template to be deployed, as per the Template Management UI in AMP itself. False
     * @param NewUsername If specified, AMP will create a new user with this name for this instance. Must be unique. If this user already exists, this will be ignored but the new instance will be assigned to this user. True
     * @param NewPassword If 'NewUsername' is specified and the user doesn't already exist, the password that will be assigned to this user. True
     * @param NewEmail If 'NewUsername' is specified and the user doesn't already exist, the email address that will be assigned to this user. True
     * @param RequiredTags If specified, AMP will only deploy this template to targets that have every single 'tag' specified in their target configuration. You can adjust this via the controller by clicking 'Edit' on the target settings. True
     * @param Tag Unrelated to RequiredTags. This is to uniquely identify this instance to your own systems. It may be something like an order ID or service ID so you can find the associated instance again at a later time. If 'UseTagAsInstanceName' is enabled, then this will also be used as the instance name for the created instance - but it must be unique. True
     * @param FriendlyName A friendly name for this instance. If left blank, AMP will generate one for you. True
     * @param Secret Must be a non-empty strong in order to get a callback on deployment state change. This secret will be passed back to you in the callback so you can verify the request. True
     * @param ExtraProvisionSettings A dictionary of setting nodes and values to create the new instance with. Identical in function to the provisioning arguments in the template itself. True
     * @param PostCreate 0: Do Nothing, 1: Update Once, 2: Update Always, 3: Update and Start Once, 4: Update and Start Always, 5. Start Always True
     * @return RunningTask
     */
    public RunningTask DeployTemplate(Integer TemplateID, String NewUsername, String NewPassword, String NewEmail, List<String> RequiredTags, String Tag, String FriendlyName, String Secret, Map<String, String> ExtraProvisionSettings, Object PostCreate) {
        Map<String, Object> args = new HashMap<>();
        args.put("TemplateID", TemplateID);
        args.put("NewUsername", NewUsername);
        args.put("NewPassword", NewPassword);
        args.put("NewEmail", NewEmail);
        args.put("RequiredTags", RequiredTags);
        args.put("Tag", Tag);
        args.put("FriendlyName", FriendlyName);
        args.put("Secret", Secret);
        args.put("ExtraProvisionSettings", ExtraProvisionSettings);
        args.put("PostCreate", PostCreate);
        Type type = new TypeToken<RunningTask>(){}.getType();
        return (RunningTask) this.authProvider.APICall("ADSModule/DeployTemplate", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Id  False
     * @return ActionResult
     */
    public ActionResult DetatchTarget(UUID Id) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/DetatchTarget", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param SourceArchive  False
     * @return ActionResult
     */
    public ActionResult ExtractEverywhere(String SourceArchive) {
        Map<String, Object> args = new HashMap<>();
        args.put("SourceArchive", SourceArchive);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/ExtractEverywhere", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param instanceId  False
     * @return List<EndpointInfo>
     */
    public List<EndpointInfo> GetApplicationEndpoints(UUID instanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        Type type = new TypeToken<List<EndpointInfo>>(){}.getType();
        return (List<EndpointInfo>) this.authProvider.APICall("ADSModule/GetApplicationEndpoints", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param id  False
     * @return InstanceDatastore
     */
    public InstanceDatastore GetDatastore(Integer id) {
        Map<String, Object> args = new HashMap<>();
        args.put("id", id);
        Type type = new TypeToken<InstanceDatastore>(){}.getType();
        return (InstanceDatastore) this.authProvider.APICall("ADSModule/GetDatastore", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param datastoreId  False
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> GetDatastoreInstances(Integer datastoreId) {
        Map<String, Object> args = new HashMap<>();
        args.put("datastoreId", datastoreId);
        Type type = new TypeToken<List<Map<String, Object>>>(){}.getType();
        return (List<Map<String, Object>>) this.authProvider.APICall("ADSModule/GetDatastoreInstances", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<InstanceDatastore>
     */
    public List<InstanceDatastore> GetDatastores() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<InstanceDatastore>>(){}.getType();
        return (List<InstanceDatastore>) this.authProvider.APICall("ADSModule/GetDatastores", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<Object>
     */
    public List<Object> GetDeploymentTemplates() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Object>>(){}.getType();
        return (List<Object>) this.authProvider.APICall("ADSModule/GetDeploymentTemplates", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param GroupId  False
     * @return IADSInstance
     */
    public IADSInstance GetGroup(UUID GroupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("GroupId", GroupId);
        Type type = new TypeToken<IADSInstance>(){}.getType();
        return (IADSInstance) this.authProvider.APICall("ADSModule/GetGroup", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceId  False
     * @return Instance
     */
    public Instance GetInstance(UUID InstanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        Type type = new TypeToken<Instance>(){}.getType();
        return (Instance) this.authProvider.APICall("ADSModule/GetInstance", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceName  False
     * @return List<Object>
     */
    public List<Object> GetInstanceNetworkInfo(String InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<List<Object>>(){}.getType();
        return (List<Object>) this.authProvider.APICall("ADSModule/GetInstanceNetworkInfo", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<InstanceStatus>
     */
    public List<InstanceStatus> GetInstanceStatuses() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<InstanceStatus>>(){}.getType();
        return (List<InstanceStatus>) this.authProvider.APICall("ADSModule/GetInstanceStatuses", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param ForceIncludeSelf  True
     * @return List<IADSInstance>
     */
    public List<IADSInstance> GetInstances(Boolean ForceIncludeSelf) {
        Map<String, Object> args = new HashMap<>();
        args.put("ForceIncludeSelf", ForceIncludeSelf);
        Type type = new TypeToken<List<IADSInstance>>(){}.getType();
        return (List<IADSInstance>) this.authProvider.APICall("ADSModule/GetInstances", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> GetLocalInstances() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Map<String, Object>>>(){}.getType();
        return (List<Map<String, Object>>) this.authProvider.APICall("ADSModule/GetLocalInstances", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param ModuleName  False
     * @return List<Object>
     */
    public List<Object> GetProvisionArguments(String ModuleName) {
        Map<String, Object> args = new HashMap<>();
        args.put("ModuleName", ModuleName);
        Type type = new TypeToken<List<Object>>(){}.getType();
        return (List<Object>) this.authProvider.APICall("ADSModule/GetProvisionArguments", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Map<String, Object>
     */
    public Map<String, Object> GetProvisionFitness() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return (Map<String, Object>) this.authProvider.APICall("ADSModule/GetProvisionFitness", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<Object>
     */
    public List<Object> GetSupportedApplications() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Object>>(){}.getType();
        return (List<Object>) this.authProvider.APICall("ADSModule/GetSupportedApplications", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return RemoteTargetInfo
     */
    public RemoteTargetInfo GetTargetInfo() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<RemoteTargetInfo>(){}.getType();
        return (RemoteTargetInfo) this.authProvider.APICall("ADSModule/GetTargetInfo", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param ForModule  False
     * @param SettingNode  False
     * @param Values  False
     * @return ActionResult
     */
    public ActionResult HandoutInstanceConfigs(String ForModule, String SettingNode, List<String> Values) {
        Map<String, Object> args = new HashMap<>();
        args.put("ForModule", ForModule);
        args.put("SettingNode", SettingNode);
        args.put("Values", Values);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/HandoutInstanceConfigs", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceId  False
     * @return ActionResult<UUID>
     */
    public ActionResult<UUID> ManageInstance(UUID InstanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        Type type = new TypeToken<ActionResult<UUID>>(){}.getType();
        return (ActionResult<UUID>) this.authProvider.APICall("ADSModule/ManageInstance", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param instanceId  False
     * @param PortNumber  False
     * @param Range  False
     * @param Protocol  False
     * @param Description  False
     * @param Open  False
     * @return ActionResult
     */
    public ActionResult ModifyCustomFirewallRule(UUID instanceId, Integer PortNumber, Integer Range, Object Protocol, String Description, Boolean Open) {
        Map<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        args.put("PortNumber", PortNumber);
        args.put("Range", Range);
        args.put("Protocol", Protocol);
        args.put("Description", Description);
        args.put("Open", Open);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/ModifyCustomFirewallRule", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param instanceId  False
     * @param datastoreId  False
     * @return RunningTask
     */
    public RunningTask MoveInstanceDatastore(UUID instanceId, Integer datastoreId) {
        Map<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        args.put("datastoreId", datastoreId);
        Type type = new TypeToken<RunningTask>(){}.getType();
        return (RunningTask) this.authProvider.APICall("ADSModule/MoveInstanceDatastore", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return RunningTask
     */
    public RunningTask ReactivateLocalInstances() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<RunningTask>(){}.getType();
        return (RunningTask) this.authProvider.APICall("ADSModule/ReactivateLocalInstances", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Void
     */
    public Void RefreshAppCache() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authProvider.APICall("ADSModule/RefreshAppCache", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param GroupId  False
     * @return ActionResult
     */
    public ActionResult RefreshGroup(UUID GroupId) {
        Map<String, Object> args = new HashMap<>();
        args.put("GroupId", GroupId);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/RefreshGroup", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceId  False
     * @param AndUpdateInstance  True
     * @return ActionResult
     */
    public ActionResult RefreshInstanceConfig(String InstanceId, Boolean AndUpdateInstance) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        args.put("AndUpdateInstance", AndUpdateInstance);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/RefreshInstanceConfig", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param force  True
     * @return Void
     */
    public Void RefreshRemoteConfigStores(Boolean force) {
        Map<String, Object> args = new HashMap<>();
        args.put("force", force);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authProvider.APICall("ADSModule/RefreshRemoteConfigStores", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param controllerUrl  False
     * @param myUrl  False
     * @param username  False
     * @param password  False
     * @param twoFactorToken  False
     * @param friendlyName  False
     * @return ActionResult
     */
    public ActionResult RegisterTarget(String controllerUrl, String myUrl, String username, String password, String twoFactorToken, String friendlyName) {
        Map<String, Object> args = new HashMap<>();
        args.put("controllerUrl", controllerUrl);
        args.put("myUrl", myUrl);
        args.put("username", username);
        args.put("password", password);
        args.put("twoFactorToken", twoFactorToken);
        args.put("friendlyName", friendlyName);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/RegisterTarget", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param id  False
     * @return RunningTask
     */
    public RunningTask RepairDatastore(Integer id) {
        Map<String, Object> args = new HashMap<>();
        args.put("id", id);
        Type type = new TypeToken<RunningTask>(){}.getType();
        return (RunningTask) this.authProvider.APICall("ADSModule/RepairDatastore", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param datastoreId  False
     * @return RunningTask
     */
    public RunningTask RequestDatastoreSizeCalculation(Integer datastoreId) {
        Map<String, Object> args = new HashMap<>();
        args.put("datastoreId", datastoreId);
        Type type = new TypeToken<RunningTask>(){}.getType();
        return (RunningTask) this.authProvider.APICall("ADSModule/RequestDatastoreSizeCalculation", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceName  False
     * @return ActionResult
     */
    public ActionResult RestartInstance(String InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/RestartInstance", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param id  False
     * @param Data  False
     * @param RealIP  False
     * @return Map<String, Object>
     */
    public Map<String, Object> Servers(String id, Map<String, Object> Data, String RealIP) {
        Map<String, Object> args = new HashMap<>();
        args.put("id", id);
        args.put("Data", Data);
        args.put("RealIP", RealIP);
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return (Map<String, Object>) this.authProvider.APICall("ADSModule/Servers", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceName  False
     * @param SettingNode  False
     * @param Value  False
     * @return ActionResult
     */
    public ActionResult SetInstanceConfig(String InstanceName, String SettingNode, String Value) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        args.put("SettingNode", SettingNode);
        args.put("Value", Value);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/SetInstanceConfig", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceId  False
     * @param PortMappings  False
     * @return ActionResult
     */
    public ActionResult SetInstanceNetworkInfo(UUID InstanceId, Map<String, Integer> PortMappings) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        args.put("PortMappings", PortMappings);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/SetInstanceNetworkInfo", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceName  False
     * @param Suspended  False
     * @return ActionResult
     */
    public ActionResult SetInstanceSuspended(String InstanceName, Boolean Suspended) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        args.put("Suspended", Suspended);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/SetInstanceSuspended", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param TargetADSInstance  False
     * @return ActionResult
     */
    public ActionResult StartAllInstances(UUID TargetADSInstance) {
        Map<String, Object> args = new HashMap<>();
        args.put("TargetADSInstance", TargetADSInstance);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/StartAllInstances", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceName  False
     * @return ActionResult
     */
    public ActionResult StartInstance(String InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/StartInstance", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param TargetADSInstance  False
     * @return ActionResult
     */
    public ActionResult StopAllInstances(UUID TargetADSInstance) {
        Map<String, Object> args = new HashMap<>();
        args.put("TargetADSInstance", TargetADSInstance);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/StopAllInstances", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceName  False
     * @return ActionResult
     */
    public ActionResult StopInstance(String InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/StopInstance", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param url  False
     * @param username  False
     * @param password  False
     * @param twoFactorToken  False
     * @return ActionResult
     */
    public ActionResult TestADSLoginDetails(String url, String username, String password, String twoFactorToken) {
        Map<String, Object> args = new HashMap<>();
        args.put("url", url);
        args.put("username", username);
        args.put("password", password);
        args.put("twoFactorToken", twoFactorToken);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/TestADSLoginDetails", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param updatedDatastore  False
     * @return ActionResult
     */
    public ActionResult UpdateDatastore(InstanceDatastore updatedDatastore) {
        Map<String, Object> args = new HashMap<>();
        args.put("updatedDatastore", updatedDatastore);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/UpdateDatastore", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param templateToUpdate  False
     * @return ActionResult
     */
    public ActionResult UpdateDeploymentTemplate(Object templateToUpdate) {
        Map<String, Object> args = new HashMap<>();
        args.put("templateToUpdate", templateToUpdate);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/UpdateDeploymentTemplate", args, type);
    }

    /**
     * 
     *
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
     * @param ContainerSwap  False
     * @param WelcomeMessage  True
     * @return ActionResult
     */
    public ActionResult UpdateInstanceInfo(String InstanceId, String FriendlyName, String Description, Boolean StartOnBoot, Boolean Suspended, Boolean ExcludeFromFirewall, Boolean RunInContainer, Integer ContainerMemory, Object MemoryPolicy, Object ContainerMaxCPU, String ContainerImage, Integer ContainerSwap, String WelcomeMessage) {
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
        args.put("ContainerImage", ContainerImage);
        args.put("ContainerSwap", ContainerSwap);
        args.put("WelcomeMessage", WelcomeMessage);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/UpdateInstanceInfo", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param TargetID  False
     * @return Void
     */
    public Void UpdateTarget(UUID TargetID) {
        Map<String, Object> args = new HashMap<>();
        args.put("TargetID", TargetID);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authProvider.APICall("ADSModule/UpdateTarget", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Id  False
     * @param FriendlyName  False
     * @param Url  False
     * @param Description  False
     * @param Tags  False
     * @return ActionResult
     */
    public ActionResult UpdateTargetInfo(UUID Id, String FriendlyName, URL Url, String Description, List<String> Tags) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("FriendlyName", FriendlyName);
        args.put("Url", Url);
        args.put("Description", Description);
        args.put("Tags", Tags);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/UpdateTargetInfo", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param RestartRunning  False
     * @param TargetADSInstance  False
     * @return ActionResult
     */
    public ActionResult UpgradeAllInstances(Boolean RestartRunning, UUID TargetADSInstance) {
        Map<String, Object> args = new HashMap<>();
        args.put("RestartRunning", RestartRunning);
        args.put("TargetADSInstance", TargetADSInstance);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/UpgradeAllInstances", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceName  False
     * @return ActionResult
     */
    public ActionResult UpgradeInstance(String InstanceName) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/UpgradeInstance", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param SpecId  False
     * @param TargetADSInstance  False
     * @param FriendlyName  False
     * @param PostCreate  True
     * @param StartOnBoot  True
     * @param TargetDatastore  True
     * @return ActionResult
     */
    public ActionResult CreateInstanceFromSpec(UUID SpecId, UUID TargetADSInstance, String FriendlyName, Object PostCreate, Boolean StartOnBoot, Integer TargetDatastore) {
        Map<String, Object> args = new HashMap<>();
        args.put("SpecId", SpecId);
        args.put("TargetADSInstance", TargetADSInstance);
        args.put("FriendlyName", FriendlyName);
        args.put("PostCreate", PostCreate);
        args.put("StartOnBoot", StartOnBoot);
        args.put("TargetDatastore", TargetDatastore);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/CreateInstanceFromSpec", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Id  False
     * @return ActionResult
     */
    public ActionResult DetachTarget(UUID Id) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("ADSModule/DetachTarget", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> GetSupportedAppSummaries() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Map<String, Object>>>(){}.getType();
        return (List<Map<String, Object>>) this.authProvider.APICall("ADSModule/GetSupportedAppSummaries", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param instanceId  False
     * @return RunningTask
     */
    public RunningTask ReactivateInstance(UUID instanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        Type type = new TypeToken<RunningTask>(){}.getType();
        return (RunningTask) this.authProvider.APICall("ADSModule/ReactivateInstance", args, type);
    }

}
