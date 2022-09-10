package gr.hua.dit.ds.it219151.forms;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ApplicationForm {
    private static final String DATE_PATTERN = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-((19|2[0-9])[0-9]{2})$";

    private String document;

    @Pattern(regexp = DATE_PATTERN, message = "{createApplication.birthdate.pattern.invalid}")
    @NotEmpty(message = "{register.not.null}")
    private String birthday;


    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

}