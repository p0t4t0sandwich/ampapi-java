package dev.neuralnexus.ampapi.auth;

import java.util.HashMap;
import java.util.Map;

public class AuthStore {
    private final Map<String, AuthProvider> authProviders = new HashMap<>();

    public AuthProvider get(String instanceName) {
        return this.authProviders.get(instanceName);
    }

    public void add(String instanceName, AuthProvider authProvider) {
        this.authProviders.put(instanceName, authProvider);
    }
}
