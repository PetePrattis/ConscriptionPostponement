package gr.hua.dit.ds.it219151.repositories;

import gr.hua.dit.ds.it219151.domains.ArmyOfficer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArmyOfficerRepository extends JpaRepository<ArmyOfficer, Long> {

    Optional<ArmyOfficer> findArmyOfficerById(Long id);

    Optional<ArmyOfficer> findArmyOfficerByEmail(String email);
}
