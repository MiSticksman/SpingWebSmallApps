package vsu.shaforostov.second.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UniversalDto {

    private String areaName;
    private Point areaLocation;

    private int boreholeNumber;
    private String boreholeType;
    private Point boreholeLocation;

}
