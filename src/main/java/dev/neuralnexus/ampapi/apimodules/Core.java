package dev.neuralnexus.ampapi.apimodules;

import dev.neuralnexus.ampapi.AMPAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return this.APICall("Core/AcknowledgeAMPUpdate", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param triggerId  False
     * @return Map
     */
    public Map AddEventTrigger(String triggerId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        return this.APICall("Core/AddEventTrigger", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param months  False
     * @param days  False
     * @param hours  False
     * @param minutes  False
     * @param daysOfMonth  False
     * @param description  False
     * @return Map
     */
    public Map AddIntervalTrigger(List<Integer> months, List<Integer> days, List<Integer> hours, List<Integer> minutes, List<Integer> daysOfMonth, String description) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("months", months);
        args.put("days", days);
        args.put("hours", hours);
        args.put("minutes", minutes);
        args.put("daysOfMonth", daysOfMonth);
        args.put("description", description);
        return this.APICall("Core/AddIntervalTrigger", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param TriggerID  False
     * @param MethodID  False
     * @param ParameterMapping  False
     * @return Map
     */
    public Map AddTask(String TriggerID, String MethodID, Map ParameterMapping) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("MethodID", MethodID);
        args.put("ParameterMapping", ParameterMapping);
        return this.APICall("Core/AddTask", args, Map.class);
    }

    /**
     * DEV: Async test method
     * Name Description Optional
     * @return Map
     */
    public Map AsyncTest() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/AsyncTest", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param TaskId  False
     * @return Map
     */
    public Map CancelTask(String TaskId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        return this.APICall("Core/CancelTask", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param TriggerID  False
     * @param TaskID  False
     * @param NewOrder  False
     * @return Map
     */
    public Map ChangeTaskOrder(String TriggerID, String TaskID, Integer NewOrder) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        args.put("NewOrder", NewOrder);
        return this.APICall("Core/ChangeTaskOrder", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param Username  False
     * @param OldPassword  False
     * @param NewPassword  False
     * @param TwoFactorPIN  False
     * @return Map
     */
    public Map ChangeUserPassword(String Username, String OldPassword, String NewPassword, String TwoFactorPIN) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("OldPassword", OldPassword);
        args.put("NewPassword", NewPassword);
        args.put("TwoFactorPIN", TwoFactorPIN);
        return this.APICall("Core/ChangeUserPassword", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param Username  False
     * @param TwoFactorCode  False
     * @return Map
     */
    public Map ConfirmTwoFactorSetup(String Username, String TwoFactorCode) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("TwoFactorCode", TwoFactorCode);
        return this.APICall("Core/ConfirmTwoFactorSetup", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param Name  False
     * @param AsCommonRole  True
     * @return Map
     */
    public Map CreateRole(String Name, boolean AsCommonRole) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        args.put("AsCommonRole", AsCommonRole);
        return this.APICall("Core/CreateRole", args, Map.class);
    }

    /**
     * DEV: Creates a non-ending task with 50% progress for testing purposes
     * Name Description Optional
     * @return Void
     */
    public Void CreateTestTask() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/CreateTestTask", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param Username  False
     * @return Map
     */
    public Map CreateUser(String Username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        return this.APICall("Core/CreateUser", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param PermissionNode  False
     * @return boolean
     */
    public boolean CurrentSessionHasPermission(String PermissionNode) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("PermissionNode", PermissionNode);
        return this.APICall("Core/CurrentSessionHasPermission", args, boolean.class);
    }

    /**
     * Name Description Optional
     * @param InstanceId  False
     * @return Map
     */
    public Map DeleteInstanceUsers(String InstanceId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        return this.APICall("Core/DeleteInstanceUsers", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param RoleId  False
     * @return Map
     */
    public Map DeleteRole(String RoleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        return this.APICall("Core/DeleteRole", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param TriggerID  False
     * @param TaskID  False
     * @return Map
     */
    public Map DeleteTask(String TriggerID, String TaskID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        return this.APICall("Core/DeleteTask", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param TriggerID  False
     * @return Map
     */
    public Map DeleteTrigger(String TriggerID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        return this.APICall("Core/DeleteTrigger", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param Username  False
     * @return Map
     */
    public Map DeleteUser(String Username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        return this.APICall("Core/DeleteUser", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param Password  False
     * @param TwoFactorCode  False
     * @return Map
     */
    public Map DisableTwoFactor(String Password, String TwoFactorCode) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Password", Password);
        args.put("TwoFactorCode", TwoFactorCode);
        return this.APICall("Core/DisableTwoFactor", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map DismissAllTasks() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/DismissAllTasks", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param TaskId  False
     * @return Map
     */
    public Map DismissTask(String TaskId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        return this.APICall("Core/DismissTask", args, Map.class);
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
     * @return Map
     */
    public Map EditIntervalTrigger(String Id, List<Integer> months, List<Integer> days, List<Integer> hours, List<Integer> minutes, List<Integer> daysOfMonth, String description) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("months", months);
        args.put("days", days);
        args.put("hours", hours);
        args.put("minutes", minutes);
        args.put("daysOfMonth", daysOfMonth);
        args.put("description", description);
        return this.APICall("Core/EditIntervalTrigger", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param TriggerID  False
     * @param TaskID  False
     * @param ParameterMapping  False
     * @return Map
     */
    public Map EditTask(String TriggerID, String TaskID, Map ParameterMapping) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        args.put("ParameterMapping", ParameterMapping);
        return this.APICall("Core/EditTask", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param Username  False
     * @param Password  False
     * @return Map
     */
    public Map EnableTwoFactor(String Username, String Password) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("Password", Password);
        return this.APICall("Core/EnableTwoFactor", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param Id  False
     * @return Void
     */
    public Void EndUserSession(String Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("Core/EndUserSession", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param RoleId  False
     * @return Map
     */
    public Map GetAMPRolePermissions(String RoleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        return this.APICall("Core/GetAMPRolePermissions", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param Username  False
     * @return Map
     */
    public Map GetAMPUserInfo(String Username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        return this.APICall("Core/GetAMPUserInfo", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map GetAMPUsersSummary() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetAMPUsersSummary", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map GetAPISpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetAPISpec", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return List
     */
    public List GetActiveAMPSessions() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetActiveAMPSessions", args, List.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map GetAllAMPUserInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetAllAMPUserInfo", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param Before  False
     * @param Count  False
     * @return Map
     */
    public Map GetAuditLogEntries(Object Before, Integer Count) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Before", Before);
        args.put("Count", Count);
        return this.APICall("Core/GetAuditLogEntries", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param node  False
     * @return Map
     */
    public Map GetConfig(String node) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("node", node);
        return this.APICall("Core/GetConfig", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param nodes  False
     * @return List
     */
    public List GetConfigs(List nodes) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("nodes", nodes);
        return this.APICall("Core/GetConfigs", args, List.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map GetDiagnosticsInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetDiagnosticsInfo", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map GetModuleInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetModuleInfo", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return String
     */
    public String GetNewGuid() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetNewGuid", args, String.class);
    }

    /**
     * Name Description Optional
     * @return List
     */
    public List GetPermissionsSpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetPermissionsSpec", args, List.class);
    }

    /**
     * Name Description Optional
     * @return List
     */
    public List GetPortSummaries() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetPortSummaries", args, List.class);
    }

    /**
     * Name Description Optional
     * @return List
     */
    public List GetProvisionSpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetProvisionSpec", args, List.class);
    }

    /**
     * Name Description Optional
     * @param Description  True
     * @param IsTemporary  True
     * @return Map
     */
    public Map GetRemoteLoginToken(String Description, boolean IsTemporary) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Description", Description);
        args.put("IsTemporary", IsTemporary);
        return this.APICall("Core/GetRemoteLoginToken", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param RoleId  False
     * @return Map
     */
    public Map GetRole(String RoleId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        return this.APICall("Core/GetRole", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map GetRoleData() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetRoleData", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map GetRoleIds() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetRoleIds", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map GetScheduleData() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetScheduleData", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param SettingNode  False
     * @param WithRefresh  True
     * @return Map
     */
    public Map GetSettingValues(String SettingNode, boolean WithRefresh) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("SettingNode", SettingNode);
        args.put("WithRefresh", WithRefresh);
        return this.APICall("Core/GetSettingValues", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map GetSettingsSpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetSettingsSpec", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map GetStatus() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetStatus", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map GetTasks() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetTasks", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param Id  False
     * @return Map
     */
    public Map GetTimeIntervalTrigger(String Id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        return this.APICall("Core/GetTimeIntervalTrigger", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map GetUpdateInfo() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetUpdateInfo", args, Map.class);
    }

    /**
     * Gets changes to the server status, in addition to any notifications or console output that have occured since the last time GetUpdates() was called by the current session.
     * Name Description Optional
     * @return Map
     */
    public Map GetUpdates() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetUpdates", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map GetUserActionsSpec() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetUserActionsSpec", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param UID  False
     * @return Map
     */
    public Map GetUserInfo(String UID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UID", UID);
        return this.APICall("Core/GetUserInfo", args, Map.class);
    }

    /**
     * Returns a list of in-application users
     * Name Description Optional
     * @return Map
     */
    public Map GetUserList() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetUserList", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map GetWebauthnChallenge() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetWebauthnChallenge", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param username  False
     * @return Map
     */
    public Map GetWebauthnCredentialIDs(String username) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("username", username);
        return this.APICall("Core/GetWebauthnCredentialIDs", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return List
     */
    public List GetWebauthnCredentialSummaries() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetWebauthnCredentialSummaries", args, List.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map GetWebserverMetrics() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/GetWebserverMetrics", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Void
     */
    public Void Kill() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Kill", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param username  False
     * @param password  False
     * @param token  False
     * @param rememberMe  False
     * @return Map
     */
    public Map Login(String username, String password, String token, boolean rememberMe) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("username", username);
        args.put("password", password);
        args.put("token", token);
        args.put("rememberMe", rememberMe);
        return this.APICall("Core/Login", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Void
     */
    public Void Logout() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Logout", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param Node  False
     * @return Map
     */
    public Map RefreshSettingValueList(String Node) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Node", Node);
        return this.APICall("Core/RefreshSettingValueList", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Void
     */
    public Void RefreshSettingsSourceCache() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/RefreshSettingsSourceCache", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param RoleId  False
     * @param NewName  False
     * @return Map
     */
    public Map RenameRole(String RoleId, String NewName) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("NewName", NewName);
        return this.APICall("Core/RenameRole", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param Username  False
     * @param NewPassword  False
     * @return Map
     */
    public Map ResetUserPassword(String Username, String NewPassword) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("NewPassword", NewPassword);
        return this.APICall("Core/ResetUserPassword", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map Restart() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Restart", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Void
     */
    public Void RestartAMP() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/RestartAMP", args, Void.class);
    }

    /**
     * Allows the service to be re-started after previously being suspended.
     * Name Description Optional
     * @return Void
     */
    public Void Resume() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Resume", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param ID  False
     * @return Map
     */
    public Map RevokeWebauthnCredential(Integer ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        return this.APICall("Core/RevokeWebauthnCredential", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param triggerId  False
     * @return Map
     */
    public Map RunEventTriggerImmediately(String triggerId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        return this.APICall("Core/RunEventTriggerImmediately", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param message  False
     * @return Void
     */
    public Void SendConsoleMessage(String message) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("message", message);
        return this.APICall("Core/SendConsoleMessage", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param RoleId  False
     * @param PermissionNode  False
     * @param Enabled  False
     * @return Map
     */
    public Map SetAMPRolePermission(String RoleId, String PermissionNode, boolean Enabled) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("PermissionNode", PermissionNode);
        args.put("Enabled", Enabled);
        return this.APICall("Core/SetAMPRolePermission", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param UserId  False
     * @param RoleId  False
     * @param IsMember  False
     * @return Map
     */
    public Map SetAMPUserRoleMembership(String UserId, String RoleId, boolean IsMember) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UserId", UserId);
        args.put("RoleId", RoleId);
        args.put("IsMember", IsMember);
        return this.APICall("Core/SetAMPUserRoleMembership", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param node  False
     * @param value  False
     * @return Map
     */
    public Map SetConfig(String node, String value) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("node", node);
        args.put("value", value);
        return this.APICall("Core/SetConfig", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param data  False
     * @return boolean
     */
    public boolean SetConfigs(Map data) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("data", data);
        return this.APICall("Core/SetConfigs", args, boolean.class);
    }

    /**
     * Name Description Optional
     * @param Id  False
     * @param Enabled  False
     * @return Map
     */
    public Map SetTriggerEnabled(String Id, boolean Enabled) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("Enabled", Enabled);
        return this.APICall("Core/SetTriggerEnabled", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map Sleep() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Sleep", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map Start() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Start", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Void
     */
    public Void Stop() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Stop", args, Void.class);
    }

    /**
     * Prevents the current instance from being started, and stops it if it's currently running.
     * Name Description Optional
     * @return Void
     */
    public Void Suspend() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/Suspend", args, Void.class);
    }

    /**
     * Name Description Optional
     * @return Void
     */
    public Void UpdateAMPInstance() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/UpdateAMPInstance", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param EmailAddress  False
     * @param TwoFactorPIN  False
     * @return Map
     */
    public Map UpdateAccountInfo(String EmailAddress, String TwoFactorPIN) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("EmailAddress", EmailAddress);
        args.put("TwoFactorPIN", TwoFactorPIN);
        return this.APICall("Core/UpdateAccountInfo", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map UpdateApplication() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/UpdateApplication", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param Username  False
     * @param Disabled  False
     * @param PasswordExpires  False
     * @param CannotChangePassword  False
     * @param MustChangePassword  False
     * @param EmailAddress  True
     * @return Map
     */
    public Map UpdateUserInfo(String Username, boolean Disabled, boolean PasswordExpires, boolean CannotChangePassword, boolean MustChangePassword, String EmailAddress) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("Disabled", Disabled);
        args.put("PasswordExpires", PasswordExpires);
        args.put("CannotChangePassword", CannotChangePassword);
        args.put("MustChangePassword", MustChangePassword);
        args.put("EmailAddress", EmailAddress);
        return this.APICall("Core/UpdateUserInfo", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Void
     */
    public Void UpgradeAMP() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("Core/UpgradeAMP", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param attestationObject  False
     * @param clientDataJSON  False
     * @param description  True
     * @return Map
     */
    public Map WebauthnRegister(String attestationObject, String clientDataJSON, String description) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("attestationObject", attestationObject);
        args.put("clientDataJSON", clientDataJSON);
        args.put("description", description);
        return this.APICall("Core/WebauthnRegister", args, Map.class);
    }

}
