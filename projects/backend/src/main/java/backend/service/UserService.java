package backend.service;

import backend.dto.UserDto;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
  void update(UserDto userDto);

  void add(UserDto userDto);

  void delete(UserDto userDto);

  Optional<UserDto> get(String userId);

  List<UserDto> getUsers();
}
