/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi-java/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.plugins;

import com.google.gson.reflect.TypeToken;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.types.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({
    "rawtypes",
    "unchecked",
    "unused",
    "DataFlowIssue",
    "JavadocBlankLines",
    "RedundantCast",
    "UnusedReturnValue"
})
public class steamcmdplugin extends AMPAPI {
    public steamcmdplugin(AuthProvider authProvider) {
        super(authProvider);
    }

    /**
     * Name Description Optional
     *
     * @return Void
     */
    public Void CancelSteamGuard() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("steamcmdplugin/CancelSteamGuard", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param code False
     * @return Void
     */
    public Void SteamGuardCode(String code) {
        Map<String, Object> args = new HashMap<>();
        args.put("code", code);
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("steamcmdplugin/SteamGuardCode", args, type);
    }

    /**
     * Name Description Optional
     *
     * @param username False
     * @param password False
     * @return Void
     */
    public Void SteamUsernamePassword(String username, String password) {
        Map<String, Object> args = new HashMap<>();
        args.put("username", username);
        args.put("password", password);
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("steamcmdplugin/SteamUsernamePassword", args, type);
    }
}
