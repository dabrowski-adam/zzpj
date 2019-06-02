package backend.repositories;

import backend.domain.Lecture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LecturesRepository extends MongoRepository<Lecture, String> {
    Optional<Lecture> findById(String id);
    List<Lecture> findAll();
    Lecture insert(Lecture lecture);
    Lecture save(Lecture lecture);
    void deleteById(String id);
}
