package vsu.shaforostov.second.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vsu.shaforostov.second.dto.BoreholeOnAreaDTO;
import vsu.shaforostov.second.entity.BoreholeOnArea;
import vsu.shaforostov.second.repository.BoreholeOnAreaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BoreholeOnAreaService {

    private final BoreholeOnAreaRepository boreholeOnAreaRepository;



    public List<BoreholeOnAreaDTO> findAll() {
        List<BoreholeOnAreaDTO> list = new ArrayList<>();
        boreholeOnAreaRepository.findAll().forEach(boreholeOnArea -> {
            list.add(new BoreholeOnAreaDTO(boreholeOnArea.getId(), boreholeOnArea.getArea(), boreholeOnArea.getBorehole()));
        });
        return list;
    }

    public BoreholeOnAreaDTO findById(Integer id) {
        BoreholeOnArea boreholeOnArea = boreholeOnAreaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("can't find by id"));
        return new BoreholeOnAreaDTO(boreholeOnArea.getId(),boreholeOnArea.getArea(), boreholeOnArea.getBorehole());
    }

    public void save(BoreholeOnAreaDTO boreholeOnAreaDTO) {
        BoreholeOnArea boreholeOnArea = new BoreholeOnArea(boreholeOnAreaDTO.getArea(), boreholeOnAreaDTO.getBorehole());
        boreholeOnAreaRepository.save(boreholeOnArea);
    }


}
