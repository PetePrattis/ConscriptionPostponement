package gr.hua.dit.ds.it219151.exceptions;

public class OnCreateApplicationException extends RuntimeException {
    private static final String MESSAGE = "Citizen doesn't exist. Cannot create Application.";

    public OnCreateApplicationException(Throwable t) {
        super(MESSAGE, t);
    }

    public OnCreateApplicationException() {
        super(MESSAGE);
    }
}
