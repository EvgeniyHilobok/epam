package by.epam.airline.exceptions;

public class PlaneLogicException extends Exception {

    public PlaneLogicException() {
    }

    public PlaneLogicException(String message, Throwable exception) {
        super(message, exception);
    }

    public PlaneLogicException(String message) {
        super(message);
    }

    public PlaneLogicException(Throwable exception) {
        super(exception);
    }
}
