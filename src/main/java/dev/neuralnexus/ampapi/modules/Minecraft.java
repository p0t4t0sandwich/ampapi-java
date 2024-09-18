package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.plugins.*;

public class Minecraft extends CommonAPI {
    public final MinecraftModule MinecraftModule;

    public Minecraft(AuthProvider authProvider) {
        super(authProvider);
        this.MinecraftModule = new MinecraftModule(authProvider);
    }
}
