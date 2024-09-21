/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi-java/blob/main/LICENSE">MIT</a>
 */
package dev.neuralnexus.ampapi.plugins;

import com.google.gson.reflect.TypeToken;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.auth.AuthProvider;
import dev.neuralnexus.ampapi.types.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({
    "rawtypes",
    "unchecked",
    "unused",
    "DataFlowIssue",
    "JavadocBlankLines",
    "RedundantCast",
    "UnusedReturnValue"
})
public class AnalyticsPlugin extends AMPAPI {
    public AnalyticsPlugin(AuthProvider authProvider) {
        super(authProvider);
    }

    /**
     * Name Description Optional
     *
     * @param PeriodDays True
     * @param StartDate True
     * @param Filters True
     * @return Object
     */
    public Object GetAnalyticsSummary(
            Integer PeriodDays, Object StartDate, Map<String, String> Filters) {
        Map<String, Object> args = new HashMap<>();
        args.put("PeriodDays", PeriodDays);
        args.put("StartDate", StartDate);
        args.put("Filters", Filters);
        Type type = new TypeToken<Object>() {}.getType();
        return (Object) this.APICall("AnalyticsPlugin/GetAnalyticsSummary", args, type);
    }
}
