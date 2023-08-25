package dev.neuralnexus.ampapi.apimodules;

import dev.neuralnexus.ampapi.AMPAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailSenderPlugin extends AMPAPI {
    public EmailSenderPlugin(AMPAPI ampapi) {
        super(ampapi);
    }

    /**
     * Name Description Optional
     * @return Object
     */
    public Object TestSMTPSettings() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("EmailSenderPlugin/TestSMTPSettings", args, Object.class);
    }

}
