package gr.hua.dit.ds.it219151.services;

import gr.hua.dit.ds.it219151.domains.ArmyOfficer;
import gr.hua.dit.ds.it219151.domains.Citizen;
import gr.hua.dit.ds.it219151.domains.OfficeWorker;
import gr.hua.dit.ds.it219151.model.LoginResponse;
import gr.hua.dit.ds.it219151.repositories.ArmyOfficerRepository;
import gr.hua.dit.ds.it219151.repositories.CitizenRepository;
import gr.hua.dit.ds.it219151.repositories.OfficeWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    private OfficeWorkerRepository officeWorkerRepository;

    @Autowired
    private ArmyOfficerRepository armyOfficerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<Citizen> optionalCitizen = citizenRepository.findCitizenByEmail(email);

        Optional<OfficeWorker> optionalOfficeWorker = officeWorkerRepository.findOfficeWorkerByEmail(email);

        Optional<ArmyOfficer> optionalArmyOfficer = armyOfficerRepository.findArmyOfficerByEmail(email);

        if(optionalCitizen.isPresent()) {
            Citizen user = optionalCitizen.get();
            return new LoginResponse(user.getEmail(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("CITIZEN")));
        }
        else if (optionalArmyOfficer.isPresent()) {
            ArmyOfficer user = optionalArmyOfficer.get();
            return new LoginResponse(user.getEmail(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("ARMY_OFFICER")));

        }
        else if (optionalOfficeWorker.isPresent()) {
            OfficeWorker user = optionalOfficeWorker.get();
            return new LoginResponse(user.getEmail(), user.getPassword(), Collections.singletonList(new SimpleGrantedAuthority("OFFICE_WORKER")));
        }
        else {
            throw new UsernameNotFoundException(email);
        }

    }
}
