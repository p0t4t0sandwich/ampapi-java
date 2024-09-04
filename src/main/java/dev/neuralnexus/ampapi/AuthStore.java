package dev.neuralnexus.ampapi;

import java.util.HashMap;
import java.util.Map;

public class AuthStore {
    public final String dataSource;
    public String baseUri;
    public String username;
    public String password;
    public Map<String, InstanceCredentials> credentialsMap = new HashMap<>();
    public String requestMethod = "POST";

    /**
     * Constructor
     *
     * @param baseUri The base URI of the AMP instance
     * @param username The username to log in with
     * @param password The password to log in with
     */
    public AuthStore(String baseUri, String username, String password) {
        this.baseUri = baseUri;

        if (!this.baseUri.endsWith("/")) {
            this.baseUri += "/";
        }
        this.dataSource = this.baseUri + "API/";

        this.username = username;
        this.password = password;
    }

    public void addInstance(String instanceName, String instanceId, String rememberMeToken, String sessionId) {
        credentialsMap.put(instanceName, new InstanceCredentials(instanceId, this.username, this.password, rememberMeToken, sessionId));
    }

    public void addInstance(String instanceName, String instanceId, String username, String password, String rememberMeToken, String sessionId) {
        credentialsMap.put(instanceName, new InstanceCredentials(instanceId, username, password, rememberMeToken, sessionId));
    }

    public static class InstanceCredentials {
        public final String instanceId;
        public final String username;
        public final String password;
        public String rememberMeToken;
        public String sessionId;
        public int relogInterval = 1000 * 60 * 5;
        private long lastAPICall = System.currentTimeMillis();

        public InstanceCredentials(String instanceId, String username, String password, String rememberMeToken, String sessionId) {
            this.instanceId = instanceId;
            this.username = username;
            this.password = password;
            this.rememberMeToken = rememberMeToken;
            this.sessionId = sessionId;
        }
    }
}
