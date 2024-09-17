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

public class Core extends AMPAPI {
    public Core(AuthStore authStore, String instanceName) {
        super(authStore, instanceName);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Void
     */
    public Void AcknowledgeAMPUpdate() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param LicenceKey  False
     * @param QueryOnly  True
     * @return ActionResult<LicenceInfo>
     */
    public ActionResult<LicenceInfo> ActivateAMPLicence(String LicenceKey, Boolean QueryOnly) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("LicenceKey", LicenceKey);
        args.put("QueryOnly", QueryOnly);
        Type type = new TypeToken<ActionResult<LicenceInfo>>(){}.getType();
        return (ActionResult<LicenceInfo>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param triggerId  False
     * @return ActionResult
     */
    public ActionResult AddEventTrigger(UUID triggerId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param months  False
     * @param days  False
     * @param hours  False
     * @param minutes  False
     * @param daysOfMonth  False
     * @param description  False
     * @return ActionResult
     */
    public ActionResult AddIntervalTrigger(List<Integer> months, List<Integer> days, List<Integer> hours, List<Integer> minutes, List<Integer> daysOfMonth, String description) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("months", months);
        args.put("days", days);
        args.put("hours", hours);
        args.put("minutes", minutes);
        args.put("daysOfMonth", daysOfMonth);
        args.put("description", description);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param TriggerID  False
     * @param MethodID  False
     * @param ParameterMapping  False
     * @return ActionResult
     */
    public ActionResult AddTask(UUID TriggerID, String MethodID, Map<String, String> ParameterMapping) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("MethodID", MethodID);
        args.put("ParameterMapping", ParameterMapping);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     * DEV: Async test method
     *
     * Name Description Optional
     * @return String
     */
    public String AsyncTest() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<String>(){}.getType();
        return (String) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param TaskId  False
     * @return ActionResult
     */
    public ActionResult CancelTask(UUID TaskId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param TriggerID  False
     * @param TaskID  False
     * @param NewOrder  False
     * @return ActionResult
     */
    public ActionResult ChangeTaskOrder(UUID TriggerID, UUID TaskID, Integer NewOrder) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        args.put("NewOrder", NewOrder);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Username  False
     * @param OldPassword  False
     * @param NewPassword  False
     * @param TwoFactorPIN  False
     * @return ActionResult
     */
    public ActionResult ChangeUserPassword(String Username, String OldPassword, String NewPassword, String TwoFactorPIN) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("OldPassword", OldPassword);
        args.put("NewPassword", NewPassword);
        args.put("TwoFactorPIN", TwoFactorPIN);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Username  False
     * @param TwoFactorCode  False
     * @return ActionResult
     */
    public ActionResult ConfirmTwoFactorSetup(String Username, String TwoFactorCode) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("TwoFactorCode", TwoFactorCode);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Name  False
     * @param AsCommonRole  True
     * @return ActionResult<UUID>
     */
    public ActionResult<UUID> CreateRole(String Name, Boolean AsCommonRole) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        args.put("AsCommonRole", AsCommonRole);
        Type type = new TypeToken<ActionResult<UUID>>(){}.getType();
        return (ActionResult<UUID>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     * DEV: Creates a non-ending task with 50% progress for testing purposes
     *
     * Name Description Optional
     * @return Void
     */
    public Void CreateTestTask() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Username  False
     * @return ActionResult<UUID>
     */
    public ActionResult<UUID> CreateUser(String Username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        Type type = new TypeToken<ActionResult<UUID>>(){}.getType();
        return (ActionResult<UUID>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param PermissionNode  False
     * @return Boolean
     */
    public Boolean CurrentSessionHasPermission(String PermissionNode) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("PermissionNode", PermissionNode);
        Type type = new TypeToken<Boolean>(){}.getType();
        return (Boolean) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
     * 
     *
     * Name Description Optional
     * @param RoleId  False
     * @return ActionResult
     */
    public ActionResult DeleteRole(UUID RoleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param TriggerID  False
     * @param TaskID  False
     * @return ActionResult
     */
    public ActionResult DeleteTask(UUID TriggerID, UUID TaskID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param TriggerID  False
     * @return ActionResult
     */
    public ActionResult DeleteTrigger(UUID TriggerID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Username  False
     * @return ActionResult
     */
    public ActionResult DeleteUser(String Username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Password  False
     * @param TwoFactorCode  False
     * @return ActionResult
     */
    public ActionResult DisableTwoFactor(String Password, String TwoFactorCode) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Password", Password);
        args.put("TwoFactorCode", TwoFactorCode);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return ActionResult
     */
    public ActionResult DismissAllTasks() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param TaskId  False
     * @return ActionResult
     */
    public ActionResult DismissTask(UUID TaskId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Id  False
     * @param months  False
     * @param days  False
     * @param hours  False
     * @param minutes  False
     * @param daysOfMonth  False
     * @param description  False
     * @return ActionResult
     */
    public ActionResult EditIntervalTrigger(UUID Id, List<Integer> months, List<Integer> days, List<Integer> hours, List<Integer> minutes, List<Integer> daysOfMonth, String description) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("months", months);
        args.put("days", days);
        args.put("hours", hours);
        args.put("minutes", minutes);
        args.put("daysOfMonth", daysOfMonth);
        args.put("description", description);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param TriggerID  False
     * @param TaskID  False
     * @param ParameterMapping  False
     * @return ActionResult
     */
    public ActionResult EditTask(UUID TriggerID, UUID TaskID, Map<String, String> ParameterMapping) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        args.put("ParameterMapping", ParameterMapping);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Username  False
     * @param Password  False
     * @return ActionResult<Object>
     */
    public ActionResult<Object> EnableTwoFactor(String Username, String Password) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("Password", Password);
        Type type = new TypeToken<ActionResult<Object>>(){}.getType();
        return (ActionResult<Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Id  False
     * @return Void
     */
    public Void EndUserSession(UUID Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param RoleId  False
     * @return List<String>
     */
    public List<String> GetAMPRolePermissions(UUID RoleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        Type type = new TypeToken<List<String>>(){}.getType();
        return (List<String>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Username  False
     * @return UserInfo
     */
    public UserInfo GetAMPUserInfo(String Username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        Type type = new TypeToken<UserInfo>(){}.getType();
        return (UserInfo) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<Object>
     */
    public List<Object> GetAMPUsersSummary() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Object>>(){}.getType();
        return (List<Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Map<String, Map<String, Object>>
     */
    public Map<String, Map<String, Object>> GetAPISpec() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, Map<String, Object>>>(){}.getType();
        return (Map<String, Map<String, Object>>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<Object>
     */
    public List<Object> GetActiveAMPSessions() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Object>>(){}.getType();
        return (List<Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<UserInfo>
     */
    public List<UserInfo> GetAllAMPUserInfo() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<UserInfo>>(){}.getType();
        return (List<UserInfo>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Before  False
     * @param Count  False
     * @return List<Object>
     */
    public List<Object> GetAuditLogEntries(Object Before, Integer Count) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Before", Before);
        args.put("Count", Count);
        Type type = new TypeToken<List<Object>>(){}.getType();
        return (List<Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param node  False
     * @return Map<String, Object>
     */
    public Map<String, Object> GetConfig(String node) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("node", node);
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return (Map<String, Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param nodes  False
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> GetConfigs(List<String> nodes) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("nodes", nodes);
        Type type = new TypeToken<List<Map<String, Object>>>(){}.getType();
        return (List<Map<String, Object>>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Map<String, String>
     */
    public Map<String, String> GetDiagnosticsInfo() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        return (Map<String, String>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return ModuleInfo
     */
    public ModuleInfo GetModuleInfo() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ModuleInfo>(){}.getType();
        return (ModuleInfo) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return UUID
     */
    public UUID GetNewGuid() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<UUID>(){}.getType();
        return (UUID) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<Object>
     */
    public List<Object> GetPermissionsSpec() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Object>>(){}.getType();
        return (List<Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<Object>
     */
    public List<Object> GetPortSummaries() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Object>>(){}.getType();
        return (List<Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> GetProvisionSpec() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Map<String, Object>>>(){}.getType();
        return (List<Map<String, Object>>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Description  True
     * @param IsTemporary  True
     * @return String
     */
    public String GetRemoteLoginToken(String Description, Boolean IsTemporary) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Description", Description);
        args.put("IsTemporary", IsTemporary);
        Type type = new TypeToken<String>(){}.getType();
        return (String) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param RoleId  False
     * @return Object
     */
    public Object GetRole(UUID RoleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        Type type = new TypeToken<Object>(){}.getType();
        return (Object) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<Object>
     */
    public List<Object> GetRoleData() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Object>>(){}.getType();
        return (List<Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Map<UUID, String>
     */
    public Map<UUID, String> GetRoleIds() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<UUID, String>>(){}.getType();
        return (Map<UUID, String>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Object
     */
    public Object GetScheduleData() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Object>(){}.getType();
        return (Object) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param SettingNode  False
     * @param WithRefresh  True
     * @return Map<String, String>
     */
    public Map<String, String> GetSettingValues(String SettingNode, Boolean WithRefresh) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("SettingNode", SettingNode);
        args.put("WithRefresh", WithRefresh);
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        return (Map<String, String>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Map<String, SettingSpec>
     */
    public Map<String, SettingSpec> GetSettingsSpec() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, SettingSpec>>(){}.getType();
        return (Map<String, SettingSpec>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Status
     */
    public Status GetStatus() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Status>(){}.getType();
        return (Status) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<RunningTask>
     */
    public List<RunningTask> GetTasks() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<RunningTask>>(){}.getType();
        return (List<RunningTask>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Id  False
     * @return Object
     */
    public Object GetTimeIntervalTrigger(UUID Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        Type type = new TypeToken<Object>(){}.getType();
        return (Object) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return UpdateInfo
     */
    public UpdateInfo GetUpdateInfo() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<UpdateInfo>(){}.getType();
        return (UpdateInfo) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     * Gets changes to the server status, in addition to any notifications or console output that have occured since the last time GetUpdates() was called by the current session.
     *
     * Name Description Optional
     * @return Updates
     */
    public Updates GetUpdates() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Updates>(){}.getType();
        return (Updates) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Object
     */
    public Object GetUserActionsSpec() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Object>(){}.getType();
        return (Object) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param UID  False
     * @return Object
     */
    public Object GetUserInfo(String UID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UID", UID);
        Type type = new TypeToken<Object>(){}.getType();
        return (Object) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     * Returns a list of in-application users
     *
     * Name Description Optional
     * @return Map<String, String>
     */
    public Map<String, String> GetUserList() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        return (Map<String, String>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return ActionResult<String>
     */
    public ActionResult<String> GetWebauthnChallenge() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult<String>>(){}.getType();
        return (ActionResult<String>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param username  False
     * @return Object
     */
    public Object GetWebauthnCredentialIDs(String username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("username", username);
        Type type = new TypeToken<Object>(){}.getType();
        return (Object) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<Object>
     */
    public List<Object> GetWebauthnCredentialSummaries() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Object>>(){}.getType();
        return (List<Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Object
     */
    public Object GetWebserverMetrics() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Object>(){}.getType();
        return (Object) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Void
     */
    public Void Kill() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param username  False
     * @param password  False
     * @param token  False
     * @param rememberMe  False
     * @return LoginResult
     */
    public LoginResult Login(String username, String password, String token, Boolean rememberMe) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("username", username);
        args.put("password", password);
        args.put("token", token);
        args.put("rememberMe", rememberMe);
        Type type = new TypeToken<LoginResult>(){}.getType();
        return (LoginResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Void
     */
    public Void Logout() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Node  False
     * @return ActionResult
     */
    public ActionResult RefreshSettingValueList(String Node) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Node", Node);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Void
     */
    public Void RefreshSettingsSourceCache() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param RoleId  False
     * @param NewName  False
     * @return ActionResult
     */
    public ActionResult RenameRole(UUID RoleId, String NewName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("NewName", NewName);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Username  False
     * @param NewPassword  False
     * @return ActionResult
     */
    public ActionResult ResetUserPassword(String Username, String NewPassword) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("NewPassword", NewPassword);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return ActionResult
     */
    public ActionResult Restart() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Void
     */
    public Void RestartAMP() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     * Allows the service to be re-started after previously being suspended.
     *
     * Name Description Optional
     * @return Void
     */
    public Void Resume() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param ID  False
     * @return ActionResult
     */
    public ActionResult RevokeWebauthnCredential(Integer ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param triggerId  False
     * @return ActionResult
     */
    public ActionResult RunEventTriggerImmediately(UUID triggerId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param message  False
     * @return Void
     */
    public Void SendConsoleMessage(String message) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("message", message);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param RoleId  False
     * @param PermissionNode  False
     * @param Enabled  False
     * @return ActionResult
     */
    public ActionResult SetAMPRolePermission(UUID RoleId, String PermissionNode, Boolean Enabled) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("PermissionNode", PermissionNode);
        args.put("Enabled", Enabled);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param UserId  False
     * @param RoleId  False
     * @param IsMember  False
     * @return ActionResult
     */
    public ActionResult SetAMPUserRoleMembership(UUID UserId, UUID RoleId, Boolean IsMember) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UserId", UserId);
        args.put("RoleId", RoleId);
        args.put("IsMember", IsMember);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param node  False
     * @param value  False
     * @return ActionResult
     */
    public ActionResult SetConfig(String node, String value) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("node", node);
        args.put("value", value);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param data  False
     * @return Boolean
     */
    public Boolean SetConfigs(Map<String, String> data) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("data", data);
        Type type = new TypeToken<Boolean>(){}.getType();
        return (Boolean) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Id  False
     * @param Enabled  False
     * @return ActionResult
     */
    public ActionResult SetTriggerEnabled(UUID Id, Boolean Enabled) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("Enabled", Enabled);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return ActionResult
     */
    public ActionResult Sleep() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return ActionResult
     */
    public ActionResult Start() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Void
     */
    public Void Stop() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     * Prevents the current instance from being started, and stops it if it's currently running.
     *
     * Name Description Optional
     * @return Void
     */
    public Void Suspend() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Void
     */
    public Void UpdateAMPInstance() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param EmailAddress  False
     * @param TwoFactorPIN  False
     * @return ActionResult
     */
    public ActionResult UpdateAccountInfo(String EmailAddress, String TwoFactorPIN) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("EmailAddress", EmailAddress);
        args.put("TwoFactorPIN", TwoFactorPIN);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return ActionResult
     */
    public ActionResult UpdateApplication() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Username  False
     * @param Disabled  False
     * @param PasswordExpires  False
     * @param CannotChangePassword  False
     * @param MustChangePassword  False
     * @param EmailAddress  True
     * @return ActionResult
     */
    public ActionResult UpdateUserInfo(String Username, Boolean Disabled, Boolean PasswordExpires, Boolean CannotChangePassword, Boolean MustChangePassword, String EmailAddress) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("Disabled", Disabled);
        args.put("PasswordExpires", PasswordExpires);
        args.put("CannotChangePassword", CannotChangePassword);
        args.put("MustChangePassword", MustChangePassword);
        args.put("EmailAddress", EmailAddress);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Void
     */
    public Void UpgradeAMP() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param attestationObject  False
     * @param clientDataJSON  False
     * @param description  True
     * @return ActionResult
     */
    public ActionResult WebauthnRegister(String attestationObject, String clientDataJSON, String description) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("attestationObject", attestationObject);
        args.put("clientDataJSON", clientDataJSON);
        args.put("description", description);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param username  False
     * @return List<Object>
     */
    public List<Object> GetAuthenticationRequirements(String username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("username", username);
        Type type = new TypeToken<List<Object>>(){}.getType();
        return (List<Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> RunSecurityCheck() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Map<String, Object>>>(){}.getType();
        return (List<Map<String, Object>>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

}
