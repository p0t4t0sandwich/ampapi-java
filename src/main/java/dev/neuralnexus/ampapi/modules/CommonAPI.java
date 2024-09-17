package dev.neuralnexus.ampapi.modules;

import dev.neuralnexus.ampapi.AMPAPI;
import dev.neuralnexus.ampapi.apimodules.*;
import dev.neuralnexus.ampapi.auth.AuthStore;

public class CommonAPI extends AMPAPI {
    public final Core Core;
    public final EmailSenderPlugin EmailSenderPlugin;
    public final FileManagerPlugin FileManagerPlugin;
    public final LocalFileBackupPlugin LocalFileBackupPlugin;

    public CommonAPI(AuthStore authStore, String instanceName) {
        super(authStore, instanceName);
        this.Core = new Core(authStore, instanceName);
        this.EmailSenderPlugin = new EmailSenderPlugin(authStore, instanceName);
        this.FileManagerPlugin = new FileManagerPlugin(authStore, instanceName);
        this.LocalFileBackupPlugin = new LocalFileBackupPlugin(authStore, instanceName);
    }
}
