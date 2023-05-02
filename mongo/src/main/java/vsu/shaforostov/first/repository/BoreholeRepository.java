package vsu.shaforostov.first.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import vsu.shaforostov.first.entity.Borehole;

import java.util.List;
import java.util.Optional;

public interface BoreholeRepository extends MongoRepository<Borehole, ObjectId> {


//    Optional<Borehole> findByNumber(int number);

    Optional<List<Borehole>> findByNumber(int number);
    Optional<Borehole> findByType(String type);

}
