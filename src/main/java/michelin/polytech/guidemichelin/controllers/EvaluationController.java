package michelin.polytech.guidemichelin.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import michelin.polytech.guidemichelin.dto.EvaluationDto;
import michelin.polytech.guidemichelin.services.EvaluationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequiredArgsConstructor
public class EvaluationController {

    private final EvaluationService evaluationService;

    @GetMapping("/restaurants/{restaurantID}/evaluations")
    public @ResponseBody EvaluationDto getEvaluationById(@PathVariable int restaurantID){
        return EvaluationDto.fromEntity(this.evaluationService.getEvaluationById(restaurantID));
    }

    @PostMapping("/restaurants/{restaurantID}/evaluations")
    public @ResponseBody EvaluationDto addCommentaire(@Valid @RequestBody EvaluationDto dto, @PathVariable int restaurantID) {
        return EvaluationDto.fromEntity(this.evaluationService.addEvaluation(restaurantID, dto.getCommentaire(), dto.getNom_evaluateur(), dto.getNote() ));
    }

}
