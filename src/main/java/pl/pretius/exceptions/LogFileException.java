package pl.pretius.exceptions;

public class LogFileException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Cannot open or modify a log file.";

    public LogFileException(Throwable cause) {
        super(ERROR_MESSAGE, cause);
    }

}
