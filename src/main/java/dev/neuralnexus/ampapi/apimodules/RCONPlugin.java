package dev.neuralnexus.ampapi.apimodules;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.responses.RCONPlugin.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RCONPlugin extends AMPAPI {
    public RCONPlugin(AMPAPI ampapi) {
        super(ampapi);
    }

    /**
     * Name Description Optional
     * @return Void
     */
    public Void Dummy() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("RCONPlugin/Dummy", args, Void.class);
    }

}
