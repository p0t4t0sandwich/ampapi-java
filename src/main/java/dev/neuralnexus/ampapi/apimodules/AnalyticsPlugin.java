package dev.neuralnexus.ampapi.apimodules;

import com.google.gson.reflect.TypeToken;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.auth.AuthStore;
import dev.neuralnexus.ampapi.types.*;

import java.lang.reflect.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AnalyticsPlugin extends AMPAPI {
    public AnalyticsPlugin(AuthStore authStore, String instanceName) {
        super(authStore, instanceName);
    }

    /**
     * 
     *
     * Name Description Optional
     * @param PeriodDays  True
     * @param StartDate  True
     * @param Filters  True
     * @return Object
     */
    public Object GetAnalyticsSummary(Integer PeriodDays, Object StartDate, Map<String, String> Filters) {
        HashMap<String, Object> args = new HashMap<>();
        args.put("PeriodDays", PeriodDays);
        args.put("StartDate", StartDate);
        args.put("Filters", Filters);
        Type type = new TypeToken<Object>(){}.getType();
        return (Object) this.authStore.get(this.instanceName).APICall("ADSModule/AddDatastore", "POST", args, type);
    }

}
