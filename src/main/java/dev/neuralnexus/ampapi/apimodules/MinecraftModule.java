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

public class MinecraftModule extends AMPAPI {
    public MinecraftModule(AuthStore authStore, String instanceName) {
        super(authStore, instanceName);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Boolean
     */
    public Boolean AcceptEULA() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Boolean>(){}.getType();
        return (Boolean) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param UserOrUUID  False
     * @return ActionResult
     */
    public ActionResult AddOPEntry(String UserOrUUID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param UserOrUUID  False
     * @return ActionResult
     */
    public ActionResult AddToWhitelist(String UserOrUUID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param ID  False
     * @return Void
     */
    public Void BanUserByID(String ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Map<String, Object>
     */
    public Map<String, Object> BukGetCategories() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return (Map<String, Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param pluginId  False
     * @return RunningTask
     */
    public RunningTask BukGetInstallUpdatePlugin(Integer pluginId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("pluginId", pluginId);
        Type type = new TypeToken<RunningTask>(){}.getType();
        return (RunningTask) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Map<String, Object>
     */
    public Map<String, Object> BukGetInstalledPlugins() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return (Map<String, Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param PluginId  False
     * @return Map<String, Object>
     */
    public Map<String, Object> BukGetPluginInfo(Integer PluginId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("PluginId", PluginId);
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return (Map<String, Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        HashMap<String, Object> args = new HashMap<>();
        args.put("CategoryId", CategoryId);
        args.put("PageNumber", PageNumber);
        args.put("PageSize", PageSize);
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return (Map<String, Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Map<String, Object>
     */
    public Map<String, Object> BukGetPopularPlugins() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return (Map<String, Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param PluginId  False
     * @return Void
     */
    public Void BukGetRemovePlugin(Integer PluginId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("PluginId", PluginId);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
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
        HashMap<String, Object> args = new HashMap<>();
        args.put("Query", Query);
        args.put("PageNumber", PageNumber);
        args.put("PageSize", PageSize);
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return (Map<String, Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param ID  False
     * @return Void
     */
    public Void ClearInventoryByID(String ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return String
     */
    public String GetFailureReason() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<String>(){}.getType();
        return (String) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param id  False
     * @return String
     */
    public String GetHeadByUUID(String id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        Type type = new TypeToken<String>(){}.getType();
        return (String) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Map<String, Object>
     */
    public Map<String, Object> GetOPWhitelist() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Map<String, Object>>(){}.getType();
        return (Map<String, Object>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> GetWhitelist() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Map<String, Object>>>(){}.getType();
        return (List<Map<String, Object>>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param ID  False
     * @return Void
     */
    public Void KickUserByID(String ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param ID  False
     * @return Void
     */
    public Void KillByID(String ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> LoadOPList() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<List<Map<String, Object>>>(){}.getType();
        return (List<Map<String, Object>>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param UserOrUUID  False
     * @return Void
     */
    public Void RemoveOPEntry(String UserOrUUID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param UserOrUUID  False
     * @return Void
     */
    public Void RemoveWhitelistEntry(String UserOrUUID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param ID  False
     * @return Void
     */
    public Void SmiteByID(String ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

}
