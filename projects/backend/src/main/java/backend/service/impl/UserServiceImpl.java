package backend.service.impl;

import static java.util.stream.Collectors.toList;

import backend.domain.User;
import backend.dto.UserDto;
import backend.repositories.UsersRepository;
import backend.service.UserService;
import java.util.List;
import java.util.Optional;
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
  public void update(UserDto userDto) {
    User user = UserDto.toModel(userDto);
    usersRepository.findById(user.getId()).ifPresent(x -> {
      usersRepository.deleteById(user.getId());
      usersRepository.save(user);
    });
  }

  @Override
  public void add(UserDto userDto) {
    User user = UserDto.toModel(userDto);
    usersRepository.insert(user);
  }

  @Override
  public void delete(UserDto userDto) {
    User user = UserDto.toModel(userDto);
    usersRepository.deleteById(user.getId());
  }

  @Override
  public Optional<UserDto> get(String userId) {
    User user = usersRepository.findById(userId).get();
    UserDto userDto = user != null ? UserDto.toDto(user) : null;
    return Optional.of(userDto);
  }

  @Override
  public List<UserDto> getUsers() {
    var users = usersRepository.findAll();
    var userDtos = users.stream().map(UserDto::toDto).collect(toList());
    return userDtos;
  }
}
