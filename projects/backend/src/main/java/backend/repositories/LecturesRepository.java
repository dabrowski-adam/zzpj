package backend.repositories;

import backend.domain.Lecture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LecturesRepository extends MongoRepository<Lecture, String> {
    public Optional<Lecture> findById(String id);
    public List<Lecture> findAll();
    public Lecture insert(Lecture lecture);
    public Lecture save(Lecture lecture);
    public void deleteById(String id);
}
