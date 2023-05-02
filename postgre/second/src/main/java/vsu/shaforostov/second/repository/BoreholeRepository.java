package vsu.shaforostov.second.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import vsu.shaforostov.second.entity.Borehole;

import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.List;
import java.util.Optional;

public interface BoreholeRepository extends JpaRepository<Borehole, Integer> {


//    Optional<Borehole> findByNumber(int number);

    Optional<List<Borehole>> findByNumber(int number);
    Optional<Borehole> findByType(String type);

    @Transactional
    @Query(value = "INSERT INTO borehole (number, type, location) " +
            "VALUES (:#{#borehole.number}, :#{#borehole.type}, :#{#borehole.location}) " +
            "ON CONFLICT(number) DO UPDATE SET type = excluded.type RETURNING ID", nativeQuery = true)
    public int insert(Borehole borehole);
}
