package vsu.shaforostov.second.dto;

import lombok.*;

import java.awt.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BoreholeDTO {

    private Integer id;


    private int number;


    private String type;


    private Point location;
}
