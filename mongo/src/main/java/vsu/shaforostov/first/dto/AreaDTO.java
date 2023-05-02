package vsu.shaforostov.first.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class AreaDTO {

    private ObjectId id;
    private String name;

    private GeoJsonPoint location;
    
}
