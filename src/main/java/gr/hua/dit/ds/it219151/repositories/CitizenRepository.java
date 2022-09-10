package gr.hua.dit.ds.it219151.repositories;

import gr.hua.dit.ds.it219151.domains.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CitizenRepository extends JpaRepository<Citizen, Long> {

    Optional<Citizen> findCitizenById(Long id);

    Optional<Citizen> findCitizenByEmail(String email);
}
