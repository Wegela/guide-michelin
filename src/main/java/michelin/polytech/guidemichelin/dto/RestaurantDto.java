package michelin.polytech.guidemichelin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import michelin.polytech.guidemichelin.entity.RestaurantEntity;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RestaurantDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    @Size(max = 90)
    private String name;

    @JsonProperty("address")
    @Size(max = 255)
    private String address;

    //@JsonProperty("commentaires")
    //private List<EvaluationDto> evaluation;

    public static RestaurantDto fromEntity(RestaurantEntity restaurantEntity) {
        return RestaurantDto.builder().
                id(restaurantEntity.getId())
                .name(restaurantEntity.getName())
                .address(restaurantEntity.getAddress())
                //.commentaires(restaurantEntity.getCommentaires().stream().map(commentaire -> CommentaireDto.fromEntity(commentaire)).collect(Collectors.toList()))
                .build();
    }
}
