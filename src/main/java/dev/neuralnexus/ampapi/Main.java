package dev.neuralnexus.ampapi;

import dev.neuralnexus.ampapi.modules.ADS;
import dev.neuralnexus.ampapi.modules.Minecraft;
import dev.neuralnexus.ampapi.responses.Core.GetStatusResult;

public class Main {
    public static void main(String[] args) {
        ADS ads = new ADS("", "", "", "", "");

        String instanceId = "17f66f29";
        String instanceModule = "Minecraft";

        Minecraft minecraft = ads.InstanceLogin(instanceId, Minecraft.class);

        GetStatusResult status = minecraft.Core.GetStatus();
        System.out.println(status.Metrics.get("CPU Usage").Percent);
    }
}
