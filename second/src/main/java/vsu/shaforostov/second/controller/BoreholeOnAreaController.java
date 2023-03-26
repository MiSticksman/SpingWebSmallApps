package vsu.shaforostov.second.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vsu.shaforostov.second.dto.BoreholeDTO;
import vsu.shaforostov.second.dto.BoreholeOnAreaDTO;
import vsu.shaforostov.second.service.BoreholeOnAreaService;
import vsu.shaforostov.second.service.BoreholeService;

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
    public BoreholeOnAreaDTO index(@PathVariable(name="id") Integer id) {
        return boreholeOnAreaService.findById(id);
    }

    @PostMapping(value="save")
    public void saveBorehole(@RequestBody BoreholeOnAreaDTO boreholeOnArea) {
        boreholeOnAreaService.save(boreholeOnArea);
    }

}
