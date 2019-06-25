package backend.service;

import backend.domain.User;
import backend.dto.UserDto;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
public interface UserService {

  static UserDto toDto(User model) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(model, UserDto.class);
  }

  static User toModel(UserDto dto) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(dto, User.class);
  }

  void update(UserDto userDto);

  void add(UserDto userDto);

  void delete(UserDto userDto);

  Optional<UserDto> get(String userId);

  List<UserDto> getUsers();
}
