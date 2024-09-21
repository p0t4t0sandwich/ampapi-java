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
public class GenericModule extends AMPAPI {
    public GenericModule(AuthProvider authProvider) {
        super(authProvider);
    }

    /**
     * Name Description Optional
     *
     * @param filename False
     * @return Map<String, String>
     */
    public Map<String, String> ImportConfig(String filename) {
        Map<String, Object> args = new HashMap<>();
        args.put("filename", filename);
        Type type = new TypeToken<Map<String, String>>() {}.getType();
        return (Map<String, String>) this.APICall("GenericModule/ImportConfig", args, type);
    }

    /**
     * Name Description Optional
     *
     * @return Void
     */
    public Void ReloadGenericConfig() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("GenericModule/ReloadGenericConfig", args, type);
    }
}
