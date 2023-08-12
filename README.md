# ampapi-java

This API allows you to communicate with AMP installations from within Java.

Documentation for available API calls can be found by appending /API to the URL of any existing AMP installation.

## Installation

### Maven

`{version}` just refers to the release tag, without the `v` prefix.

```xml
<repository>
    <id>neural-nexus</id>
    <name>NerualNexus</name>
    <url>https://maven.neuralnexus.dev/releases</url>
</repository>

<dependency>
    <groupId>dev.neuralnexus</groupId>
    <artifactId>ampapi</artifactId>
    <version>{version}</version>
    <scope>provided</scope>
</dependency>
```

### Gradle

```gradle
maven {
    name "NerualNexus"
    url "https://maven.neuralnexus.dev/releases"
}

dependencies {
    implementation 'dev.neuralnexus:ampapi:{version}'
}
```

## AMPAPI Example

```java
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        AMPAPI API = new AMPAPI("http://localhost:8080/");

        try {
            // The third parameter is either used for 2FA logins, or if no password is specified to use a remembered token from a previous login, or a service login token.
            HashMap loginResult = API.Core_Login("admin", "myfancypassword123", "", false);

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
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        AMPAPIHandler ADS = new AMPAPIHandler("http://localhost:8080/", "admin", "myfancypassword123", "", "");
        ADS.Login();

        ArrayList targets = (ArrayList) ADS.ADSModule_GetInstances().get("result");

        HashMap target = (HashMap) targets.get(1);

        ArrayList<HashMap<String,Object>> instances = (ArrayList<HashMap<String,Object>>) target.get("AvailableInstances");

        String hub_instance_id = "";

        for (HashMap instance : instances) {
            if (Objects.equals(instance.get("InstanceName"), "Hub")) {
                hub_instance_id = (String) instance.get("InstanceID");
                break;
            }
        }

        AMPAPIHandler Hub = ADS.InstanceLogin(hub_instance_id);
        Hub.Login();

        Map currentStatus = Hub.Core_GetStatus();

        double CPUUsagePercent = (double) ((HashMap) ((HashMap) currentStatus.get("Metrics")).get("CPU Usage")).get("Percent");
        Hub.Core_SendConsoleMessage("say Current CPU usage is: " + CPUUsagePercent + "%");
    }
}
```
