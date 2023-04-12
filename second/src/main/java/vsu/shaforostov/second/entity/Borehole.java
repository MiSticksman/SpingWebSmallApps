package vsu.shaforostov.second.entity;

import jakarta.persistence.*;
import lombok. *;

import java.awt.*;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "borehole")
public class Borehole {

    public Borehole(int number, String type, Point location) {
        this.number = number;
        this.type = type;
        this.location = location;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int number;

    private String type;

    @Column()
    private Point location;


    @OneToMany(mappedBy = "borehole")
    Set<BoreholeOnArea> boreholeOnAreas;

}
