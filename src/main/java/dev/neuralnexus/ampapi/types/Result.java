package dev.neuralnexus.ampapi.types;

/**
 * Generic response type for calls that return a result
 * @author p0t4t0sandwich
 */
public class Result<T> {
    /**
     * Result - The result of the call
     */
    public T result;

    /**
     * toString
     * @return A string representation of the object
     */
    public String toString() {
        return "Result{result=" + this.result + "}";
    }
}
