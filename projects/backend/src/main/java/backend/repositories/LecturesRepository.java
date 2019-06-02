package backend.repositories;

import backend.domain.Lecture;
import backend.domain.Subject;
import backend.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LecturesRepository extends MongoRepository<Lecture, String> {
    Optional<Lecture> findById(String id);
    Lecture findByKey(String key);
    List<Lecture> findAllByPinAndOpenIsTrue(long pin);
    List<Lecture> findAllByLecturer(User user);
    List<Lecture> findAllBySubject(Subject subject);
    List<Lecture> findAll();
    Lecture insert(Lecture lecture);
    Lecture save(Lecture lecture);
    void deleteById(String id);
}
