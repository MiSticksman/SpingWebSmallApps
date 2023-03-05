package vsu.shaforostov.first.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vsu.shaforostov.first.entity.Area;
import vsu.shaforostov.first.entity.Borehole;
import vsu.shaforostov.first.repository.BoreholeRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BoreholeService {

    private BoreholeRepository boreholeRepository;

    public List<Borehole> findAll() {
       return  boreholeRepository.findAll();
    }

    public Borehole findByNumber(int number) {
        return boreholeRepository.findByNumber(number)
                .orElseThrow(() -> new NoSuchElementException("can't find by number"));
    }
}
