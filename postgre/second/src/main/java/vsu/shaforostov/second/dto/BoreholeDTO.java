package vsu.shaforostov.second.dto;

import lombok.*;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BoreholeDTO {

    private Integer id;
    private int number;
    private String type;
    private Point location;
//    private Set<AreaDTO> areas = new HashSet<>();
}
