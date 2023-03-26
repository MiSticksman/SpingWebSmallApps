package vsu.shaforostov.second.repository;

import org.springframework.data.repository.CrudRepository;
import vsu.shaforostov.second.entity.Area;

import java.util.List;
import java.util.Optional;

public interface AreaRepository extends CrudRepository<Area, Integer> {


    Optional<Area> findByName(String name);

}
