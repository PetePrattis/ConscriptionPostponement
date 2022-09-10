package gr.hua.dit.ds.it219151.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CitizenForm {
    private static final String EMAIL_PATTERN = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$";

    @Pattern(regexp = EMAIL_PATTERN, message = "{createCitizen.email.pattern.invalid}")
    @NotEmpty(message = "{register.not.null}")
    private String email;
    private String firstName;
    private String lastName;

    public static String getEmailPattern() {
        return EMAIL_PATTERN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
