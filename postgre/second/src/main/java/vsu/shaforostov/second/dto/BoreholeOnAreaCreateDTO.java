package vsu.shaforostov.second.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoreholeOnAreaCreateDTO {

    @JsonProperty("area_id")
    private Integer areaId;

    @JsonProperty("borehole_id")
    private Integer boreholeId;

}
