package michelin.polytech.guidemichelin.repository;

import michelin.polytech.guidemichelin.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Integer> {
}
