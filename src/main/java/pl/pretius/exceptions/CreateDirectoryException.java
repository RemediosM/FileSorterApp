package pl.pretius.exceptions;

public class CreateDirectoryException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Unable to create directory.";

    public CreateDirectoryException(Throwable cause) {
        super(ERROR_MESSAGE, cause);
    }

}
