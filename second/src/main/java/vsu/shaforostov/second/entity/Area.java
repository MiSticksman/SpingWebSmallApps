package vsu.shaforostov.second.entity;


import jakarta.persistence.*;
import lombok.*;

import java.awt.*;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "area")
public class Area {

    public Area(String name, Point location) {
        this.name = name;
        this.location = location;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;
    private String name; // unique
    @Column()
    private Point location;

    @OneToMany(mappedBy = "area")
    Set<BoreholeOnArea> boreholesOnArea;

}


