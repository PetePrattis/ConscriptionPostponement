package gr.hua.dit.ds.it219151.services;

import gr.hua.dit.ds.it219151.domains.Citizen;
import gr.hua.dit.ds.it219151.exceptions.CitizenNotFoundException;
import gr.hua.dit.ds.it219151.forms.CitizenForm;
import gr.hua.dit.ds.it219151.mappers.CitizenFormToCitizenMapper;
import gr.hua.dit.ds.it219151.mappers.CitizenToCitizenModelMapper;
import gr.hua.dit.ds.it219151.model.CitizenModel;
import gr.hua.dit.ds.it219151.repositories.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CitizenServiceImpl implements CitizenService{

    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    private CitizenToCitizenModelMapper citizenToCitizenModel;

    @Autowired
    private CitizenFormToCitizenMapper citizenFormToCitizen;

    @Override
    public CitizenModel createCitizen(CitizenForm citizenForm) {
        Citizen citizen = citizenFormToCitizen.map(citizenForm);
        citizen.setPassword(new BCryptPasswordEncoder().encode(citizen.getPassword()));
        Citizen newCitizen = citizenRepository.save(citizen);
        return citizenToCitizenModel.map(newCitizen);
    }

    @Override
    public Optional<Citizen> findCitizenByEmailOptional(String email) {
        return citizenRepository.findCitizenByEmail(email);
    }

    @Override
    public CitizenModel findCitizenByEmail(String email) throws CitizenNotFoundException {
        Optional<Citizen> citizen = citizenRepository.findCitizenByEmail(email);
        if (citizen.isEmpty()) throw new CitizenNotFoundException();
        return citizenToCitizenModel.map(citizen.get());
    }

    @Override
    public CitizenModel findCitizenById(Long id) throws CitizenNotFoundException {
        Optional<Citizen> citizen = citizenRepository.findCitizenById(id);
        if (citizen.isEmpty()) throw new CitizenNotFoundException();
        return citizenToCitizenModel.map(citizen.get());
    }
}
