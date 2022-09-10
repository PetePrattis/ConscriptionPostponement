package gr.hua.dit.ds.it219151.controllers.citizen;

import gr.hua.dit.ds.it219151.forms.CitizenForm;
import gr.hua.dit.ds.it219151.model.CitizenModel;
import gr.hua.dit.ds.it219151.services.CitizenService;
import gr.hua.dit.ds.it219151.validators.CitizenFormValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CreateCitizenController {
    private static final String CITIZENS_FORM = "citizensForm";
    private static final String ERROR_MESSAGE = "errorMessage";

    @Autowired
    private CitizenService citizenService;

    @Autowired
    private CitizenFormValidation citizenFormValidation;

    /**
     * This method is used to initialize the validation for the citizen form.
     */
    @InitBinder(CITIZENS_FORM)
    protected void initBinder(final WebDataBinder binder) {
        binder.addValidators(citizenFormValidation);
    }

    /**
     * This method returns register citizen page.
     * @return Register Page
     */
    @GetMapping(value = "/register")
    public String registerCitizenView(Model model) {
        model.addAttribute(CITIZENS_FORM, new CitizenForm());
        return "pages/register";
    }

    /**
     * This method is used to add a citizen.
     * If validation is good, then the citizen is added.
     * Else the user is redirected to the register.
     */
    @PostMapping(value = "/register")
    public String createCitizen(Model model, @Valid @ModelAttribute(CITIZENS_FORM) CitizenForm citizenForm,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            model.addAttribute(ERROR_MESSAGE, "Validation errors occurred!");
            return "pages/register";
        }
        CitizenModel citizen = citizenService.createCitizen(citizenForm);
        return "pages/login";
    }

}
