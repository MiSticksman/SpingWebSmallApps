package vsu.shaforostov.first.dto;

import lombok.*;
import org.bson.types.ObjectId;
import vsu.shaforostov.first.entity.Area;
import vsu.shaforostov.first.entity.Borehole;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BoreholeOnAreaDTO {

    private ObjectId id;

    private Area area;

    private Borehole borehole;
}
