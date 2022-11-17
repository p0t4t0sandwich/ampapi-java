package ca.sperrer.p0t4t0sandwich.ampapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class AMPAPI {
    class MultiArray {
        String f1;
        Integer f2;
        Boolean f3;
    }
    private final Map<String, Object> _API = new HashMap<>();
    public final Map<String, Map<String, Consumer<Object[]>>> API = new HashMap<>();
    private final String baseURI;
    private final String dataSource;
    private final String sessionId = "";

    public AMPAPI(String baseURI) {
        this.baseURI = baseURI;

        if (baseURI.charAt(baseURI.length()-1) == '/') {
            this.dataSource = this.baseURI + "API";
        } else {
            this.dataSource = this.baseURI + "/API";
        }

        Map<Object, Object> module = new HashMap<>();
        module.put("GetAPISpec", new HashMap<>());
        this._API.put("Core", module);
    }

    Map APICall(String module, String methodName, Object[] args) {
        try {
            Map method = (Map) ((Map) this._API.get(module)).get(methodName);

            Map data = new HashMap<>();

            if (method.containsKey("Parameters")) {
                Map[] methodParams = (Map[]) method.get("Parameters");
                System.out.println(methodParams);
                for (int i = 0; i < methodParams.length-1; i++) {
                    data.put(((Map) methodParams[i]).get("Name"), args[i]);
                }
            }
            data.put("SESSIONID", this.sessionId);

            Gson gson = new GsonBuilder().create();
            String data_json = gson.toJson(data);

            URL url = new URL(this.dataSource + "/" + module + "/" + methodName);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Accept", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream());
            osw.write(data_json);
            osw.flush();
            osw.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            return gson.fromJson(br.readLine(), Map.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    boolean init(boolean stage2) {
        for (Map.Entry<String, Object> module_loop : this._API.entrySet()) {
            String module = module_loop.getKey();
            Map<String, Object> methods = (Map<String, Object>) module_loop.getValue();

            Map<String, Consumer<Object[]>> new_api_methods = new HashMap<>();

            for (Map.Entry<String, Object> method_loop : methods.entrySet()) {
                String method = method_loop.getKey();
                new_api_methods.put(method, (args) -> this.APICall(module, method, args));
            }
            this.API.put(module, new_api_methods);
        }
        System.out.println(this.API);
        return stage2;
    }
}
