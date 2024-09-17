package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.apimodules.*;
import dev.neuralnexus.ampapi.auth.AuthStore;

public class Minecraft extends CommonAPI {
    public final MinecraftModule MinecraftModule;

    public Minecraft(AuthStore authStore, String instanceName) {
        super(authStore, instanceName);
        this.MinecraftModule = new MinecraftModule(authStore, instanceName);
    }
}
