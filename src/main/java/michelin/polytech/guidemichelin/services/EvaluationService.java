package michelin.polytech.guidemichelin.services;

import lombok.RequiredArgsConstructor;
import michelin.polytech.guidemichelin.entity.EvaluationEntity;
import michelin.polytech.guidemichelin.entity.RestaurantEntity;
import michelin.polytech.guidemichelin.exception.ResourceDoesntExist;
import michelin.polytech.guidemichelin.repository.EvaluationRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EvaluationService {

    private final EvaluationRepository evaluationRepository;
    private final RestaurantService restaurantService;

    public EvaluationEntity getEvaluationById(final int id){
        return this.evaluationRepository.findById(id)
                .orElseThrow(() -> new ResourceDoesntExist("Restaurant with id " + id + " doesn't exists"));
    }
    public EvaluationEntity addEvaluation(int restaurantId, String commentaire, String nom_evaluateur, int note){
        final RestaurantEntity restaurant = restaurantService.getRestaurantById(restaurantId);
        final EvaluationEntity newEvaluation = EvaluationEntity.builder().nom_evaluateur(nom_evaluateur).commentaire(commentaire).note(note).restaurant(restaurant).build();


        return this.evaluationRepository.save(newEvaluation);
    }
}
