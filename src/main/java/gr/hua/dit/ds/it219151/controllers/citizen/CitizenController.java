package gr.hua.dit.ds.it219151.controllers.citizen;

import gr.hua.dit.ds.it219151.domains.Application;
import gr.hua.dit.ds.it219151.model.ApplicationModel;
import gr.hua.dit.ds.it219151.model.CitizenModel;
import gr.hua.dit.ds.it219151.services.ApplicationService;
import gr.hua.dit.ds.it219151.services.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CitizenController {

    @Autowired
    private CitizenService citizenService;

    @Autowired
    private ApplicationService applicationService;

    /**
     * This method return the citizens all applications page.
     * @return Owner home page
     */
    @GetMapping("/citizen/home")
    public String citizenHomePageView(Model model) {
       String email = SecurityContextHolder.getContext().getAuthentication().getName();
        CitizenModel citizen = citizenService.findCitizenByEmail(email);

        List<ApplicationModel> applicationList = new ArrayList<>();
        applicationList.addAll(applicationService.findApplicationsByCitizenId(citizen.getId()));

        model.addAttribute("applicationList", applicationList);
        return "pages/citizenHomePage";
    }

}
