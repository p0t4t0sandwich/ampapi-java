package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.plugins.*;

public class GenericModule extends CommonAPI {
    public dev.neuralnexus.ampapi.plugins.GenericModule GenericModule;
    public RCONPlugin RCONPlugin;
    public steamcmdplugin steamcmdplugin;

    public GenericModule(AuthProvider authProvider) {
        super(authProvider);
        this.GenericModule = new dev.neuralnexus.ampapi.plugins.GenericModule(authProvider);
        this.RCONPlugin = new RCONPlugin(authProvider);
        this.steamcmdplugin = new steamcmdplugin(authProvider);
    }
}
