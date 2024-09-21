/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.ampapi.plugins;

import com.google.gson.reflect.TypeToken;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.types.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings({
    "rawtypes",
    "unchecked",
    "unused",
    "DataFlowIssue",
    "JavadocBlankLines",
    "RedundantCast",
    "UnusedReturnValue"
})
public class Core extends AMPAPI {
    public Core(AuthProvider authProvider) {
        super(authProvider);
    }

    /**
     * Name Description Optional
     *
     * @return Void
     */
    public Void AcknowledgeAMPUpdate() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("Core/AcknowledgeAMPUpdate", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param LicenceKey False
     * @param QueryOnly True
     * @return ActionResult<LicenceInfo>
     */
    public ActionResult<LicenceInfo> ActivateAMPLicence(String LicenceKey, Boolean QueryOnly) {
        Map<String, Object> args = new HashMap<>();
        args.put("LicenceKey", LicenceKey);
        args.put("QueryOnly", QueryOnly);
        Type type = new TypeToken<ActionResult<LicenceInfo>>() {}.getType();
        return (ActionResult<LicenceInfo>) this.APICall("Core/ActivateAMPLicence", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param triggerId False
     * @return ActionResult
     */
    public ActionResult AddEventTrigger(UUID triggerId) {
        Map<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/AddEventTrigger", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param months False
     * @param days False
     * @param hours False
     * @param minutes False
     * @param daysOfMonth False
     * @param description False
     * @return ActionResult
     */
    public ActionResult AddIntervalTrigger(
            List<Integer> months,
            List<Integer> days,
            List<Integer> hours,
            List<Integer> minutes,
            List<Integer> daysOfMonth,
            String description) {
        Map<String, Object> args = new HashMap<>();
        args.put("months", months);
        args.put("days", days);
        args.put("hours", hours);
        args.put("minutes", minutes);
        args.put("daysOfMonth", daysOfMonth);
        args.put("description", description);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/AddIntervalTrigger", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param TriggerID False
     * @param MethodID False
     * @param ParameterMapping False
     * @return ActionResult
     */
    public ActionResult AddTask(
            UUID TriggerID, String MethodID, Map<String, String> ParameterMapping) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("MethodID", MethodID);
        args.put("ParameterMapping", ParameterMapping);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/AddTask", args, type);
    }

    /**
     * DEV: Async test method
     *
     * <p>Name Description Optional
     *
     * @return String
     */
    public String AsyncTest() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<String>() {}.getType();
        return (String) this.APICall("Core/AsyncTest", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param TaskId False
     * @return ActionResult
     */
    public ActionResult CancelTask(UUID TaskId) {
        Map<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/CancelTask", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param TriggerID False
     * @param TaskID False
     * @param NewOrder False
     * @return ActionResult
     */
    public ActionResult ChangeTaskOrder(UUID TriggerID, UUID TaskID, Integer NewOrder) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        args.put("NewOrder", NewOrder);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/ChangeTaskOrder", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Username False
     * @param OldPassword False
     * @param NewPassword False
     * @param TwoFactorPIN False
     * @return ActionResult
     */
    public ActionResult ChangeUserPassword(
            String Username, String OldPassword, String NewPassword, String TwoFactorPIN) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("OldPassword", OldPassword);
        args.put("NewPassword", NewPassword);
        args.put("TwoFactorPIN", TwoFactorPIN);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/ChangeUserPassword", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Username False
     * @param TwoFactorCode False
     * @return ActionResult
     */
    public ActionResult ConfirmTwoFactorSetup(String Username, String TwoFactorCode) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("TwoFactorCode", TwoFactorCode);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/ConfirmTwoFactorSetup", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Name False
     * @param AsCommonRole True
     * @return ActionResult<UUID>
     */
    public ActionResult<UUID> CreateRole(String Name, Boolean AsCommonRole) {
        Map<String, Object> args = new HashMap<>();
        args.put("Name", Name);
        args.put("AsCommonRole", AsCommonRole);
        Type type = new TypeToken<ActionResult<UUID>>() {}.getType();
        return (ActionResult<UUID>) this.APICall("Core/CreateRole", args, type);
    }

    /**
     * DEV: Creates a non-ending task with 50% progress for testing purposes
     *
     * <p>Name Description Optional
     *
     * @return Void
     */
    public Void CreateTestTask() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("Core/CreateTestTask", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Username False
     * @return ActionResult<UUID>
     */
    public ActionResult<UUID> CreateUser(String Username) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        Type type = new TypeToken<ActionResult<UUID>>() {}.getType();
        return (ActionResult<UUID>) this.APICall("Core/CreateUser", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param PermissionNode False
     * @return Boolean
     */
    public Boolean CurrentSessionHasPermission(String PermissionNode) {
        Map<String, Object> args = new HashMap<>();
        args.put("PermissionNode", PermissionNode);
        Type type = new TypeToken<Boolean>() {}.getType();
        return (Boolean) this.APICall("Core/CurrentSessionHasPermission", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param InstanceId False
     * @return ActionResult
     */
    public ActionResult DeleteInstanceUsers(UUID InstanceId) {
        Map<String, Object> args = new HashMap<>();
        args.put("InstanceId", InstanceId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/DeleteInstanceUsers", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param RoleId False
     * @return ActionResult
     */
    public ActionResult DeleteRole(UUID RoleId) {
        Map<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/DeleteRole", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param TriggerID False
     * @param TaskID False
     * @return ActionResult
     */
    public ActionResult DeleteTask(UUID TriggerID, UUID TaskID) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/DeleteTask", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param TriggerID False
     * @return ActionResult
     */
    public ActionResult DeleteTrigger(UUID TriggerID) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/DeleteTrigger", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Username False
     * @return ActionResult
     */
    public ActionResult DeleteUser(String Username) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/DeleteUser", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Password False
     * @param TwoFactorCode False
     * @return ActionResult
     */
    public ActionResult DisableTwoFactor(String Password, String TwoFactorCode) {
        Map<String, Object> args = new HashMap<>();
        args.put("Password", Password);
        args.put("TwoFactorCode", TwoFactorCode);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/DisableTwoFactor", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return ActionResult
     */
    public ActionResult DismissAllTasks() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/DismissAllTasks", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param TaskId False
     * @return ActionResult
     */
    public ActionResult DismissTask(UUID TaskId) {
        Map<String, Object> args = new HashMap<>();
        args.put("TaskId", TaskId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/DismissTask", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Id False
     * @param months False
     * @param days False
     * @param hours False
     * @param minutes False
     * @param daysOfMonth False
     * @param description False
     * @return ActionResult
     */
    public ActionResult EditIntervalTrigger(
            UUID Id,
            List<Integer> months,
            List<Integer> days,
            List<Integer> hours,
            List<Integer> minutes,
            List<Integer> daysOfMonth,
            String description) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("months", months);
        args.put("days", days);
        args.put("hours", hours);
        args.put("minutes", minutes);
        args.put("daysOfMonth", daysOfMonth);
        args.put("description", description);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/EditIntervalTrigger", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param TriggerID False
     * @param TaskID False
     * @param ParameterMapping False
     * @return ActionResult
     */
    public ActionResult EditTask(
            UUID TriggerID, UUID TaskID, Map<String, String> ParameterMapping) {
        Map<String, Object> args = new HashMap<>();
        args.put("TriggerID", TriggerID);
        args.put("TaskID", TaskID);
        args.put("ParameterMapping", ParameterMapping);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/EditTask", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Username False
     * @param Password False
     * @return ActionResult<Object>
     */
    public ActionResult<Object> EnableTwoFactor(String Username, String Password) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("Password", Password);
        Type type = new TypeToken<ActionResult<Object>>() {}.getType();
        return (ActionResult<Object>) this.APICall("Core/EnableTwoFactor", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Id False
     * @return Void
     */
    public Void EndUserSession(UUID Id) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("Core/EndUserSession", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param RoleId False
     * @return List<String>
     */
    public List<String> GetAMPRolePermissions(UUID RoleId) {
        Map<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        Type type = new TypeToken<List<String>>() {}.getType();
        return (List<String>) this.APICall("Core/GetAMPRolePermissions", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Username False
     * @return UserInfo
     */
    public UserInfo GetAMPUserInfo(String Username) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        Type type = new TypeToken<UserInfo>() {}.getType();
        return (UserInfo) this.APICall("Core/GetAMPUserInfo", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return List<Object>
     */
    public List<Object> GetAMPUsersSummary() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Object>>() {}.getType();
        return (List<Object>) this.APICall("Core/GetAMPUsersSummary", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return Map<String, Map<String, Object>>
     */
    public Map<String, Map<String, Object>> GetAPISpec() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, Map<String, Object>>>() {}.getType();
        return (Map<String, Map<String, Object>>) this.APICall("Core/GetAPISpec", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return List<Object>
     */
    public List<Object> GetActiveAMPSessions() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Object>>() {}.getType();
        return (List<Object>) this.APICall("Core/GetActiveAMPSessions", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return List<UserInfo>
     */
    public List<UserInfo> GetAllAMPUserInfo() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<UserInfo>>() {}.getType();
        return (List<UserInfo>) this.APICall("Core/GetAllAMPUserInfo", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Before False
     * @param Count False
     * @return List<Object>
     */
    public List<Object> GetAuditLogEntries(Object Before, Integer Count) {
        Map<String, Object> args = new HashMap<>();
        args.put("Before", Before);
        args.put("Count", Count);
        Type type = new TypeToken<List<Object>>() {}.getType();
        return (List<Object>) this.APICall("Core/GetAuditLogEntries", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param node False
     * @return Map<String, Object>
     */
    public Map<String, Object> GetConfig(String node) {
        Map<String, Object> args = new HashMap<>();
        args.put("node", node);
        Type type = new TypeToken<Map<String, Object>>() {}.getType();
        return (Map<String, Object>) this.APICall("Core/GetConfig", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param nodes False
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> GetConfigs(List<String> nodes) {
        Map<String, Object> args = new HashMap<>();
        args.put("nodes", nodes);
        Type type = new TypeToken<List<Map<String, Object>>>() {}.getType();
        return (List<Map<String, Object>>) this.APICall("Core/GetConfigs", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return Map<String, String>
     */
    public Map<String, String> GetDiagnosticsInfo() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        return (Map<String, String>) this.APICall("Core/GetDiagnosticsInfo", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return ModuleInfo
     */
    public ModuleInfo GetModuleInfo() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ModuleInfo>() {}.getType();
        return (ModuleInfo) this.APICall("Core/GetModuleInfo", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return UUID
     */
    public UUID GetNewGuid() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<UUID>() {}.getType();
        return (UUID) this.APICall("Core/GetNewGuid", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return List<Object>
     */
    public List<Object> GetPermissionsSpec() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Object>>() {}.getType();
        return (List<Object>) this.APICall("Core/GetPermissionsSpec", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return List<Object>
     */
    public List<Object> GetPortSummaries() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Object>>() {}.getType();
        return (List<Object>) this.APICall("Core/GetPortSummaries", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> GetProvisionSpec() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Map<String, Object>>>() {}.getType();
        return (List<Map<String, Object>>) this.APICall("Core/GetProvisionSpec", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Description True
     * @param IsTemporary True
     * @return String
     */
    public String GetRemoteLoginToken(String Description, Boolean IsTemporary) {
        Map<String, Object> args = new HashMap<>();
        args.put("Description", Description);
        args.put("IsTemporary", IsTemporary);
        Type type = new TypeToken<String>() {}.getType();
        return (String) this.APICall("Core/GetRemoteLoginToken", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param RoleId False
     * @return Object
     */
    public Object GetRole(UUID RoleId) {
        Map<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        Type type = new TypeToken<Object>() {}.getType();
        return (Object) this.APICall("Core/GetRole", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return List<Object>
     */
    public List<Object> GetRoleData() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Object>>() {}.getType();
        return (List<Object>) this.APICall("Core/GetRoleData", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return Map<UUID, String>
     */
    public Map<UUID, String> GetRoleIds() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<UUID, String>>() {}.getType();
        return (Map<UUID, String>) this.APICall("Core/GetRoleIds", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return Object
     */
    public Object GetScheduleData() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Object>() {}.getType();
        return (Object) this.APICall("Core/GetScheduleData", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param SettingNode False
     * @param WithRefresh True
     * @return Map<String, String>
     */
    public Map<String, String> GetSettingValues(String SettingNode, Boolean WithRefresh) {
        Map<String, Object> args = new HashMap<>();
        args.put("SettingNode", SettingNode);
        args.put("WithRefresh", WithRefresh);
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        return (Map<String, String>) this.APICall("Core/GetSettingValues", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return Map<String, SettingSpec>
     */
    public Map<String, SettingSpec> GetSettingsSpec() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, SettingSpec>>() {}.getType();
        return (Map<String, SettingSpec>) this.APICall("Core/GetSettingsSpec", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return Status
     */
    public Status GetStatus() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Status>() {}.getType();
        return (Status) this.APICall("Core/GetStatus", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return List<RunningTask>
     */
    public List<RunningTask> GetTasks() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<RunningTask>>() {}.getType();
        return (List<RunningTask>) this.APICall("Core/GetTasks", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Id False
     * @return Object
     */
    public Object GetTimeIntervalTrigger(UUID Id) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        Type type = new TypeToken<Object>() {}.getType();
        return (Object) this.APICall("Core/GetTimeIntervalTrigger", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return UpdateInfo
     */
    public UpdateInfo GetUpdateInfo() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<UpdateInfo>() {}.getType();
        return (UpdateInfo) this.APICall("Core/GetUpdateInfo", args, type);
    }

    /**
     * Gets changes to the server status, in addition to any notifications or console output that
     * have occured since the last time GetUpdates() was called by the current session.
     *
     * <p>Name Description Optional
     *
     * @return Updates
     */
    public Updates GetUpdates() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Updates>() {}.getType();
        return (Updates) this.APICall("Core/GetUpdates", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return Object
     */
    public Object GetUserActionsSpec() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Object>() {}.getType();
        return (Object) this.APICall("Core/GetUserActionsSpec", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param UID False
     * @return Object
     */
    public Object GetUserInfo(String UID) {
        Map<String, Object> args = new HashMap<>();
        args.put("UID", UID);
        Type type = new TypeToken<Object>() {}.getType();
        return (Object) this.APICall("Core/GetUserInfo", args, type);
    }

    /**
     * Returns a list of in-application users
     *
     * <p>Name Description Optional
     *
     * @return Map<String, String>
     */
    public Map<String, String> GetUserList() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        return (Map<String, String>) this.APICall("Core/GetUserList", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return ActionResult<String>
     */
    public ActionResult<String> GetWebauthnChallenge() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult<String>>() {}.getType();
        return (ActionResult<String>) this.APICall("Core/GetWebauthnChallenge", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param username False
     * @return Object
     */
    public Object GetWebauthnCredentialIDs(String username) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", username);
        Type type = new TypeToken<Object>() {}.getType();
        return (Object) this.APICall("Core/GetWebauthnCredentialIDs", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return List<Object>
     */
    public List<Object> GetWebauthnCredentialSummaries() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Object>>() {}.getType();
        return (List<Object>) this.APICall("Core/GetWebauthnCredentialSummaries", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return Object
     */
    public Object GetWebserverMetrics() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Object>() {}.getType();
        return (Object) this.APICall("Core/GetWebserverMetrics", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return Void
     */
    public Void Kill() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("Core/Kill", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param username False
     * @param password False
     * @param token False
     * @param rememberMe False
     * @return LoginResult
     */
    public LoginResult Login(String username, String password, String token, Boolean rememberMe) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", username);
        args.put("password", password);
        args.put("token", token);
        args.put("rememberMe", rememberMe);
        Type type = new TypeToken<LoginResult>() {}.getType();
        return (LoginResult) this.APICall("Core/Login", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return Void
     */
    public Void Logout() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("Core/Logout", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Node False
     * @return ActionResult
     */
    public ActionResult RefreshSettingValueList(String Node) {
        Map<String, Object> args = new HashMap<>();
        args.put("Node", Node);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/RefreshSettingValueList", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return Void
     */
    public Void RefreshSettingsSourceCache() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("Core/RefreshSettingsSourceCache", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param RoleId False
     * @param NewName False
     * @return ActionResult
     */
    public ActionResult RenameRole(UUID RoleId, String NewName) {
        Map<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("NewName", NewName);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/RenameRole", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Username False
     * @param NewPassword False
     * @return ActionResult
     */
    public ActionResult ResetUserPassword(String Username, String NewPassword) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("NewPassword", NewPassword);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/ResetUserPassword", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return ActionResult
     */
    public ActionResult Restart() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/Restart", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return Void
     */
    public Void RestartAMP() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("Core/RestartAMP", args, type);
    }

    /**
     * Allows the service to be re-started after previously being suspended.
     *
     * <p>Name Description Optional
     *
     * @return Void
     */
    public Void Resume() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("Core/Resume", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param ID False
     * @return ActionResult
     */
    public ActionResult RevokeWebauthnCredential(Integer ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/RevokeWebauthnCredential", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param triggerId False
     * @return ActionResult
     */
    public ActionResult RunEventTriggerImmediately(UUID triggerId) {
        Map<String, Object> args = new HashMap<>();
        args.put("triggerId", triggerId);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/RunEventTriggerImmediately", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param message False
     * @return Void
     */
    public Void SendConsoleMessage(String message) {
        Map<String, Object> args = new HashMap<>();
        args.put("message", message);
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("Core/SendConsoleMessage", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param RoleId False
     * @param PermissionNode False
     * @param Enabled False
     * @return ActionResult
     */
    public ActionResult SetAMPRolePermission(UUID RoleId, String PermissionNode, Boolean Enabled) {
        Map<String, Object> args = new HashMap<>();
        args.put("RoleId", RoleId);
        args.put("PermissionNode", PermissionNode);
        args.put("Enabled", Enabled);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/SetAMPRolePermission", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param UserId False
     * @param RoleId False
     * @param IsMember False
     * @return ActionResult
     */
    public ActionResult SetAMPUserRoleMembership(UUID UserId, UUID RoleId, Boolean IsMember) {
        Map<String, Object> args = new HashMap<>();
        args.put("UserId", UserId);
        args.put("RoleId", RoleId);
        args.put("IsMember", IsMember);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/SetAMPUserRoleMembership", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param node False
     * @param value False
     * @return ActionResult
     */
    public ActionResult SetConfig(String node, String value) {
        Map<String, Object> args = new HashMap<>();
        args.put("node", node);
        args.put("value", value);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/SetConfig", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param data False
     * @return Boolean
     */
    public Boolean SetConfigs(Map<String, String> data) {
        Map<String, Object> args = new HashMap<>();
        args.put("data", data);
        Type type = new TypeToken<Boolean>() {}.getType();
        return (Boolean) this.APICall("Core/SetConfigs", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Id False
     * @param Enabled False
     * @return ActionResult
     */
    public ActionResult SetTriggerEnabled(UUID Id, Boolean Enabled) {
        Map<String, Object> args = new HashMap<>();
        args.put("Id", Id);
        args.put("Enabled", Enabled);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/SetTriggerEnabled", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return ActionResult
     */
    public ActionResult Sleep() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/Sleep", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return ActionResult
     */
    public ActionResult Start() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/Start", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return Void
     */
    public Void Stop() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("Core/Stop", args, type);
    }

    /**
     * Prevents the current instance from being started, and stops it if it's currently running.
     *
     * <p>Name Description Optional
     *
     * @return Void
     */
    public Void Suspend() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("Core/Suspend", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return Void
     */
    public Void UpdateAMPInstance() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("Core/UpdateAMPInstance", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param EmailAddress False
     * @param TwoFactorPIN False
     * @return ActionResult
     */
    public ActionResult UpdateAccountInfo(String EmailAddress, String TwoFactorPIN) {
        Map<String, Object> args = new HashMap<>();
        args.put("EmailAddress", EmailAddress);
        args.put("TwoFactorPIN", TwoFactorPIN);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/UpdateAccountInfo", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return ActionResult
     */
    public ActionResult UpdateApplication() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/UpdateApplication", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param Username False
     * @param Disabled False
     * @param PasswordExpires False
     * @param CannotChangePassword False
     * @param MustChangePassword False
     * @param EmailAddress True
     * @return ActionResult
     */
    public ActionResult UpdateUserInfo(
            String Username,
            Boolean Disabled,
            Boolean PasswordExpires,
            Boolean CannotChangePassword,
            Boolean MustChangePassword,
            String EmailAddress) {
        Map<String, Object> args = new HashMap<>();
        args.put("Username", Username);
        args.put("Disabled", Disabled);
        args.put("PasswordExpires", PasswordExpires);
        args.put("CannotChangePassword", CannotChangePassword);
        args.put("MustChangePassword", MustChangePassword);
        args.put("EmailAddress", EmailAddress);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/UpdateUserInfo", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return Void
     */
    public Void UpgradeAMP() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("Core/UpgradeAMP", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param attestationObject False
     * @param clientDataJSON False
     * @param description True
     * @return ActionResult
     */
    public ActionResult WebauthnRegister(
            String attestationObject, String clientDataJSON, String description) {
        Map<String, Object> args = new HashMap<>();
        args.put("attestationObject", attestationObject);
        args.put("clientDataJSON", clientDataJSON);
        args.put("description", description);
        Type type = new TypeToken<ActionResult>() {}.getType();
        return (ActionResult) this.APICall("Core/WebauthnRegister", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param username False
     * @return List<Object>
     */
    public List<Object> GetAuthenticationRequirements(String username) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", username);
        Type type = new TypeToken<List<Object>>() {}.getType();
        return (List<Object>) this.APICall("Core/GetAuthenticationRequirements", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> RunSecurityCheck() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Map<String, Object>>>() {}.getType();
        return (List<Map<String, Object>>) this.APICall("Core/RunSecurityCheck", args, type);
    }
}
