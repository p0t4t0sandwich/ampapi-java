package dev.neuralnexus.ampapi;

import dev.neuralnexus.ampapi.auth.AuthProvider;

public class AMPAPI {
    protected final AuthProvider authProvider;

    /**
     * Constructor
     *
     * @param authProvider The auth provider to use when making API calls
     */
    public AMPAPI(AuthProvider authProvider) {
        this.authProvider = authProvider;
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
