package michelin.polytech.guidemichelin.controllers;

import lombok.extern.slf4j.Slf4j;
import michelin.polytech.guidemichelin.dto.RestaurantDto;
import michelin.polytech.guidemichelin.services.RestaurantService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestaurantController {
    public final RestaurantService restaurantService;

    public RestaurantController(RestaurantService rservice){
        this.restaurantService = rservice;
    }
    @GetMapping("/restaurants")
    public @ResponseBody List<RestaurantDto> getRestaurants(){
        System.out.println("Retourne la liste complete de tous les restaurants");
        return this.restaurantService.getAllRestaurant().stream().map(entity -> RestaurantDto.fromEntity(entity)).collect(Collectors.toList());
    }

    @GetMapping("restaurants/{id}")
    public @ResponseBody RestaurantDto getRestaurantById(@PathVariable int id){
        return RestaurantDto.fromEntity(this.restaurantService.getRestaurantById(id));
    }

    @PostMapping("/restaurants")
    public RestaurantDto postRestaurant(@Valid @RequestBody RestaurantDto resto){
        return RestaurantDto.fromEntity(this.restaurantService.addRestaurant(resto.getName(), resto.getAddress()));
    }

    @DeleteMapping("/restaurants/{id}")
    public void deleteRestaurant(@PathVariable int id){
        this.restaurantService.deleteRestaurant(id);
    }
}
