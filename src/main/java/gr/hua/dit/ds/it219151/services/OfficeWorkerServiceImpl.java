package gr.hua.dit.ds.it219151.services;

import gr.hua.dit.ds.it219151.domains.OfficeWorker;
import gr.hua.dit.ds.it219151.exceptions.CitizenNotFoundException;
import gr.hua.dit.ds.it219151.exceptions.OfficeWorkerNotFoundException;
import gr.hua.dit.ds.it219151.mappers.OfficeWorkerToOfficeWorkerModelMapper;
import gr.hua.dit.ds.it219151.model.OfficeWorkerModel;
import gr.hua.dit.ds.it219151.repositories.OfficeWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfficeWorkerServiceImpl implements OfficeWorkerService{

    @Autowired
    private OfficeWorkerRepository officeWorkerRepository;

    @Autowired
    private OfficeWorkerToOfficeWorkerModelMapper officeWorkerToOfficeWorkerModel;


    @Override
    public OfficeWorkerModel findOfficeWorkerByEmail(String email) throws OfficeWorkerNotFoundException {
        Optional<OfficeWorker> officeWorker = officeWorkerRepository.findOfficeWorkerByEmail(email);
        if (officeWorker.isEmpty()) throw new CitizenNotFoundException();
        return officeWorkerToOfficeWorkerModel.map(officeWorker.get());
    }

    @Override
    public OfficeWorkerModel findOfficeWorkerById(Long id) throws OfficeWorkerNotFoundException {
        Optional<OfficeWorker> officeWorker = officeWorkerRepository.findOfficeWorkerById(id);
        if (officeWorker.isEmpty()) throw new CitizenNotFoundException();
        return officeWorkerToOfficeWorkerModel.map(officeWorker.get());
    }
}
