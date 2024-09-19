package dev.neuralnexus.ampapi.exceptions;

import dev.neuralnexus.ampapi.types.LoginResult;

public class APILoginException extends RuntimeException {
    public APILoginException(LoginResult loginResult) {
        super(loginResult.resultReason + ": " + loginResult.result + "\n" + loginResult);
    }
}
