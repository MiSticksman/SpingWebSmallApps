package vsu.shaforostov.second.dto;

import lombok.*;
import vsu.shaforostov.second.entity.Area;
import vsu.shaforostov.second.entity.Borehole;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BoreholeOnAreaReadDTO {

    private AreaDTO area;

    private BoreholeDTO borehole;
}
