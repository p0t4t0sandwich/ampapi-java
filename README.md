# ampapi-java

This API allows you to communicate with AMP installations from within Java.

Documentation for available API calls can be found by appending /API to the URL of any existing AMP installation.

## Installation

`{version}` just refers to the release tag, without the `v` prefix.

### Maven

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

## Notes

- If a function returns an `Object`, it's safe to assume it's a `Map`, it just doesn't have a defined type yet.

## Examples

### CommonAPI Example

```java
import dev.neuralnexus.ampapi.modules.CommonAPI;
import dev.neuralnexus.ampapi.responses.Core.GetStatusResult;

public class Main {
    public static void main(String[] args) {
        CommonAPI API = new CommonAPI("http://localhost:8080/", "admin", "myfancypassword123", "");
        
        // API call parameters are simply in the same order as shown in the documentation.
        API.Core.SendConsoleMessage("say Hello Everyone, this message was sent from the Java API!");
        
        GetStatusResult currentStatus = API.Core.GetStatus();
        double CPUUsagePercent = currentStatus.Metrics.get("CPU Usage").Percent;
        
        System.out.println("Current CPU usage is: " + CPUUsagePercent + "%");
    }
}
```

### Example using the ADS to manage an instance

```java
import dev.neuralnexus.ampapi.modules.ADS;
import dev.neuralnexus.ampapi.modules.Minecraft;
import dev.neuralnexus.ampapi.responses.ADSModule.GetInstancesResult;
import dev.neuralnexus.ampapi.responses.Core.GetStatusResult;
import dev.neuralnexus.ampapi.types.ADSInstance;
import dev.neuralnexus.ampapi.types.Instance;

public class Main {
    public static void main(String[] args) {
        ADS API = new ADS("http://localhost:8080/", "admin", "myfancypassword123", "", "");

        // Get the available instances
        GetInstancesResult instancesResult = API.ADSModule.GetInstances();
        ADSInstance[] targets = instancesResult.result;

        // In this example, my Hub server is on the second target
        // If you're running a standalone setup, you can just use targets[0]
        ADSInstance target = targets[1];

        String hub_instance_id = "";

        // Get the available instances
        Instance[] instances = target.AvailableInstances;
        for (Instance instance : instances) {
            // Find the instance named "Hub"
            if (instance.InstanceName.equals("Hub")) {
                hub_instance_id = instance.InstanceID;
                break;
            }
        }

        // Use the instance ID to get the API for the instance
        Minecraft Hub = API.InstanceLogin(hub_instance_id, Minecraft.class);

        // Get the current CPU usage
        GetStatusResult currentStatus = API.Core.GetStatus();
        double CPUUsagePercent = currentStatus.Metrics.get("CPU Usage").Percent;

        // Send a message to the console
        Hub.Core.SendConsoleMessage("say Current CPU usage is: " + CPUUsagePercent + "%");
    }
}
```

### CommonAPI Example, handling the sessionId and rememberMeToken manually (not recommended)

```java
import dev.neuralnexus.ampapi.modules.CommonAPI;
import dev.neuralnexus.ampapi.responses.Core.GetStatusResult;
import dev.neuralnexus.ampapi.responses.Core.LoginResult;

public class Main {
    public static void main(String[] args) {
        CommonAPI API = new CommonAPI("http://localhost:8080/");

        try {
            // The third parameter is either used for 2FA logins, or if no password is specified to use a remembered token from a previous login, or a service login token.
            LoginResult loginResult = API.Core.Login("admin", "myfancypassword123", "", false);

            if (loginResult.success) {
                System.out.println("Login successful");

                // Update the session ID
                String sessionId = loginResult.sessionID;
                API.sessionId = sessionId;
                API.Core.sessionId = sessionId;

                // API call parameters are simply in the same order as shown in the documentation.
                API.Core.SendConsoleMessage("say Hello Everyone, this message was sent from the Java API!");
                
                GetStatusResult currentStatus = API.Core.GetStatus();
                double CPUUsagePercent = currentStatus.Metrics.get("CPU Usage").Percent;
                
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

## TODO

- Add a check to see if it's been 5min since the last API call, and if so, attempt to re-log

## Release Notes

- `ADS#InstanceLogin` can now return another ADS, in the case of a Controller ADS proxying a login directly to a Target ADS
