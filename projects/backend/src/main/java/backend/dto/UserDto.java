package backend.dto;

import backend.domain.User;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class UserDto implements Serializable {

  private String id;
  private String name;
  private String surname;
  private String password;
  private String indexNumber;
  private boolean isActive;
  private String activationToken;
  private String resetToken;
  private boolean resetPass;
  private LocalDateTime creationDate;
  private RoleDto role;
  private String mail;
  private byte semester;
  private CourseDto course;

  public static UserDto toDto(User model) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(model, UserDto.class);
  }

  public static User toModel(UserDto dto) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(dto, User.class);
  }
}
