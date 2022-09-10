package gr.hua.dit.ds.it219151.mappers;

import gr.hua.dit.ds.it219151.domains.OfficeWorker;
import gr.hua.dit.ds.it219151.model.OfficeWorkerModel;
import org.springframework.stereotype.Component;


@Component
public class OfficeWorkerToOfficeWorkerModelMapper {

    public OfficeWorkerModel map(OfficeWorker officeWorker) {
        OfficeWorkerModel officeWorkerModel = new OfficeWorkerModel();
        officeWorkerModel.setId(officeWorker.getId());
        officeWorkerModel.setEmail(officeWorker.getEmail());
        officeWorkerModel.setFirstname(officeWorker.getFirstName());
        officeWorkerModel.setLastname(officeWorker.getLastName());

        return officeWorkerModel;
    }
}