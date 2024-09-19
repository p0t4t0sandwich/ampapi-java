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
