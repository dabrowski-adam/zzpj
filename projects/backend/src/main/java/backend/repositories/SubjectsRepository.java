package backend.repositories;

import backend.domain.Subject;
import backend.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectsRepository extends MongoRepository<Subject, String> {
    public Optional<Subject> findById(String id);
    public Subject findByKey(String key);
    public List<Subject> findAllByLecturer(User user);
    public List<Subject> findAll();
    public Subject insert(Subject subject);
    public Subject save(Subject subject);
    public void deleteById(String id);
}
