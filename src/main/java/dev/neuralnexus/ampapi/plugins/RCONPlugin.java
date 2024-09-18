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
public class RCONPlugin extends AMPAPI {
    public RCONPlugin(AuthProvider authProvider) {
        super(authProvider);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Void
     */
    public Void Dummy() {
        Map<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authProvider.APICall("RCONPlugin/Dummy", args, type);
    }

}
