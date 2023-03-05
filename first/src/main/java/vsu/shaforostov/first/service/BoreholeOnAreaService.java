package vsu.shaforostov.first.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vsu.shaforostov.first.entity.BoreholeOnArea;
import vsu.shaforostov.first.repository.BoreholeOnAreaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoreholeOnAreaService {

    private BoreholeOnAreaRepository boreholeOnAreaRepository;

    public List<BoreholeOnArea> findAll() {
        return boreholeOnAreaRepository.findAll();
    }


}
