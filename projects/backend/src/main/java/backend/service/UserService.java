package backend.service;

import backend.domain.User;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public interface UserService {
  void update(User user);

  void add(User user);

  void delete(User user);

  User get(String userId);

  List<User> getUsers();
}
