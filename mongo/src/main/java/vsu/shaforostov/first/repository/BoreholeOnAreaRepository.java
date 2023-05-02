package vsu.shaforostov.first.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import vsu.shaforostov.first.entity.BoreholeOnArea;

import java.util.Optional;

public interface BoreholeOnAreaRepository extends MongoRepository<BoreholeOnArea, ObjectId> {


}
