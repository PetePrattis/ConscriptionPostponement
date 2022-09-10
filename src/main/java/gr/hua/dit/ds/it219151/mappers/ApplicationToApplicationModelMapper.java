package gr.hua.dit.ds.it219151.mappers;

import gr.hua.dit.ds.it219151.domains.Application;
import gr.hua.dit.ds.it219151.model.ApplicationModel;
import org.springframework.stereotype.Component;

@Component
public class ApplicationToApplicationModelMapper {

    public ApplicationModel map(Application application) {
        ApplicationModel applicationModel = new ApplicationModel();
        applicationModel.setId(application.getId());
        applicationModel.setDocument(application.getDocument());
        applicationModel.setBirthday(application.getBirthday());
        applicationModel.setCitizen_id(application.getCitizenId());
        applicationModel.setOffice_worker_id(application.getOfficeWorkerId());
        applicationModel.setArmy_officer_id(application.getArmyOfficerId());
        applicationModel.setValidated(application.getValidated());
        applicationModel.setApproved(application.getApproved());

        return applicationModel;
    }
}
