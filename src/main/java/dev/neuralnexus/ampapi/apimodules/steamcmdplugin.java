package dev.neuralnexus.ampapi.apimodules;

import dev.neuralnexus.ampapi.AMPAPIBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class steamcmdplugin extends AMPAPIBase {
    public steamcmdplugin(AMPAPIBase ampapiBase) {
        super(ampapiBase);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> CancelSteamGuard() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("steamcmdplugin/CancelSteamGuard", args);
    }

    /**
     * Name TypeName Description Optional
     * @param code String AMPType: String 
     * @return void AMPType: Void
     */
    public Map<?, ?> SteamGuardCode(String code) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("code", code);
        return this.APICall("steamcmdplugin/SteamGuardCode", args);
    }

    /**
     * Name TypeName Description Optional
     * @param username String AMPType: String 
     * @param password String AMPType: String 
     * @return void AMPType: Void
     */
    public Map<?, ?> SteamUsernamePassword(String username, String password) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("username", username);
        args.put("password", password);
        return this.APICall("steamcmdplugin/SteamUsernamePassword", args);
    }

}
