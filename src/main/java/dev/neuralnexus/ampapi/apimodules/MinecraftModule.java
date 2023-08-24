package dev.neuralnexus.ampapi.apimodules;

import dev.neuralnexus.ampapi.AMPAPIBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinecraftModule extends AMPAPIBase {
    public MinecraftModule(AMPAPIBase ampapiBase) {
        super(ampapiBase);
    }

    /**
     * Name TypeName Description Optional
     * @return boolean AMPType: Boolean
     */
    public Map<?, ?> AcceptEULA() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("MinecraftModule/AcceptEULA", args);
    }

    /**
     * Name TypeName Description Optional
     * @param UserOrUUID String AMPType: String 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> AddOPEntry(String UserOrUUID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        return this.APICall("MinecraftModule/AddOPEntry", args);
    }

    /**
     * Name TypeName Description Optional
     * @param UserOrUUID String AMPType: String 
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> AddToWhitelist(String UserOrUUID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        return this.APICall("MinecraftModule/AddToWhitelist", args);
    }

    /**
     * Name TypeName Description Optional
     * @param ID String AMPType: String 
     * @return void AMPType: Void
     */
    public Map<?, ?> BanUserByID(String ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        return this.APICall("MinecraftModule/BanUserByID", args);
    }

    /**
     * Name TypeName Description Optional
     * @return Map<?, ?> AMPType: JObject
     */
    public Map<?, ?> BukGetCategories() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("MinecraftModule/BukGetCategories", args);
    }

    /**
     * Name TypeName Description Optional
     * @param pluginId Integer AMPType: Int32 
     * @return  AMPType: Task<RunningTask>
     */
    public Map<?, ?> BukGetInstallUpdatePlugin(Integer pluginId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("pluginId", pluginId);
        return this.APICall("MinecraftModule/BukGetInstallUpdatePlugin", args);
    }

    /**
     * Name TypeName Description Optional
     * @return Map<?, ?> AMPType: JObject
     */
    public Map<?, ?> BukGetInstalledPlugins() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("MinecraftModule/BukGetInstalledPlugins", args);
    }

    /**
     * Name TypeName Description Optional
     * @param PluginId Integer AMPType: Int32 
     * @return Map<?, ?> AMPType: JObject
     */
    public Map<?, ?> BukGetPluginInfo(Integer PluginId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("PluginId", PluginId);
        return this.APICall("MinecraftModule/BukGetPluginInfo", args);
    }

    /**
     * Name TypeName Description Optional
     * @param CategoryId String AMPType: String 
     * @param PageNumber Integer AMPType: Int32 
     * @param PageSize Integer AMPType: Int32 
     * @return Map<?, ?> AMPType: JObject
     */
    public Map<?, ?> BukGetPluginsForCategory(String CategoryId, Integer PageNumber, Integer PageSize) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("CategoryId", CategoryId);
        args.put("PageNumber", PageNumber);
        args.put("PageSize", PageSize);
        return this.APICall("MinecraftModule/BukGetPluginsForCategory", args);
    }

    /**
     * Name TypeName Description Optional
     * @return Map<?, ?> AMPType: JObject
     */
    public Map<?, ?> BukGetPopularPlugins() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("MinecraftModule/BukGetPopularPlugins", args);
    }

    /**
     * Name TypeName Description Optional
     * @param PluginId Integer AMPType: Int32 
     * @return void AMPType: Void
     */
    public Map<?, ?> BukGetRemovePlugin(Integer PluginId) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("PluginId", PluginId);
        return this.APICall("MinecraftModule/BukGetRemovePlugin", args);
    }

    /**
     * Name TypeName Description Optional
     * @param Query String AMPType: String 
     * @param PageNumber Integer AMPType: Int32 
     * @param PageSize Integer AMPType: Int32 
     * @return Map<?, ?> AMPType: JObject
     */
    public Map<?, ?> BukGetSearch(String Query, Integer PageNumber, Integer PageSize) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("Query", Query);
        args.put("PageNumber", PageNumber);
        args.put("PageSize", PageSize);
        return this.APICall("MinecraftModule/BukGetSearch", args);
    }

    /**
     * Name TypeName Description Optional
     * @param ID String AMPType: String 
     * @return void AMPType: Void
     */
    public Map<?, ?> ClearInventoryByID(String ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        return this.APICall("MinecraftModule/ClearInventoryByID", args);
    }

    /**
     * Name TypeName Description Optional
     * @return String AMPType: String
     */
    public Map<?, ?> GetFailureReason() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("MinecraftModule/GetFailureReason", args);
    }

    /**
     * Get a skin as a base64 string
     * Name TypeName Description Optional
     * @param id String AMPType: String 
     * @return String AMPType: String
     */
    public Map<?, ?> GetHeadByUUID(String id) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("id", id);
        return this.APICall("MinecraftModule/GetHeadByUUID", args);
    }

    /**
     * Name TypeName Description Optional
     * @return Map<?, ?> AMPType: JObject
     */
    public Map<?, ?> GetOPWhitelist() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("MinecraftModule/GetOPWhitelist", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<Map<?, ?>> AMPType: IEnumerable<JObject>
     */
    public Map<?, ?> GetWhitelist() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("MinecraftModule/GetWhitelist", args);
    }

    /**
     * Name TypeName Description Optional
     * @param ID String AMPType: String 
     * @return void AMPType: Void
     */
    public Map<?, ?> KickUserByID(String ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        return this.APICall("MinecraftModule/KickUserByID", args);
    }

    /**
     * Name TypeName Description Optional
     * @param ID String AMPType: String 
     * @return void AMPType: Void
     */
    public Map<?, ?> KillByID(String ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        return this.APICall("MinecraftModule/KillByID", args);
    }

    /**
     * Name TypeName Description Optional
     * @return List<Map<?, ?>> AMPType: IEnumerable<JObject>
     */
    public Map<?, ?> LoadOPList() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("MinecraftModule/LoadOPList", args);
    }

    /**
     * Name TypeName Description Optional
     * @param UserOrUUID String AMPType: String 
     * @return void AMPType: Void
     */
    public Map<?, ?> RemoveOPEntry(String UserOrUUID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        return this.APICall("MinecraftModule/RemoveOPEntry", args);
    }

    /**
     * Name TypeName Description Optional
     * @param UserOrUUID String AMPType: String 
     * @return void AMPType: Void
     */
    public Map<?, ?> RemoveWhitelistEntry(String UserOrUUID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("UserOrUUID", UserOrUUID);
        return this.APICall("MinecraftModule/RemoveWhitelistEntry", args);
    }

    /**
     * Strike a player with lightning
     * Name TypeName Description Optional
     * @param ID String AMPType: String 
     * @return void AMPType: Void
     */
    public Map<?, ?> SmiteByID(String ID) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("ID", ID);
        return this.APICall("MinecraftModule/SmiteByID", args);
    }

}
