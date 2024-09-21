/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.ampapi.exceptions;

import dev.neuralnexus.ampapi.types.LoginResult;

public class APILoginException extends RuntimeException {
    public APILoginException(LoginResult loginResult) {
        super(loginResult.resultReason + ": " + loginResult.result + "\n" + loginResult);
    }
}
