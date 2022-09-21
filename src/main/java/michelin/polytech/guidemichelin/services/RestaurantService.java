package michelin.polytech.guidemichelin.services;

import lombok.RequiredArgsConstructor;
import michelin.polytech.guidemichelin.dto.RestaurantDto;
import michelin.polytech.guidemichelin.entity.RestaurantEntity;
import michelin.polytech.guidemichelin.exception.InvalidValueException;
import michelin.polytech.guidemichelin.exception.ResourceDoesntExist;
import michelin.polytech.guidemichelin.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;


    public RestaurantEntity getRestaurantById(int id){
        return this.restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceDoesntExist("Restaurant with id " + id + " doesn't exists"));
    }

   public List<RestaurantEntity> getAllRestaurant(){
       return this.restaurantRepository.findAll();
   }


    public RestaurantEntity addRestaurant(final String name, final String address) {
        final RestaurantEntity newRestaurant = RestaurantEntity.builder().name(name).address(address).build();
        return this.restaurantRepository.save(newRestaurant);
    }

    public RestaurantEntity updateRestaurant(int id, String nouveauNom, String nouvelleAdresse) {
        if (nouveauNom == null) {
            throw new InvalidValueException("le nouveau nom ne doit pas être null");
        }

        if (nouvelleAdresse == null) {
            throw new InvalidValueException("la nouvelle adresse ne doit pas être null");
        }
        final RestaurantEntity restaurantToUpdate = this.restaurantRepository.findById(id).orElseThrow(() -> new ResourceDoesntExist("le restaurant avec l'id " + id + " n'existe pas"));
        restaurantToUpdate.setName(nouveauNom);
        restaurantToUpdate.setAddress(nouvelleAdresse);
        restaurantRepository.save(restaurantToUpdate);
        return restaurantToUpdate;
    }

    public void deleteRestaurant(int id){
        if (getRestaurantById(id) == null) {
            throw new ResourceDoesntExist("le restaurant n'existe pas");
        }
       this.restaurantRepository.deleteById(id);;
    }

}
