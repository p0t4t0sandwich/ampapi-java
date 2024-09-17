package dev.neuralnexus.ampapi;

import dev.neuralnexus.ampapi.auth.AuthStore;

public class AMPAPI {
    protected final AuthStore authStore;
    protected final String instanceName;

    /**
     * Constructor
     *
     * @param authStore The auth store to use when making API calls
     * @param instanceName The instance that this API object is currently using
     */
    public AMPAPI(AuthStore authStore, String instanceName) {
        this.authStore = authStore;
        this.instanceName = instanceName;
    }

    public static class AMPAPIException extends RuntimeException {
        public AMPAPIException(Data data) {
            super(data.Title + ": " + data.Message + "\n" + data.StackTrace);
        }

        public static class Data {
            public String Title;
            public String Message;
            public String StackTrace;
        }
    }
}
