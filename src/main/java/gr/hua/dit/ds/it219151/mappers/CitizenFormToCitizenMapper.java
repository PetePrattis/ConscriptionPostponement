package gr.hua.dit.ds.it219151.mappers;

import gr.hua.dit.ds.it219151.domains.Citizen;
import gr.hua.dit.ds.it219151.forms.CitizenForm;
import org.springframework.stereotype.Component;

@Component
public class CitizenFormToCitizenMapper {

    public Citizen map(CitizenForm citizenForm) {
        Citizen citizen = new Citizen();
        citizen.setEmail(citizenForm.getEmail());
        citizen.setFirstName(citizenForm.getFirstName());
        citizen.setLastName(citizenForm.getLastName());

        return citizen;
    }
}
