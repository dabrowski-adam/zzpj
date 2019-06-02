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
    public Optional<Lecture> findById(String id);
    public Lecture findByKey(String key);
    public List<Lecture> findAllByPinAndOpenIsTrue(long pin);
    public List<Lecture> findAllByLecturer(User user);
    public List<Lecture> findAllBySubject(Subject subject);
    public List<Lecture> findAll();
    public Lecture insert(Lecture lecture);
    public Lecture save(Lecture lecture);
    public void deleteById(String id);
}
