/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi-java/blob/main/LICENSE">MIT</a>
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
