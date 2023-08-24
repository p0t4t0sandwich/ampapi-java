package dev.neuralnexus.ampapi.apimodules;

import dev.neuralnexus.ampapi.AMPAPIBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RCONPlugin extends AMPAPIBase {
    public RCONPlugin(AMPAPIBase ampapiBase) {
        super(ampapiBase);
    }

    /**
     * Name TypeName Description Optional
     * @return void AMPType: Void
     */
    public Map<?, ?> Dummy() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("RCONPlugin/Dummy", args);
    }

}
