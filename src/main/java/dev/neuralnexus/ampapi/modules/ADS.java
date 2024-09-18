package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.auth.AuthProvider;
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

    public <T extends AMPAPI> T InstanceLogin(UUID instanceId, AuthProvider.Builder authBuilder, Class<T> clazz) {
        UUID remoteToken = this.ADSModule.ManageInstance(instanceId).Result;
        AuthProvider auth = authBuilder
                .panelUrl(this.authProvider.dataSource() + "ADSModule/Servers/" + instanceId)
                .username(this.authProvider.username())
                .token(remoteToken)
                .build();
        auth.Login(true);
        this.authStore.add(authProvider);

        if (clazz.equals(ADS.class)) {
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
                .filter(hub -> hub.InstanceName.equals(instanceName))
                .map(hub -> hub.InstanceID)
                .findFirst()
                .orElse(null);
        return this.InstanceLogin(instanceId, authBuilder, clazz);
    }

    public CommonAPI InstanceLogin(String instanceName, AuthProvider.Builder authBuilder) {
        return this.InstanceLogin(instanceName, authBuilder, CommonAPI.class);
    }
}
