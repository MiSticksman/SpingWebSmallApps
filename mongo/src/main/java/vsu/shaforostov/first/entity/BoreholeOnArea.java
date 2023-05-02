package vsu.shaforostov.first.entity;


import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "borehole_on_area")
public class BoreholeOnArea {

    public BoreholeOnArea(@NonNull Area area, @NonNull Borehole borehole) {
        this.area = area;
        this.borehole = borehole;
    }

    @MongoId
    private ObjectId id;

    @NonNull
    private Area area;
    @NonNull
    private Borehole borehole;

}
