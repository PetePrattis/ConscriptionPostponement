package gr.hua.dit.ds.it219151.services;

import gr.hua.dit.ds.it219151.domains.Citizen;
import gr.hua.dit.ds.it219151.exceptions.CitizenNotFoundException;
import gr.hua.dit.ds.it219151.forms.CitizenForm;
import gr.hua.dit.ds.it219151.model.CitizenModel;

import java.util.Optional;

public interface CitizenService {
    CitizenModel createCitizen(CitizenForm citizenForm);

    Optional<Citizen> findCitizenByEmailOptional(String email);

    CitizenModel findCitizenByEmail(String email) throws CitizenNotFoundException;

    CitizenModel findCitizenById(Long id) throws CitizenNotFoundException;

}
