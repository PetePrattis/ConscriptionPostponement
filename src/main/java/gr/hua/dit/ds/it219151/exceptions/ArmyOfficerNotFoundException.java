package gr.hua.dit.ds.it219151.exceptions;

public class ArmyOfficerNotFoundException  extends RuntimeException{
    private static final String MESSAGE = "Army Officer doesn't exist.";

    public ArmyOfficerNotFoundException(Throwable t) {super(MESSAGE, t); }

    public ArmyOfficerNotFoundException() {super(MESSAGE); }
}
