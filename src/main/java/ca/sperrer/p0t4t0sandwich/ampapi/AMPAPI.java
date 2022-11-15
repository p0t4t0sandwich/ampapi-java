package ca.sperrer.p0t4t0sandwich.ampapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AMPAPI {
    private final Map<Object, Object> _API = new HashMap<>();
    private final String baseURI;
    private final String dataSource;

    public AMPAPI(String baseURI) {
        this.baseURI = baseURI;

        if (baseURI.charAt(baseURI.length()-1) == '/') {
            this.dataSource = baseURI + "API";
        } else {
            this.dataSource = baseURI + "/API";
        }

        Map<Object, Object> module = new HashMap<>();
        module.put("GetAPISpec", new HashMap<>());
        this._API.put("Core", module);
    }

    String APICall(String module, String methodName, String[] args) {
        String data_json = "{\"SESSIONID\":\"\"}";

        try {
            Map method = (Map) ((Map<?, ?>) this._API.get(module)).get(methodName);

            Map data = new HashMap<>();//

            if (method.containsKey("Parameters")) {

            }


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

            return br.readLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static boolean init(boolean stage2) {
        System.out.println("a" + stage2);
        return stage2;
    }
}
