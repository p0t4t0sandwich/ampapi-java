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

- If a function returns anything in the form of `Map<String, Object>`, then you can treat it as `JSON` and parse it as such (Feel free to draft up a return type if you'd like).
- If you're running into a `GSON`/`JSON` error, the API return type may be missing a `Task<T>` or `Result<T>` wrapper (or the return type could just be wrong in general).

## Examples

### CommonAPI Example

```java
import dev.neuralnexus.ampapi.modules.CommonAPI;
import dev.neuralnexus.ampapi.types.GetStatusResult;

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
import dev.neuralnexus.ampapi.types.GetStatusResult;
import dev.neuralnexus.ampapi.types.IADSInstance;
import dev.neuralnexus.ampapi.types.Instance;

public class Main {
    public static void main(String[] args) {
        ADS API = new ADS("http://localhost:8080/", "admin", "myfancypassword123", "", "");

        // Get the available instances
        Result<List<IADSInstance>> instancesResult = API.ADSModule.GetInstances();
        List<IADSInstance> targets = instancesResult.result;

        // In this example, my Hub server is on the second target
        // If you're running a standalone setup, you can just use targets.get(0)
        IADSInstance target = targets.get(1);

        UUID hub_instance_id;

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
import dev.neuralnexus.ampapi.types.GetStatusResult;
import dev.neuralnexus.ampapi.types.LoginResult;

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
      // In reality, you'd handle this exception better
      throw new RuntimeException(e);
    }
  }
}
```

## TODO

- Add a check to see if it's been 5min since the last API call, and if so, attempt to re-log
- Might want to look into `CompletableFuture`s for async calls
- Create custom types:
  - DeploymentTemplate
  - PostCreateActions
  - ApplicationSpec
  - PortProtocol
  - PortUsage
  - LocalAMPInstance
  - ContainerMemoryPolicy
  - Single
  - FileChunkData
  - BackupManifest
  - DateTime
  - IAuditLogEntry
  - Nullable -> might be able to use an Optional for this
  - ScheduleInfo
  - TimeIntervalTrigger
  - WebSessionSummary
  - IPermissionsTreeNode
  - WebauthnLoginInfo
  - WebauthnCredentialSummary
  - MethodInfoSummary
  - ListeningPortSummary
  - TwoFactorSetupInfo
  - UserInfoSummary
  - AuthRoleSummary

## Release Notes

- `ADS#InstanceLogin` can now return another ADS, in the case of a Controller ADS proxying a login directly to a Target ADS
- Huge breakthrough with return types, most AMP C# types are now mapped to Java types, with generics and everything!
- Created custom response type for `API.Core.GetSettingsSpec`
- Created new types `RemoteTargetInfo` and `RunningTask`
- Turned `GetStatusResult` into `Status` for re-usability in `API.Core.GetUpdates`
- Created new type `Message` for `API.Core.GetUpdates`
- Added an enum for `Status#State`, which translates the integer to the enum string
- Created new type `UpdateInfo` for `API.Core.GetUpdateInfo`
- Created new type `ModuleInfo` for `API.Core.GetModuleInfo`
- Refactored all the types into one package and nested single-use types
