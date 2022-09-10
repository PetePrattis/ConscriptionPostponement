package gr.hua.dit.ds.it219151.mappers;

import gr.hua.dit.ds.it219151.domains.ArmyOfficer;
import gr.hua.dit.ds.it219151.model.ArmyOfficerModel;
import org.springframework.stereotype.Component;


@Component
public class ArmyOfficerToArmyOfficerModelMapper {

    public ArmyOfficerModel map(ArmyOfficer armyOfficer) {
        ArmyOfficerModel armyOfficerModel = new ArmyOfficerModel();
        armyOfficerModel.setId(armyOfficer.getId());
        armyOfficerModel.setEmail(armyOfficer.getEmail());
        armyOfficerModel.setFirstname(armyOfficer.getFirstName());
        armyOfficerModel.setLastname(armyOfficer.getLastName());

        return armyOfficerModel;
    }
}