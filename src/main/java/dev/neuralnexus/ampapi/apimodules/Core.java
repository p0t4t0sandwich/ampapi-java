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

public class Core extends AMPAPI {
    public Core(AMPAPI ampapi) {
        super(ampapi);
    }

    /**
     * Name Description Optional
     * @return Void
     */
    public Void AcknowledgeAMPUpdate() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.APICall("Core/AcknowledgeAMPUpdate", args, type);
    }

    /**
     * Name Description Optional
     * @param triggerId  False
     * @return ActionResult
     */
    public ActionResult AddEventTrigger(UUID triggerId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.APICall("Core/AddEventTrigger", args, type);
    }

    /**
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
        return (ActionResult) this.APICall("Core/AddIntervalTrigger", args, type);
    }

    /**
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
        return (ActionResult) this.APICall("Core/AddTask", args, type);
    }

    /**
     * DEV: Async test method
     * Name Description Optional
     * @return Task<String>
     */
    public Task<String> AsyncTest() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Task<String>>(){}.getType();
        return (Task<String>) this.APICall("Core/AsyncTest", args, type);
    }

    /**
     * Name Description Optional
     * @param TaskId  False
     * @return ActionResult
     */
    public ActionResult CancelTask(UUID TaskId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.APICall("Core/CancelTask", args, type);
    }

    /**
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
        return (ActionResult) this.APICall("Core/ChangeTaskOrder", args, type);
    }

    /**
     * Name Description Optional
     * @param Username  False
     * @param OldPassword  False
     * @param NewPassword  False
     * @param TwoFactorPIN  False
     * @return Task<ActionResult>
     */
    public Task<ActionResult> ChangeUserPassword(String Username, String OldPassword, String NewPassword, String TwoFactorPIN) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("OldPassword", OldPassword);
        args.put("NewPassword", NewPassword);
        args.put("TwoFactorPIN", TwoFactorPIN);
        Type type = new TypeToken<Task<ActionResult>>(){}.getType();
        return (Task<ActionResult>) this.APICall("Core/ChangeUserPassword", args, type);
    }

    /**
     * Name Description Optional
     * @param Username  False
     * @param TwoFactorCode  False
     * @return Task<ActionResult>
     */
    public Task<ActionResult> ConfirmTwoFactorSetup(String Username, String TwoFactorCode) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("TwoFactorCode", TwoFactorCode);
        Type type = new TypeToken<Task<ActionResult>>(){}.getType();
        return (Task<ActionResult>) this.APICall("Core/ConfirmTwoFactorSetup", args, type);
    }

    /**
     * Name Description Optional
     * @param Name  False
     * @param AsCommonRole  True
     * @return Task<ActionResult<UUID>>
     */
    public Task<ActionResult<UUID>> CreateRole(String Name, Boolean AsCommonRole) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        args.put("AsCommonRole", AsCommonRole);
        Type type = new TypeToken<Task<ActionResult<UUID>>>(){}.getType();
        return (Task<ActionResult<UUID>>) this.APICall("Core/CreateRole", args, type);
    }

    /**
     * DEV: Creates a non-ending task with 50% progress for testing purposes
     * Name Description Optional
     * @return Void
     */
    public Void CreateTestTask() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.APICall("Core/CreateTestTask", args, type);
    }

    /**
     * Name Description Optional
     * @param Username  False
     * @return Task<ActionResult<UUID>>
     */
    public Task<ActionResult<UUID>> CreateUser(String Username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        Type type = new TypeToken<Task<ActionResult<UUID>>>(){}.getType();
        return (Task<ActionResult<UUID>>) this.APICall("Core/CreateUser", args, type);
    }

    /**
     * Name Description Optional
     * @param PermissionNode  False
     * @return Boolean
     */
    public Boolean CurrentSessionHasPermission(String PermissionNode) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("PermissionNode", PermissionNode);
        Type type = new TypeToken<Boolean>(){}.getType();
        return (Boolean) this.APICall("Core/CurrentSessionHasPermission", args, type);
    }

    /**
     * Name Description Optional
     * @param InstanceId  False
     * @return Task<ActionResult>
     */
    public Task<ActionResult> DeleteInstanceUsers(UUID InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        Type type = new TypeToken<Task<ActionResult>>(){}.getType();
        return (Task<ActionResult>) this.APICall("Core/DeleteInstanceUsers", args, type);
    }

    /**
     * Name Description Optional
     * @param RoleId  False
     * @return Task<ActionResult>
     */
    public Task<ActionResult> DeleteRole(UUID RoleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        Type type = new TypeToken<Task<ActionResult>>(){}.getType();
        return (Task<ActionResult>) this.APICall("Core/DeleteRole", args, type);
    }

    /**
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
        return (ActionResult) this.APICall("Core/DeleteTask", args, type);
    }

    /**
     * Name Description Optional
     * @param TriggerID  False
     * @return ActionResult
     */
    public ActionResult DeleteTrigger(UUID TriggerID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.APICall("Core/DeleteTrigger", args, type);
    }

    /**
     * Name Description Optional
     * @param Username  False
     * @return Task<ActionResult>
     */
    public Task<ActionResult> DeleteUser(String Username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        Type type = new TypeToken<Task<ActionResult>>(){}.getType();
        return (Task<ActionResult>) this.APICall("Core/DeleteUser", args, type);
    }

    /**
     * Name Description Optional
     * @param Password  False
     * @param TwoFactorCode  False
     * @return Task<ActionResult>
     */
    public Task<ActionResult> DisableTwoFactor(String Password, String TwoFactorCode) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Password", Password);
        args.put("TwoFactorCode", TwoFactorCode);
        Type type = new TypeToken<Task<ActionResult>>(){}.getType();
        return (Task<ActionResult>) this.APICall("Core/DisableTwoFactor", args, type);
    }

    /**
     * Name Description Optional
     * @return ActionResult
     */
    public ActionResult DismissAllTasks() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.APICall("Core/DismissAllTasks", args, type);
    }

    /**
     * Name Description Optional
     * @param TaskId  False
     * @return ActionResult
     */
    public ActionResult DismissTask(UUID TaskId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.APICall("Core/DismissTask", args, type);
    }

    /**
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
        return (ActionResult) this.APICall("Core/EditIntervalTrigger", args, type);
    }

    /**
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
        return (ActionResult) this.APICall("Core/EditTask", args, type);
    }

    /**
     * Name Description Optional
     * @param Username  False
     * @param Password  False
     * @return Task<Object>
     */
    public Task<Object> EnableTwoFactor(String Username, String Password) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("Password", Password);
        Type type = new TypeToken<Task<Object>>(){}.getType();
        return (Task<Object>) this.APICall("Core/EnableTwoFactor", args, type);
    }

    /**
     * Name Description Optional
     * @param Id  False
     * @return Void
     */
    public Void EndUserSession(UUID Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.APICall("Core/EndUserSession", args, type);
    }

    /**
     * Name Description Optional
     * @param RoleId  False
     * @return Task<List<String>>
     */
    public Task<List<String>> GetAMPRolePermissions(UUID RoleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        Type type = new TypeToken<Task<List<String>>>(){}.getType();
        return (Task<List<String>>) this.APICall("Core/GetAMPRolePermissions", args, type);
    }

    /**
     * Name Description Optional
     * @param Username  False
     * @return Task<UserInfo>
     */
    public Task<UserInfo> GetAMPUserInfo(String Username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        Type type = new TypeToken<Task<UserInfo>>(){}.getType();
        return (Task<UserInfo>) this.APICall("Core/GetAMPUserInfo", args, type);
    }

    /**
     * Name Description Optional
     * @return Task<List<Object>>
     */
    public Task<List<Object>> GetAMPUsersSummary() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Task<List<Object>>>(){}.getType();
        return (Task<List<Object>>) this.APICall("Core/GetAMPUsersSummary", args, type);
    }

    /**
     * Name Description Optional
     * @return Map<String, Map<String, Object>>
     */
    public Map<String, Map<String, Object>> GetAPISpec() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, Map<String, Object>>>(){}.getType();
        return (Map<String, Map<String, Object>>) this.APICall("Core/GetAPISpec", args, type);
    }

    /**
     * Name Description Optional
     * @return Result<List<Object>>
     */
    public Result<List<Object>> GetActiveAMPSessions() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Result<List<Object>>>(){}.getType();
        return (Result<List<Object>>) this.APICall("Core/GetActiveAMPSessions", args, type);
    }

    /**
     * Name Description Optional
     * @return Task<List<UserInfo>>
     */
    public Task<List<UserInfo>> GetAllAMPUserInfo() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Task<List<UserInfo>>>(){}.getType();
        return (Task<List<UserInfo>>) this.APICall("Core/GetAllAMPUserInfo", args, type);
    }

    /**
     * Name Description Optional
     * @param Before  False
     * @param Count  False
     * @return Result<List<Object>>
     */
    public Result<List<Object>> GetAuditLogEntries(Object Before, Integer Count) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Before", Before);
        args.put("Count", Count);
        Type type = new TypeToken<Result<List<Object>>>(){}.getType();
        return (Result<List<Object>>) this.APICall("Core/GetAuditLogEntries", args, type);
    }

    /**
     * Name Description Optional
     * @param node  False
     * @return Map<String, Object>
     */
    public Map<String, Object> GetConfig(String node) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("node", node);
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return (Map<String, Object>) this.APICall("Core/GetConfig", args, type);
    }

    /**
     * Name Description Optional
     * @param nodes  False
     * @return Result<List<Map<String, Object>>>
     */
    public Result<List<Map<String, Object>>> GetConfigs(List<String> nodes) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("nodes", nodes);
        Type type = new TypeToken<Result<List<Map<String, Object>>>>(){}.getType();
        return (Result<List<Map<String, Object>>>) this.APICall("Core/GetConfigs", args, type);
    }

    /**
     * Name Description Optional
     * @return Map<String, String>
     */
    public Map<String, String> GetDiagnosticsInfo() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        return (Map<String, String>) this.APICall("Core/GetDiagnosticsInfo", args, type);
    }

    /**
     * Name Description Optional
     * @return Result<ModuleInfo>
     */
    public Result<ModuleInfo> GetModuleInfo() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Result<ModuleInfo>>(){}.getType();
        return (Result<ModuleInfo>) this.APICall("Core/GetModuleInfo", args, type);
    }

    /**
     * Name Description Optional
     * @return UUID
     */
    public UUID GetNewGuid() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<UUID>(){}.getType();
        return (UUID) this.APICall("Core/GetNewGuid", args, type);
    }

    /**
     * Name Description Optional
     * @return List<Object>
     */
    public List<Object> GetPermissionsSpec() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Object>>(){}.getType();
        return (List<Object>) this.APICall("Core/GetPermissionsSpec", args, type);
    }

    /**
     * Name Description Optional
     * @return Result<List<Object>>
     */
    public Result<List<Object>> GetPortSummaries() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Result<List<Object>>>(){}.getType();
        return (Result<List<Object>>) this.APICall("Core/GetPortSummaries", args, type);
    }

    /**
     * Name Description Optional
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> GetProvisionSpec() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Map<String, Object>>>(){}.getType();
        return (List<Map<String, Object>>) this.APICall("Core/GetProvisionSpec", args, type);
    }

    /**
     * Name Description Optional
     * @param Description  True
     * @param IsTemporary  True
     * @return Task<String>
     */
    public Task<String> GetRemoteLoginToken(String Description, Boolean IsTemporary) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Description", Description);
        args.put("IsTemporary", IsTemporary);
        Type type = new TypeToken<Task<String>>(){}.getType();
        return (Task<String>) this.APICall("Core/GetRemoteLoginToken", args, type);
    }

    /**
     * Name Description Optional
     * @param RoleId  False
     * @return Task<Object>
     */
    public Task<Object> GetRole(UUID RoleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        Type type = new TypeToken<Task<Object>>(){}.getType();
        return (Task<Object>) this.APICall("Core/GetRole", args, type);
    }

    /**
     * Name Description Optional
     * @return Task<List<Object>>
     */
    public Task<List<Object>> GetRoleData() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Task<List<Object>>>(){}.getType();
        return (Task<List<Object>>) this.APICall("Core/GetRoleData", args, type);
    }

    /**
     * Name Description Optional
     * @return Task<Map<UUID, String>>
     */
    public Task<Map<UUID, String>> GetRoleIds() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Task<Map<UUID, String>>>(){}.getType();
        return (Task<Map<UUID, String>>) this.APICall("Core/GetRoleIds", args, type);
    }

    /**
     * Name Description Optional
     * @return Object
     */
    public Object GetScheduleData() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Object>(){}.getType();
        return (Object) this.APICall("Core/GetScheduleData", args, type);
    }

    /**
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
        return (Map<String, String>) this.APICall("Core/GetSettingValues", args, type);
    }

    /**
     * Name Description Optional
     * @return SettingsSpec
     */
    public SettingsSpec GetSettingsSpec() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<SettingsSpec>(){}.getType();
        return (SettingsSpec) this.APICall("Core/GetSettingsSpec", args, type);
    }

    /**
     * Name Description Optional
     * @return Status
     */
    public Status GetStatus() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Status>(){}.getType();
        return (Status) this.APICall("Core/GetStatus", args, type);
    }

    /**
     * Name Description Optional
     * @return Result<List<RunningTask>>
     */
    public Result<List<RunningTask>> GetTasks() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Result<List<RunningTask>>>(){}.getType();
        return (Result<List<RunningTask>>) this.APICall("Core/GetTasks", args, type);
    }

    /**
     * Name Description Optional
     * @param Id  False
     * @return Object
     */
    public Object GetTimeIntervalTrigger(UUID Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        Type type = new TypeToken<Object>(){}.getType();
        return (Object) this.APICall("Core/GetTimeIntervalTrigger", args, type);
    }

    /**
     * Name Description Optional
     * @return Result<UpdateInfo>
     */
    public Result<UpdateInfo> GetUpdateInfo() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Result<UpdateInfo>>(){}.getType();
        return (Result<UpdateInfo>) this.APICall("Core/GetUpdateInfo", args, type);
    }

    /**
     * Gets changes to the server status, in addition to any notifications or console output that have occured since the last time GetUpdates() was called by the current session.
     * Name Description Optional
     * @return Updates
     */
    public Updates GetUpdates() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Updates>(){}.getType();
        return (Updates) this.APICall("Core/GetUpdates", args, type);
    }

    /**
     * Name Description Optional
     * @return Object
     */
    public Object GetUserActionsSpec() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Object>(){}.getType();
        return (Object) this.APICall("Core/GetUserActionsSpec", args, type);
    }

    /**
     * Name Description Optional
     * @param UID  False
     * @return Map<String, Object>
     */
    public Map<String, Object> GetUserInfo(String UID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UID", UID);
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return (Map<String, Object>) this.APICall("Core/GetUserInfo", args, type);
    }

    /**
     * Returns a list of in-application users
     * Name Description Optional
     * @return Result<Map<String, String>>
     */
    public Result<Map<String, String>> GetUserList() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Result<Map<String, String>>>(){}.getType();
        return (Result<Map<String, String>>) this.APICall("Core/GetUserList", args, type);
    }

    /**
     * Name Description Optional
     * @return ActionResult<String>
     */
    public ActionResult<String> GetWebauthnChallenge() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult<String>>(){}.getType();
        return (ActionResult<String>) this.APICall("Core/GetWebauthnChallenge", args, type);
    }

    /**
     * Name Description Optional
     * @param username  False
     * @return Object
     */
    public Object GetWebauthnCredentialIDs(String username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("username", username);
        Type type = new TypeToken<Object>(){}.getType();
        return (Object) this.APICall("Core/GetWebauthnCredentialIDs", args, type);
    }

    /**
     * Name Description Optional
     * @return Result<List<Object>>
     */
    public Result<List<Object>> GetWebauthnCredentialSummaries() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Result<List<Object>>>(){}.getType();
        return (Result<List<Object>>) this.APICall("Core/GetWebauthnCredentialSummaries", args, type);
    }

    /**
     * Name Description Optional
     * @return Object
     */
    public Object GetWebserverMetrics() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Object>(){}.getType();
        return (Object) this.APICall("Core/GetWebserverMetrics", args, type);
    }

    /**
     * Name Description Optional
     * @return Void
     */
    public Void Kill() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.APICall("Core/Kill", args, type);
    }

    /**
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
        return (LoginResult) this.APICall("Core/Login", args, type);
    }

    /**
     * Name Description Optional
     * @return Void
     */
    public Void Logout() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.APICall("Core/Logout", args, type);
    }

    /**
     * Name Description Optional
     * @param Node  False
     * @return ActionResult
     */
    public ActionResult RefreshSettingValueList(String Node) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Node", Node);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.APICall("Core/RefreshSettingValueList", args, type);
    }

    /**
     * Name Description Optional
     * @return Void
     */
    public Void RefreshSettingsSourceCache() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.APICall("Core/RefreshSettingsSourceCache", args, type);
    }

    /**
     * Name Description Optional
     * @param RoleId  False
     * @param NewName  False
     * @return Task<ActionResult>
     */
    public Task<ActionResult> RenameRole(UUID RoleId, String NewName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("NewName", NewName);
        Type type = new TypeToken<Task<ActionResult>>(){}.getType();
        return (Task<ActionResult>) this.APICall("Core/RenameRole", args, type);
    }

    /**
     * Name Description Optional
     * @param Username  False
     * @param NewPassword  False
     * @return Task<ActionResult>
     */
    public Task<ActionResult> ResetUserPassword(String Username, String NewPassword) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("NewPassword", NewPassword);
        Type type = new TypeToken<Task<ActionResult>>(){}.getType();
        return (Task<ActionResult>) this.APICall("Core/ResetUserPassword", args, type);
    }

    /**
     * Name Description Optional
     * @return ActionResult
     */
    public ActionResult Restart() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.APICall("Core/Restart", args, type);
    }

    /**
     * Name Description Optional
     * @return Void
     */
    public Void RestartAMP() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.APICall("Core/RestartAMP", args, type);
    }

    /**
     * Allows the service to be re-started after previously being suspended.
     * Name Description Optional
     * @return Void
     */
    public Void Resume() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.APICall("Core/Resume", args, type);
    }

    /**
     * Name Description Optional
     * @param ID  False
     * @return ActionResult
     */
    public ActionResult RevokeWebauthnCredential(Integer ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.APICall("Core/RevokeWebauthnCredential", args, type);
    }

    /**
     * Name Description Optional
     * @param triggerId  False
     * @return ActionResult
     */
    public ActionResult RunEventTriggerImmediately(UUID triggerId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.APICall("Core/RunEventTriggerImmediately", args, type);
    }

    /**
     * Name Description Optional
     * @param message  False
     * @return Void
     */
    public Void SendConsoleMessage(String message) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("message", message);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.APICall("Core/SendConsoleMessage", args, type);
    }

    /**
     * Name Description Optional
     * @param RoleId  False
     * @param PermissionNode  False
     * @param Enabled  False
     * @return Task<ActionResult>
     */
    public Task<ActionResult> SetAMPRolePermission(UUID RoleId, String PermissionNode, Boolean Enabled) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("PermissionNode", PermissionNode);
        args.put("Enabled", Enabled);
        Type type = new TypeToken<Task<ActionResult>>(){}.getType();
        return (Task<ActionResult>) this.APICall("Core/SetAMPRolePermission", args, type);
    }

    /**
     * Name Description Optional
     * @param UserId  False
     * @param RoleId  False
     * @param IsMember  False
     * @return Task<ActionResult>
     */
    public Task<ActionResult> SetAMPUserRoleMembership(UUID UserId, UUID RoleId, Boolean IsMember) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UserId", UserId);
        args.put("RoleId", RoleId);
        args.put("IsMember", IsMember);
        Type type = new TypeToken<Task<ActionResult>>(){}.getType();
        return (Task<ActionResult>) this.APICall("Core/SetAMPUserRoleMembership", args, type);
    }

    /**
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
        return (ActionResult) this.APICall("Core/SetConfig", args, type);
    }

    /**
     * Name Description Optional
     * @param data  False
     * @return Boolean
     */
    public Boolean SetConfigs(Map<String, String> data) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("data", data);
        Type type = new TypeToken<Boolean>(){}.getType();
        return (Boolean) this.APICall("Core/SetConfigs", args, type);
    }

    /**
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
        return (ActionResult) this.APICall("Core/SetTriggerEnabled", args, type);
    }

    /**
     * Name Description Optional
     * @return ActionResult
     */
    public ActionResult Sleep() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.APICall("Core/Sleep", args, type);
    }

    /**
     * Name Description Optional
     * @return ActionResult
     */
    public ActionResult Start() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.APICall("Core/Start", args, type);
    }

    /**
     * Name Description Optional
     * @return Void
     */
    public Void Stop() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.APICall("Core/Stop", args, type);
    }

    /**
     * Prevents the current instance from being started, and stops it if it's currently running.
     * Name Description Optional
     * @return Void
     */
    public Void Suspend() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.APICall("Core/Suspend", args, type);
    }

    /**
     * Name Description Optional
     * @return Void
     */
    public Void UpdateAMPInstance() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.APICall("Core/UpdateAMPInstance", args, type);
    }

    /**
     * Name Description Optional
     * @param EmailAddress  False
     * @param TwoFactorPIN  False
     * @return Task<ActionResult>
     */
    public Task<ActionResult> UpdateAccountInfo(String EmailAddress, String TwoFactorPIN) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("EmailAddress", EmailAddress);
        args.put("TwoFactorPIN", TwoFactorPIN);
        Type type = new TypeToken<Task<ActionResult>>(){}.getType();
        return (Task<ActionResult>) this.APICall("Core/UpdateAccountInfo", args, type);
    }

    /**
     * Name Description Optional
     * @return ActionResult
     */
    public ActionResult UpdateApplication() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.APICall("Core/UpdateApplication", args, type);
    }

    /**
     * Name Description Optional
     * @param Username  False
     * @param Disabled  False
     * @param PasswordExpires  False
     * @param CannotChangePassword  False
     * @param MustChangePassword  False
     * @param EmailAddress  True
     * @return Task<ActionResult>
     */
    public Task<ActionResult> UpdateUserInfo(String Username, Boolean Disabled, Boolean PasswordExpires, Boolean CannotChangePassword, Boolean MustChangePassword, String EmailAddress) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("Disabled", Disabled);
        args.put("PasswordExpires", PasswordExpires);
        args.put("CannotChangePassword", CannotChangePassword);
        args.put("MustChangePassword", MustChangePassword);
        args.put("EmailAddress", EmailAddress);
        Type type = new TypeToken<Task<ActionResult>>(){}.getType();
        return (Task<ActionResult>) this.APICall("Core/UpdateUserInfo", args, type);
    }

    /**
     * Name Description Optional
     * @return Void
     */
    public Void UpgradeAMP() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.APICall("Core/UpgradeAMP", args, type);
    }

    /**
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
        return (ActionResult) this.APICall("Core/WebauthnRegister", args, type);
    }

}
