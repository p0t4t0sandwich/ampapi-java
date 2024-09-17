package dev.neuralnexus.ampapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class HTTPReq {
    private static final Gson gson = new GsonBuilder().create();

    public static <T> T APICall(String endpoint, String requestMethod, Map<String, Object> data, Type returnType) {
        try {
            URL url = new URL(endpoint);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod(requestMethod);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("User-Agent", "ampapi-java/1.3.0");
            con.setConnectTimeout(5000);

            String json = gson.toJson(data);
            con.getOutputStream().write(json.getBytes());

            if (returnType == Void.class) {
                return null;
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String jsonString = br.readLine();
            br.close();

            if (jsonString.contains("Title") && jsonString.contains("Message") && jsonString.contains("StackTrace")) {
                throw new AMPAPI.AMPAPIException(gson.fromJson(jsonString, AMPAPI.AMPAPIException.Data.class));
            }
            return gson.fromJson(jsonString, returnType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
