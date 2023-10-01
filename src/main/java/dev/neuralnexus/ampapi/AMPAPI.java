package dev.neuralnexus.ampapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.neuralnexus.ampapi.types.LoginResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
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
    public String requestMethod = "POST";
    private long lastAPICall = System.currentTimeMillis();
    public int relogInterval = 1000*60*5;

    /**
     * Constructor
     * @param baseUri The base URI of the AMP instance
     */
    public AMPAPI(String baseUri) {
        this.baseUri = baseUri;

        if (!this.baseUri.endsWith("/")) {
            this.baseUri += "/";
        }
        this.dataSource = this.baseUri + "API/";
    }

    /**
     * Constructor
     * @param ampapi The AMPAPI to copy
     */
    public AMPAPI(AMPAPI ampapi) {
        this.baseUri = ampapi.baseUri;

        if (!this.baseUri.endsWith("/")) {
            this.baseUri += "/";
        }
        this.dataSource = this.baseUri + "API/";

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

        if (!this.baseUri.endsWith("/")) {
            this.baseUri += "/";
        }
        this.dataSource = this.baseUri + "API/";

        this.username = username;
        this.password = password;
        this.rememberMeToken = rememberMeToken;
        this.sessionId = sessionId;
    }

    /**
     * General API call method.
     * @param endpoint The endpoint to call.
     * @param data The data to send.
     * @param returnType The class to use when serializing the response.
     */
    public Object APICall(String endpoint, Map<String, Object> data, Type returnType) {
        // Check the last API call time, and if it's been more than the relog interval, relog.
        long now = System.currentTimeMillis();
        if (now - this.lastAPICall > this.relogInterval) {
            this.lastAPICall = now;
            this.Login();
        } else {
            this.lastAPICall = now;
        }
        data.put("SESSIONID", this.sessionId);

        try {
            Gson gson = new GsonBuilder().create();

            URL url = new URL(this.dataSource + endpoint);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod(this.requestMethod);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            con.setRequestProperty("User-Agent", "ampapi-java/1.2.4");
            con.setConnectTimeout(5000);

            String json = gson.toJson(data);
            con.getOutputStream().write(json.getBytes());

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

            if (returnType == Void.class) {
                return null;
            }
            String line = br.readLine();
            br.close();
            return gson.fromJson(line, returnType);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Simplified login function
     * @return The result of the login
     */
    public LoginResult Login() {
        Map<String, Object> args = new HashMap<>();
        args.put("username", this.username);
        args.put("password", this.password);
        args.put("token", this.rememberMeToken);
        args.put("rememberMe", true);

        // If remember me token is empty, use the password.
        if (this.rememberMeToken.isEmpty()) {
            args.put("password", this.password);
        }

        LoginResult loginResult = (LoginResult) this.APICall("Core/Login", args, LoginResult.class);

        if (loginResult.success) {
            this.rememberMeToken = loginResult.rememberMeToken;
            this.sessionId = loginResult.sessionID;
        }
        return loginResult;
    }
}
