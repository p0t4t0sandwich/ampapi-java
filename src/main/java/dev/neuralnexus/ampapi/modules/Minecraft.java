/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
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
