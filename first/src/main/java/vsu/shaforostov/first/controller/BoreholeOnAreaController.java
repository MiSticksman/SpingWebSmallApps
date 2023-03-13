package vsu.shaforostov.first.controller;


import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import vsu.shaforostov.first.dto.BoreholeDTO;
import vsu.shaforostov.first.dto.BoreholeOnAreaDTO;
import vsu.shaforostov.first.service.BoreholeOnAreaService;
import vsu.shaforostov.first.service.BoreholeService;

import java.util.List;

@RestController
@RequestMapping("/boreholesOnArea")
@RequiredArgsConstructor
public class BoreholeOnAreaController {

    private final BoreholeOnAreaService boreholeOnAreaService;


    @GetMapping()
    public List<BoreholeOnAreaDTO> getAllBoreholesOnArea() {
        return boreholeOnAreaService.findAll();
    }


    @GetMapping("/{id}")
    public BoreholeOnAreaDTO index(@PathVariable(name="id") ObjectId id) {
        return boreholeOnAreaService.findById(id);
    }

    @PostMapping(value="save")
    public void saveBorehole(@RequestBody BoreholeOnAreaDTO boreholeOnArea) {
        boreholeOnAreaService.save(boreholeOnArea);
    }

}
