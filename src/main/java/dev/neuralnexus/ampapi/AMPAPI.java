package dev.neuralnexus.ampapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AMPAPI {
    String baseUri;
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
    public Map<?,?> APICall(String endpoint, Map<String, Object> data) {
        try {
            data.put("SESSIONID", this.sessionId);

            Gson gson = new GsonBuilder().create();
            String data_json = gson.toJson(data);

            URL url = new URL(this.dataSource + "/" + endpoint);

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

            return gson.fromJson(br.readLine(), Map.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Name TypeName Description Optional
     * @param newDatastore  AMPType: InstanceDatastore
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> ADSModule_AddDatastore(Object newDatastore) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("newDatastore", newDatastore);
        return this.APICall("ADSModule/AddDatastore", args);
    }

    /**
     * Name TypeName Description Optional
     * @param id Integer AMPType: Int32
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> ADSModule_DeleteDatastore(Integer id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return this.APICall("ADSModule/DeleteDatastore", args);
    }

    /**
     * Name TypeName Description Optional
     * @param updatedDatastore  AMPType: InstanceDatastore
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> ADSModule_UpdateDatastore(Object updatedDatastore) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("updatedDatastore", updatedDatastore);
        return this.APICall("ADSModule/UpdateDatastore", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<?> AMPType: IEnumerable<InstanceDatastore>
     */
    public Map<?, ?> ADSModule_GetDatastores() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetDatastores", args);
    }

    /**
     * Name TypeName Description Optional
     * @param datastoreId Integer AMPType: Int32
     * @return  AMPType: RunningTask
     */
    public Map<?, ?> ADSModule_RequestDatastoreSizeCalculation(Integer datastoreId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("datastoreId", datastoreId);
        return this.APICall("ADSModule/RequestDatastoreSizeCalculation", args);
    }

    /**
     * Name TypeName Description Optional
     * @param id Integer AMPType: Int32
     * @return  AMPType: InstanceDatastore
     */
    public Map<?, ?> ADSModule_GetDatastore(Integer id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return this.APICall("ADSModule/GetDatastore", args);
    }

    /**
     * Name TypeName Description Optional
     * @param id Integer AMPType: Int32
     * @return  AMPType: RunningTask
     */
    public Map<?, ?> ADSModule_RepairDatastore(Integer id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return this.APICall("ADSModule/RepairDatastore", args);
    }

    /**
     * Name TypeName Description Optional
     * @param datastoreId Integer AMPType: Int32
     * @return List<Map<?, ?>> AMPType: IEnumerable<JObject>
     */
    public Map<?, ?> ADSModule_GetDatastoreInstances(Integer datastoreId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("datastoreId", datastoreId);
        return this.APICall("ADSModule/GetDatastoreInstances", args);
    }

    /**
     * Name TypeName Description Optional
     * @param instanceId String AMPType: Guid
     * @param datastoreId Integer AMPType: Int32
     * @return  AMPType: Task<RunningTask>
     */
    public Map<?, ?> ADSModule_MoveInstanceDatastore(String instanceId, Integer datastoreId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        args.put("datastoreId", datastoreId);
        return this.APICall("ADSModule/MoveInstanceDatastore", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<?> AMPType: IEnumerable<DeploymentTemplate>
     */
    public Map<?, ?> ADSModule_GetDeploymentTemplates() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetDeploymentTemplates", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Name String AMPType: String
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> ADSModule_CreateDeploymentTemplate(String Name) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        return this.APICall("ADSModule/CreateDeploymentTemplate", args);
    }

    /**
     * Name TypeName Description Optional
     * @param templateToUpdate  AMPType: DeploymentTemplate
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> ADSModule_UpdateDeploymentTemplate(Object templateToUpdate) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("templateToUpdate", templateToUpdate);
        return this.APICall("ADSModule/UpdateDeploymentTemplate", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Id Integer AMPType: Int32
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> ADSModule_DeleteDeploymentTemplate(Integer Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("ADSModule/DeleteDeploymentTemplate", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Id Integer AMPType: Int32
     * @param NewName String AMPType: String
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> ADSModule_CloneTemplate(Integer Id, String NewName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("NewName", NewName);
        return this.APICall("ADSModule/CloneTemplate", args);
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
    public Map<?, ?> ADSModule_ApplyTemplate(String InstanceID, Integer TemplateID, String NewFriendlyName, String Secret, boolean RestartIfPreviouslyRunning) {
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
    public Map<?, ?> ADSModule_DeployTemplate(Integer TemplateID, String NewUsername, String NewPassword, String NewEmail, List<String> RequiredTags, String Tag, String FriendlyName, String Secret, Object PostCreate, Map<String, String> ExtraProvisionSettings) {
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
     * @return  AMPType: RemoteTargetInfo
     */
    public Map<?, ?> ADSModule_GetTargetInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetTargetInfo", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<?> AMPType: IEnumerable<ApplicationSpec>
     */
    public Map<?, ?> ADSModule_GetSupportedApplications() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetSupportedApplications", args);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> ADSModule_RefreshAppCache() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/RefreshAppCache", args);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> ADSModule_RefreshRemoteConfigStores() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/RefreshRemoteConfigStores", args);
    }

    /**
     * Name TypeName Description Optional
     * @param instanceId String AMPType: Guid
     * @return List<?> AMPType: IEnumerable<EndpointInfo>
     */
    public Map<?, ?> ADSModule_GetApplicationEndpoints(String instanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        return this.APICall("ADSModule/GetApplicationEndpoints", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: RunningTask
     */
    public Map<?, ?> ADSModule_ReactivateLocalInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/ReactivateLocalInstances", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<?> AMPType: IEnumerable<IADSInstance>
     */
    public Map<?, ?> ADSModule_GetInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetInstances", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceId String AMPType: Guid
     * @return Map<?, ?> AMPType: JObject
     */
    public Map<?, ?> ADSModule_GetInstance(String InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("ADSModule/GetInstance", args);
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
    public Map<?, ?> ADSModule_ModifyCustomFirewallRule(String instanceId, Integer PortNumber, Integer Range, String Protocol, String Description, boolean Open) {
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
     * @param InstanceId String AMPType: Guid
     * @return  AMPType: ActionResult<String>
     */
    public Map<?, ?> ADSModule_ManageInstance(String InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("ADSModule/ManageInstance", args);
    }

    /**
     * Name TypeName Description Optional
     * @param GroupId String AMPType: Guid
     * @return bool AMPType: IADSInstance
     */
    public Map<?, ?> ADSModule_GetGroup(String GroupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("GroupId", GroupId);
        return this.APICall("ADSModule/GetGroup", args);
    }

    /**
     * Name TypeName Description Optional
     * @param GroupId String AMPType: Guid
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> ADSModule_RefreshGroup(String GroupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("GroupId", GroupId);
        return this.APICall("ADSModule/RefreshGroup", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<Map<?, ?>> AMPType: IEnumerable<JObject>
     */
    public Map<?, ?> ADSModule_GetLocalInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetLocalInstances", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<Map<?, ?>> AMPType: IEnumerable<JObject>
     */
    public Map<?, ?> ADSModule_GetInstanceStatuses() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetInstanceStatuses", args);
    }

    /**
     * Name TypeName Description Optional
     * @return Map<?, ?> AMPType: JObject
     */
    public Map<?, ?> ADSModule_GetProvisionFitness() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/GetProvisionFitness", args);
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
    public Map<?, ?> ADSModule_AttachADS(String Friendly, boolean IsHTTPS, String Host, Integer Port, String InstanceID) {
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
     * @param Id String AMPType: Guid
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> ADSModule_DetatchTarget(String Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("ADSModule/DetatchTarget", args);
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
    public Map<?, ?> ADSModule_UpdateTargetInfo(String Id, String FriendlyName, String Url, String Description, List<String> Tags) {
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
     * @param InstanceName String AMPType: String
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> ADSModule_ConvertToManaged(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("ADSModule/ConvertToManaged", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceName String AMPType: String
     * @return List<?> AMPType: IEnumerable<PortUsage>
     */
    public Map<?, ?> ADSModule_GetInstanceNetworkInfo(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("ADSModule/GetInstanceNetworkInfo", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceId String AMPType: Guid
     * @param PortMappings Map<String, Integer> AMPType: Dictionary<String, Int32>
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> ADSModule_SetInstanceNetworkInfo(String InstanceId, Map<String, Integer> PortMappings) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        args.put("PortMappings", PortMappings);
        return this.APICall("ADSModule/SetInstanceNetworkInfo", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceID String AMPType: Guid
     * @param Args Map<String, String> AMPType: Dictionary<String, String>
     * @param RebuildConfiguration boolean AMPType: Boolean
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> ADSModule_ApplyInstanceConfiguration(String InstanceID, Map<String, String> Args, boolean RebuildConfiguration) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceID", InstanceID);
        args.put("Args", Args);
        args.put("RebuildConfiguration", RebuildConfiguration);
        return this.APICall("ADSModule/ApplyInstanceConfiguration", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Instance  AMPType: LocalAMPInstance
     * @param PostCreate  AMPType: PostCreateActions
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> ADSModule_CreateLocalInstance(Object Instance, Object PostCreate) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Instance", Instance);
        args.put("PostCreate", PostCreate);
        return this.APICall("ADSModule/CreateLocalInstance", args);
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
    public Map<?, ?> ADSModule_CreateInstance(String TargetADSInstance, String NewInstanceId, String Module, String InstanceName, String FriendlyName, String IPBinding, Integer PortNumber, String AdminUsername, String AdminPassword, Map<String, String> ProvisionSettings, boolean AutoConfigure, Object PostCreate, boolean StartOnBoot, String DisplayImageSource, Integer TargetDatastore) {
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
     * @param InstanceName String AMPType: String
     * @param SettingNode String AMPType: String
     * @param Value String AMPType: String
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> ADSModule_SetInstanceConfig(String InstanceName, String SettingNode, String Value) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        args.put("SettingNode", SettingNode);
        args.put("Value", Value);
        return this.APICall("ADSModule/SetInstanceConfig", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceId String AMPType: String
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> ADSModule_RefreshInstanceConfig(String InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("ADSModule/RefreshInstanceConfig", args);
    }

    /**
     * Name TypeName Description Optional
     * @param ForModule String AMPType: String
     * @param SettingNode String AMPType: String
     * @param Values List<String> AMPType: List<String>
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> ADSModule_HandoutInstanceConfigs(String ForModule, String SettingNode, List<String> Values) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ForModule", ForModule);
        args.put("SettingNode", SettingNode);
        args.put("Values", Values);
        return this.APICall("ADSModule/HandoutInstanceConfigs", args);
    }

    /**
     * Name TypeName Description Optional
     * @param ModuleName String AMPType: String
     * @return List<Map<?, ?>> AMPType: IEnumerable<JObject>
     */
    public Map<?, ?> ADSModule_GetProvisionArguments(String ModuleName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ModuleName", ModuleName);
        return this.APICall("ADSModule/GetProvisionArguments", args);
    }

    /**
     * Name TypeName Description Optional
     * @param url String AMPType: String
     * @param username String AMPType: String
     * @param password String AMPType: String
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> ADSModule_TestADSLoginDetails(String url, String username, String password) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("url", url);
        args.put("username", username);
        args.put("password", password);
        return this.APICall("ADSModule/TestADSLoginDetails", args);
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
    public Map<?, ?> ADSModule_RegisterTarget(String controllerUrl, String myUrl, String username, String password, String twoFactorToken, String friendlyName) {
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
     * @param TargetID String AMPType: Guid
     * @return void AMPType: Void
     */
    public Map<?, ?> ADSModule_UpdateTarget(String TargetID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TargetID", TargetID);
        return this.APICall("ADSModule/UpdateTarget", args);
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
    public Map<?, ?> ADSModule_UpdateInstanceInfo(String InstanceId, String FriendlyName, String Description, boolean StartOnBoot, boolean Suspended, boolean ExcludeFromFirewall, boolean RunInContainer, Integer ContainerMemory, Object MemoryPolicy, Object ContainerMaxCPU, String ContainerImage) {
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
     * @param InstanceName String AMPType: String
     * @param Suspended boolean AMPType: Boolean
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> ADSModule_SetInstanceSuspended(String InstanceName, boolean Suspended) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        args.put("Suspended", Suspended);
        return this.APICall("ADSModule/SetInstanceSuspended", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceName String AMPType: String
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> ADSModule_UpgradeInstance(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("ADSModule/UpgradeInstance", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> ADSModule_StartAllInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/StartAllInstances", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> ADSModule_StopAllInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("ADSModule/StopAllInstances", args);
    }

    /**
     * Name TypeName Description Optional
     * @param RestartRunning boolean AMPType: Boolean
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> ADSModule_UpgradeAllInstances(boolean RestartRunning) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RestartRunning", RestartRunning);
        return this.APICall("ADSModule/UpgradeAllInstances", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceName String AMPType: String
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> ADSModule_StartInstance(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("ADSModule/StartInstance", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceName String AMPType: String
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> ADSModule_RestartInstance(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("ADSModule/RestartInstance", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceName String AMPType: String
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> ADSModule_StopInstance(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("ADSModule/StopInstance", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceId String AMPType: Guid
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> ADSModule_DeleteInstanceUsers(String InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("ADSModule/DeleteInstanceUsers", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceName String AMPType: String
     * @return  AMPType: RunningTask
     */
    public Map<?, ?> ADSModule_DeleteInstance(String InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("ADSModule/DeleteInstance", args);
    }

    /**
     * Name TypeName Description Optional
     * @param SourceArchive String AMPType: String
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> ADSModule_ExtractEverywhere(String SourceArchive) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("SourceArchive", SourceArchive);
        return this.APICall("ADSModule/ExtractEverywhere", args);
    }

    /**
     * Name TypeName Description Optional
     * @param id String AMPType: String
     * @param REQ_RAWJSON String AMPType: String
     * @return  AMPType: Task<JObject>
     */
    public Map<?, ?> ADSModule_Servers(String id, String REQ_RAWJSON) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        args.put("REQ_RAWJSON", REQ_RAWJSON);
        return this.APICall("ADSModule/Servers", args);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> FileManagerPlugin_Dummy() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("FileManagerPlugin/Dummy", args);
    }

    /**
     * Name TypeName Description Optional
     * @param FilePath String AMPType: String
     * @return  AMPType: ActionResult<String>
     */
    public Map<?, ?> FileManagerPlugin_CalculateFileMD5Sum(String FilePath) {
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
    public Map<?, ?> FileManagerPlugin_ChangeExclusion(String ModifyPath, boolean AsDirectory, boolean Exclude) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ModifyPath", ModifyPath);
        args.put("AsDirectory", AsDirectory);
        args.put("Exclude", Exclude);
        return this.APICall("FileManagerPlugin/ChangeExclusion", args);
    }

    /**
     * Name TypeName Description Optional
     * @param PathToArchive String AMPType: String
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> FileManagerPlugin_CreateArchive(String PathToArchive) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("PathToArchive", PathToArchive);
        return this.APICall("FileManagerPlugin/CreateArchive", args);
    }

    /**
     * Name TypeName Description Optional
     * @param ArchivePath String AMPType: String
     * @param DestinationPath String AMPType: String
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> FileManagerPlugin_ExtractArchive(String ArchivePath, String DestinationPath) {
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
    public Map<?, ?> FileManagerPlugin_GetDirectoryListing(String Dir) {
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
    public Map<?, ?> FileManagerPlugin_GetFileChunk(String Filename, Integer Position, Integer Length) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Position", Position);
        args.put("Length", Length);
        return this.APICall("FileManagerPlugin/GetFileChunk", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Filename String AMPType: String
     * @param Data String AMPType: String
     * @param Delete boolean AMPType: Boolean
     * @return void AMPType: Void
     */
    public Map<?, ?> FileManagerPlugin_AppendFileChunk(String Filename, String Data, boolean Delete) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Data", Data);
        args.put("Delete", Delete);
        return this.APICall("FileManagerPlugin/AppendFileChunk", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Filename String AMPType: String
     * @param Offset Integer AMPType: Int64
     * @param ChunkSize Integer AMPType: Int64
     * @return  AMPType: ActionResult<String>
     */
    public Map<?, ?> FileManagerPlugin_ReadFileChunk(String Filename, Integer Offset, Integer ChunkSize) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Offset", Offset);
        args.put("ChunkSize", ChunkSize);
        return this.APICall("FileManagerPlugin/ReadFileChunk", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Filename String AMPType: String
     * @param Data String AMPType: String
     * @param Offset Integer AMPType: Int64
     * @param FinalChunk boolean AMPType: Boolean
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> FileManagerPlugin_WriteFileChunk(String Filename, String Data, Integer Offset, boolean FinalChunk) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Data", Data);
        args.put("Offset", Offset);
        args.put("FinalChunk", FinalChunk);
        return this.APICall("FileManagerPlugin/WriteFileChunk", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Source String AMPType: Uri
     * @param TargetDirectory String AMPType: String
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> FileManagerPlugin_DownloadFileFromURL(String Source, String TargetDirectory) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Source", Source);
        args.put("TargetDirectory", TargetDirectory);
        return this.APICall("FileManagerPlugin/DownloadFileFromURL", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Filename String AMPType: String
     * @param NewFilename String AMPType: String
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> FileManagerPlugin_RenameFile(String Filename, String NewFilename) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("NewFilename", NewFilename);
        return this.APICall("FileManagerPlugin/RenameFile", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Origin String AMPType: String
     * @param TargetDirectory String AMPType: String
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> FileManagerPlugin_CopyFile(String Origin, String TargetDirectory) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Origin", Origin);
        args.put("TargetDirectory", TargetDirectory);
        return this.APICall("FileManagerPlugin/CopyFile", args);
    }

    /**
     * Moves a file to trash, files must be trashed before they can be deleted.
     * Name TypeName Description Optional
     * @param Filename String AMPType: String
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> FileManagerPlugin_TrashFile(String Filename) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        return this.APICall("FileManagerPlugin/TrashFile", args);
    }

    /**
     * Moves a directory to trash, files must be trashed before they can be deleted.
     * Name TypeName Description Optional
     * @param DirectoryName String AMPType: String
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> FileManagerPlugin_TrashDirectory(String DirectoryName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("DirectoryName", DirectoryName);
        return this.APICall("FileManagerPlugin/TrashDirectory", args);
    }

    /**
     * Empties a trash bin
     * Name TypeName Description Optional
     * @param TrashDirectoryName String AMPType: String
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> FileManagerPlugin_EmptyTrash(String TrashDirectoryName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TrashDirectoryName", TrashDirectoryName);
        return this.APICall("FileManagerPlugin/EmptyTrash", args);
    }

    /**
     * Creates a new directory. The parent directory must already exist.
     * Name TypeName Description Optional
     * @param NewPath String AMPType: String
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> FileManagerPlugin_CreateDirectory(String NewPath) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("NewPath", NewPath);
        return this.APICall("FileManagerPlugin/CreateDirectory", args);
    }

    /**
     * Renames a directory
     * Name TypeName Description Optional
     * @param oldDirectory String AMPType: String The full path to the old directory
     * @param NewDirectoryName String AMPType: String The name component of the new directory (not the full path)
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> FileManagerPlugin_RenameDirectory(String oldDirectory, String NewDirectoryName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("oldDirectory", oldDirectory);
        args.put("NewDirectoryName", NewDirectoryName);
        return this.APICall("FileManagerPlugin/RenameDirectory", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> EmailSenderPlugin_TestSMTPSettings() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("EmailSenderPlugin/TestSMTPSettings", args);
    }

    /**
     * Name TypeName Description Optional
     * @param BackupId String AMPType: Guid
     * @return  AMPType: RunningTask
     */
    public Map<?, ?> LocalFileBackupPlugin_UploadToS3(String BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("LocalFileBackupPlugin/UploadToS3", args);
    }

    /**
     * Name TypeName Description Optional
     * @param BackupId String AMPType: Guid
     * @return  AMPType: RunningTask
     */
    public Map<?, ?> LocalFileBackupPlugin_DownloadFromS3(String BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("LocalFileBackupPlugin/DownloadFromS3", args);
    }

    /**
     * Name TypeName Description Optional
     * @param BackupId String AMPType: Guid
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> LocalFileBackupPlugin_DeleteFromS3(String BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("LocalFileBackupPlugin/DeleteFromS3", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<Map<?, ?>> AMPType: IEnumerable<BackupManifest>
     */
    public Map<?, ?> LocalFileBackupPlugin_GetBackups() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("LocalFileBackupPlugin/GetBackups", args);
    }

    /**
     * Name TypeName Description Optional
     * @param BackupId String AMPType: Guid
     * @param DeleteExistingData boolean AMPType: Boolean
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> LocalFileBackupPlugin_RestoreBackup(String BackupId, boolean DeleteExistingData) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        args.put("DeleteExistingData", DeleteExistingData);
        return this.APICall("LocalFileBackupPlugin/RestoreBackup", args);
    }

    /**
     * Name TypeName Description Optional
     * @param BackupId String AMPType: Guid
     * @return void AMPType: Void
     */
    public Map<?, ?> LocalFileBackupPlugin_DeleteLocalBackup(String BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("LocalFileBackupPlugin/DeleteLocalBackup", args);
    }

    /**
     * Name TypeName Description Optional
     * @param BackupId String AMPType: Guid
     * @param Sticky boolean AMPType: Boolean
     * @return void AMPType: Void
     */
    public Map<?, ?> LocalFileBackupPlugin_SetBackupSticky(String BackupId, boolean Sticky) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        args.put("Sticky", Sticky);
        return this.APICall("LocalFileBackupPlugin/SetBackupSticky", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Title String AMPType: String
     * @param Description String AMPType: String
     * @param Sticky boolean AMPType: Boolean
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> LocalFileBackupPlugin_TakeBackup(String Title, String Description, boolean Sticky) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Title", Title);
        args.put("Description", Description);
        args.put("Sticky", Sticky);
        return this.APICall("LocalFileBackupPlugin/TakeBackup", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Before  AMPType: Nullable<DateTime>
     * @param Count Integer AMPType: Int32
     * @return Map<?, ?> AMPType: IEnumerable<IAuditLogEntry>
     */
    public Map<?, ?> Core_GetAuditLogEntries(Object Before, Integer Count) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Before", Before);
        args.put("Count", Count);
        return this.APICall("Core/GetAuditLogEntries", args);
    }

    /**
     * Name TypeName Description Optional
     * @return dict[str, list[dict]] AMPType: Dictionary<String, IEnumerable<JObject>>
     */
    public Map<?, ?> Core_GetSettingsSpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetSettingsSpec", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Node String AMPType: String
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Core_RefreshSettingValueList(String Node) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Node", Node);
        return this.APICall("Core/RefreshSettingValueList", args);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> Core_RefreshSettingsSourceCache() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/RefreshSettingsSourceCache", args);
    }

    /**
     * Name TypeName Description Optional
     * @param SettingNode String AMPType: String
     * @param WithRefresh boolean AMPType: Boolean
     * @return Map<String, String> AMPType: IDictionary<String, String>
     */
    public Map<?, ?> Core_GetSettingValues(String SettingNode, boolean WithRefresh) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("SettingNode", SettingNode);
        args.put("WithRefresh", WithRefresh);
        return this.APICall("Core/GetSettingValues", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<Map<?, ?>> AMPType: List<JObject>
     */
    public Map<?, ?> Core_GetProvisionSpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetProvisionSpec", args);
    }

    /**
     * Name TypeName Description Optional
     * @param node String AMPType: String
     * @return Map<?, ?> AMPType: JObject
     */
    public Map<?, ?> Core_GetConfig(String node) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("node", node);
        return this.APICall("Core/GetConfig", args);
    }

    /**
     * Name TypeName Description Optional
     * @param nodes List<String> AMPType: String[]
     * @return List<Map<?, ?>> AMPType: IEnumerable<JObject>
     */
    public Map<?, ?> Core_GetConfigs(List<String> nodes) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("nodes", nodes);
        return this.APICall("Core/GetConfigs", args);
    }

    /**
     * Name TypeName Description Optional
     * @param data Map<String, String> AMPType: Dictionary<String, String>
     * @return boolean AMPType: Boolean
     */
    public Map<?, ?> Core_SetConfigs(Map<String, String> data) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("data", data);
        return this.APICall("Core/SetConfigs", args);
    }

    /**
     * Name TypeName Description Optional
     * @param node String AMPType: String
     * @param value String AMPType: String
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Core_SetConfig(String node, String value) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("node", node);
        args.put("value", value);
        return this.APICall("Core/SetConfig", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: Task<IEnumerable<AuthRoleSummary>>
     */
    public Map<?, ?> Core_GetRoleData() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetRoleData", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: Task<IDictionary<Guid, String>>
     */
    public Map<?, ?> Core_GetRoleIds() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetRoleIds", args);
    }

    /**
     * Name TypeName Description Optional
     * @param RoleId String AMPType: Guid
     * @return  AMPType: Task<AuthRoleSummary>
     */
    public Map<?, ?> Core_GetRole(String RoleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        return this.APICall("Core/GetRole", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Name String AMPType: String
     * @param AsCommonRole boolean AMPType: Boolean
     * @return  AMPType: Task<ActionResult<Guid>>
     */
    public Map<?, ?> Core_CreateRole(String Name, boolean AsCommonRole) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        args.put("AsCommonRole", AsCommonRole);
        return this.APICall("Core/CreateRole", args);
    }

    /**
     * Name TypeName Description Optional
     * @param RoleId String AMPType: Guid
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> Core_DeleteRole(String RoleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        return this.APICall("Core/DeleteRole", args);
    }

    /**
     * Name TypeName Description Optional
     * @param RoleId String AMPType: Guid
     * @param NewName String AMPType: String
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> Core_RenameRole(String RoleId, String NewName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("NewName", NewName);
        return this.APICall("Core/RenameRole", args);
    }

    /**
     * Name TypeName Description Optional
     * @param RoleId String AMPType: Guid
     * @param PermissionNode String AMPType: String
     * @param Enabled boolean AMPType: Nullable<Boolean>
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> Core_SetAMPRolePermission(String RoleId, String PermissionNode, boolean Enabled) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("PermissionNode", PermissionNode);
        args.put("Enabled", Enabled);
        return this.APICall("Core/SetAMPRolePermission", args);
    }

    /**
     * Name TypeName Description Optional
     * @param RoleId String AMPType: Guid
     * @return  AMPType: Task<IEnumerable<String>>
     */
    public Map<?, ?> Core_GetAMPRolePermissions(String RoleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        return this.APICall("Core/GetAMPRolePermissions", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: ScheduleInfo
     */
    public Map<?, ?> Core_GetScheduleData() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetScheduleData", args);
    }

    /**
     * Name TypeName Description Optional
     * @param triggerId String AMPType: Guid
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Core_AddEventTrigger(String triggerId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        return this.APICall("Core/AddEventTrigger", args);
    }

    /**
     * Name TypeName Description Optional
     * @param triggerId String AMPType: Guid
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Core_RunEventTriggerImmediately(String triggerId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        return this.APICall("Core/RunEventTriggerImmediately", args);
    }

    /**
     * Name TypeName Description Optional
     * @param months List<Integer> AMPType: Int32[]
     * @param days List<Integer> AMPType: Int32[]
     * @param hours List<Integer> AMPType: Int32[]
     * @param minutes List<Integer> AMPType: Int32[]
     * @param daysOfMonth List<Integer> AMPType: Int32[]
     * @param description String AMPType: String
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Core_AddIntervalTrigger(List<Integer> months, List<Integer> days, List<Integer> hours, List<Integer> minutes, List<Integer> daysOfMonth, String description) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("months", months);
        args.put("days", days);
        args.put("hours", hours);
        args.put("minutes", minutes);
        args.put("daysOfMonth", daysOfMonth);
        args.put("description", description);
        return this.APICall("Core/AddIntervalTrigger", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Id String AMPType: Guid
     * @return  AMPType: TimeIntervalTrigger
     */
    public Map<?, ?> Core_GetTimeIntervalTrigger(String Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("Core/GetTimeIntervalTrigger", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Id String AMPType: Guid
     * @param months List<Integer> AMPType: Int32[]
     * @param days List<Integer> AMPType: Int32[]
     * @param hours List<Integer> AMPType: Int32[]
     * @param minutes List<Integer> AMPType: Int32[]
     * @param daysOfMonth List<Integer> AMPType: Int32[]
     * @param description String AMPType: String
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Core_EditIntervalTrigger(String Id, List<Integer> months, List<Integer> days, List<Integer> hours, List<Integer> minutes, List<Integer> daysOfMonth, String description) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("months", months);
        args.put("days", days);
        args.put("hours", hours);
        args.put("minutes", minutes);
        args.put("daysOfMonth", daysOfMonth);
        args.put("description", description);
        return this.APICall("Core/EditIntervalTrigger", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Id String AMPType: Guid
     * @param Enabled boolean AMPType: Boolean
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Core_SetTriggerEnabled(String Id, boolean Enabled) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("Enabled", Enabled);
        return this.APICall("Core/SetTriggerEnabled", args);
    }

    /**
     * Name TypeName Description Optional
     * @param TriggerID String AMPType: Guid
     * @param MethodID String AMPType: String
     * @param ParameterMapping Map<String, String> AMPType: Dictionary<String, String>
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Core_AddTask(String TriggerID, String MethodID, Map<String, String> ParameterMapping) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("MethodID", MethodID);
        args.put("ParameterMapping", ParameterMapping);
        return this.APICall("Core/AddTask", args);
    }

    /**
     * Name TypeName Description Optional
     * @param TriggerID String AMPType: Guid
     * @param TaskID String AMPType: Guid
     * @param ParameterMapping Map<String, String> AMPType: Dictionary<String, String>
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Core_EditTask(String TriggerID, String TaskID, Map<String, String> ParameterMapping) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        args.put("ParameterMapping", ParameterMapping);
        return this.APICall("Core/EditTask", args);
    }

    /**
     * Name TypeName Description Optional
     * @param TriggerID String AMPType: Guid
     * @param TaskID String AMPType: Guid
     * @param NewOrder Integer AMPType: Int32
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Core_ChangeTaskOrder(String TriggerID, String TaskID, Integer NewOrder) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        args.put("NewOrder", NewOrder);
        return this.APICall("Core/ChangeTaskOrder", args);
    }

    /**
     * Name TypeName Description Optional
     * @param TriggerID String AMPType: Guid
     * @param TaskID String AMPType: Guid
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Core_DeleteTask(String TriggerID, String TaskID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        return this.APICall("Core/DeleteTask", args);
    }

    /**
     * Name TypeName Description Optional
     * @param TriggerID String AMPType: Guid
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Core_DeleteTrigger(String TriggerID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        return this.APICall("Core/DeleteTrigger", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<?> AMPType: IEnumerable<WebSessionSummary>
     */
    public Map<?, ?> Core_GetActiveAMPSessions() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetActiveAMPSessions", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Id String AMPType: Guid
     * @return void AMPType: Void
     */
    public Map<?, ?> Core_EndUserSession(String Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("Core/EndUserSession", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: Task<IEnumerable<UserInfoSummary>>
     */
    public Map<?, ?> Core_GetAMPUsersSummary() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetAMPUsersSummary", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Username String AMPType: String
     * @return  AMPType: Task<UserInfo>
     */
    public Map<?, ?> Core_GetAMPUserInfo(String Username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        return this.APICall("Core/GetAMPUserInfo", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: Task<IEnumerable<UserInfo>>
     */
    public Map<?, ?> Core_GetAllAMPUserInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetAllAMPUserInfo", args);
    }

    /**
     * Name TypeName Description Optional
     * @param UserId String AMPType: Guid
     * @param RoleId String AMPType: Guid
     * @param IsMember boolean AMPType: Boolean
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> Core_SetAMPUserRoleMembership(String UserId, String RoleId, boolean IsMember) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UserId", UserId);
        args.put("RoleId", RoleId);
        args.put("IsMember", IsMember);
        return this.APICall("Core/SetAMPUserRoleMembership", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<?> AMPType: IList<IPermissionsTreeNode>
     */
    public Map<?, ?> Core_GetPermissionsSpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetPermissionsSpec", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Username String AMPType: String
     * @return  AMPType: Task<ActionResult<Guid>>
     */
    public Map<?, ?> Core_CreateUser(String Username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        return this.APICall("Core/CreateUser", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Username String AMPType: String
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> Core_DeleteUser(String Username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        return this.APICall("Core/DeleteUser", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Username String AMPType: String
     * @param Disabled boolean AMPType: Boolean
     * @param PasswordExpires boolean AMPType: Boolean
     * @param CannotChangePassword boolean AMPType: Boolean
     * @param MustChangePassword boolean AMPType: Boolean
     * @param EmailAddress String AMPType: String
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> Core_UpdateUserInfo(String Username, boolean Disabled, boolean PasswordExpires, boolean CannotChangePassword, boolean MustChangePassword, String EmailAddress) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("Disabled", Disabled);
        args.put("PasswordExpires", PasswordExpires);
        args.put("CannotChangePassword", CannotChangePassword);
        args.put("MustChangePassword", MustChangePassword);
        args.put("EmailAddress", EmailAddress);
        return this.APICall("Core/UpdateUserInfo", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: ActionResult<String>
     */
    public Map<?, ?> Core_GetWebauthnChallenge() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetWebauthnChallenge", args);
    }

    /**
     * Name TypeName Description Optional
     * @param username String AMPType: String
     * @return  AMPType: WebauthnLoginInfo
     */
    public Map<?, ?> Core_GetWebauthnCredentialIDs(String username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("username", username);
        return this.APICall("Core/GetWebauthnCredentialIDs", args);
    }

    /**
     * Name TypeName Description Optional
     * @param attestationObject String AMPType: String
     * @param clientDataJSON String AMPType: String
     * @param description String AMPType: String
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Core_WebauthnRegister(String attestationObject, String clientDataJSON, String description) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("attestationObject", attestationObject);
        args.put("clientDataJSON", clientDataJSON);
        args.put("description", description);
        return this.APICall("Core/WebauthnRegister", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<?> AMPType: IEnumerable<WebauthnCredentialSummary>
     */
    public Map<?, ?> Core_GetWebauthnCredentialSummaries() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetWebauthnCredentialSummaries", args);
    }

    /**
     * Name TypeName Description Optional
     * @param ID Integer AMPType: Int32
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Core_RevokeWebauthnCredential(Integer ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        return this.APICall("Core/RevokeWebauthnCredential", args);
    }

    /**
     * Name TypeName Description Optional
     * @param EmailAddress String AMPType: String
     * @param TwoFactorPIN String AMPType: String
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> Core_UpdateAccountInfo(String EmailAddress, String TwoFactorPIN) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("EmailAddress", EmailAddress);
        args.put("TwoFactorPIN", TwoFactorPIN);
        return this.APICall("Core/UpdateAccountInfo", args);
    }

    /**
     * Sets up two-factor authentication for the given user. ConfirmTwoFactorSetup must be invoked to complete setup.
     * Name TypeName Description Optional
     * @param Username String AMPType: String
     * @param Password String AMPType: String
     * @return  AMPType: Task<ActionResult<TwoFactorSetupInfo>>
     */
    public Map<?, ?> Core_EnableTwoFactor(String Username, String Password) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("Password", Password);
        return this.APICall("Core/EnableTwoFactor", args);
    }

    /**
     * Completes two-factor setup by supplying a valid two factor code based on the secret provided by EnableTwoFactor
     * Name TypeName Description Optional
     * @param Username String AMPType: String
     * @param TwoFactorCode String AMPType: String
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> Core_ConfirmTwoFactorSetup(String Username, String TwoFactorCode) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("TwoFactorCode", TwoFactorCode);
        return this.APICall("Core/ConfirmTwoFactorSetup", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Password String AMPType: String
     * @param TwoFactorCode String AMPType: String
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> Core_DisableTwoFactor(String Password, String TwoFactorCode) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Password", Password);
        args.put("TwoFactorCode", TwoFactorCode);
        return this.APICall("Core/DisableTwoFactor", args);
    }

    /**
     * For administrative users to alter the password of another user
     * Name TypeName Description Optional
     * @param Username String AMPType: String
     * @param NewPassword String AMPType: String
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> Core_ResetUserPassword(String Username, String NewPassword) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("NewPassword", NewPassword);
        return this.APICall("Core/ResetUserPassword", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceId String AMPType: Guid
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> Core_DeleteInstanceUsers(String InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("Core/DeleteInstanceUsers", args);
    }

    /**
     * For a user to change their own password, requires knowing the old password
     * Name TypeName Description Optional
     * @param Username String AMPType: String
     * @param OldPassword String AMPType: String
     * @param NewPassword String AMPType: String
     * @param TwoFactorPIN String AMPType: String
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> Core_ChangeUserPassword(String Username, String OldPassword, String NewPassword, String TwoFactorPIN) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("OldPassword", OldPassword);
        args.put("NewPassword", NewPassword);
        args.put("TwoFactorPIN", TwoFactorPIN);
        return this.APICall("Core/ChangeUserPassword", args);
    }

    /**
     * Gets changes to the server status, in addition to any notifications or console output that have occured since the last time GetUpdates() was called by the current session.
     * Name TypeName Description Optional
     * @return Map<?, ?> AMPType: JObject
     */
    public Map<?, ?> Core_GetUpdates() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetUpdates", args);
    }

    /**
     * Name TypeName Description Optional
     * @return String AMPType: Guid
     */
    public Map<?, ?> Core_GetNewGuid() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetNewGuid", args);
    }

    /**
     * Returns a list of in-application users
     * Name TypeName Description Optional
     * @return Map<String, String> AMPType: Dictionary<String, String>
     */
    public Map<?, ?> Core_GetUserList() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetUserList", args);
    }

    /**
     * Name TypeName Description Optional
     * @param PermissionNode String AMPType: String
     * @return boolean AMPType: Boolean
     */
    public Map<?, ?> Core_CurrentSessionHasPermission(String PermissionNode) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("PermissionNode", PermissionNode);
        return this.APICall("Core/CurrentSessionHasPermission", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: IEnumerable<RunningTask>
     */
    public Map<?, ?> Core_GetTasks() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetTasks", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<?> AMPType: IEnumerable<ListeningPortSummary>
     */
    public Map<?, ?> Core_GetPortSummaries() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetPortSummaries", args);
    }

    /**
     * Name TypeName Description Optional
     * @return Map<?, ?> AMPType: JObject
     */
    public Map<?, ?> Core_GetStatus() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetStatus", args);
    }

    /**
     * Name TypeName Description Optional
     * @param TaskId String AMPType: Guid
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Core_CancelTask(String TaskId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        return this.APICall("Core/CancelTask", args);
    }

    /**
     * Name TypeName Description Optional
     * @param TaskId String AMPType: Guid
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Core_DismissTask(String TaskId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        return this.APICall("Core/DismissTask", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Core_DismissAllTasks() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/DismissAllTasks", args);
    }

    /**
     * Provides information about a given in-application user (as opposed to AMP system users)
     * Name TypeName Description Optional
     * @param UID String AMPType: String
     * @return Map<?, ?> AMPType: JObject
     */
    public Map<?, ?> Core_GetUserInfo(String UID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UID", UID);
        return this.APICall("Core/GetUserInfo", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Core_Start() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Start", args);
    }

    /**
     * Prevents the current instance from being started, and stops it if it's currently running.
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> Core_Suspend() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Suspend", args);
    }

    /**
     * Allows the service to be re-started after previously being suspended.
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> Core_Resume() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Resume", args);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> Core_Stop() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Stop", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Core_Restart() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Restart", args);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> Core_Kill() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Kill", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Core_Sleep() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Sleep", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Core_UpdateApplication() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/UpdateApplication", args);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> Core_AcknowledgeAMPUpdate() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/AcknowledgeAMPUpdate", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: ModuleInfo
     */
    public Map<?, ?> Core_GetModuleInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetModuleInfo", args);
    }

    /**
     * Name TypeName Description Optional
     * @return Map<String, Map<String, Object>> AMPType: Dictionary<String, Dictionary<String, MethodInfoSummary>>
     */
    public Map<?, ?> Core_GetAPISpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetAPISpec", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: Object
     */
    public Map<?, ?> Core_GetUserActionsSpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetUserActionsSpec", args);
    }

    /**
     * Name TypeName Description Optional
     * @param username String AMPType: String
     * @param password String AMPType: String
     * @param token String AMPType: String
     * @param rememberMe boolean AMPType: Boolean
     * @return  AMPType: Task<JObject>
     */
    public Map<?, ?> Core_Login(String username, String password, String token, boolean rememberMe) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("username", username);
        args.put("password", password);
        args.put("token", token);
        args.put("rememberMe", rememberMe);
        return this.APICall("Core/Login", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Description String AMPType: String
     * @param IsTemporary boolean AMPType: Boolean
     * @return  AMPType: Task<String>
     */
    public Map<?, ?> Core_GetRemoteLoginToken(String Description, boolean IsTemporary) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Description", Description);
        args.put("IsTemporary", IsTemporary);
        return this.APICall("Core/GetRemoteLoginToken", args);
    }

    /**
     * Name TypeName Description Optional
     * @param message String AMPType: String
     * @return void AMPType: Void
     */
    public Map<?, ?> Core_SendConsoleMessage(String message) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("message", message);
        return this.APICall("Core/SendConsoleMessage", args);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> Core_UpdateAMPInstance() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/UpdateAMPInstance", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: UpdateInfo
     */
    public Map<?, ?> Core_GetUpdateInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetUpdateInfo", args);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> Core_Logout() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Logout", args);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> Core_RestartAMP() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/RestartAMP", args);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> Core_UpgradeAMP() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/UpgradeAMP", args);
    }

    /**
     * Name TypeName Description Optional
     * @return Map<String, String> AMPType: Dictionary<String, String>
     */
    public Map<?, ?> Core_GetDiagnosticsInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetDiagnosticsInfo", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: Object
     */
    public Map<?, ?> Core_GetWebserverMetrics() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetWebserverMetrics", args);
    }

    /**
     * DEV: Creates a non-ending task with 50% progress for testing purposes
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> Core_CreateTestTask() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/CreateTestTask", args);
    }

    /**
     * DEV: Async test method
     * Name TypeName Description Optional
     * @return  AMPType: Task<String>
     */
    public Map<?, ?> Core_AsyncTest() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/AsyncTest", args);
    }
}
