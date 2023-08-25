package dev.neuralnexus.ampapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AMPAPI {
    public String baseUri;
    public final String dataSource;
    public String username;
    public String password;
    public String rememberMeToken;
    public String sessionId;

    /**
     * Constructor
     * @param baseUri The base URI of the AMP instance
     */
    public AMPAPI(String baseUri) {
        this.baseUri = baseUri;

        if (baseUri.charAt(baseUri.length() - 1) == '/') {
            this.dataSource = this.baseUri + "API/";
        } else {
            this.dataSource = this.baseUri + "/API/";
        }
    }

    /**
     * Constructor
     * @param ampapi The AMPAPI to copy
     */
    public AMPAPI(AMPAPI ampapi) {
        this.baseUri = ampapi.baseUri;

        if (this.baseUri.charAt(baseUri.length() - 1) == '/') {
            this.dataSource = this.baseUri + "API/";
        } else {
            this.dataSource = this.baseUri + "/API/";
        }

        this.username = ampapi.username;
        this.password = ampapi.password;
        this.rememberMeToken = ampapi.rememberMeToken;
        this.sessionId = ampapi.sessionId;
    }

    /**
     * Constructor
     * @param baseUri The base URI of the AMP instance
     * @param username The username to log in with
     * @param password The password to log in with
     * @param rememberMeToken The rememberMeToken to log in with
     *                        (if you don't have one, use an empty string)
     * @param sessionId The session ID to log in with
     *                  (if you don't have one, use an empty string)
     */
    public AMPAPI(String baseUri, String username, String password, String rememberMeToken, String sessionId) {
        this.baseUri = baseUri;

        if (this.baseUri.charAt(baseUri.length() - 1) == '/') {
            this.dataSource = this.baseUri + "API/";
        } else {
            this.dataSource = this.baseUri + "/API/";
        }

        if (!this.baseUri.endsWith("/")) {
            this.baseUri += "/";
        }
        this.username = username;
        this.password = password;
        this.rememberMeToken = rememberMeToken;
        this.sessionId = sessionId;
    }

    /**
     * General API call method.
     * @param endpoint The endpoint to call.
     * @param requestMethod The request method to use.
     * @param returnClass The class to use when serializing the response.
     */
    public <T> T APICall(String endpoint, String requestMethod, Map<String, Object> data, Class<T> returnClass) {
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
        return this.APICall(endpoint, requestMethod, data, Map.class);
    }

    /**
     * General API call method.
     * @param endpoint The endpoint to call.
     * @param data The data to send.
     */
    public <T> T APICall(String endpoint, Map<String, Object> data, Class<T> returnClass) {
        data.put("SESSIONID", this.sessionId);
        return this.APICall(endpoint, "POST", data, returnClass);
    }

    /**
     * General API call method.
     * @param endpoint The endpoint to call.
     * @param data The data to send.
     */
    public Map<?,?> APICall(String endpoint, Map<String, Object> data) {
        return this.APICall(endpoint, data, Map.class);
    }

    /**
     * General API call method.
     * @param endpoint The endpoint to call.
     */
    public Map<?,?> APICall(String endpoint) {
        return this.APICall(endpoint, new HashMap<>());
    }

    /**
     * Simplified login function
     * @return The result of the login
     */
    public Map<?, ?> Login() {
        Map<String, Object> args = new HashMap<>();
        args.put("username", this.username);
        args.put("password", this.password);
        args.put("token", this.rememberMeToken);
        args.put("rememberMe", true);
        Map<String, Object> loginResult = (Map<String, Object>) this.APICall("Core/Login", args);
        if (loginResult != null && loginResult.containsKey("success") && (boolean) loginResult.get("success")) {
            this.rememberMeToken = (String) loginResult.get("rememberMeToken");
            this.sessionId = (String) loginResult.get("sessionID");
        }
        return loginResult;
    }
}
