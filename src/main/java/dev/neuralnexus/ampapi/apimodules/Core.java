package dev.neuralnexus.ampapi.apimodules;

import dev.neuralnexus.ampapi.AMPAPIBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Core extends AMPAPIBase {
    public Core(AMPAPIBase ampapiBase) {
        super(ampapiBase);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> AcknowledgeAMPUpdate() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/AcknowledgeAMPUpdate", args);
    }

    /**
     * Name TypeName Description Optional
     * @param triggerId String AMPType: Guid 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> AddEventTrigger(String triggerId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        return this.APICall("Core/AddEventTrigger", args);
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
    public Map<?, ?> AddIntervalTrigger(List<Integer> months, List<Integer> days, List<Integer> hours, List<Integer> minutes, List<Integer> daysOfMonth, String description) {
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
     * @param TriggerID String AMPType: Guid 
     * @param MethodID String AMPType: String 
     * @param ParameterMapping Map<String, String> AMPType: Dictionary<String, String> 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> AddTask(String TriggerID, String MethodID, Map<String, String> ParameterMapping) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("MethodID", MethodID);
        args.put("ParameterMapping", ParameterMapping);
        return this.APICall("Core/AddTask", args);
    }

    /**
     * DEV: Async test method
     * Name TypeName Description Optional
     * @return  AMPType: Task<String>
     */
    public Map<?, ?> AsyncTest() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/AsyncTest", args);
    }

    /**
     * Name TypeName Description Optional
     * @param TaskId String AMPType: Guid 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> CancelTask(String TaskId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        return this.APICall("Core/CancelTask", args);
    }

    /**
     * Name TypeName Description Optional
     * @param TriggerID String AMPType: Guid 
     * @param TaskID String AMPType: Guid 
     * @param NewOrder Integer AMPType: Int32 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> ChangeTaskOrder(String TriggerID, String TaskID, Integer NewOrder) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        args.put("NewOrder", NewOrder);
        return this.APICall("Core/ChangeTaskOrder", args);
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
    public Map<?, ?> ChangeUserPassword(String Username, String OldPassword, String NewPassword, String TwoFactorPIN) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("OldPassword", OldPassword);
        args.put("NewPassword", NewPassword);
        args.put("TwoFactorPIN", TwoFactorPIN);
        return this.APICall("Core/ChangeUserPassword", args);
    }

    /**
     * Completes two-factor setup by supplying a valid two factor code based on the secret provided by EnableTwoFactor
     * Name TypeName Description Optional
     * @param Username String AMPType: String 
     * @param TwoFactorCode String AMPType: String 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> ConfirmTwoFactorSetup(String Username, String TwoFactorCode) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("TwoFactorCode", TwoFactorCode);
        return this.APICall("Core/ConfirmTwoFactorSetup", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Name String AMPType: String 
     * @param AsCommonRole boolean AMPType: Boolean 
     * @return  AMPType: Task<ActionResult<Guid>>
     */
    public Map<?, ?> CreateRole(String Name, boolean AsCommonRole) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        args.put("AsCommonRole", AsCommonRole);
        return this.APICall("Core/CreateRole", args);
    }

    /**
     * DEV: Creates a non-ending task with 50% progress for testing purposes
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> CreateTestTask() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/CreateTestTask", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Username String AMPType: String 
     * @return  AMPType: Task<ActionResult<Guid>>
     */
    public Map<?, ?> CreateUser(String Username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        return this.APICall("Core/CreateUser", args);
    }

    /**
     * Name TypeName Description Optional
     * @param PermissionNode String AMPType: String 
     * @return boolean AMPType: Boolean
     */
    public Map<?, ?> CurrentSessionHasPermission(String PermissionNode) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("PermissionNode", PermissionNode);
        return this.APICall("Core/CurrentSessionHasPermission", args);
    }

    /**
     * Name TypeName Description Optional
     * @param InstanceId String AMPType: Guid 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> DeleteInstanceUsers(String InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("Core/DeleteInstanceUsers", args);
    }

    /**
     * Name TypeName Description Optional
     * @param RoleId String AMPType: Guid 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> DeleteRole(String RoleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        return this.APICall("Core/DeleteRole", args);
    }

    /**
     * Name TypeName Description Optional
     * @param TriggerID String AMPType: Guid 
     * @param TaskID String AMPType: Guid 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> DeleteTask(String TriggerID, String TaskID) {
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
    public Map<?, ?> DeleteTrigger(String TriggerID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        return this.APICall("Core/DeleteTrigger", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Username String AMPType: String 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> DeleteUser(String Username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        return this.APICall("Core/DeleteUser", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Password String AMPType: String 
     * @param TwoFactorCode String AMPType: String 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> DisableTwoFactor(String Password, String TwoFactorCode) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Password", Password);
        args.put("TwoFactorCode", TwoFactorCode);
        return this.APICall("Core/DisableTwoFactor", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> DismissAllTasks() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/DismissAllTasks", args);
    }

    /**
     * Name TypeName Description Optional
     * @param TaskId String AMPType: Guid 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> DismissTask(String TaskId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        return this.APICall("Core/DismissTask", args);
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
    public Map<?, ?> EditIntervalTrigger(String Id, List<Integer> months, List<Integer> days, List<Integer> hours, List<Integer> minutes, List<Integer> daysOfMonth, String description) {
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
     * @param TriggerID String AMPType: Guid 
     * @param TaskID String AMPType: Guid 
     * @param ParameterMapping Map<String, String> AMPType: Dictionary<String, String> 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> EditTask(String TriggerID, String TaskID, Map<String, String> ParameterMapping) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        args.put("ParameterMapping", ParameterMapping);
        return this.APICall("Core/EditTask", args);
    }

    /**
     * Sets up two-factor authentication for the given user. ConfirmTwoFactorSetup must be invoked to complete setup.
     * Name TypeName Description Optional
     * @param Username String AMPType: String 
     * @param Password String AMPType: String 
     * @return  AMPType: Task<ActionResult<TwoFactorSetupInfo>>
     */
    public Map<?, ?> EnableTwoFactor(String Username, String Password) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("Password", Password);
        return this.APICall("Core/EnableTwoFactor", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Id String AMPType: Guid 
     * @return void AMPType: Void
     */
    public Map<?, ?> EndUserSession(String Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("Core/EndUserSession", args);
    }

    /**
     * Name TypeName Description Optional
     * @param RoleId String AMPType: Guid 
     * @return  AMPType: Task<IEnumerable<String>>
     */
    public Map<?, ?> GetAMPRolePermissions(String RoleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        return this.APICall("Core/GetAMPRolePermissions", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Username String AMPType: String 
     * @return  AMPType: Task<UserInfo>
     */
    public Map<?, ?> GetAMPUserInfo(String Username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        return this.APICall("Core/GetAMPUserInfo", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: Task<IEnumerable<UserInfoSummary>>
     */
    public Map<?, ?> GetAMPUsersSummary() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetAMPUsersSummary", args);
    }

    /**
     * Name TypeName Description Optional
     * @return Map<String, Map<String, Object>> AMPType: Dictionary<String, Dictionary<String, MethodInfoSummary>>
     */
    public Map<?, ?> GetAPISpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetAPISpec", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<?> AMPType: IEnumerable<WebSessionSummary>
     */
    public Map<?, ?> GetActiveAMPSessions() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetActiveAMPSessions", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: Task<IEnumerable<UserInfo>>
     */
    public Map<?, ?> GetAllAMPUserInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetAllAMPUserInfo", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Before  AMPType: Nullable<DateTime> 
     * @param Count Integer AMPType: Int32 
     * @return Map<?, ?> AMPType: IEnumerable<IAuditLogEntry>
     */
    public Map<?, ?> GetAuditLogEntries(Object Before, Integer Count) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Before", Before);
        args.put("Count", Count);
        return this.APICall("Core/GetAuditLogEntries", args);
    }

    /**
     * Name TypeName Description Optional
     * @param node String AMPType: String 
     * @return Map<?, ?> AMPType: JObject
     */
    public Map<?, ?> GetConfig(String node) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("node", node);
        return this.APICall("Core/GetConfig", args);
    }

    /**
     * Name TypeName Description Optional
     * @param nodes List<String> AMPType: String[] 
     * @return List<Map<?, ?>> AMPType: IEnumerable<JObject>
     */
    public Map<?, ?> GetConfigs(List<String> nodes) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("nodes", nodes);
        return this.APICall("Core/GetConfigs", args);
    }

    /**
     * Name TypeName Description Optional
     * @return Map<String, String> AMPType: Dictionary<String, String>
     */
    public Map<?, ?> GetDiagnosticsInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetDiagnosticsInfo", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: ModuleInfo
     */
    public Map<?, ?> GetModuleInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetModuleInfo", args);
    }

    /**
     * Name TypeName Description Optional
     * @return String AMPType: Guid
     */
    public Map<?, ?> GetNewGuid() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetNewGuid", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<?> AMPType: IList<IPermissionsTreeNode>
     */
    public Map<?, ?> GetPermissionsSpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetPermissionsSpec", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<?> AMPType: IEnumerable<ListeningPortSummary>
     */
    public Map<?, ?> GetPortSummaries() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetPortSummaries", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<Map<?, ?>> AMPType: List<JObject>
     */
    public Map<?, ?> GetProvisionSpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetProvisionSpec", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Description String AMPType: String 
     * @param IsTemporary boolean AMPType: Boolean 
     * @return  AMPType: Task<String>
     */
    public Map<?, ?> GetRemoteLoginToken(String Description, boolean IsTemporary) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Description", Description);
        args.put("IsTemporary", IsTemporary);
        return this.APICall("Core/GetRemoteLoginToken", args);
    }

    /**
     * Name TypeName Description Optional
     * @param RoleId String AMPType: Guid 
     * @return  AMPType: Task<AuthRoleSummary>
     */
    public Map<?, ?> GetRole(String RoleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        return this.APICall("Core/GetRole", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: Task<IEnumerable<AuthRoleSummary>>
     */
    public Map<?, ?> GetRoleData() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetRoleData", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: Task<IDictionary<Guid, String>>
     */
    public Map<?, ?> GetRoleIds() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetRoleIds", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: ScheduleInfo
     */
    public Map<?, ?> GetScheduleData() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetScheduleData", args);
    }

    /**
     * Name TypeName Description Optional
     * @param SettingNode String AMPType: String 
     * @param WithRefresh boolean AMPType: Boolean 
     * @return Map<String, String> AMPType: IDictionary<String, String>
     */
    public Map<?, ?> GetSettingValues(String SettingNode, boolean WithRefresh) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("SettingNode", SettingNode);
        args.put("WithRefresh", WithRefresh);
        return this.APICall("Core/GetSettingValues", args);
    }

    /**
     * Name TypeName Description Optional
     * @return dict[str, list[dict]] AMPType: Dictionary<String, IEnumerable<JObject>>
     */
    public Map<?, ?> GetSettingsSpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetSettingsSpec", args);
    }

    /**
     * Name TypeName Description Optional
     * @return Map<?, ?> AMPType: JObject
     */
    public Map<?, ?> GetStatus() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetStatus", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: IEnumerable<RunningTask>
     */
    public Map<?, ?> GetTasks() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetTasks", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Id String AMPType: Guid 
     * @return  AMPType: TimeIntervalTrigger
     */
    public Map<?, ?> GetTimeIntervalTrigger(String Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("Core/GetTimeIntervalTrigger", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: UpdateInfo
     */
    public Map<?, ?> GetUpdateInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetUpdateInfo", args);
    }

    /**
     * Gets changes to the server status, in addition to any notifications or console output that have occured since the last time GetUpdates() was called by the current session.
     * Name TypeName Description Optional
     * @return Map<?, ?> AMPType: JObject
     */
    public Map<?, ?> GetUpdates() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetUpdates", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: Object
     */
    public Map<?, ?> GetUserActionsSpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetUserActionsSpec", args);
    }

    /**
     * Provides information about a given in-application user (as opposed to AMP system users)
     * Name TypeName Description Optional
     * @param UID String AMPType: String 
     * @return Map<?, ?> AMPType: JObject
     */
    public Map<?, ?> GetUserInfo(String UID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UID", UID);
        return this.APICall("Core/GetUserInfo", args);
    }

    /**
     * Returns a list of in-application users
     * Name TypeName Description Optional
     * @return Map<String, String> AMPType: Dictionary<String, String>
     */
    public Map<?, ?> GetUserList() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetUserList", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: ActionResult<String>
     */
    public Map<?, ?> GetWebauthnChallenge() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetWebauthnChallenge", args);
    }

    /**
     * Name TypeName Description Optional
     * @param username String AMPType: String 
     * @return  AMPType: WebauthnLoginInfo
     */
    public Map<?, ?> GetWebauthnCredentialIDs(String username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("username", username);
        return this.APICall("Core/GetWebauthnCredentialIDs", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<?> AMPType: IEnumerable<WebauthnCredentialSummary>
     */
    public Map<?, ?> GetWebauthnCredentialSummaries() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetWebauthnCredentialSummaries", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: Object
     */
    public Map<?, ?> GetWebserverMetrics() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetWebserverMetrics", args);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> Kill() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Kill", args);
    }

    /**
     * Name TypeName Description Optional
     * @param username String AMPType: String 
     * @param password String AMPType: String 
     * @param token String AMPType: String 
     * @param rememberMe boolean AMPType: Boolean 
     * @return  AMPType: Task<JObject>
     */
    public Map<?, ?> Login(String username, String password, String token, boolean rememberMe) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("username", username);
        args.put("password", password);
        args.put("token", token);
        args.put("rememberMe", rememberMe);
        return this.APICall("Core/Login", args);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> Logout() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Logout", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Node String AMPType: String 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> RefreshSettingValueList(String Node) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Node", Node);
        return this.APICall("Core/RefreshSettingValueList", args);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> RefreshSettingsSourceCache() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/RefreshSettingsSourceCache", args);
    }

    /**
     * Name TypeName Description Optional
     * @param RoleId String AMPType: Guid 
     * @param NewName String AMPType: String 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> RenameRole(String RoleId, String NewName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("NewName", NewName);
        return this.APICall("Core/RenameRole", args);
    }

    /**
     * For administrative users to alter the password of another user
     * Name TypeName Description Optional
     * @param Username String AMPType: String 
     * @param NewPassword String AMPType: String 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> ResetUserPassword(String Username, String NewPassword) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("NewPassword", NewPassword);
        return this.APICall("Core/ResetUserPassword", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Restart() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Restart", args);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> RestartAMP() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/RestartAMP", args);
    }

    /**
     * Allows the service to be re-started after previously being suspended.
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> Resume() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Resume", args);
    }

    /**
     * Name TypeName Description Optional
     * @param ID Integer AMPType: Int32 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> RevokeWebauthnCredential(Integer ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        return this.APICall("Core/RevokeWebauthnCredential", args);
    }

    /**
     * Name TypeName Description Optional
     * @param triggerId String AMPType: Guid 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> RunEventTriggerImmediately(String triggerId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        return this.APICall("Core/RunEventTriggerImmediately", args);
    }

    /**
     * Name TypeName Description Optional
     * @param message String AMPType: String 
     * @return void AMPType: Void
     */
    public Map<?, ?> SendConsoleMessage(String message) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("message", message);
        return this.APICall("Core/SendConsoleMessage", args);
    }

    /**
     * Name TypeName Description Optional
     * @param RoleId String AMPType: Guid 
     * @param PermissionNode String AMPType: String 
     * @param Enabled boolean AMPType: Nullable<Boolean> 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> SetAMPRolePermission(String RoleId, String PermissionNode, boolean Enabled) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("PermissionNode", PermissionNode);
        args.put("Enabled", Enabled);
        return this.APICall("Core/SetAMPRolePermission", args);
    }

    /**
     * Name TypeName Description Optional
     * @param UserId String AMPType: Guid 
     * @param RoleId String AMPType: Guid 
     * @param IsMember boolean AMPType: Boolean 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> SetAMPUserRoleMembership(String UserId, String RoleId, boolean IsMember) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UserId", UserId);
        args.put("RoleId", RoleId);
        args.put("IsMember", IsMember);
        return this.APICall("Core/SetAMPUserRoleMembership", args);
    }

    /**
     * Name TypeName Description Optional
     * @param node String AMPType: String 
     * @param value String AMPType: String 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> SetConfig(String node, String value) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("node", node);
        args.put("value", value);
        return this.APICall("Core/SetConfig", args);
    }

    /**
     * Name TypeName Description Optional
     * @param data Map<String, String> AMPType: Dictionary<String, String> 
     * @return boolean AMPType: Boolean
     */
    public Map<?, ?> SetConfigs(Map<String, String> data) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("data", data);
        return this.APICall("Core/SetConfigs", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Id String AMPType: Guid 
     * @param Enabled boolean AMPType: Boolean 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> SetTriggerEnabled(String Id, boolean Enabled) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("Enabled", Enabled);
        return this.APICall("Core/SetTriggerEnabled", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Sleep() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Sleep", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> Start() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Start", args);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> Stop() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Stop", args);
    }

    /**
     * Prevents the current instance from being started, and stops it if it's currently running.
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> Suspend() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Suspend", args);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> UpdateAMPInstance() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/UpdateAMPInstance", args);
    }

    /**
     * Name TypeName Description Optional
     * @param EmailAddress String AMPType: String 
     * @param TwoFactorPIN String AMPType: String 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> UpdateAccountInfo(String EmailAddress, String TwoFactorPIN) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("EmailAddress", EmailAddress);
        args.put("TwoFactorPIN", TwoFactorPIN);
        return this.APICall("Core/UpdateAccountInfo", args);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> UpdateApplication() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/UpdateApplication", args);
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
    public Map<?, ?> UpdateUserInfo(String Username, boolean Disabled, boolean PasswordExpires, boolean CannotChangePassword, boolean MustChangePassword, String EmailAddress) {
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
     * @return void AMPType: Void
     */
    public Map<?, ?> UpgradeAMP() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/UpgradeAMP", args);
    }

    /**
     * Name TypeName Description Optional
     * @param attestationObject String AMPType: String 
     * @param clientDataJSON String AMPType: String 
     * @param description String AMPType: String 
     * @return  AMPType: ActionResult
     */
    public Map<?, ?> WebauthnRegister(String attestationObject, String clientDataJSON, String description) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("attestationObject", attestationObject);
        args.put("clientDataJSON", clientDataJSON);
        args.put("description", description);
        return this.APICall("Core/WebauthnRegister", args);
    }

}
