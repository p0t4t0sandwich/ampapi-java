package dev.neuralnexus.ampapi;

import dev.neuralnexus.ampapi.modules.ADS;
import dev.neuralnexus.ampapi.responses.Result;
import dev.neuralnexus.ampapi.types.Instance;
import dev.neuralnexus.ampapi.types.InstanceDatastore;
import dev.neuralnexus.ampapi.types.SettingSpec;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ADS API = new ADS("http://172.16.1.172:8080", "api_user", "izYxzCSPRCWRe6gHTMbg5wDZNKgmPiwh", "", "");

//        Result<List<InstanceDatastore>> datastores = API.ADSModule.GetDatastores();

//        int datastoreId = datastores.result.get(0).Id;

//        Result<List<Instance>> result = API.ADSModule.GetDatastoreInstances(datastoreId);

        Result<Map<String, List<SettingSpec>>> result = API.Core.GetSettingsSpec();

        SettingSpec res = result.result.get("AMP Core").get(0);

        System.out.println(res);

        // GetApplicationEndpoints
    }
}
