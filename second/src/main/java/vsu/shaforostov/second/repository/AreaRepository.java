package vsu.shaforostov.second.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vsu.shaforostov.second.entity.Area;

import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

public interface AreaRepository extends JpaRepository<Area, Integer> {

    Optional<Area> findByName(String name);


//    @Modifying
    @Transactional
    @Query(value = "INSERT INTO area (name, location) VALUES (:#{#area.name}, :#{#area.location}) ON CONFLICT do nothing RETURNING ID", nativeQuery = true)
    public int insert(Area area);


}
