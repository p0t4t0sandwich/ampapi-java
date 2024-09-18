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
public class MinecraftModule extends AMPAPI {
    public MinecraftModule(AuthProvider authProvider) {
        super(authProvider);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Boolean
     */
    public Boolean AcceptEULA() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Boolean>(){}.getType();
        return (Boolean) this.authProvider.APICall("MinecraftModule/AcceptEULA", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param UserOrUUID  False
     * @return ActionResult
     */
    public ActionResult AddOPEntry(String UserOrUUID) {
        Map<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("MinecraftModule/AddOPEntry", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param UserOrUUID  False
     * @return ActionResult
     */
    public ActionResult AddToWhitelist(String UserOrUUID) {
        Map<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authProvider.APICall("MinecraftModule/AddToWhitelist", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param ID  False
     * @return Void
     */
    public Void BanUserByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authProvider.APICall("MinecraftModule/BanUserByID", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Map<String, Object>
     */
    public Map<String, Object> BukGetCategories() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return (Map<String, Object>) this.authProvider.APICall("MinecraftModule/BukGetCategories", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param pluginId  False
     * @return RunningTask
     */
    public RunningTask BukGetInstallUpdatePlugin(Integer pluginId) {
        Map<String, Object> args = new HashMap<>();
        args.put("pluginId", pluginId);
        Type type = new TypeToken<RunningTask>(){}.getType();
        return (RunningTask) this.authProvider.APICall("MinecraftModule/BukGetInstallUpdatePlugin", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Map<String, Object>
     */
    public Map<String, Object> BukGetInstalledPlugins() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return (Map<String, Object>) this.authProvider.APICall("MinecraftModule/BukGetInstalledPlugins", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param PluginId  False
     * @return Map<String, Object>
     */
    public Map<String, Object> BukGetPluginInfo(Integer PluginId) {
        Map<String, Object> args = new HashMap<>();
        args.put("PluginId", PluginId);
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return (Map<String, Object>) this.authProvider.APICall("MinecraftModule/BukGetPluginInfo", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param CategoryId  False
     * @param PageNumber  False
     * @param PageSize  False
     * @return Map<String, Object>
     */
    public Map<String, Object> BukGetPluginsForCategory(String CategoryId, Integer PageNumber, Integer PageSize) {
        Map<String, Object> args = new HashMap<>();
        args.put("CategoryId", CategoryId);
        args.put("PageNumber", PageNumber);
        args.put("PageSize", PageSize);
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return (Map<String, Object>) this.authProvider.APICall("MinecraftModule/BukGetPluginsForCategory", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Map<String, Object>
     */
    public Map<String, Object> BukGetPopularPlugins() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return (Map<String, Object>) this.authProvider.APICall("MinecraftModule/BukGetPopularPlugins", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param PluginId  False
     * @return Void
     */
    public Void BukGetRemovePlugin(Integer PluginId) {
        Map<String, Object> args = new HashMap<>();
        args.put("PluginId", PluginId);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authProvider.APICall("MinecraftModule/BukGetRemovePlugin", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param Query  False
     * @param PageNumber  False
     * @param PageSize  False
     * @return Map<String, Object>
     */
    public Map<String, Object> BukGetSearch(String Query, Integer PageNumber, Integer PageSize) {
        Map<String, Object> args = new HashMap<>();
        args.put("Query", Query);
        args.put("PageNumber", PageNumber);
        args.put("PageSize", PageSize);
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return (Map<String, Object>) this.authProvider.APICall("MinecraftModule/BukGetSearch", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param ID  False
     * @return Void
     */
    public Void ClearInventoryByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authProvider.APICall("MinecraftModule/ClearInventoryByID", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return String
     */
    public String GetFailureReason() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<String>(){}.getType();
        return (String) this.authProvider.APICall("MinecraftModule/GetFailureReason", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param id  False
     * @return String
     */
    public String GetHeadByUUID(String id) {
        Map<String, Object> args = new HashMap<>();
        args.put("id", id);
        Type type = new TypeToken<String>(){}.getType();
        return (String) this.authProvider.APICall("MinecraftModule/GetHeadByUUID", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Map<String, Object>
     */
    public Map<String, Object> GetOPWhitelist() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return (Map<String, Object>) this.authProvider.APICall("MinecraftModule/GetOPWhitelist", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> GetWhitelist() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Map<String, Object>>>(){}.getType();
        return (List<Map<String, Object>>) this.authProvider.APICall("MinecraftModule/GetWhitelist", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param ID  False
     * @return Void
     */
    public Void KickUserByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authProvider.APICall("MinecraftModule/KickUserByID", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param ID  False
     * @return Void
     */
    public Void KillByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authProvider.APICall("MinecraftModule/KillByID", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> LoadOPList() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Map<String, Object>>>(){}.getType();
        return (List<Map<String, Object>>) this.authProvider.APICall("MinecraftModule/LoadOPList", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param UserOrUUID  False
     * @return Void
     */
    public Void RemoveOPEntry(String UserOrUUID) {
        Map<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authProvider.APICall("MinecraftModule/RemoveOPEntry", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param UserOrUUID  False
     * @return Void
     */
    public Void RemoveWhitelistEntry(String UserOrUUID) {
        Map<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authProvider.APICall("MinecraftModule/RemoveWhitelistEntry", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param ID  False
     * @return Void
     */
    public Void SmiteByID(String ID) {
        Map<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authProvider.APICall("MinecraftModule/SmiteByID", args, type);
    }

}
