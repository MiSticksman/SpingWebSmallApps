package vsu.shaforostov.first.service;


import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;
import vsu.shaforostov.first.dto.AreaDTO;
import vsu.shaforostov.first.entity.Area;
import vsu.shaforostov.first.entity.Borehole;
import vsu.shaforostov.first.repository.AreaRepository;
import vsu.shaforostov.first.repository.BoreholeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AreaService {

    private final AreaRepository areaRepository;

    private final BoreholeRepository boreholeRepository;

    public List<AreaDTO> findAll() {
        List<AreaDTO> list = new ArrayList<>();
        areaRepository.findAll().forEach(area -> {
            list.add(new AreaDTO(area.getId(), area.getName(), area.getLocation()));
        });
        return list;
    }

    public AreaDTO findById(ObjectId id) {
        Area area = areaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("can't find by id"));
        return new AreaDTO(area.getId(), area.getName(), area.getLocation());
    }

    public Area findByName(String name) {
        return areaRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("can't find by name"));
    }

    public void save(AreaDTO areaDTO) {
        Area area = new Area(areaDTO.getName(), areaDTO.getLocation());
        areaRepository.save(area);
    }

    public List<Borehole> findBoreholesNearArea(ObjectId id, double radius) {
        AreaDTO areaDTO = this.findById(id);
        return findBoreholesNearArea(areaDTO.getLocation(), radius);
    }

    public static double rangeBetween(GeoJsonPoint point1, GeoJsonPoint point2) {
        double distanceX = point1.getX() - point2.getX();
        double distanceY = point1.getY() - point2.getY();
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }
    public List<Borehole> findBoreholesNearArea(GeoJsonPoint areaPoint, double radius) {
        return boreholeRepository.findAll().stream().filter(borehole -> {
            GeoJsonPoint location = borehole.getLocation();

            return rangeBetween(areaPoint, location) < radius;
        }).toList();
    }

}
