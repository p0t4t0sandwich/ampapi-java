package dev.neuralnexus.ampapi;

import dev.neuralnexus.ampapi.modules.ADS;
import dev.neuralnexus.ampapi.modules.Minecraft;

public class Main {
    public static void main(String[] args) {
        ADS ads = new ADS("", "", "", "", "");

        String instanceId = "17f66f29";
        String instanceModule = "Minecraft";

        Minecraft minecraft = ads.InstanceLogin(instanceId, Minecraft.class);

        System.out.println(minecraft.Core.GetStatus());
    }
}
