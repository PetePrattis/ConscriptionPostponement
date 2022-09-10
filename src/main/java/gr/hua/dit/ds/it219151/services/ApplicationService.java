package gr.hua.dit.ds.it219151.services;

import gr.hua.dit.ds.it219151.exceptions.ApplicationNotFoundException;
import gr.hua.dit.ds.it219151.forms.ApplicationForm;
import gr.hua.dit.ds.it219151.model.ApplicationModel;

import java.util.List;

public interface ApplicationService {

    ApplicationModel findApplicationById(Long id) throws ApplicationNotFoundException;

    List<ApplicationModel> findApplicationsByCitizenId(Long id) throws ApplicationNotFoundException;

    List<ApplicationModel> findApplicationsByOfficeWorkerId(Long id) throws ApplicationNotFoundException;

    List<ApplicationModel> findApplicationsByArmyOfficerId(Long id) throws ApplicationNotFoundException;

    ApplicationModel createApplication(ApplicationForm applicationForm);

    ApplicationModel updateApplication(ApplicationModel applicationModel) throws ApplicationNotFoundException;

}
