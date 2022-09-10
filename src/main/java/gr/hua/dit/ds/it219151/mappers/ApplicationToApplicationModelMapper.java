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
        applicationModel.setCitizen_id(application.getCitizen_id());
        applicationModel.setOffice_worker_id(application.getOffice_worker_id());
        applicationModel.setArmy_officer_id(application.getArmy_officer_id());
        applicationModel.setValidated(application.getValidated());
        applicationModel.setApproved(application.getApproved());

        return applicationModel;
    }
}
