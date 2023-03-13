package vsu.shaforostov.first.entity;

import lombok. *;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "borehole")
public class Borehole {

    public Borehole(@NonNull int number, @NonNull String type, @NonNull GeoJsonPoint location) {
        this.number = number;
        this.type = type;
        this.location = location;
    }

    @MongoId
    private ObjectId id;

    @NonNull
    private int number;

    @NonNull
    private String type;

    @NonNull
    private GeoJsonPoint location;

}
