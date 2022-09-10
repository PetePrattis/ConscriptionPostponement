package gr.hua.dit.ds.it219151.controllers.office_worker;

import gr.hua.dit.ds.it219151.model.ApplicationModel;
import gr.hua.dit.ds.it219151.model.OfficeWorkerModel;
import gr.hua.dit.ds.it219151.services.ApplicationService;
import gr.hua.dit.ds.it219151.services.OfficeWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OfficeWorkerController {

    @Autowired
    private OfficeWorkerService officeWorkerService;

    @Autowired
    private ApplicationService applicationService;

    /**
     * This method return the citizens all applications page.
     * @return Owner home page
     */
    @GetMapping("/office_worker/home")
    public String officeWorkerHomePageView(Model model) {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        OfficeWorkerModel officeWorker = officeWorkerService.findOfficeWorkerByEmail(email);

        List<ApplicationModel> applicationList = new ArrayList<>();
        applicationList.addAll(applicationService.findApplicationsByOfficeWorkerId(officeWorker.getId()));

        model.addAttribute("applicationList", applicationList);
        return "pages/officeWorkerHomePage";
    }
}
