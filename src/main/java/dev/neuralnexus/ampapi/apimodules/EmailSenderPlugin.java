package dev.neuralnexus.ampapi.apimodules;

import dev.neuralnexus.ampapi.AMPAPIBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmailSenderPlugin extends AMPAPIBase {
    public EmailSenderPlugin(AMPAPIBase ampapiBase) {
        super(ampapiBase);
    }

    /**
     * Name TypeName Description Optional
     * @return  AMPType: Task<ActionResult>
     */
    public Map<?, ?> TestSMTPSettings() {
        HashMap<String, Object> args = new HashMap<>();
        return this.APICall("EmailSenderPlugin/TestSMTPSettings", args);
    }

}
