package pl.pretius.exceptions;

public class MoveFileException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Unable to move file.";

    public MoveFileException(Throwable cause) {
        super(ERROR_MESSAGE, cause);
    }

}
