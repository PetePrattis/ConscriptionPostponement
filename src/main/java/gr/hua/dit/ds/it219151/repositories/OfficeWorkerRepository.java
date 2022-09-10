package gr.hua.dit.ds.it219151.repositories;

import gr.hua.dit.ds.it219151.domains.OfficeWorker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfficeWorkerRepository extends JpaRepository<OfficeWorker, Long> {

    Optional<OfficeWorker> findOfficeWorkerById(Long id);

    Optional<OfficeWorker> findOfficeWorkerByEmail(String email);
}
