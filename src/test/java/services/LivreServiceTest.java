package services;

import michelin.polytech.guidemichelin.entity.RestaurantEntity;
import michelin.polytech.guidemichelin.exception.InvalidValueException;
import michelin.polytech.guidemichelin.exception.ResourceDoesntExist;
import michelin.polytech.guidemichelin.repository.RestaurantRepository;
import michelin.polytech.guidemichelin.services.RestaurantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LivreServiceTest {

    @InjectMocks
    private RestaurantService restaurantService;

    @Mock
    private RestaurantRepository restaurantRepository;

    @Test()
    public void shouldThrowAInvalidValueException() {
        assertThrows(InvalidValueException.class, () -> this.restaurantService.updateRestaurant(1, null, null));
    }

    @Test()
    public void shouldThrownAResourceDoesntExist() {
        when(restaurantRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(ResourceDoesntExist.class, () -> this.restaurantService.updateRestaurant(1, "nouveau nom", "nouvelle adresse"));
    }

    @Test()
    public void shouldReturnALivreEntity() {
        RestaurantEntity expected = RestaurantEntity.builder().id(1).build();
        when(restaurantRepository.findById(any())).thenReturn(Optional.of(expected));
        RestaurantEntity result = this.restaurantService.getRestaurantById(1);
        assertEquals(expected, result);
    }

}
