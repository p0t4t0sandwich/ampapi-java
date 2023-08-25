package dev.neuralnexus.ampapi.apimodules;

import dev.neuralnexus.ampapi.AMPAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinecraftModule extends AMPAPI {
    public MinecraftModule(AMPAPI ampapi) {
        super(ampapi);
    }

    /**
     * Name Description Optional
     * @return boolean
     */
    public boolean AcceptEULA() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("MinecraftModule/AcceptEULA", args, boolean.class);
    }

    /**
     * Name Description Optional
     * @param UserOrUUID  False
     * @return Map
     */
    public Map AddOPEntry(String UserOrUUID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        return this.APICall("MinecraftModule/AddOPEntry", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param UserOrUUID  False
     * @return Map
     */
    public Map AddToWhitelist(String UserOrUUID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        return this.APICall("MinecraftModule/AddToWhitelist", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param ID  False
     * @return Void
     */
    public Void BanUserByID(String ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        return this.APICall("MinecraftModule/BanUserByID", args, Void.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map BukGetCategories() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("MinecraftModule/BukGetCategories", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param pluginId  False
     * @return Map
     */
    public Map BukGetInstallUpdatePlugin(Integer pluginId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("pluginId", pluginId);
        return this.APICall("MinecraftModule/BukGetInstallUpdatePlugin", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map BukGetInstalledPlugins() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("MinecraftModule/BukGetInstalledPlugins", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param PluginId  False
     * @return Map
     */
    public Map BukGetPluginInfo(Integer PluginId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("PluginId", PluginId);
        return this.APICall("MinecraftModule/BukGetPluginInfo", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param CategoryId  False
     * @param PageNumber  False
     * @param PageSize  False
     * @return Map
     */
    public Map BukGetPluginsForCategory(String CategoryId, Integer PageNumber, Integer PageSize) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("CategoryId", CategoryId);
        args.put("PageNumber", PageNumber);
        args.put("PageSize", PageSize);
        return this.APICall("MinecraftModule/BukGetPluginsForCategory", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map BukGetPopularPlugins() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("MinecraftModule/BukGetPopularPlugins", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param PluginId  False
     * @return Void
     */
    public Void BukGetRemovePlugin(Integer PluginId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("PluginId", PluginId);
        return this.APICall("MinecraftModule/BukGetRemovePlugin", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param Query  False
     * @param PageNumber  False
     * @param PageSize  False
     * @return Map
     */
    public Map BukGetSearch(String Query, Integer PageNumber, Integer PageSize) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Query", Query);
        args.put("PageNumber", PageNumber);
        args.put("PageSize", PageSize);
        return this.APICall("MinecraftModule/BukGetSearch", args, Map.class);
    }

    /**
     * Name Description Optional
     * @param ID  False
     * @return Void
     */
    public Void ClearInventoryByID(String ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        return this.APICall("MinecraftModule/ClearInventoryByID", args, Void.class);
    }

    /**
     * Name Description Optional
     * @return String
     */
    public String GetFailureReason() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("MinecraftModule/GetFailureReason", args, String.class);
    }

    /**
     * Name Description Optional
     * @param id  False
     * @return String
     */
    public String GetHeadByUUID(String id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return this.APICall("MinecraftModule/GetHeadByUUID", args, String.class);
    }

    /**
     * Name Description Optional
     * @return Map
     */
    public Map GetOPWhitelist() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("MinecraftModule/GetOPWhitelist", args, Map.class);
    }

    /**
     * Name Description Optional
     * @return List
     */
    public List GetWhitelist() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("MinecraftModule/GetWhitelist", args, List.class);
    }

    /**
     * Name Description Optional
     * @param ID  False
     * @return Void
     */
    public Void KickUserByID(String ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        return this.APICall("MinecraftModule/KickUserByID", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param ID  False
     * @return Void
     */
    public Void KillByID(String ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        return this.APICall("MinecraftModule/KillByID", args, Void.class);
    }

    /**
     * Name Description Optional
     * @return List
     */
    public List LoadOPList() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("MinecraftModule/LoadOPList", args, List.class);
    }

    /**
     * Name Description Optional
     * @param UserOrUUID  False
     * @return Void
     */
    public Void RemoveOPEntry(String UserOrUUID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        return this.APICall("MinecraftModule/RemoveOPEntry", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param UserOrUUID  False
     * @return Void
     */
    public Void RemoveWhitelistEntry(String UserOrUUID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        return this.APICall("MinecraftModule/RemoveWhitelistEntry", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param ID  False
     * @return Void
     */
    public Void SmiteByID(String ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        return this.APICall("MinecraftModule/SmiteByID", args, Void.class);
    }

}
