package task.job.restApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.job.restApi.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
