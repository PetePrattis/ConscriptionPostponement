package gr.hua.dit.ds.it219151.mappers;

import gr.hua.dit.ds.it219151.domains.Citizen;
import gr.hua.dit.ds.it219151.model.CitizenModel;
import org.springframework.stereotype.Component;

@Component
public class CitizenToCitizenModelMapper {

    public CitizenModel map(Citizen citizen) {
        CitizenModel citizenModel = new CitizenModel();
        citizenModel.setId(citizen.getId());
        citizenModel.setEmail(citizen.getEmail());
        citizenModel.setFirstname(citizen.getFirstName());
        citizenModel.setLastname(citizen.getLastName());
        citizenModel.setEnlistment_number(citizen.getEnlistment_number());

        return citizenModel;
    }
}
