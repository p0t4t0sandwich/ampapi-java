package dev.neuralnexus.ampapi.responses.Core;

import dev.neuralnexus.ampapi.types.Metric;

import java.util.Map;

/**
 * Response type for API.Core.GetStatus
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.apimodules.Core#GetStatus()
 */
public class GetStatusResult {
    /**
     * State - Current state of the instance
     * Uptime - Time since the instance was started
     * Metrics - A map of metrics and their values
     */
    public int State;
    public String Uptime;
    public Map<String, Metric> Metrics;

    /**
     * toString
     * @return A string representation of the object
     */
    public String toString() {
        return "GetStatusResult{State=" + this.State + ", Uptime=" + this.Uptime + ", Metrics=" + this.Metrics + "}";
    }
}
