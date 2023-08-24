package dev.neuralnexus.ampapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * A class for handling API calls.
 */
public class APIHandler {
    public String baseUri;
    public final String dataSource;

    /**
     * Creates a new APIHandler instance.
     * @param baseURI The base URI of the API.
     */
    public APIHandler(String baseURI) {
        this.baseUri = baseURI;

        if (baseURI.charAt(baseURI.length() - 1) == '/') {
            this.dataSource = this.baseUri + "API/";
        } else {
            this.dataSource = this.baseUri + "/API/";
        }
    }

    /**
     * General API call method.
     * @param endpoint The endpoint to call.
     * @param requestMethod The request method to use.
     * @param returnClass The class to use when serializing the response.
     */
    public Object APICall(String endpoint, String requestMethod, Map<String, Object> data, Class<?> returnClass) {
        try {
            Gson gson = new GsonBuilder().create();

            URL url = new URL(this.dataSource + endpoint);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod(requestMethod);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            con.setRequestProperty("User-Agent", "ampapi-java/1.2.0");
            con.setConnectTimeout(5000);

            // Only send data if it's not null.
            if (data != null) {
                String json = gson.toJson(data);
                con.getOutputStream().write(json.getBytes());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            return gson.fromJson(br.readLine(), returnClass);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * General API call method.
     * @param endpoint The endpoint to call.
     * @param requestMethod The request method to use.
     * @param data The data to send.
     */
    public Map<?,?> APICall(String endpoint, String requestMethod, Map<String, Object> data) {
        return (Map<?, ?>) this.APICall(endpoint, requestMethod, data, Map.class);
    }
}
