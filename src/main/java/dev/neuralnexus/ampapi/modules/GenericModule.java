package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.apimodules.*;
import dev.neuralnexus.ampapi.auth.AuthStore;

public class GenericModule extends CommonAPI {
    public dev.neuralnexus.ampapi.apimodules.GenericModule GenericModule;
    public RCONPlugin RCONPlugin;
    public steamcmdplugin steamcmdplugin;

    public GenericModule(AuthStore authStore, String instanceName) {
        super(authStore, instanceName);
        this.GenericModule = new dev.neuralnexus.ampapi.apimodules.GenericModule(authStore, instanceName);
        this.RCONPlugin = new RCONPlugin(authStore, instanceName);
        this.steamcmdplugin = new steamcmdplugin(authStore, instanceName);
    }
}
