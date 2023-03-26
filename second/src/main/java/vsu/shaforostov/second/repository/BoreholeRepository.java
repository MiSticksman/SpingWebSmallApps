package vsu.shaforostov.second.repository;


import org.springframework.data.repository.CrudRepository;
import vsu.shaforostov.second.entity.Borehole;

import java.util.List;
import java.util.Optional;

public interface BoreholeRepository extends CrudRepository<Borehole, Integer> {


//    Optional<Borehole> findByNumber(int number);

    Optional<List<Borehole>> findByNumber(int number);
    Optional<Borehole> findByType(String type);

}
