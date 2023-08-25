package dev.neuralnexus.ampapi.responses.Core;

import java.util.Map;

public class GetStatusResult {
    public int State = 0;
    public String Uptime = "";
    public Map<String, StatusMetric> Metrics = null;

    public static class StatusMetric {
        public int RawValue = 0;
        public int MaxValue = 0;
        public int Percent = 0;
        public String Units = "";
        public String Color = "";
        public String Color2 = "";
        public String Color3 = "";
    }
}
