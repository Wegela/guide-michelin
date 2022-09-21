package michelin.polytech.guidemichelin.repository;

import michelin.polytech.guidemichelin.entity.EvaluationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<EvaluationEntity, Integer> {
}
