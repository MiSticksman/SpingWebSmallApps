package vsu.shaforostov.first.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vsu.shaforostov.first.dto.AreaDTO;
import vsu.shaforostov.first.entity.Area;
import vsu.shaforostov.first.repository.AreaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AreaService {

    private AreaRepository areaRepository;

    public List<AreaDTO> findAll() {
        List<AreaDTO> list = new ArrayList<>();
        areaRepository.findAll().forEach(area -> {
            list.add(new AreaDTO(area.getName()));
        });
        return list;
    }

    public Area findByName(String name) {
        return areaRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("can't find by name"));
    }

    public AreaDTO save(AreaDTO areaDTO) {
        Area area = areaRepository.save
        return
    }

}
