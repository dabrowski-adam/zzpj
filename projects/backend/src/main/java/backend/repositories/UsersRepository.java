package backend.repositories;

import backend.domain.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends MongoRepository<User, String> {

  Optional<User> findById(String id);

  Optional<User> findByIndexNumber(String index);

  Optional<User> findByMail(String mail);

  List<User> findAll();

  User insert(User user);

  User save(User user);

  void deleteById(String id);
}
