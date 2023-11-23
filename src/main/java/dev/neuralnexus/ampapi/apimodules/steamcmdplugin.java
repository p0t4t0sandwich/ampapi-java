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

public class steamcmdplugin extends AMPAPI {
    public steamcmdplugin(AMPAPI ampapi) {
        super(ampapi);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Void
     */
    public Void CancelSteamGuard() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.APICall("steamcmdplugin/CancelSteamGuard", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param code  False
     * @return Void
     */
    public Void SteamGuardCode(String code) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("code", code);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.APICall("steamcmdplugin/SteamGuardCode", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param username  False
     * @param password  False
     * @return Void
     */
    public Void SteamUsernamePassword(String username, String password) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("username", username);
        args.put("password", password);
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.APICall("steamcmdplugin/SteamUsernamePassword", args, type);
    }

}
