package by.epam.airline.exceptions;

public class PlaneTechnicalException extends Exception {

    public PlaneTechnicalException(String message, Throwable exception) {
        super(message, exception);
    }

}
