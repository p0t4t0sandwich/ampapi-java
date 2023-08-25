package dev.neuralnexus.ampapi.apimodules;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.responses.steamcmdplugin.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class steamcmdplugin extends AMPAPI {
    public steamcmdplugin(AMPAPI ampapi) {
        super(ampapi);
    }

    /**
     * Name Description Optional
     * @return Void
     */
    public Void CancelSteamGuard() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("steamcmdplugin/CancelSteamGuard", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param code  False
     * @return Void
     */
    public Void SteamGuardCode(String code) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("code", code);
        return this.APICall("steamcmdplugin/SteamGuardCode", args, Void.class);
    }

    /**
     * Name Description Optional
     * @param username  False
     * @param password  False
     * @return Void
     */
    public Void SteamUsernamePassword(String username, String password) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("username", username);
        args.put("password", password);
        return this.APICall("steamcmdplugin/SteamUsernamePassword", args, Void.class);
    }

}
