package dev.neuralnexus.ampapi.types;

/**
 * EndpointInfo - An application endpoint object
 *
 * @author p0t4t0sandwich
 * @see dev.neuralnexus.ampapi.plugins.ADSModule#GetApplicationEndpoints(java.util.UUID)
 */
public class EndpointInfo {
    /**
     * DisplayName - The display name of the endpoint <br>
     * Endpoint - The endpoint address <br>
     * Uri - The URI of the endpoint
     */
    public String DisplayName;

    public String Endpoint;
    public String Uri;

    /**
     * toString
     *
     * @return A string representation of the object
     */
    @Override
    public String toString() {
        return "EndpointInfo{DisplayName="
                + this.DisplayName
                + ", Endpoint="
                + this.Endpoint
                + ", Uri="
                + this.Uri
                + "}";
    }
}
