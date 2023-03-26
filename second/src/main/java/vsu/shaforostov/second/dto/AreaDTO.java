package vsu.shaforostov.second.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class AreaDTO {

    private Integer id;
    private String name;

    private Point location;
    
}
