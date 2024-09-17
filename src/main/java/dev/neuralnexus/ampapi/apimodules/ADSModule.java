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

public class ADSModule extends AMPAPI {
    public ADSModule(AuthStore authStore, String instanceName) {
        super(authStore, instanceName);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param newDatastore  False
     * @return ActionResult
     */
    public ActionResult AddDatastore(InstanceDatastore newDatastore) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("newDatastore", newDatastore);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceID", InstanceID);
        args.put("Args", Args);
        args.put("RebuildConfiguration", RebuildConfiguration);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceID", InstanceID);
        args.put("TemplateID", TemplateID);
        args.put("NewFriendlyName", NewFriendlyName);
        args.put("Secret", Secret);
        args.put("RestartIfPreviouslyRunning", RestartIfPreviouslyRunning);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        HashMap<String, Object> args = new HashMap<>();
        args.put("Friendly", Friendly);
        args.put("IsHTTPS", IsHTTPS);
        args.put("Host", Host);
        args.put("Port", Port);
        args.put("InstanceID", InstanceID);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("NewName", NewName);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceName  False
     * @return ActionResult
     */
    public ActionResult ConvertToManaged(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Name  False
     * @return ActionResult
     */
    public ActionResult CreateDeploymentTemplate(String Name) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        args.put("StartOnBoot", StartOnBoot);
        args.put("DisplayImageSource", DisplayImageSource);
        args.put("TargetDatastore", TargetDatastore);
        args.put("PostCreate", PostCreate);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        HashMap<String, Object> args = new HashMap<>();
        args.put("Instance", Instance);
        args.put("PostCreate", PostCreate);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param id  False
     * @return ActionResult
     */
    public ActionResult DeleteDatastore(Integer id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Id  False
     * @return ActionResult
     */
    public ActionResult DeleteDeploymentTemplate(Integer Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceName  False
     * @return RunningTask
     */
    public RunningTask DeleteInstance(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<RunningTask>(){}.getType();
        return (RunningTask) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceId  False
     * @return ActionResult
     */
    public ActionResult DeleteInstanceUsers(UUID InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        HashMap<String, Object> args = new HashMap<>();
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
        return (RunningTask) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Id  False
     * @return ActionResult
     */
    public ActionResult DetatchTarget(UUID Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param SourceArchive  False
     * @return ActionResult
     */
    public ActionResult ExtractEverywhere(String SourceArchive) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("SourceArchive", SourceArchive);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param instanceId  False
     * @return List<EndpointInfo>
     */
    public List<EndpointInfo> GetApplicationEndpoints(UUID instanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        Type type = new TypeToken<List<EndpointInfo>>(){}.getType();
        return (List<EndpointInfo>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param id  False
     * @return InstanceDatastore
     */
    public InstanceDatastore GetDatastore(Integer id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        Type type = new TypeToken<InstanceDatastore>(){}.getType();
        return (InstanceDatastore) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param datastoreId  False
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> GetDatastoreInstances(Integer datastoreId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("datastoreId", datastoreId);
        Type type = new TypeToken<List<Map<String, Object>>>(){}.getType();
        return (List<Map<String, Object>>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<InstanceDatastore>
     */
    public List<InstanceDatastore> GetDatastores() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<InstanceDatastore>>(){}.getType();
        return (List<InstanceDatastore>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<Object>
     */
    public List<Object> GetDeploymentTemplates() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Object>>(){}.getType();
        return (List<Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param GroupId  False
     * @return IADSInstance
     */
    public IADSInstance GetGroup(UUID GroupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("GroupId", GroupId);
        Type type = new TypeToken<IADSInstance>(){}.getType();
        return (IADSInstance) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceId  False
     * @return Instance
     */
    public Instance GetInstance(UUID InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        Type type = new TypeToken<Instance>(){}.getType();
        return (Instance) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceName  False
     * @return List<Object>
     */
    public List<Object> GetInstanceNetworkInfo(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<List<Object>>(){}.getType();
        return (List<Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<InstanceStatus>
     */
    public List<InstanceStatus> GetInstanceStatuses() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<InstanceStatus>>(){}.getType();
        return (List<InstanceStatus>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param ForceIncludeSelf  True
     * @return List<IADSInstance>
     */
    public List<IADSInstance> GetInstances(Boolean ForceIncludeSelf) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ForceIncludeSelf", ForceIncludeSelf);
        Type type = new TypeToken<List<IADSInstance>>(){}.getType();
        return (List<IADSInstance>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> GetLocalInstances() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Map<String, Object>>>(){}.getType();
        return (List<Map<String, Object>>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param ModuleName  False
     * @return List<Object>
     */
    public List<Object> GetProvisionArguments(String ModuleName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ModuleName", ModuleName);
        Type type = new TypeToken<List<Object>>(){}.getType();
        return (List<Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Map<String, Object>
     */
    public Map<String, Object> GetProvisionFitness() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return (Map<String, Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<Object>
     */
    public List<Object> GetSupportedApplications() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Object>>(){}.getType();
        return (List<Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return RemoteTargetInfo
     */
    public RemoteTargetInfo GetTargetInfo() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<RemoteTargetInfo>(){}.getType();
        return (RemoteTargetInfo) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        HashMap<String, Object> args = new HashMap<>();
        args.put("ForModule", ForModule);
        args.put("SettingNode", SettingNode);
        args.put("Values", Values);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceId  False
     * @return ActionResult<String>
     */
    public ActionResult<String> ManageInstance(UUID InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        Type type = new TypeToken<ActionResult<String>>(){}.getType();
        return (ActionResult<String>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        HashMap<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        args.put("PortNumber", PortNumber);
        args.put("Range", Range);
        args.put("Protocol", Protocol);
        args.put("Description", Description);
        args.put("Open", Open);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        HashMap<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        args.put("datastoreId", datastoreId);
        Type type = new TypeToken<RunningTask>(){}.getType();
        return (RunningTask) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return RunningTask
     */
    public RunningTask ReactivateLocalInstances() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<RunningTask>(){}.getType();
        return (RunningTask) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Void
     */
    public Void RefreshAppCache() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param GroupId  False
     * @return ActionResult
     */
    public ActionResult RefreshGroup(UUID GroupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("GroupId", GroupId);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        args.put("AndUpdateInstance", AndUpdateInstance);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param force  True
     * @return Void
     */
    public Void RefreshRemoteConfigStores(Boolean force) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("force", force);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        HashMap<String, Object> args = new HashMap<>();
        args.put("controllerUrl", controllerUrl);
        args.put("myUrl", myUrl);
        args.put("username", username);
        args.put("password", password);
        args.put("twoFactorToken", twoFactorToken);
        args.put("friendlyName", friendlyName);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param id  False
     * @return RunningTask
     */
    public RunningTask RepairDatastore(Integer id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        Type type = new TypeToken<RunningTask>(){}.getType();
        return (RunningTask) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param datastoreId  False
     * @return RunningTask
     */
    public RunningTask RequestDatastoreSizeCalculation(Integer datastoreId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("datastoreId", datastoreId);
        Type type = new TypeToken<RunningTask>(){}.getType();
        return (RunningTask) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceName  False
     * @return ActionResult
     */
    public ActionResult RestartInstance(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        args.put("Data", Data);
        args.put("RealIP", RealIP);
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return (Map<String, Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        args.put("SettingNode", SettingNode);
        args.put("Value", Value);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        args.put("PortMappings", PortMappings);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        args.put("Suspended", Suspended);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param TargetADSInstance  False
     * @return ActionResult
     */
    public ActionResult StartAllInstances(UUID TargetADSInstance) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TargetADSInstance", TargetADSInstance);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceName  False
     * @return ActionResult
     */
    public ActionResult StartInstance(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param TargetADSInstance  False
     * @return ActionResult
     */
    public ActionResult StopAllInstances(UUID TargetADSInstance) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TargetADSInstance", TargetADSInstance);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceName  False
     * @return ActionResult
     */
    public ActionResult StopInstance(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        HashMap<String, Object> args = new HashMap<>();
        args.put("url", url);
        args.put("username", username);
        args.put("password", password);
        args.put("twoFactorToken", twoFactorToken);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param updatedDatastore  False
     * @return ActionResult
     */
    public ActionResult UpdateDatastore(InstanceDatastore updatedDatastore) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("updatedDatastore", updatedDatastore);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param templateToUpdate  False
     * @return ActionResult
     */
    public ActionResult UpdateDeploymentTemplate(Object templateToUpdate) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("templateToUpdate", templateToUpdate);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        args.put("ContainerSwap", ContainerSwap);
        args.put("WelcomeMessage", WelcomeMessage);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param TargetID  False
     * @return Void
     */
    public Void UpdateTarget(UUID TargetID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TargetID", TargetID);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("FriendlyName", FriendlyName);
        args.put("Url", Url);
        args.put("Description", Description);
        args.put("Tags", Tags);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        HashMap<String, Object> args = new HashMap<>();
        args.put("RestartRunning", RestartRunning);
        args.put("TargetADSInstance", TargetADSInstance);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param InstanceName  False
     * @return ActionResult
     */
    public ActionResult UpgradeInstance(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        HashMap<String, Object> args = new HashMap<>();
        args.put("SpecId", SpecId);
        args.put("TargetADSInstance", TargetADSInstance);
        args.put("FriendlyName", FriendlyName);
        args.put("PostCreate", PostCreate);
        args.put("StartOnBoot", StartOnBoot);
        args.put("TargetDatastore", TargetDatastore);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Id  False
     * @return ActionResult
     */
    public ActionResult DetachTarget(UUID Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> GetSupportedAppSummaries() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Map<String, Object>>>(){}.getType();
        return (List<Map<String, Object>>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param instanceId  False
     * @return RunningTask
     */
    public RunningTask ReactivateInstance(UUID instanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        Type type = new TypeToken<RunningTask>(){}.getType();
        return (RunningTask) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

}
