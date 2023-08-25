package dev.neuralnexus.ampapi.responses.ADSModule;

import dev.neuralnexus.ampapi.responses.Result;
import dev.neuralnexus.ampapi.types.ADSInstance;

import java.util.Arrays;

/**
 * Response type for API.ADSModule.GetInstances
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.apimodules.ADSModule#GetInstances()
 * @see dev.neuralnexus.ampapi.responses.Result
 * @see dev.neuralnexus.ampapi.types.ADSInstance
 */
public class GetInstancesResult extends Result<ADSInstance[]> {
    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        return "GetInstancesResult{result=" + Arrays.toString(this.result) + "}";
    }
}
