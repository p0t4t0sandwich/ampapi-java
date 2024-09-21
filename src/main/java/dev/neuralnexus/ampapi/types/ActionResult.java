/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.ampapi.types;

/**
 * Generic response type for calls that return a result and a reason for failure
 *
 * @author p0t4t0sandwich
 */
public class ActionResult<T> {
    /**
     * Status - true if successful, false if not <br>
     * Reason - reason for failure <br>
     * Result - result of the call
     */
    public boolean Status;

    public String Reason;
    public T Result;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    @Override
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
