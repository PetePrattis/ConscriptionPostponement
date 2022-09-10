package gr.hua.dit.ds.it219151.exceptions;

public class CitizenNotFoundException extends RuntimeException{
    private static final String MESSAGE = "Citizen doesn't exist.";

    public CitizenNotFoundException(Throwable t) {super(MESSAGE, t); }

    public CitizenNotFoundException() {super(MESSAGE); }

}
