package dev.neuralnexus.ampapi.apimodules;

import com.google.gson.reflect.TypeToken;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.types.*;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ADSModule extends AMPAPI {
    public ADSModule(AMPAPI ampapi) {
        super(ampapi);
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
        return (ActionResult) this.APICall("ADSModule/AddDatastore", args, type);
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
        return (ActionResult) this.APICall("ADSModule/ApplyInstanceConfiguration", args, type);
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
        return (ActionResult) this.APICall("ADSModule/ApplyTemplate", args, type);
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
        return (ActionResult) this.APICall("ADSModule/AttachADS", args, type);
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
        return (ActionResult) this.APICall("ADSModule/CloneTemplate", args, type);
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
        return (ActionResult) this.APICall("ADSModule/ConvertToManaged", args, type);
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
        return (ActionResult) this.APICall("ADSModule/CreateDeploymentTemplate", args, type);
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
     * @param PostCreate  True
     * @param StartOnBoot  True
     * @param DisplayImageSource  True
     * @param TargetDatastore  True
     * @return ActionResult
     */
    public ActionResult CreateInstance(UUID TargetADSInstance, UUID NewInstanceId, String Module, String InstanceName, String FriendlyName, String IPBinding, Integer PortNumber, String AdminUsername, String AdminPassword, Map<String, String> ProvisionSettings, Boolean AutoConfigure, Object PostCreate, Boolean StartOnBoot, String DisplayImageSource, Integer TargetDatastore) {
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
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.APICall("ADSModule/CreateInstance", args, type);
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
        return (ActionResult) this.APICall("ADSModule/CreateLocalInstance", args, type);
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
        return (ActionResult) this.APICall("ADSModule/DeleteDatastore", args, type);
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
        return (ActionResult) this.APICall("ADSModule/DeleteDeploymentTemplate", args, type);
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
        return (RunningTask) this.APICall("ADSModule/DeleteInstance", args, type);
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
        return (ActionResult) this.APICall("ADSModule/DeleteInstanceUsers", args, type);
    }

    /**
     * A dictionary of setting nodes and values to create the new instance with. Identical in function to the provisioning arguments in the template itself.
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
     * @param PostCreate 0: Do nothing, 1: Start instance only, 2: Start instance and update application, 3: Full application startup. True
     * @param ExtraProvisionSettings A dictionary of setting nodes and values to create the new instance with. Identical in function to the provisioning arguments in the template itself. True
     * @return RunningTask
     */
    public RunningTask DeployTemplate(Integer TemplateID, String NewUsername, String NewPassword, String NewEmail, List<String> RequiredTags, String Tag, String FriendlyName, String Secret, Object PostCreate, Map<String, String> ExtraProvisionSettings) {
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
        Type type = new TypeToken<RunningTask>(){}.getType();
        return (RunningTask) this.APICall("ADSModule/DeployTemplate", args, type);
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
        return (ActionResult) this.APICall("ADSModule/DetatchTarget", args, type);
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
        return (ActionResult) this.APICall("ADSModule/ExtractEverywhere", args, type);
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
        return (List<EndpointInfo>) this.APICall("ADSModule/GetApplicationEndpoints", args, type);
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
        return (InstanceDatastore) this.APICall("ADSModule/GetDatastore", args, type);
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
        return (List<Map<String, Object>>) this.APICall("ADSModule/GetDatastoreInstances", args, type);
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
        return (List<InstanceDatastore>) this.APICall("ADSModule/GetDatastores", args, type);
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
        return (List<Object>) this.APICall("ADSModule/GetDeploymentTemplates", args, type);
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
        return (IADSInstance) this.APICall("ADSModule/GetGroup", args, type);
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
        return (Instance) this.APICall("ADSModule/GetInstance", args, type);
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
        return (List<Object>) this.APICall("ADSModule/GetInstanceNetworkInfo", args, type);
    }

