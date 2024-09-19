package dev.neuralnexus.ampapi.auth;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AuthStore {
    private final Map<UUID, AuthProvider> authProviders = new HashMap<>();

    public AuthProvider get(UUID instanceId) {
        return this.authProviders.get(instanceId);
    }

    public void add(UUID instanceId, AuthProvider authProvider) {
        this.authProviders.put(instanceId, authProvider);
    }

    public void add(AuthProvider authProvider) {
        this.add(authProvider.instanceId(), authProvider);
    }

    public void remove(UUID instanceId) {
        this.authProviders.remove(instanceId);
    }
}
