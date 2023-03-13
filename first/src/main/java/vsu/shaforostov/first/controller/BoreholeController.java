package vsu.shaforostov.first.controller;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;
import vsu.shaforostov.first.dto.BoreholeDTO;
import vsu.shaforostov.first.service.BoreholeService;

import java.util.List;

@RestController
@RequestMapping("/boreholes")
@RequiredArgsConstructor

public class BoreholeController {

    private final BoreholeService boreholeService;

    @GetMapping()
    public List<BoreholeDTO> getAllBoreholes() {
        return boreholeService.findAll();
    }


    @GetMapping("/{id}")
    public BoreholeDTO index(@PathVariable(name="id") ObjectId id) {
        return boreholeService.findById(id);
    }

    @GetMapping("/numbers/{number}")
    public List<BoreholeDTO> numbers(@PathVariable(name="number") Integer number) {
        return boreholeService.findByNumber(number);
    }

    @PostMapping(value="save")
    public void saveBorehole(@RequestBody BoreholeDTO borehole) {
        boreholeService.save(borehole);
    }

}
