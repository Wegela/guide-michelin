package michelin.polytech.guidemichelin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Evaluation")
public class EvaluationEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "nom_evaluateur")
    private String nom_evaluateur;

    @Column(name = "commentaire")
    private String commentaire;

    @Column(name = "note")
    private int note;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    private RestaurantEntity restaurant;
}
