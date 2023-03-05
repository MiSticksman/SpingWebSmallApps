package vsu.shaforostov.first.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vsu.shaforostov.first.dto.AreaDTO;
import vsu.shaforostov.first.service.AreaService;

import java.util.List;

@RestController
@RequestMapping("/areas")
@RequiredArgsConstructor
public class AreaController {

    private AreaService areaService;

    @GetMapping(value="/")
    public List<AreaDTO> getAllAreas() {
        return areaService.findAll();
    }

    @PostMapping(value="save")
    public AreaDTO saveArea() {
        areaService.sa
    }

}
