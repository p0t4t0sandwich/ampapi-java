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

            return gson.fromJson(br.readLine(), Map.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /** Name TypeName Description Optional
     * @param newDatastore InstanceDatastore  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> ADSModule_AddDatastore(Object newDatastore) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("newDatastore", newDatastore);
        return this.APICall("/ADSModule/AddDatastore", args);
    }

    /** Name TypeName Description Optional
     * @param id Int32  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> ADSModule_DeleteDatastore(Object id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return this.APICall("/ADSModule/DeleteDatastore", args);
    }

    /** Name TypeName Description Optional
     * @param updatedDatastore InstanceDatastore  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> ADSModule_UpdateDatastore(Object updatedDatastore) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("updatedDatastore", updatedDatastore);
        return this.APICall("/ADSModule/UpdateDatastore", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return IEnumerable<InstanceDatastore> False
     */
    public Map<?, ?> ADSModule_GetDatastores() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetDatastores", args);
    }

    /** Name TypeName Description Optional
     * @param datastoreId Int32  False
     *  ReturnTypeName IsComplexType
     * @return RunningTask False
     */
    public Map<?, ?> ADSModule_RequestDatastoreSizeCalculation(Object datastoreId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("datastoreId", datastoreId);
        return this.APICall("/ADSModule/RequestDatastoreSizeCalculation", args);
    }

    /** Name TypeName Description Optional
     * @param id Int32  False
     *  ReturnTypeName IsComplexType
     * @return InstanceDatastore False
     */
    public Map<?, ?> ADSModule_GetDatastore(Object id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return this.APICall("/ADSModule/GetDatastore", args);
    }

    /** Name TypeName Description Optional
     * @param id Int32  False
     *  ReturnTypeName IsComplexType
     * @return RunningTask False
     */
    public Map<?, ?> ADSModule_RepairDatastore(Object id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return this.APICall("/ADSModule/RepairDatastore", args);
    }

    /** Name TypeName Description Optional
     * @param datastoreId Int32  False
     *  ReturnTypeName IsComplexType
     * @return IEnumerable<JObject> True
     */
    public Map<?, ?> ADSModule_GetDatastoreInstances(Object datastoreId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("datastoreId", datastoreId);
        return this.APICall("/ADSModule/GetDatastoreInstances", args);
    }

    /** Name TypeName Description Optional
     * @param instanceId Guid  False
     * @param datastoreId Int32  False
     *  ReturnTypeName IsComplexType
     * @return Task<RunningTask> False
     */
    public Map<?, ?> ADSModule_MoveInstanceDatastore(Object instanceId, Object datastoreId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        args.put("datastoreId", datastoreId);
        return this.APICall("/ADSModule/MoveInstanceDatastore", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return IEnumerable<DeploymentTemplate> False
     */
    public Map<?, ?> ADSModule_GetDeploymentTemplates() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetDeploymentTemplates", args);
    }

    /** Name TypeName Description Optional
     * @param Name String  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> ADSModule_CreateDeploymentTemplate(Object Name) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        return this.APICall("/ADSModule/CreateDeploymentTemplate", args);
    }

    /** Name TypeName Description Optional
     * @param templateToUpdate DeploymentTemplate  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> ADSModule_UpdateDeploymentTemplate(Object templateToUpdate) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("templateToUpdate", templateToUpdate);
        return this.APICall("/ADSModule/UpdateDeploymentTemplate", args);
    }

    /** Name TypeName Description Optional
     * @param Id Int32  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> ADSModule_DeleteDeploymentTemplate(Object Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("/ADSModule/DeleteDeploymentTemplate", args);
    }

    /** Name TypeName Description Optional
     * @param Id Int32  False
     * @param NewName String  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> ADSModule_CloneTemplate(Object Id, Object NewName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("NewName", NewName);
        return this.APICall("/ADSModule/CloneTemplate", args);
    }

    /** Name TypeName Description Optional
     * @param InstanceID Guid  False
     * @param TemplateID Int32  False
     * @param NewFriendlyName String  True
     * @param Secret String  True
     * @param RestartIfPreviouslyRunning Boolean  True
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> ADSModule_ApplyTemplate(Object InstanceID, Object TemplateID, Object NewFriendlyName, Object Secret, Object RestartIfPreviouslyRunning) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceID", InstanceID);
        args.put("TemplateID", TemplateID);
        args.put("NewFriendlyName", NewFriendlyName);
        args.put("Secret", Secret);
        args.put("RestartIfPreviouslyRunning", RestartIfPreviouslyRunning);
        return this.APICall("/ADSModule/ApplyTemplate", args);
    }

    /** Name TypeName Description Optional
     * @param TemplateID Int32 The ID of the template to be deployed, as per the Template Management UI in AMP itself. False
     * @param NewUsername String If specified, AMP will create a new user with this name for this instance. Must be unique. If this user already exists, this will be ignored but the new instance will be assigned to this user. True
     * @param NewPassword String If 'NewUsername' is specified and the user doesn't already exist, the password that will be assigned to this user. True
     * @param NewEmail String If 'NewUsername' is specified and the user doesn't already exist, the email address that will be assigned to this user. True
     * @param RequiredTags List<String> If specified, AMP will only deploy this template to targets that have every single 'tag' specified in their target configuration. You can adjust this via the controller by clicking 'Edit' on the target settings. True
     * @param Tag String Unrelated to RequiredTags. This is to uniquely identify this instance to your own systems. It may be something like an order ID or service ID so you can find the associated instance again at a later time. If 'UseTagAsInstanceName' is enabled, then this will also be used as the instance name for the created instance - but it must be unique. True
     * @param FriendlyName String A friendly name for this instance. If left blank, AMP will generate one for you. True
     * @param Secret String Must be a non-empty strong in order to get a callback on deployment state change. This secret will be passed back to you in the callback so you can verify the request. True
     * @param PostCreate PostCreateActions 0: Do nothing, 10: Start instance only, 20: Start instance and update application, 30: Full application startup. True
     * @param ExtraProvisionSettings Dictionary<String, String> A dictionary of setting nodes and values to create the new instance with. Identical in function to the provisioning arguments in the template itself. True
     *  ReturnTypeName IsComplexType
     * @return RunningTask False
     */
    public Map<?, ?> ADSModule_DeployTemplate(Object TemplateID, Object NewUsername, Object NewPassword, Object NewEmail, Object RequiredTags, Object Tag, Object FriendlyName, Object Secret, Object PostCreate, Object ExtraProvisionSettings) {
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

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return RemoteTargetInfo False
     */
    public Map<?, ?> ADSModule_GetTargetInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetTargetInfo", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return IEnumerable<ApplicationSpec> False
     */
    public Map<?, ?> ADSModule_GetSupportedApplications() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetSupportedApplications", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Void False
     */
    public Map<?, ?> ADSModule_RefreshAppCache() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/RefreshAppCache", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Void False
     */
    public Map<?, ?> ADSModule_RefreshRemoteConfigStores() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/RefreshRemoteConfigStores", args);
    }

    /** Name TypeName Description Optional
     * @param instanceId Guid  False
     *  ReturnTypeName IsComplexType
     * @return IEnumerable<EndpointInfo> False
     */
    public Map<?, ?> ADSModule_GetApplicationEndpoints(Object instanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        return this.APICall("/ADSModule/GetApplicationEndpoints", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return RunningTask False
     */
    public Map<?, ?> ADSModule_ReactivateLocalInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/ReactivateLocalInstances", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return IEnumerable<IADSInstance> False
     */
    public Map<?, ?> ADSModule_GetInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetInstances", args);
    }

    /** Name TypeName Description Optional
     * @param InstanceId Guid  False
     *  ReturnTypeName IsComplexType
     * @return JObject True
     */
    public Map<?, ?> ADSModule_GetInstance(Object InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("/ADSModule/GetInstance", args);
    }

    /** Name TypeName Description Optional
     * @param instanceId Guid  False
     * @param PortNumber Int32  False
     * @param Range Int32  False
     * @param Protocol PortProtocol  False
     * @param Description String  False
     * @param Open Boolean  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> ADSModule_ModifyCustomFirewallRule(Object instanceId, Object PortNumber, Object Range, Object Protocol, Object Description, Object Open) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("instanceId", instanceId);
        args.put("PortNumber", PortNumber);
        args.put("Range", Range);
        args.put("Protocol", Protocol);
        args.put("Description", Description);
        args.put("Open", Open);
        return this.APICall("/ADSModule/ModifyCustomFirewallRule", args);
    }

    /** Name TypeName Description Optional
     * @param InstanceId Guid  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult<String> False
     */
    public Map<?, ?> ADSModule_ManageInstance(Object InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("/ADSModule/ManageInstance", args);
    }

    /** Name TypeName Description Optional
     * @param GroupId Guid  False
     *  ReturnTypeName IsComplexType
     * @return IADSInstance False
     */
    public Map<?, ?> ADSModule_GetGroup(Object GroupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("GroupId", GroupId);
        return this.APICall("/ADSModule/GetGroup", args);
    }

    /** Name TypeName Description Optional
     * @param GroupId Guid  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> ADSModule_RefreshGroup(Object GroupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("GroupId", GroupId);
        return this.APICall("/ADSModule/RefreshGroup", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return IEnumerable<JObject> True
     */
    public Map<?, ?> ADSModule_GetLocalInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetLocalInstances", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return IEnumerable<JObject> True
     */
    public Map<?, ?> ADSModule_GetInstanceStatuses() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetInstanceStatuses", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return JObject True
     */
    public Map<?, ?> ADSModule_GetProvisionFitness() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/GetProvisionFitness", args);
    }

    /** Name TypeName Description Optional
     * @param Friendly String  False
     * @param IsHTTPS Boolean  False
     * @param Host String  False
     * @param Port Int32  False
     * @param InstanceID Guid  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> ADSModule_AttachADS(Object Friendly, Object IsHTTPS, Object Host, Object Port, Object InstanceID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Friendly", Friendly);
        args.put("IsHTTPS", IsHTTPS);
        args.put("Host", Host);
        args.put("Port", Port);
        args.put("InstanceID", InstanceID);
        return this.APICall("/ADSModule/AttachADS", args);
    }

    /** Name TypeName Description Optional
     * @param Id Guid  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> ADSModule_DetatchTarget(Object Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("/ADSModule/DetatchTarget", args);
    }

    /** Name TypeName Description Optional
     * @param Id Guid  False
     * @param FriendlyName String  False
     * @param Url Uri  False
     * @param Description String  False
     * @param Tags List<String>  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> ADSModule_UpdateTargetInfo(Object Id, Object FriendlyName, Object Url, Object Description, Object Tags) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("FriendlyName", FriendlyName);
        args.put("Url", Url);
        args.put("Description", Description);
        args.put("Tags", Tags);
        return this.APICall("/ADSModule/UpdateTargetInfo", args);
    }

    /** Name TypeName Description Optional
     * @param InstanceName String  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> ADSModule_ConvertToManaged(Object InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("/ADSModule/ConvertToManaged", args);
    }

    /** Name TypeName Description Optional
     * @param InstanceName String  False
     *  ReturnTypeName IsComplexType
     * @return IEnumerable<PortUsage> False
     */
    public Map<?, ?> ADSModule_GetInstanceNetworkInfo(Object InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("/ADSModule/GetInstanceNetworkInfo", args);
    }

    /** Name TypeName Description Optional
     * @param InstanceId Guid  False
     * @param PortMappings Dictionary<String, Int32>  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> ADSModule_SetInstanceNetworkInfo(Object InstanceId, Object PortMappings) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        args.put("PortMappings", PortMappings);
        return this.APICall("/ADSModule/SetInstanceNetworkInfo", args);
    }

    /** Name TypeName Description Optional
     * @param InstanceID Guid  False
     * @param Args Dictionary<String, String>  False
     * @param RebuildConfiguration Boolean  True
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> ADSModule_ApplyInstanceConfiguration(Object InstanceID, Object Args, Object RebuildConfiguration) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceID", InstanceID);
        args.put("Args", Args);
        args.put("RebuildConfiguration", RebuildConfiguration);
        return this.APICall("/ADSModule/ApplyInstanceConfiguration", args);
    }

    /** Name TypeName Description Optional
     * @param Instance LocalAMPInstance  False
     * @param PostCreate PostCreateActions  True
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> ADSModule_CreateLocalInstance(Object Instance, Object PostCreate) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Instance", Instance);
        args.put("PostCreate", PostCreate);
        return this.APICall("/ADSModule/CreateLocalInstance", args);
    }

    /** Name TypeName Description Optional
     * @param TargetADSInstance Guid  False
     * @param NewInstanceId Guid  False
     * @param Module String  False
     * @param InstanceName String  False
     * @param FriendlyName String  False
     * @param IPBinding String  False
     * @param PortNumber Int32  False
     * @param AdminUsername String  False
     * @param AdminPassword String  False
     * @param ProvisionSettings Dictionary<String, String>  False
     * @param AutoConfigure Boolean When enabled, all settings other than the Module, Target and FriendlyName are ignored and replaced with automatically generated values. True
     * @param PostCreate PostCreateActions  True
     * @param StartOnBoot Boolean  True
     * @param DisplayImageSource String  True
     * @param TargetDatastore Int32  True
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> ADSModule_CreateInstance(Object TargetADSInstance, Object NewInstanceId, Object Module, Object InstanceName, Object FriendlyName, Object IPBinding, Object PortNumber, Object AdminUsername, Object AdminPassword, Object ProvisionSettings, Object AutoConfigure, Object PostCreate, Object StartOnBoot, Object DisplayImageSource, Object TargetDatastore) {
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

    /** Name TypeName Description Optional
     * @param InstanceName String  False
     * @param SettingNode String  False
     * @param Value String  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> ADSModule_SetInstanceConfig(Object InstanceName, Object SettingNode, Object Value) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        args.put("SettingNode", SettingNode);
        args.put("Value", Value);
        return this.APICall("/ADSModule/SetInstanceConfig", args);
    }

    /** Name TypeName Description Optional
     * @param InstanceId String  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> ADSModule_RefreshInstanceConfig(Object InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("/ADSModule/RefreshInstanceConfig", args);
    }

    /** Name TypeName Description Optional
     * @param ForModule String  False
     * @param SettingNode String  False
     * @param Values List<String>  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> ADSModule_HandoutInstanceConfigs(Object ForModule, Object SettingNode, Object Values) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ForModule", ForModule);
        args.put("SettingNode", SettingNode);
        args.put("Values", Values);
        return this.APICall("/ADSModule/HandoutInstanceConfigs", args);
    }

    /** Name TypeName Description Optional
     * @param ModuleName String  False
     *  ReturnTypeName IsComplexType
     * @return IEnumerable<JObject> True
     */
    public Map<?, ?> ADSModule_GetProvisionArguments(Object ModuleName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ModuleName", ModuleName);
        return this.APICall("/ADSModule/GetProvisionArguments", args);
    }

    /** Name TypeName Description Optional
     * @param url String  False
     * @param username String  False
     * @param password String  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> ADSModule_TestADSLoginDetails(Object url, Object username, Object password) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("url", url);
        args.put("username", username);
        args.put("password", password);
        return this.APICall("/ADSModule/TestADSLoginDetails", args);
    }

    /** Name TypeName Description Optional
     * @param controllerUrl String  False
     * @param myUrl String  False
     * @param username String  False
     * @param password String  False
     * @param twoFactorToken String  False
     * @param friendlyName String  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> ADSModule_RegisterTarget(Object controllerUrl, Object myUrl, Object username, Object password, Object twoFactorToken, Object friendlyName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("controllerUrl", controllerUrl);
        args.put("myUrl", myUrl);
        args.put("username", username);
        args.put("password", password);
        args.put("twoFactorToken", twoFactorToken);
        args.put("friendlyName", friendlyName);
        return this.APICall("/ADSModule/RegisterTarget", args);
    }

    /** Name TypeName Description Optional
     * @param TargetID Guid  False
     *  ReturnTypeName IsComplexType
     * @return Void False
     */
    public Map<?, ?> ADSModule_UpdateTarget(Object TargetID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TargetID", TargetID);
        return this.APICall("/ADSModule/UpdateTarget", args);
    }

    /** Name TypeName Description Optional
     * @param InstanceId String  False
     * @param FriendlyName String  False
     * @param Description String  False
     * @param StartOnBoot Boolean  False
     * @param Suspended Boolean  False
     * @param ExcludeFromFirewall Boolean  False
     * @param RunInContainer Boolean  False
     * @param ContainerMemory Int32  False
     * @param MemoryPolicy ContainerMemoryPolicy  False
     * @param ContainerMaxCPU Single  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> ADSModule_UpdateInstanceInfo(Object InstanceId, Object FriendlyName, Object Description, Object StartOnBoot, Object Suspended, Object ExcludeFromFirewall, Object RunInContainer, Object ContainerMemory, Object MemoryPolicy, Object ContainerMaxCPU) {
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

    /** Name TypeName Description Optional
     * @param InstanceName String  False
     * @param Suspended Boolean  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> ADSModule_SetInstanceSuspended(Object InstanceName, Object Suspended) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        args.put("Suspended", Suspended);
        return this.APICall("/ADSModule/SetInstanceSuspended", args);
    }

    /** Name TypeName Description Optional
     * @param InstanceName String  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> ADSModule_UpgradeInstance(Object InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("/ADSModule/UpgradeInstance", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> ADSModule_StartAllInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/StartAllInstances", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> ADSModule_StopAllInstances() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/ADSModule/StopAllInstances", args);
    }

    /** Name TypeName Description Optional
     * @param RestartRunning Boolean  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> ADSModule_UpgradeAllInstances(Object RestartRunning) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RestartRunning", RestartRunning);
        return this.APICall("/ADSModule/UpgradeAllInstances", args);
    }

    /** Name TypeName Description Optional
     * @param InstanceName String  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> ADSModule_StartInstance(Object InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("/ADSModule/StartInstance", args);
    }

    /** Name TypeName Description Optional
     * @param InstanceName String  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> ADSModule_RestartInstance(Object InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("/ADSModule/RestartInstance", args);
    }

    /** Name TypeName Description Optional
     * @param InstanceName String  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> ADSModule_StopInstance(Object InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("/ADSModule/StopInstance", args);
    }

    /** Name TypeName Description Optional
     * @param InstanceId Guid  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> ADSModule_DeleteInstanceUsers(Object InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("/ADSModule/DeleteInstanceUsers", args);
    }

    /** Name TypeName Description Optional
     * @param InstanceName String  False
     *  ReturnTypeName IsComplexType
     * @return RunningTask False
     */
    public Map<?, ?> ADSModule_DeleteInstance(Object InstanceName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceName", InstanceName);
        return this.APICall("/ADSModule/DeleteInstance", args);
    }

    /** Name TypeName Description Optional
     * @param SourceArchive String  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> ADSModule_ExtractEverywhere(Object SourceArchive) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("SourceArchive", SourceArchive);
        return this.APICall("/ADSModule/ExtractEverywhere", args);
    }

    /** Name TypeName Description Optional
     * @param id String  False
     * @param REQ_RAWJSON String  False
     *  ReturnTypeName IsComplexType
     * @return Task<JObject> True
     */
    public Map<?, ?> ADSModule_Servers(Object id, Object REQ_RAWJSON) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        args.put("REQ_RAWJSON", REQ_RAWJSON);
        return this.APICall("/ADSModule/Servers", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Void False
     */
    public Map<?, ?> FileManagerPlugin_Dummy() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/FileManagerPlugin/Dummy", args);
    }

    /** Name TypeName Description Optional
     * @param FilePath String  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult<String> False
     */
    public Map<?, ?> FileManagerPlugin_CalculateFileMD5Sum(Object FilePath) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("FilePath", FilePath);
        return this.APICall("/FileManagerPlugin/CalculateFileMD5Sum", args);
    }

    /** Name TypeName Description Optional
     * @param ModifyPath String  False
     * @param AsDirectory Boolean  False
     * @param Exclude Boolean  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> FileManagerPlugin_ChangeExclusion(Object ModifyPath, Object AsDirectory, Object Exclude) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ModifyPath", ModifyPath);
        args.put("AsDirectory", AsDirectory);
        args.put("Exclude", Exclude);
        return this.APICall("/FileManagerPlugin/ChangeExclusion", args);
    }

    /** Name TypeName Description Optional
     * @param PathToArchive String  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> FileManagerPlugin_CreateArchive(Object PathToArchive) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("PathToArchive", PathToArchive);
        return this.APICall("/FileManagerPlugin/CreateArchive", args);
    }

    /** Name TypeName Description Optional
     * @param ArchivePath String  False
     * @param DestinationPath String  True
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> FileManagerPlugin_ExtractArchive(Object ArchivePath, Object DestinationPath) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ArchivePath", ArchivePath);
        args.put("DestinationPath", DestinationPath);
        return this.APICall("/FileManagerPlugin/ExtractArchive", args);
    }

    /** Name TypeName Description Optional
     * @param Dir String  False
     *  ReturnTypeName IsComplexType
     * @return IEnumerable<JObject> True
     */
    public Map<?, ?> FileManagerPlugin_GetDirectoryListing(Object Dir) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Dir", Dir);
        return this.APICall("/FileManagerPlugin/GetDirectoryListing", args);
    }

    /** Name TypeName Description Optional
     * @param Filename String  False
     * @param Position Int64  False
     * @param Length Int32  False
     *  ReturnTypeName IsComplexType
     * @return FileChunkData False
     */
    public Map<?, ?> FileManagerPlugin_GetFileChunk(Object Filename, Object Position, Object Length) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Position", Position);
        args.put("Length", Length);
        return this.APICall("/FileManagerPlugin/GetFileChunk", args);
    }

    /** Name TypeName Description Optional
     * @param Filename String  False
     * @param Data String  False
     * @param Delete Boolean  False
     *  ReturnTypeName IsComplexType
     * @return Void False
     */
    public Map<?, ?> FileManagerPlugin_AppendFileChunk(Object Filename, Object Data, Object Delete) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Data", Data);
        args.put("Delete", Delete);
        return this.APICall("/FileManagerPlugin/AppendFileChunk", args);
    }

    /** Name TypeName Description Optional
     * @param Filename String  False
     * @param Position Int64  False
     * @param Data String  False
     *  ReturnTypeName IsComplexType
     * @return Void False
     */
    public Map<?, ?> FileManagerPlugin_WriteFileChunk(Object Filename, Object Position, Object Data) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("Position", Position);
        args.put("Data", Data);
        return this.APICall("/FileManagerPlugin/WriteFileChunk", args);
    }

    /** Name TypeName Description Optional
     * @param Source Uri  False
     * @param TargetDirectory String  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> FileManagerPlugin_DownloadFileFromURL(Object Source, Object TargetDirectory) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Source", Source);
        args.put("TargetDirectory", TargetDirectory);
        return this.APICall("/FileManagerPlugin/DownloadFileFromURL", args);
    }

    /** Name TypeName Description Optional
     * @param Filename String  False
     * @param NewFilename String  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> FileManagerPlugin_RenameFile(Object Filename, Object NewFilename) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        args.put("NewFilename", NewFilename);
        return this.APICall("/FileManagerPlugin/RenameFile", args);
    }

    /** Name TypeName Description Optional
     * @param Origin String  False
     * @param TargetDirectory String  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> FileManagerPlugin_CopyFile(Object Origin, Object TargetDirectory) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Origin", Origin);
        args.put("TargetDirectory", TargetDirectory);
        return this.APICall("/FileManagerPlugin/CopyFile", args);
    }

    /** Name TypeName Description Optional
     * @param Filename String  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> FileManagerPlugin_TrashFile(Object Filename) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Filename", Filename);
        return this.APICall("/FileManagerPlugin/TrashFile", args);
    }

    /** Name TypeName Description Optional
     * @param DirectoryName String  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> FileManagerPlugin_TrashDirectory(Object DirectoryName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("DirectoryName", DirectoryName);
        return this.APICall("/FileManagerPlugin/TrashDirectory", args);
    }

    /** Name TypeName Description Optional
     * @param TrashDirectoryName String  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> FileManagerPlugin_EmptyTrash(Object TrashDirectoryName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TrashDirectoryName", TrashDirectoryName);
        return this.APICall("/FileManagerPlugin/EmptyTrash", args);
    }

    /** Name TypeName Description Optional
     * @param NewPath String  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> FileManagerPlugin_CreateDirectory(Object NewPath) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("NewPath", NewPath);
        return this.APICall("/FileManagerPlugin/CreateDirectory", args);
    }

    /** Name TypeName Description Optional
     * @param oldDirectory String The full path to the old directory False
     * @param NewDirectoryName String The name component of the new directory (not the full path) False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> FileManagerPlugin_RenameDirectory(Object oldDirectory, Object NewDirectoryName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("oldDirectory", oldDirectory);
        args.put("NewDirectoryName", NewDirectoryName);
        return this.APICall("/FileManagerPlugin/RenameDirectory", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> EmailSenderPlugin_TestSMTPSettings() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/EmailSenderPlugin/TestSMTPSettings", args);
    }

    /** Name TypeName Description Optional
     * @param BackupId Guid  False
     *  ReturnTypeName IsComplexType
     * @return RunningTask False
     */
    public Map<?, ?> LocalFileBackupPlugin_UploadToS3(Object BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("/LocalFileBackupPlugin/UploadToS3", args);
    }

    /** Name TypeName Description Optional
     * @param BackupId Guid  False
     *  ReturnTypeName IsComplexType
     * @return RunningTask False
     */
    public Map<?, ?> LocalFileBackupPlugin_DownloadFromS3(Object BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("/LocalFileBackupPlugin/DownloadFromS3", args);
    }

    /** Name TypeName Description Optional
     * @param BackupId Guid  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> LocalFileBackupPlugin_DeleteFromS3(Object BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("/LocalFileBackupPlugin/DeleteFromS3", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return IEnumerable<BackupManifest> False
     */
    public Map<?, ?> LocalFileBackupPlugin_GetBackups() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/LocalFileBackupPlugin/GetBackups", args);
    }

    /** Name TypeName Description Optional
     * @param BackupId Guid  False
     * @param DeleteExistingData Boolean  True
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> LocalFileBackupPlugin_RestoreBackup(Object BackupId, Object DeleteExistingData) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        args.put("DeleteExistingData", DeleteExistingData);
        return this.APICall("/LocalFileBackupPlugin/RestoreBackup", args);
    }

    /** Name TypeName Description Optional
     * @param BackupId Guid  False
     *  ReturnTypeName IsComplexType
     * @return Void False
     */
    public Map<?, ?> LocalFileBackupPlugin_DeleteLocalBackup(Object BackupId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        return this.APICall("/LocalFileBackupPlugin/DeleteLocalBackup", args);
    }

    /** Name TypeName Description Optional
     * @param BackupId Guid  False
     * @param Sticky Boolean  False
     *  ReturnTypeName IsComplexType
     * @return Void False
     */
    public Map<?, ?> LocalFileBackupPlugin_SetBackupSticky(Object BackupId, Object Sticky) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("BackupId", BackupId);
        args.put("Sticky", Sticky);
        return this.APICall("/LocalFileBackupPlugin/SetBackupSticky", args);
    }

    /** Name TypeName Description Optional
     * @param Title String  False
     * @param Description String  False
     * @param Sticky Boolean  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> LocalFileBackupPlugin_TakeBackup(Object Title, Object Description, Object Sticky) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Title", Title);
        args.put("Description", Description);
        args.put("Sticky", Sticky);
        return this.APICall("/LocalFileBackupPlugin/TakeBackup", args);
    }

    /** Name TypeName Description Optional
     * @param Before Nullable<DateTime>  False
     * @param Count Int32  False
     *  ReturnTypeName IsComplexType
     * @return IEnumerable<IAuditLogEntry> False
     */
    public Map<?, ?> Core_GetAuditLogEntries(Object Before, Object Count) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Before", Before);
        args.put("Count", Count);
        return this.APICall("/Core/GetAuditLogEntries", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Dictionary<String, IEnumerable<JObject>> True
     */
    public Map<?, ?> Core_GetSettingsSpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetSettingsSpec", args);
    }

    /** Name TypeName Description Optional
     * @param Node String  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> Core_RefreshSettingValueList(Object Node) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Node", Node);
        return this.APICall("/Core/RefreshSettingValueList", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Void False
     */
    public Map<?, ?> Core_RefreshSettingsSourceCache() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/RefreshSettingsSourceCache", args);
    }

    /** Name TypeName Description Optional
     * @param SettingNode String  False
     * @param WithRefresh Boolean  True
     *  ReturnTypeName IsComplexType
     * @return IDictionary<String, String> False
     */
    public Map<?, ?> Core_GetSettingValues(Object SettingNode, Object WithRefresh) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("SettingNode", SettingNode);
        args.put("WithRefresh", WithRefresh);
        return this.APICall("/Core/GetSettingValues", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return List<JObject> True
     */
    public Map<?, ?> Core_GetProvisionSpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetProvisionSpec", args);
    }

    /** Name TypeName Description Optional
     * @param node String  False
     *  ReturnTypeName IsComplexType
     * @return JObject True
     */
    public Map<?, ?> Core_GetConfig(Object node) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("node", node);
        return this.APICall("/Core/GetConfig", args);
    }

    /** Name TypeName Description Optional
     * @param nodes String[]  False
     *  ReturnTypeName IsComplexType
     * @return IEnumerable<JObject> True
     */
    public Map<?, ?> Core_GetConfigs(Object nodes) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("nodes", nodes);
        return this.APICall("/Core/GetConfigs", args);
    }

    /** Name TypeName Description Optional
     * @param data Dictionary<String, String>  False
     *  ReturnTypeName IsComplexType
     * @return Boolean False
     */
    public Map<?, ?> Core_SetConfigs(Object data) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("data", data);
        return this.APICall("/Core/SetConfigs", args);
    }

    /** Name TypeName Description Optional
     * @param node String  False
     * @param value String  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> Core_SetConfig(Object node, Object value) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("node", node);
        args.put("value", value);
        return this.APICall("/Core/SetConfig", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Task<IEnumerable<AuthRoleSummary>> False
     */
    public Map<?, ?> Core_GetRoleData() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetRoleData", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Task<IDictionary<Guid, String>> False
     */
    public Map<?, ?> Core_GetRoleIds() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetRoleIds", args);
    }

    /** Name TypeName Description Optional
     * @param RoleId Guid  False
     *  ReturnTypeName IsComplexType
     * @return Task<AuthRoleSummary> False
     */
    public Map<?, ?> Core_GetRole(Object RoleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        return this.APICall("/Core/GetRole", args);
    }

    /** Name TypeName Description Optional
     * @param Name String  False
     * @param AsCommonRole Boolean  True
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult<Guid>> False
     */
    public Map<?, ?> Core_CreateRole(Object Name, Object AsCommonRole) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        args.put("AsCommonRole", AsCommonRole);
        return this.APICall("/Core/CreateRole", args);
    }

    /** Name TypeName Description Optional
     * @param RoleId Guid  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> Core_DeleteRole(Object RoleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        return this.APICall("/Core/DeleteRole", args);
    }

    /** Name TypeName Description Optional
     * @param RoleId Guid  False
     * @param NewName String  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> Core_RenameRole(Object RoleId, Object NewName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("NewName", NewName);
        return this.APICall("/Core/RenameRole", args);
    }

    /** Name TypeName Description Optional
     * @param RoleId Guid  False
     * @param PermissionNode String  False
     * @param Enabled Nullable<Boolean>  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> Core_SetAMPRolePermission(Object RoleId, Object PermissionNode, Object Enabled) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("PermissionNode", PermissionNode);
        args.put("Enabled", Enabled);
        return this.APICall("/Core/SetAMPRolePermission", args);
    }

    /** Name TypeName Description Optional
     * @param RoleId Guid  False
     *  ReturnTypeName IsComplexType
     * @return Task<IEnumerable<String>> False
     */
    public Map<?, ?> Core_GetAMPRolePermissions(Object RoleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        return this.APICall("/Core/GetAMPRolePermissions", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return ScheduleInfo False
     */
    public Map<?, ?> Core_GetScheduleData() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetScheduleData", args);
    }

    /** Name TypeName Description Optional
     * @param triggerId Guid  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> Core_AddEventTrigger(Object triggerId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        return this.APICall("/Core/AddEventTrigger", args);
    }

    /** Name TypeName Description Optional
     * @param triggerId Guid  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> Core_RunEventTriggerImmediately(Object triggerId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        return this.APICall("/Core/RunEventTriggerImmediately", args);
    }

    /** Name TypeName Description Optional
     * @param months Int32[]  False
     * @param days Int32[]  False
     * @param hours Int32[]  False
     * @param minutes Int32[]  False
     * @param daysOfMonth Int32[]  False
     * @param description String  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> Core_AddIntervalTrigger(Object months, Object days, Object hours, Object minutes, Object daysOfMonth, Object description) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("months", months);
        args.put("days", days);
        args.put("hours", hours);
        args.put("minutes", minutes);
        args.put("daysOfMonth", daysOfMonth);
        args.put("description", description);
        return this.APICall("/Core/AddIntervalTrigger", args);
    }

    /** Name TypeName Description Optional
     * @param Id Guid  False
     *  ReturnTypeName IsComplexType
     * @return TimeIntervalTrigger False
     */
    public Map<?, ?> Core_GetTimeIntervalTrigger(Object Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("/Core/GetTimeIntervalTrigger", args);
    }

    /** Name TypeName Description Optional
     * @param Id Guid  False
     * @param months Int32[]  False
     * @param days Int32[]  False
     * @param hours Int32[]  False
     * @param minutes Int32[]  False
     * @param daysOfMonth Int32[]  False
     * @param description String  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> Core_EditIntervalTrigger(Object Id, Object months, Object days, Object hours, Object minutes, Object daysOfMonth, Object description) {
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

    /** Name TypeName Description Optional
     * @param Id Guid  False
     * @param Enabled Boolean  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> Core_SetTriggerEnabled(Object Id, Object Enabled) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("Enabled", Enabled);
        return this.APICall("/Core/SetTriggerEnabled", args);
    }

    /** Name TypeName Description Optional
     * @param TriggerID Guid  False
     * @param MethodID String  False
     * @param ParameterMapping Dictionary<String, String>  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> Core_AddTask(Object TriggerID, Object MethodID, Object ParameterMapping) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("MethodID", MethodID);
        args.put("ParameterMapping", ParameterMapping);
        return this.APICall("/Core/AddTask", args);
    }

    /** Name TypeName Description Optional
     * @param TriggerID Guid  False
     * @param TaskID Guid  False
     * @param ParameterMapping Dictionary<String, String>  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> Core_EditTask(Object TriggerID, Object TaskID, Object ParameterMapping) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        args.put("ParameterMapping", ParameterMapping);
        return this.APICall("/Core/EditTask", args);
    }

    /** Name TypeName Description Optional
     * @param TriggerID Guid  False
     * @param TaskID Guid  False
     * @param NewOrder Int32  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> Core_ChangeTaskOrder(Object TriggerID, Object TaskID, Object NewOrder) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        args.put("NewOrder", NewOrder);
        return this.APICall("/Core/ChangeTaskOrder", args);
    }

    /** Name TypeName Description Optional
     * @param TriggerID Guid  False
     * @param TaskID Guid  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> Core_DeleteTask(Object TriggerID, Object TaskID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        return this.APICall("/Core/DeleteTask", args);
    }

    /** Name TypeName Description Optional
     * @param TriggerID Guid  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> Core_DeleteTrigger(Object TriggerID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        return this.APICall("/Core/DeleteTrigger", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return IEnumerable<WebSessionSummary> False
     */
    public Map<?, ?> Core_GetActiveAMPSessions() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetActiveAMPSessions", args);
    }

    /** Name TypeName Description Optional
     * @param Id Guid  False
     *  ReturnTypeName IsComplexType
     * @return Void False
     */
    public Map<?, ?> Core_EndUserSession(Object Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("/Core/EndUserSession", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Task<IEnumerable<UserInfoSummary>> False
     */
    public Map<?, ?> Core_GetAMPUsersSummary() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetAMPUsersSummary", args);
    }

    /** Name TypeName Description Optional
     * @param Username String  False
     *  ReturnTypeName IsComplexType
     * @return Task<UserInfo> False
     */
    public Map<?, ?> Core_GetAMPUserInfo(Object Username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        return this.APICall("/Core/GetAMPUserInfo", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Task<IEnumerable<UserInfo>> False
     */
    public Map<?, ?> Core_GetAllAMPUserInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetAllAMPUserInfo", args);
    }

    /** Name TypeName Description Optional
     * @param UserId Guid  False
     * @param RoleId Guid  False
     * @param IsMember Boolean  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> Core_SetAMPUserRoleMembership(Object UserId, Object RoleId, Object IsMember) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UserId", UserId);
        args.put("RoleId", RoleId);
        args.put("IsMember", IsMember);
        return this.APICall("/Core/SetAMPUserRoleMembership", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return IList<IPermissionsTreeNode> False
     */
    public Map<?, ?> Core_GetPermissionsSpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetPermissionsSpec", args);
    }

    /** Name TypeName Description Optional
     * @param Username String  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult<Guid>> False
     */
    public Map<?, ?> Core_CreateUser(Object Username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        return this.APICall("/Core/CreateUser", args);
    }

    /** Name TypeName Description Optional
     * @param Username String  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> Core_DeleteUser(Object Username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        return this.APICall("/Core/DeleteUser", args);
    }

    /** Name TypeName Description Optional
     * @param Username String  False
     * @param Disabled Boolean  False
     * @param PasswordExpires Boolean  False
     * @param CannotChangePassword Boolean  False
     * @param MustChangePassword Boolean  False
     * @param EmailAddress String  True
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> Core_UpdateUserInfo(Object Username, Object Disabled, Object PasswordExpires, Object CannotChangePassword, Object MustChangePassword, Object EmailAddress) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("Disabled", Disabled);
        args.put("PasswordExpires", PasswordExpires);
        args.put("CannotChangePassword", CannotChangePassword);
        args.put("MustChangePassword", MustChangePassword);
        args.put("EmailAddress", EmailAddress);
        return this.APICall("/Core/UpdateUserInfo", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return ActionResult<String> False
     */
    public Map<?, ?> Core_GetWebauthnChallenge() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetWebauthnChallenge", args);
    }

    /** Name TypeName Description Optional
     * @param username String  False
     *  ReturnTypeName IsComplexType
     * @return WebauthnLoginInfo False
     */
    public Map<?, ?> Core_GetWebauthnCredentialIDs(Object username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("username", username);
        return this.APICall("/Core/GetWebauthnCredentialIDs", args);
    }

    /** Name TypeName Description Optional
     * @param attestationObject String  False
     * @param clientDataJSON String  False
     * @param description String  True
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> Core_WebauthnRegister(Object attestationObject, Object clientDataJSON, Object description) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("attestationObject", attestationObject);
        args.put("clientDataJSON", clientDataJSON);
        args.put("description", description);
        return this.APICall("/Core/WebauthnRegister", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return IEnumerable<WebauthnCredentialSummary> False
     */
    public Map<?, ?> Core_GetWebauthnCredentialSummaries() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetWebauthnCredentialSummaries", args);
    }

    /** Name TypeName Description Optional
     * @param ID Int32  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> Core_RevokeWebauthnCredential(Object ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        return this.APICall("/Core/RevokeWebauthnCredential", args);
    }

    /** Name TypeName Description Optional
     * @param EmailAddress String  False
     * @param TwoFactorPIN String  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> Core_UpdateAccountInfo(Object EmailAddress, Object TwoFactorPIN) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("EmailAddress", EmailAddress);
        args.put("TwoFactorPIN", TwoFactorPIN);
        return this.APICall("/Core/UpdateAccountInfo", args);
    }

    /** Name TypeName Description Optional
     * @param Username String  False
     * @param Password String  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult<TwoFactorSetupInfo>> False
     */
    public Map<?, ?> Core_EnableTwoFactor(Object Username, Object Password) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("Password", Password);
        return this.APICall("/Core/EnableTwoFactor", args);
    }

    /** Name TypeName Description Optional
     * @param Username String  False
     * @param TwoFactorCode String  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> Core_ConfirmTwoFactorSetup(Object Username, Object TwoFactorCode) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("TwoFactorCode", TwoFactorCode);
        return this.APICall("/Core/ConfirmTwoFactorSetup", args);
    }

    /** Name TypeName Description Optional
     * @param Password String  False
     * @param TwoFactorCode String  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> Core_DisableTwoFactor(Object Password, Object TwoFactorCode) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Password", Password);
        args.put("TwoFactorCode", TwoFactorCode);
        return this.APICall("/Core/DisableTwoFactor", args);
    }

    /** Name TypeName Description Optional
     * @param Username String  False
     * @param NewPassword String  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> Core_ResetUserPassword(Object Username, Object NewPassword) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("NewPassword", NewPassword);
        return this.APICall("/Core/ResetUserPassword", args);
    }

    /** Name TypeName Description Optional
     * @param InstanceId Guid  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> Core_DeleteInstanceUsers(Object InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("/Core/DeleteInstanceUsers", args);
    }

    /** Name TypeName Description Optional
     * @param Username String  False
     * @param OldPassword String  False
     * @param NewPassword String  False
     * @param TwoFactorPIN String  False
     *  ReturnTypeName IsComplexType
     * @return Task<ActionResult> False
     */
    public Map<?, ?> Core_ChangeUserPassword(Object Username, Object OldPassword, Object NewPassword, Object TwoFactorPIN) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("OldPassword", OldPassword);
        args.put("NewPassword", NewPassword);
        args.put("TwoFactorPIN", TwoFactorPIN);
        return this.APICall("/Core/ChangeUserPassword", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return JObject True
     */
    public Map<?, ?> Core_GetUpdates() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetUpdates", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Guid False
     */
    public Map<?, ?> Core_GetNewGuid() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetNewGuid", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Dictionary<String, String> False
     */
    public Map<?, ?> Core_GetUserList() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetUserList", args);
    }

    /** Name TypeName Description Optional
     * @param PermissionNode String  False
     *  ReturnTypeName IsComplexType
     * @return Boolean False
     */
    public Map<?, ?> Core_CurrentSessionHasPermission(Object PermissionNode) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("PermissionNode", PermissionNode);
        return this.APICall("/Core/CurrentSessionHasPermission", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return IEnumerable<RunningTask> False
     */
    public Map<?, ?> Core_GetTasks() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetTasks", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return JObject True
     */
    public Map<?, ?> Core_GetStatus() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetStatus", args);
    }

    /** Name TypeName Description Optional
     * @param TaskId Guid  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> Core_CancelTask(Object TaskId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        return this.APICall("/Core/CancelTask", args);
    }

    /** Name TypeName Description Optional
     * @param TaskId Guid  False
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> Core_DismissTask(Object TaskId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        return this.APICall("/Core/DismissTask", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> Core_DismissAllTasks() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/DismissAllTasks", args);
    }

    /** Name TypeName Description Optional
     * @param UID String  False
     *  ReturnTypeName IsComplexType
     * @return JObject True
     */
    public Map<?, ?> Core_GetUserInfo(Object UID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UID", UID);
        return this.APICall("/Core/GetUserInfo", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> Core_Start() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Start", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Void False
     */
    public Map<?, ?> Core_Suspend() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Suspend", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Void False
     */
    public Map<?, ?> Core_Resume() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Resume", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Void False
     */
    public Map<?, ?> Core_Stop() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Stop", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> Core_Restart() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Restart", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Void False
     */
    public Map<?, ?> Core_Kill() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Kill", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> Core_Sleep() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Sleep", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return ActionResult False
     */
    public Map<?, ?> Core_UpdateApplication() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/UpdateApplication", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Void False
     */
    public Map<?, ?> Core_AcknowledgeAMPUpdate() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/AcknowledgeAMPUpdate", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return ModuleInfo False
     */
    public Map<?, ?> Core_GetModuleInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetModuleInfo", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Dictionary<String, Dictionary<String, MethodInfoSummary>> False
     */
    public Map<?, ?> Core_GetAPISpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetAPISpec", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Object False
     */
    public Map<?, ?> Core_GetUserActionsSpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetUserActionsSpec", args);
    }

    /** Name TypeName Description Optional
     * @param username String  False
     * @param password String  False
     * @param token String  False
     * @param rememberMe Boolean  False
     *  ReturnTypeName IsComplexType
     * @return Task<JObject> True
     */
    public Map<?, ?> Core_Login(Object username, Object password, Object token, Object rememberMe) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("username", username);
        args.put("password", password);
        args.put("token", token);
        args.put("rememberMe", rememberMe);
        return this.APICall("/Core/Login", args);
    }

    /** Name TypeName Description Optional
     * @param Description String  True
     * @param IsTemporary Boolean  True
     *  ReturnTypeName IsComplexType
     * @return Task<String> False
     */
    public Map<?, ?> Core_GetRemoteLoginToken(Object Description, Object IsTemporary) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Description", Description);
        args.put("IsTemporary", IsTemporary);
        return this.APICall("/Core/GetRemoteLoginToken", args);
    }

    /** Name TypeName Description Optional
     * @param message String  False
     *  ReturnTypeName IsComplexType
     * @return Void False
     */
    public Map<?, ?> Core_SendConsoleMessage(Object message) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("message", message);
        return this.APICall("/Core/SendConsoleMessage", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Void False
     */
    public Map<?, ?> Core_UpdateAMPInstance() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/UpdateAMPInstance", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return UpdateInfo False
     */
    public Map<?, ?> Core_GetUpdateInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetUpdateInfo", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Void False
     */
    public Map<?, ?> Core_Logout() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/Logout", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Void False
     */
    public Map<?, ?> Core_RestartAMP() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/RestartAMP", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Void False
     */
    public Map<?, ?> Core_UpgradeAMP() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/UpgradeAMP", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Dictionary<String, String> False
     */
    public Map<?, ?> Core_GetDiagnosticsInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/GetDiagnosticsInfo", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Void False
     */
    public Map<?, ?> Core_CreateTestTask() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/CreateTestTask", args);
    }

    /** Name TypeName Description Optional
     *  ReturnTypeName IsComplexType
     * @return Task<String> False
     */
    public Map<?, ?> Core_AsyncTest() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("/Core/AsyncTest", args);
    }
}
