package backend.service.impl;

import backend.domain.User;
import backend.repositories.UsersRepository;
import backend.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UsersRepository usersRepository;


  @Autowired
  public UserServiceImpl(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }


  @Override
  public void update(User user) {
    usersRepository.findById(user.getId()).ifPresent(x -> {
      usersRepository.deleteById(user.getId());
      usersRepository.save(user);
    });
  }

  @Override
  public void add(User user) {
    usersRepository.insert(user);
  }

  @Override
  public void delete(User user) {
    usersRepository.deleteById(user.getId());
  }

  @Override
  public User get(String userId) {
    return usersRepository.findById(userId).get();
  }

  @Override
  public List<User> getUsers() {
    return usersRepository.findAll();
  }
}
