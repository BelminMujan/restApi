package task.job.restApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.job.restApi.model.Opcina;

public interface OpcinaRepository extends JpaRepository<Opcina, Long> {
}
