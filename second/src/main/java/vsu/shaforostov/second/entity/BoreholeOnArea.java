package vsu.shaforostov.second.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(BoreholeOnAreaId.class)
@Table(name = "borehole_on_area")
public class BoreholeOnArea {

    @Id
    @ManyToOne
    @JoinColumn(name = "area_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Area area;

    @Id
    @ManyToOne
    @JoinColumn(name = "borehole_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Borehole borehole;

}
