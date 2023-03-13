package vsu.shaforostov.first.dto;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BoreholeDTO {

    private ObjectId id;


    private int number;


    private String type;


    private GeoJsonPoint location;
}
