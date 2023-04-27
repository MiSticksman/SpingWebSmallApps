package vsu.shaforostov.second.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import vsu.shaforostov.second.entity.Area;
import vsu.shaforostov.second.entity.Borehole;
import vsu.shaforostov.second.entity.BoreholeOnArea;
import vsu.shaforostov.second.entity.BoreholeOnAreaId;

import java.util.Optional;

public interface BoreholeOnAreaRepository extends JpaRepository<BoreholeOnArea, BoreholeOnAreaId> {


}
