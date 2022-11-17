package ca.sperrer.p0t4t0sandwich.ampapi;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        AMPAPI API = new AMPAPI("http://localhost:8080/");

        try {
            // The third parameter is either used for 2FA logins, or if no password is specified to use a remembered token from a previous login, or a service login token.
            Map loginResult = API.Core_Login("admin", "myfancypassword123", "", false);

            if ((boolean) loginResult.get("success")) {
                System.out.println("Login successful");
                API.sessionId = (String) loginResult.get("sessionID");

                //API call parameters are simply in the same order as shown in the documentation.
                API.Core_SendConsoleMessage("say Hello Everyone, this message was sent from the Java API!");
                Map currentStatus = API.Core_GetStatus();
                double CPUUsagePercent = (double) ((Map) ((Map) currentStatus.get("Metrics")).get("CPU Usage")).get("Percent");
                System.out.println("Current CPU usage is: " + CPUUsagePercent + "%");


            } else {
                System.out.println("Login failed");
                System.out.println(loginResult);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
