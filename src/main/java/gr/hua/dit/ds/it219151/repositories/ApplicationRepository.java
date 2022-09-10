package gr.hua.dit.ds.it219151.repositories;

import gr.hua.dit.ds.it219151.domains.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    Optional<Application> findApplicationByCitizenId(Long id);
    Optional<Application> findApplicationByOfficeWorkerId(Long id);
    Optional<Application> findApplicationByArmyOfficerId(Long id);

}
