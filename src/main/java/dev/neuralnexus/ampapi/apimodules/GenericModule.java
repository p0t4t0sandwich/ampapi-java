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

public class GenericModule extends AMPAPI {
    public GenericModule(AuthStore authStore, String instanceName) {
        super(authStore, instanceName);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param filename  False
     * @return Map<String, String>
     */
    public Map<String, String> ImportConfig(String filename) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("filename", filename);
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        return (Map<String, String>) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return Void
     */
    public Void ReloadGenericConfig() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

}
