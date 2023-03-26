package vsu.shaforostov.second.service;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import vsu.shaforostov.second.dto.AreaDTO;
import vsu.shaforostov.second.entity.Area;
import vsu.shaforostov.second.entity.Borehole;
import vsu.shaforostov.second.repository.AreaRepository;
import vsu.shaforostov.second.repository.BoreholeRepository;

import java.awt.*;
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

    public AreaDTO findById(Integer id) {
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

    public List<Borehole> findBoreholesNearArea(Integer id, double radius) {
        AreaDTO areaDTO = this.findById(id);
        return findBoreholesNearArea(areaDTO.getLocation(), radius);
    }

    public static double rangeBetween(Point point1, Point point2) {
        double distanceX = point1.getX() - point2.getX();
        double distanceY = point1.getY() - point2.getY();
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
    }
    public List<Borehole> findBoreholesNearArea(Point areaPoint, double radius) {
        List<Borehole> boreholes = new ArrayList<>();
        boreholeRepository.findAll().forEach(boreholes::add);
        return boreholes.stream().filter(borehole -> {
            Point location = borehole.getLocation();
            return rangeBetween(areaPoint, location) < radius;
        }).toList();
    }

}
