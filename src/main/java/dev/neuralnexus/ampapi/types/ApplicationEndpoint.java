package dev.neuralnexus.ampapi.types;

/**
 * ApplicationEndpoint - An application endpoint object
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.responses.ADSModule.GetInstanceResult
 */
public class ApplicationEndpoint {
    /**
     * DisplayName - The display name of the endpoint
     * Endpoint - The endpoint address
     * Uri - The URI of the endpoint
     */
    public String DisplayName;
    public String Endpoint;
    public String Uri;

    /**
     * toString
     * @return A string representation of the object
     */
    public String toString() {
        return "ApplicationEndpoint{DisplayName=" + this.DisplayName + ", Endpoint=" + this.Endpoint + ", Uri=" + this.Uri + "}";
    }
}