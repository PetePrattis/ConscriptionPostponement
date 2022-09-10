package gr.hua.dit.ds.it219151.services;

import gr.hua.dit.ds.it219151.domains.Application;
import gr.hua.dit.ds.it219151.domains.ArmyOfficer;
import gr.hua.dit.ds.it219151.domains.Citizen;
import gr.hua.dit.ds.it219151.domains.OfficeWorker;
import gr.hua.dit.ds.it219151.exceptions.ApplicationNotFoundException;
import gr.hua.dit.ds.it219151.exceptions.OnCreateApplicationException;
import gr.hua.dit.ds.it219151.forms.ApplicationForm;
import gr.hua.dit.ds.it219151.mappers.ApplicationFormToApplicationMapper;
import gr.hua.dit.ds.it219151.mappers.ApplicationToApplicationModelMapper;
import gr.hua.dit.ds.it219151.model.ApplicationModel;
import gr.hua.dit.ds.it219151.repositories.ApplicationRepository;
import gr.hua.dit.ds.it219151.repositories.ArmyOfficerRepository;
import gr.hua.dit.ds.it219151.repositories.CitizenRepository;
import gr.hua.dit.ds.it219151.repositories.OfficeWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    private OfficeWorkerRepository officeWorkerRepository;

    @Autowired
    private ArmyOfficerRepository armyOfficerRepository;

    @Autowired
    private ApplicationToApplicationModelMapper applicationToApplicationModel;

    @Autowired
    private ApplicationFormToApplicationMapper applicationFormToApplication;

    @Override
    public ApplicationModel findApplicationById(Long id) throws ApplicationNotFoundException {
        Optional<Application> application = applicationRepository.findById(id);
        if(application.isEmpty()) throw new ApplicationNotFoundException();
        return applicationToApplicationModel.map(application.get());
    }

    @Override
    public List<ApplicationModel> findApplicationsByCitizenId(Long id) throws ApplicationNotFoundException {
        return applicationRepository
                .findApplicationByCitizenId(id)
                .stream()
                .map(application -> applicationToApplicationModel.map(application))
                .collect(Collectors.toList());
    }

    @Override
    public List<ApplicationModel> findApplicationsByOfficeWorkerId(Long id) throws ApplicationNotFoundException {
        return applicationRepository
                .findApplicationByOfficeWorkerId(id)
                .stream()
                .map(application -> applicationToApplicationModel.map(application))
                .filter(application -> application.getValidated() == 0)
                .collect(Collectors.toList());
    }

    @Override
    public List<ApplicationModel> findApplicationsByArmyOfficerId(Long id) throws ApplicationNotFoundException {
        return applicationRepository
                .findApplicationByArmyOfficerId(id)
                .stream()
                .map(application -> applicationToApplicationModel.map(application))
                .filter(application -> application.getValidated() == 1 && application.getApproved() == 0)
                .collect(Collectors.toList());
    }

    @Override
    public ApplicationModel createApplication(ApplicationForm applicationForm) {
        try {
            Application application = applicationFormToApplication.map(applicationForm);

            Optional<OfficeWorker> officeWorker = officeWorkerRepository.findOfficeWorkerByEmail("admin@mail.com");
            Optional<ArmyOfficer> armyOfficer = armyOfficerRepository.findArmyOfficerByEmail("general@mail.com");
            application.setOfficeWorkerId(officeWorker.isEmpty() ? 0 : officeWorker.get().getId());
            application.setArmyOfficerId(armyOfficer.isEmpty() ? 0 : armyOfficer.get().getId());

            Citizen currentCitizen = (Citizen) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            application.setCitizenId(currentCitizen.getId());

            Application newApplication = applicationRepository.save(application);
            return applicationToApplicationModel.map(newApplication);

        } catch (OnCreateApplicationException e) {
            throw new OnCreateApplicationException();
        }
    }

    @Override
    public ApplicationModel updateApplication(ApplicationModel applicationModel) throws ApplicationNotFoundException {
        Optional<Application> originalApplication  = applicationRepository.findById(applicationModel.getId());
        if(originalApplication.isEmpty()) throw new ApplicationNotFoundException();
        originalApplication.get().setValidated(applicationModel.getValidated());
        originalApplication.get().setApproved(applicationModel.getApproved());

        Application newApplication = applicationRepository.save(originalApplication.get());
        return applicationToApplicationModel.map(newApplication);
    }
}
