package dev.neuralnexus.ampapi.types;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Response type for API.Core.GetStatus
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.apimodules.Core#GetStatus()
 */
public class Status {
    /**
     * {@link State State} - Current state of the instance
     * Uptime - Time since the instance was started
     * {@link Metric Metrics} - A map of metrics and their values
     */
    public State State;
    public String Uptime;
    public Map<String, Metric> Metrics;

    /**
     * toString
     * @return A string representation of the object
     */
    public String toString() {
        return "Status{State=" + this.State + ", Uptime=" + this.Uptime + ", Metrics=" + this.Metrics + "}";
    }

    /**
     * Represents the state of an instance.
     * @author p0t4t0sandwich
     */
    public enum State {
        @SerializedName("-1")
        Undefined(-1),
        @SerializedName("0")
        Stopped(0),
        @SerializedName("5")
        PreStart(5),
        /**
         * The server is performing some first-time-start configuration.
         */
        @SerializedName("7")
        Configuring(7),
        @SerializedName("10")
        Starting(10),
        @SerializedName("20")
        Ready(20),
        /**
         * Server is in the middle of stopping, but once shutdown has finished it will automatically restart.
         */
        @SerializedName("30")
        Restarting(30),
        @SerializedName("40")
        Stopping(40),
        @SerializedName("45")
        PreparingForSleep(45),
        /**
         * The application should be able to be resumed quickly if using this state. Otherwise use Stopped.
         */
        @SerializedName("50")
        Sleeping(50),
        /**
         * The application is waiting for some external service/application to respond/become available.
         */
        @SerializedName("60")
        Waiting(60),
        @SerializedName("70")
        Installing(70),
        @SerializedName("75")
        Updating(75),
        /**
         * Used during installation, means that some user input is required to complete setup (authentication etc).
         */
        @SerializedName("80")
        AwaitingUserInput(80),
        /**
         * Something is preventing the application from starting, and the module will not try again without user action
         */
        @SerializedName("100")
        Failed(100),
        @SerializedName("200")
        Suspended(200),
        @SerializedName("250")
        Maintainence(250),
        /**
         * The state is unknown, or doesn't apply (for modules that don't start an external process)
         */
        @SerializedName("999")
        Indeterminate(999);

        /**
         * The value of the state.
         */
        private final int value;

        State(int i) {
            this.value = i;
        }

        State(double i) {
            this.value = (int) i;
        }
    }
}
