package vsu.shaforostov.first.controller;


import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import vsu.shaforostov.first.dto.AreaDTO;
import vsu.shaforostov.first.dto.BoreholeDTO;
import vsu.shaforostov.first.entity.Borehole;
import vsu.shaforostov.first.service.AreaService;

import java.util.List;

@RestController
@RequestMapping("/areas")
@RequiredArgsConstructor
public class AreaController {

    private final AreaService areaService;

    @GetMapping()
    public List<AreaDTO> getAllAreas() {
        return areaService.findAll();
    }


    @GetMapping("/{id}")
    public AreaDTO index(@PathVariable(name="id") ObjectId id) {
        return areaService.findById(id);
    }

    @PostMapping(value="save")
    public void saveArea(@RequestBody AreaDTO area) {
        areaService.save(area);
    }

    @GetMapping(value ="nearArea")
    public List<Borehole> index(@RequestParam(name="id") ObjectId id, @RequestParam(name="radius") double radius) {
        return areaService.findBoreholesNearArea(id, radius);
    }


}
