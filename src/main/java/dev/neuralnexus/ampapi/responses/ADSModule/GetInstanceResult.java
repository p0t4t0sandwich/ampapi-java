package dev.neuralnexus.ampapi.responses.ADSModule;

import dev.neuralnexus.ampapi.responses.Result;
import dev.neuralnexus.ampapi.types.Instance;

/**
 * Response type for API.ADSModule.GetInstance
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.apimodules.ADSModule#GetInstance(String)
 * @see dev.neuralnexus.ampapi.responses.Result
 * @see dev.neuralnexus.ampapi.types.Instance
 */
public abstract class GetInstanceResult extends Result<Instance> {
    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        return "GetInstanceResult{result=" + this.result + "}";
    }
}
