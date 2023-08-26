package dev.neuralnexus.ampapi.apimodules;

import com.google.gson.reflect.TypeToken;
import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.responses.*;
import dev.neuralnexus.ampapi.responses.RCONPlugin.*;
import dev.neuralnexus.ampapi.types.*;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
        Type type = new TypeToken<Void>(){}.getType();
        return (Void) this.APICall("RCONPlugin/Dummy", args, type);
    }

}
