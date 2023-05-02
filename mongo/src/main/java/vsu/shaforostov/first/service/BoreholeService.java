package vsu.shaforostov.first.service;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;
import vsu.shaforostov.first.dto.AreaDTO;
import vsu.shaforostov.first.dto.BoreholeDTO;
import vsu.shaforostov.first.entity.Area;
import vsu.shaforostov.first.entity.Borehole;
import vsu.shaforostov.first.repository.BoreholeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BoreholeService {

    private final BoreholeRepository boreholeRepository;

    public List<BoreholeDTO> findAll() {
        List<BoreholeDTO> list = new ArrayList<>();
        boreholeRepository.findAll().forEach(borehole -> {
            list.add(new BoreholeDTO(borehole.getId(), borehole.getNumber(), borehole.getType(), borehole.getLocation()));
        });
        return list;
    }

    public BoreholeDTO findById(ObjectId id) {
        Borehole borehole = boreholeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("can't find by id"));
        return new BoreholeDTO(borehole.getId(), borehole.getNumber(), borehole.getType(), borehole.getLocation());
    }

    public List<BoreholeDTO> findByNumber(int number) {
        return boreholeRepository.findByNumber(number)
                .orElseThrow(() -> new NoSuchElementException("can't find by number"))
                .stream()
                .map(borehole -> new BoreholeDTO(borehole.getId(), borehole.getNumber(), borehole.getType(), borehole.getLocation()))
                .toList();
    }

    public Borehole findByType(String type) {
        return boreholeRepository.findByType(type)
                .orElseThrow(() -> new NoSuchElementException("can't find by type"));
    }

    public void save(BoreholeDTO boreholeDTO) {
        Borehole borehole = new Borehole(boreholeDTO.getNumber(), boreholeDTO.getType(), boreholeDTO.getLocation());
        boreholeRepository.save(borehole);
    }

}
