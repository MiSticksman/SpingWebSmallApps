package vsu.shaforostov.first.repository;

import org.bson.types.ObjectId;
import vsu.shaforostov.first.entity.Area;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
public interface AreaRepository extends MongoRepository<Area, ObjectId>{


    Optional<Area> findByName(String name);

}
