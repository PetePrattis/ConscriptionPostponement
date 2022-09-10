package gr.hua.dit.ds.it219151.controllers.army_officer;

import gr.hua.dit.ds.it219151.model.ApplicationModel;
import gr.hua.dit.ds.it219151.model.ArmyOfficerModel;
import gr.hua.dit.ds.it219151.model.OfficeWorkerModel;
import gr.hua.dit.ds.it219151.services.ApplicationService;
import gr.hua.dit.ds.it219151.services.ArmyOfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ArmyOfficerController {

    @Autowired
    private ArmyOfficerService armyOfficerService;

    @Autowired
    private ApplicationService applicationService;

    /**
     * This method return the citizens all applications page.
     * @return Owner home page
     */
    @GetMapping("/army_officer/home")
    public String armyOfficerHomePageView(Model model) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        ArmyOfficerModel armyOfficer = armyOfficerService.findArmyOfficerByEmail(email);

        List<ApplicationModel> applicationList = new ArrayList<>();
        applicationList.addAll(applicationService.findApplicationsByOfficeWorkerId(armyOfficer.getId()));

        model.addAttribute("applicationList", applicationList);
        return "pages/armyOfficerHomePage";
    }
}
