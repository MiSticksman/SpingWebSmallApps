package vsu.shaforostov.second.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vsu.shaforostov.second.dto.BoreholeOnAreaCreateDTO;
import vsu.shaforostov.second.dto.BoreholeOnAreaReadDTO;
import vsu.shaforostov.second.dto.UniversalDto;
import vsu.shaforostov.second.entity.BoreholeOnAreaId;
import vsu.shaforostov.second.service.BoreholeOnAreaService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/boreholesOnArea")
@RequiredArgsConstructor
public class BoreholeOnAreaController {

    private final BoreholeOnAreaService boreholeOnAreaService;


    @GetMapping()
    public List<BoreholeOnAreaReadDTO> getAllBoreholesOnArea() {
        return boreholeOnAreaService.findAll();
    }


    @GetMapping("/{area_id}/{borehole_id}")
    public BoreholeOnAreaReadDTO index(@PathVariable(name="area_id") Integer areaId, @PathVariable(name="borehole_id") Integer boreholeId) {
        return boreholeOnAreaService.findById(areaId, boreholeId);
    }

//    @PostMapping(value="save")
//    public void saveBorehole(@RequestBody BoreholeOnAreaCreateDTO boreholeOnArea) {
//        boreholeOnAreaService.save(boreholeOnArea);
//    }

    @PostMapping(value="save")
    public void saveBorehole(@RequestBody UniversalDto universalDto) {
        boreholeOnAreaService.insert(universalDto);
    }


}
