package dev.neuralnexus.ampapi.types;


import java.util.Map;

/**
 * Response type for API.Core.GetStatus
 *
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.apimodules.Core#GetStatus()
 */
public class Status {
    /**
     * {@link State State} - Current state of the instance Uptime - Time since the instance was
     * started {@link Metric Metrics} - A map of metrics and their values
     */
    public State State;

    public String Uptime;
    public Map<String, Metric> Metrics;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    public String toString() {
        return "Status{State="
                + this.State
                + ", Uptime="
                + this.Uptime
                + ", Metrics="
                + this.Metrics
                + "}";
    }
}
