package vsu.shaforostov.second.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vsu.shaforostov.second.dto.AreaDTO;
import vsu.shaforostov.second.dto.BoreholeDTO;
import vsu.shaforostov.second.entity.Area;
import vsu.shaforostov.second.entity.Borehole;
import vsu.shaforostov.second.repository.BoreholeRepository;

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

    public BoreholeDTO findById(Integer id) {
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
