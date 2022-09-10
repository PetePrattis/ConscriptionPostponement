package gr.hua.dit.ds.it219151.controllers.application;

import gr.hua.dit.ds.it219151.exceptions.OnCreateApplicationException;
import gr.hua.dit.ds.it219151.forms.ApplicationForm;
import gr.hua.dit.ds.it219151.services.ApplicationService;
import gr.hua.dit.ds.it219151.validators.ApplicationFormValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class CreateApplicationController {
    private static final String APPLICATIONS_FORM = "applicationsForm";
    private static final String ERROR_MESSAGE = "errorMessage";

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ApplicationFormValidation applicationFormValidation;

    @InitBinder(APPLICATIONS_FORM)
    protected void initBinder(final WebDataBinder binder) {
        binder.addValidators(applicationFormValidation);
    }

    @GetMapping(value = "/citizen/create")
    public String createApplication(Model model) {
        model.addAttribute(APPLICATIONS_FORM, new ApplicationForm());
        return "pages/application/create_application";
    }

    @PostMapping(value = "/citizen/create")
    public String createCitizen(Model model, @Valid @ModelAttribute(APPLICATIONS_FORM) ApplicationForm applicationForm,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()) {
            model.addAttribute(ERROR_MESSAGE, "Validation errors occurred!");
            return "pages/create_application";
        }
        applicationService.createApplication(applicationForm);
        return "redirect:/citizen/home";
    }

    @ExceptionHandler({OnCreateApplicationException.class})
    public String handleCitizenNotFoundError(HttpServletRequest request,
                                           RedirectAttributes redirectAttributes,
                                             OnCreateApplicationException e)
    {
        redirectAttributes.addFlashAttribute(ERROR_MESSAGE, "error.application.create.citizen.null");
        return "redirect:/error/generic";
    }
}
