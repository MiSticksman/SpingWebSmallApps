package vsu.shaforostov.first.entity;


import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.geo.GeoJson;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "area")
public class Area {

    public Area(@NonNull String name, @NonNull GeoJsonPoint location) {
        this.name = name;
        this.location = location;
    }

    @MongoId
    private ObjectId id;

    @NonNull
    private String name;

    @NonNull
    private GeoJsonPoint location;

}


