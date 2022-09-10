package gr.hua.dit.ds.it219151.services;


import gr.hua.dit.ds.it219151.exceptions.OfficeWorkerNotFoundException;
import gr.hua.dit.ds.it219151.model.OfficeWorkerModel;

public interface OfficeWorkerService {

    OfficeWorkerModel findOfficeWorkerByEmail(String email) throws OfficeWorkerNotFoundException;

    OfficeWorkerModel findOfficeWorkerById(Long id) throws OfficeWorkerNotFoundException;

}
