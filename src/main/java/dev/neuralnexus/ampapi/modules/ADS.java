package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.apimodules.*;
import dev.neuralnexus.ampapi.auth.AuthStore;

public class ADS extends CommonAPI {
    public final ADSModule ADSModule;

    public ADS(AuthStore authStore, String instanceName) {
        super(authStore, instanceName);
        this.ADSModule = new ADSModule(authStore, instanceName);
    }
}
