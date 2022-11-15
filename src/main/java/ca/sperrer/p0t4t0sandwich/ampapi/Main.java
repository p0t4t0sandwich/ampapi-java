package ca.sperrer.p0t4t0sandwich.ampapi;

import com.google.gson.Gson;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] arguments = new String[] {};

        AMPAPI API = new AMPAPI("http://172.16.1.172:8080/");

        //System.out.println(((Map<?, ?>) API.API.get("Core")).get("GetAPISpec"));

        String res = API.APICall("Core", "GetAPISpec", arguments);

        Map<?, ?> res_map;
        Gson gson = new Gson();
        res_map = gson.fromJson(res, Map.class);


        System.out.println(
                ((Map<?, ?>) ((Map<?, ?>) res_map
                        .get("result"))
                        .get("Core"))
                        .get("Login")
        );
    }
}
