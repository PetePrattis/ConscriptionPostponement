package gr.hua.dit.ds.it219151.controllers.application;

import gr.hua.dit.ds.it219151.exceptions.ApplicationNotFoundException;
import gr.hua.dit.ds.it219151.model.ApplicationModel;
import gr.hua.dit.ds.it219151.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UpdateApplicationController {

    private static final String ERROR_MESSAGE = "errorMessage";

    @Autowired
    private ApplicationService applicationService;

    @GetMapping(value = "/office_worker/application/{id}/update")
    public String updateApplicationValidation(@PathVariable Long id, Model model) {
        ApplicationModel applicationModel = applicationService.findApplicationById(id);
        return "pages/office_worker/application_update";
    }

    @GetMapping(value = "/army_officer/application/{id}/update")
    public String updateApplicationApproving(@PathVariable Long id, Model model) {
        ApplicationModel applicationModel = applicationService.findApplicationById(id);
        return "pages/army_officer/application_update";
    }

    @PostMapping(value = "/application_validation/update")
    public String updateApplicationValidation(ApplicationModel applicationModel) {
        applicationService.updateApplication(applicationModel);
        return "redirect:/office_worker/home";
    }

    @PostMapping(value = "/application_approving/update")
    public String updateApplicationApproving(ApplicationModel applicationModel) {
        applicationService.updateApplication(applicationModel);
        return "redirect:/army_officer/home";
    }

    @ExceptionHandler(ApplicationNotFoundException.class)
    public String handleApplicationNotFoundError(HttpServletRequest request,
                                                   RedirectAttributes redirectAttributes,
                                                   ApplicationNotFoundException e)
    {
        redirectAttributes.addFlashAttribute(ERROR_MESSAGE, "error.application.null");
        return "redirect:/error/generic";
    }

}
