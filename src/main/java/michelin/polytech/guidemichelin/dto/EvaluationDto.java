package michelin.polytech.guidemichelin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import michelin.polytech.guidemichelin.entity.EvaluationEntity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class EvaluationDto {


    private int id;

    @NotBlank
    @JsonProperty("nom_evaluateur")
    @Size(max = 50)
    private String nom_evaluateur;

    @NotBlank
    @JsonProperty("commentaire")
    @Size(max = 255)
    private String commentaire;

    @NotBlank
    @JsonProperty("note")
    private int note;

    public static EvaluationDto fromEntity(EvaluationEntity entity){
        return EvaluationDto.builder().id(entity.getId()).nom_evaluateur(entity.getNom_evaluateur()).commentaire(entity.getCommentaire()).note(entity.getNote()).build();
    }
}
