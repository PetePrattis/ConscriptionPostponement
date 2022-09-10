package gr.hua.dit.ds.it219151.validators;

import gr.hua.dit.ds.it219151.domains.Citizen;
import gr.hua.dit.ds.it219151.forms.CitizenForm;
import gr.hua.dit.ds.it219151.services.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class CitizenFormValidation implements Validator{

    @Autowired
    private CitizenService citizenService;

    @Override
    public boolean supports(Class<?> aClass) {
        return CitizenForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CitizenForm registrationForm = (CitizenForm) target;


        Optional<Citizen> citizenByEmail = citizenService.findCitizenByEmailOptional(registrationForm.getEmail());
        if (citizenByEmail.isPresent()) {
            errors.rejectValue("email", "register.email.taken.error");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "register.not.null.or.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "register.not.null.or.empty");
    }
}
