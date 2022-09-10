package gr.hua.dit.ds.it219151.exceptions;

public class OfficeWorkerNotFoundException extends RuntimeException{
    private static final String MESSAGE = "Office Worker doesn't exist.";

    public OfficeWorkerNotFoundException(Throwable t) {super(MESSAGE, t); }

    public OfficeWorkerNotFoundException() {super(MESSAGE); }
}
