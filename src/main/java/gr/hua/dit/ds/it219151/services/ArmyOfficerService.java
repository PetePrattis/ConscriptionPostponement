package gr.hua.dit.ds.it219151.services;

import gr.hua.dit.ds.it219151.exceptions.ArmyOfficerNotFoundException;
import gr.hua.dit.ds.it219151.model.ArmyOfficerModel;

public interface ArmyOfficerService {

    ArmyOfficerModel findArmyOfficerByEmail(String email) throws ArmyOfficerNotFoundException;

    ArmyOfficerModel findArmyOfficerById(Long id) throws ArmyOfficerNotFoundException;

}
