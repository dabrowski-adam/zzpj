package backend.service;

import backend.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    void update(User user);

    void add(User user);

    void delete(User user);

    User get(String userId);

    List<User> getUsers();
}
