package vsu.shaforostov.second.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoreholeOnAreaId implements Serializable {

    private Area area;
    private Borehole borehole;

}
