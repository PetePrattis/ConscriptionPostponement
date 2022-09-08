package gr.hua.dit.ds.it219151.exceptions;

public class ApplicationNotFoundException extends RuntimeException{
    private static final String MESSAGE = "Application doesn't exist.";

    public ApplicationNotFoundException(Throwable t) {super(MESSAGE, t); }

    public ApplicationNotFoundException() {super(MESSAGE); }
}
