package dev.neuralnexus.ampapi.types;

/**
 * Generic response type for calls that return a result and a reason for failure
 *
 * @author p0t4t0sandwich
 */
public class ActionResult<T> {
    /**
     * Status - true if successful, false if not Reason - reason for failure Result - result of the
     * call
     */
    public boolean Status;

    public String Reason;
    public T Result;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    public String toString() {
        return "ActionResult{Status="
                + this.Status
                + ", Reason="
                + this.Reason
                + ", Result="
                + this.Result
                + "}";
    }
}
