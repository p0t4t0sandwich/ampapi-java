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
public class RCONPlugin extends AMPAPI {
    public RCONPlugin(AuthProvider authProvider) {
        super(authProvider);
    }

    /**
     * Name Description Optional
     *
     * @return Void
     */
    public Void Dummy() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>() {}.getType();
        return (Void) this.APICall("RCONPlugin/Dummy", args, type);
    }
}
