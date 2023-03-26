package vsu.shaforostov.second.entity;


import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "borehole_on_area")
public class BoreholeOnArea {

    public BoreholeOnArea(Area area, Borehole borehole) {
        this.area = area;
        this.borehole = borehole;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Area area;

    @OneToOne
    private Borehole borehole;

}
