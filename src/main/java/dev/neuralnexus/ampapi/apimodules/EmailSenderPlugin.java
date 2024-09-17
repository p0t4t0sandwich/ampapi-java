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

public class EmailSenderPlugin extends AMPAPI {
    public EmailSenderPlugin(AuthStore authStore, String instanceName) {
        super(authStore, instanceName);
    }

    /**
     * 
     *
     * Name Description Optional
     * @return ActionResult
     */
    public ActionResult TestSMTPSettings() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<ActionResult>(){}.getType();
        return (ActionResult) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

}
