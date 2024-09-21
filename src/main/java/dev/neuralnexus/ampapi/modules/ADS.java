package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.auth.RefreshingAuthProvider;
import dev.neuralnexus.ampapi.plugins.*;
import dev.neuralnexus.ampapi.auth.AuthStore;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class ADS extends CommonAPI {
    private final AuthStore authStore;
    public final ADSModule ADSModule;

    public ADS(AuthStore authStore, AuthProvider authProvider) {
        super(authProvider);
        this.authStore = authStore;
        this.ADSModule = new ADSModule(authProvider);
    }

    @SuppressWarnings("unchecked")
    public <T extends AMPAPI> T InstanceLogin(UUID instanceId, AuthProvider.Builder authBuilder, Class<T> clazz) {
        if (this.authProvider.username().isEmpty()) {
            throw new IllegalStateException("Username must be defined to manage remote instances");
        }

        AuthProvider auth = this.authStore.get(instanceId);
        if (auth == null) {
            authBuilder.panelUrl(this.authProvider.dataSource() + "ADSModule/Servers/" + instanceId).username(this.authProvider.username());
            if (this.authProvider.password().isEmpty()) {
                UUID remoteToken = this.ADSModule.ManageInstance(instanceId).Result;
                authBuilder.token(remoteToken).rememberMe(false);
                if (authBuilder instanceof RefreshingAuthProvider.Builder refBuilder) {
                    if (this.authProvider instanceof RefreshingAuthProvider) {
                        refBuilder.relogInterval(
                                ((RefreshingAuthProvider) authProvider).relogInterval());
                    }
                    refBuilder.relogCallback(
                            ap -> {
                                ap.setToken(this.ADSModule.ManageInstance(instanceId).Result.toString());
                                ap.Login();
                            });
                }
            } else {
                authBuilder.password(this.authProvider.password());
                if (authBuilder instanceof RefreshingAuthProvider.Builder refBuilder) {
                    if (this.authProvider instanceof RefreshingAuthProvider refAuthProvider) {
                        refBuilder.relogInterval(refAuthProvider.relogInterval());
                    }
                }
            }
            auth = authBuilder.build();
            auth.Login();

            this.authStore.add(auth);
        }

        if (clazz.isAssignableFrom(ADS.class)) {
            return (T) new ADS(this.authStore, auth);
        }

        try {
            return clazz.getConstructor(AuthProvider.class).newInstance(auth);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException("No constructor found for " + clazz.getName() + " that takes AuthProvider");
        }
    }

    public CommonAPI InstanceLogin(UUID instanceId, AuthProvider.Builder authBuilder) {
        return this.InstanceLogin(instanceId, authBuilder, CommonAPI.class);
    }

    public <T extends AMPAPI> T InstanceLogin(String instanceName, AuthProvider.Builder authBuilder, Class<T> clazz) {
        UUID instanceId = this.ADSModule.GetInstances(false).stream()
                .flatMap(ads -> ads.AvailableInstances.stream())
                .filter(i -> i.InstanceName.equals(instanceName))
                .map(i -> i.InstanceID)
                .findFirst()
                .orElse(null);
        return this.InstanceLogin(instanceId, authBuilder, clazz);
    }

    public CommonAPI InstanceLogin(String instanceName, AuthProvider.Builder authBuilder) {
        return this.InstanceLogin(instanceName, authBuilder, CommonAPI.class);
    }
}
