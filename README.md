# ampapi-java

## This implementation is under active development, please feel free to contribute or create an issue if you've found anything that needs fixing

This API allows you to communicate with AMP installations from within Python.

Documentation for available API calls can be found by appending /API to the URL of any existing AMP installation.

Please Note: This program is directly based on the [ampapi-node](https://github.com/CubeCoders/ampapi-node) implementation and is almost verbatim in some aspects.

## Installation

### Maven
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.p0t4t0sandwich</groupId>
    <artifactId>ampapi-java</artifactId>
    <version>{version}</version>
    <scope>provided</scope>
</dependency>
```
### Gradle
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    compileOnly 'com.github.p0t4t0sandwich:ampapi-java:{version}'
}
```

## AMPAPI Example

```java
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
```
## AMPAPIHandler Example

```java
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        AMPAPIHandler ADS = new AMPAPIHandler("http://localhost:8080/", "admin", "myfancypassword123", "", "");
        ADS.Login();

        ArrayList targets = (ArrayList) ADS.ADSModule_GetInstances().get("result");

        Map target = (Map) targets.get(1);

        ArrayList<Map<String,Object>> instances = (ArrayList<Map<String,Object>>) target.get("AvailableInstances");

        String hub_instance_id = "";

        for (Map instance : instances) {
            if (Objects.equals(instance.get("InstanceName"), "Hub")) {
                hub_instance_id = (String) instance.get("InstanceID");
                break;
            }
        }

        AMPAPIHandler Hub = ADS.InstanceLogin(hub_instance_id);
        Hub.Login();

        Map currentStatus = Hub.Core_GetStatus();

        double CPUUsagePercent = (double) ((Map) ((Map) currentStatus.get("Metrics")).get("CPU Usage")).get("Percent");
        Hub.Core_SendConsoleMessage("say Current CPU usage is: " + CPUUsagePercent + "%");
    }
}
```
