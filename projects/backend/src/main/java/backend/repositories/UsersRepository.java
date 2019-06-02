package backend.repositories;

import backend.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends MongoRepository<User, String> {
    public Optional<User> findById(String id);
    public Optional<User> findByMail(String mail);
    public List<User> findAll();
    public User insert(User user);
    public User save(User user);
    public void deleteById(String id);
}
