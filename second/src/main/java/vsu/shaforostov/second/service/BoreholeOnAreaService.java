package vsu.shaforostov.second.service;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vsu.shaforostov.second.dto.AreaDTO;
import vsu.shaforostov.second.dto.BoreholeDTO;
import vsu.shaforostov.second.dto.BoreholeOnAreaCreateDTO;
import vsu.shaforostov.second.dto.BoreholeOnAreaReadDTO;
import vsu.shaforostov.second.entity.Area;
import vsu.shaforostov.second.entity.Borehole;
import vsu.shaforostov.second.entity.BoreholeOnArea;
import vsu.shaforostov.second.entity.BoreholeOnAreaId;
import vsu.shaforostov.second.repository.BoreholeOnAreaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BoreholeOnAreaService {

    private final BoreholeOnAreaRepository boreholeOnAreaRepository;

//    private final AreaService areaService;
//
//    private final BoreholeService boreholeService;


    @PersistenceContext
    private EntityManager entityManager;

    public List<BoreholeOnAreaReadDTO> findAll() {
        return boreholeOnAreaRepository.findAll().stream()
                .map(boreholeOnArea -> {
                    Area area = boreholeOnArea.getArea();
                    AreaDTO areaDTO = new AreaDTO(area.getId(),area.getName(), area.getLocation());

                    Borehole borehole = boreholeOnArea.getBorehole();
                    BoreholeDTO boreholeDTO = new BoreholeDTO(borehole.getId(), borehole.getNumber(),
                            borehole.getType(), borehole.getLocation());

                    return new BoreholeOnAreaReadDTO(areaDTO, boreholeDTO);
                }).toList();
    }

    public BoreholeOnAreaReadDTO findById(Integer areaId, Integer boreholeId) {
        BoreholeOnAreaId boreholeOnAreaId = new BoreholeOnAreaId(entityManager.getReference(Area.class, areaId),
                entityManager.getReference(Borehole.class, boreholeId));
        BoreholeOnArea boreholeOnArea = boreholeOnAreaRepository.findById(boreholeOnAreaId)
                .orElse(null);
        Area area = boreholeOnArea.getArea();
        AreaDTO areaDTO = new AreaDTO(area.getId(),area.getName(), area.getLocation());

        Borehole borehole = boreholeOnArea.getBorehole();
        BoreholeDTO boreholeDTO = new BoreholeDTO(borehole.getId(), borehole.getNumber(),
                borehole.getType(), borehole.getLocation());

        return new BoreholeOnAreaReadDTO(areaDTO, boreholeDTO);
    }

    public void save(BoreholeOnAreaCreateDTO boreholeOnAreaDTO) {
//        AreaDTO areaDto = areaService.findById(boreholeOnAreaDTO.getAreaId());
//        Area area = new Area(areaDto.getName(), areaDto.getLocation());
//        BoreholeDTO boreholeDto = boreholeService.findById(boreholeOnAreaDTO.getBoreholeId());
//        Borehole borehole = new Borehole(boreholeDto.getNumber(), boreholeDto.getType(), boreholeDto.getLocation());
//        BoreholeOnArea boreholeOnArea = new BoreholeOnArea(area, borehole);
        BoreholeOnArea boreholeOnArea = new BoreholeOnArea();
        boreholeOnArea.setArea(entityManager.getReference(Area.class, boreholeOnAreaDTO.getAreaId()));
        boreholeOnArea.setBorehole(entityManager.getReference(Borehole.class, boreholeOnAreaDTO.getBoreholeId()));
        boreholeOnAreaRepository.save(boreholeOnArea);
    }

}
