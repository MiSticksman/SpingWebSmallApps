package vsu.shaforostov.first.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "borehole_on_area")
public class BoreholeOnArea {

    @MongoId
    private Object id;

    private Area area;

    private Borehole borehole;

}
