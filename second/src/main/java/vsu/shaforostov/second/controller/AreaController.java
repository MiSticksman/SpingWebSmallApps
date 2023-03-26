package vsu.shaforostov.second.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import vsu.shaforostov.second.dto.AreaDTO;
import vsu.shaforostov.second.dto.BoreholeDTO;
import vsu.shaforostov.second.entity.Borehole;
import vsu.shaforostov.second.service.AreaService;

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
    public AreaDTO index(@PathVariable(name="id") Integer id) {
        return areaService.findById(id);
    }

    @PostMapping(value="save")
    public void saveArea(@RequestBody AreaDTO area) {
        areaService.save(area);
    }

    @GetMapping(value ="nearArea")
    public List<Borehole> index(@RequestParam(name="id") Integer id, @RequestParam(name="radius") double radius) {
        return areaService.findBoreholesNearArea(id, radius);
    }


}
