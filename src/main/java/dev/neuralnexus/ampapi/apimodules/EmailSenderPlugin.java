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

public class EmailSenderPlugin extends AMPAPI {
    public EmailSenderPlugin(AMPAPI ampapi) {
        super(ampapi);
    }

    /**
     * Name Description Optional
     * @return Task<ActionResult>
     */
    public Task<ActionResult> TestSMTPSettings() {
        HashMap<String, Object> args = new HashMap<>();
        Type type = new TypeToken<Task<ActionResult>>(){}.getType();
        return (Task<ActionResult>) this.APICall("EmailSenderPlugin/TestSMTPSettings", args, type);
    }

}
