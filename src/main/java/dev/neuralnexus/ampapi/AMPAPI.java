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
}
