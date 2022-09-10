package gr.hua.dit.ds.it219151.validators;

import gr.hua.dit.ds.it219151.forms.ApplicationForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ApplicationFormValidation implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return ApplicationForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "document", "register.not.null.or.empty");
    }
}
