package backend.repositories;

import backend.domain.Subject;
import backend.domain.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectsRepository extends MongoRepository<Subject, String> {

  Optional<Subject> findById(String id);

  Subject findByKey(String key);

  List<Subject> findAllByLecturer(User user);

  List<Subject> findAll();

  Subject insert(Subject subject);

  Subject save(Subject subject);

  void deleteById(String id);
}
