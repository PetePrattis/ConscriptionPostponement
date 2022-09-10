package gr.hua.dit.ds.it219151.services;

import gr.hua.dit.ds.it219151.domains.ArmyOfficer;
import gr.hua.dit.ds.it219151.exceptions.ArmyOfficerNotFoundException;
import gr.hua.dit.ds.it219151.exceptions.CitizenNotFoundException;
import gr.hua.dit.ds.it219151.mappers.ArmyOfficerToArmyOfficerModelMapper;
import gr.hua.dit.ds.it219151.model.ArmyOfficerModel;
import gr.hua.dit.ds.it219151.repositories.ArmyOfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArmyOfficerServiceImpl implements ArmyOfficerService{

    @Autowired
    private ArmyOfficerRepository armyOfficerRepository;

    @Autowired
    private ArmyOfficerToArmyOfficerModelMapper armyOfficerToArmyOfficerModel;

    @Override
    public ArmyOfficerModel findArmyOfficerByEmail(String email) throws ArmyOfficerNotFoundException {
        Optional<ArmyOfficer> armyOfficer = armyOfficerRepository.findArmyOfficerByEmail(email);
        if (armyOfficer.isEmpty()) throw new CitizenNotFoundException();
        return armyOfficerToArmyOfficerModel.map(armyOfficer.get());
    }

    @Override
    public ArmyOfficerModel findArmyOfficerById(Long id) throws ArmyOfficerNotFoundException {
        Optional<ArmyOfficer> armyOfficer = armyOfficerRepository.findArmyOfficerById(id);
        if (armyOfficer.isEmpty()) throw new CitizenNotFoundException();
        return armyOfficerToArmyOfficerModel.map(armyOfficer.get());
    }
}
