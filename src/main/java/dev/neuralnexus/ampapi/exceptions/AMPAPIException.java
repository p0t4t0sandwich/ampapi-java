/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.ampapi.exceptions;

public class AMPAPIException extends RuntimeException {
    public AMPAPIException(Data data) {
        super(data.Title + ": " + data.Message + "\n" + data.StackTrace);
    }

    public static class Data {
        public String Title;
        public String Message;
        public String StackTrace;
    }
}
