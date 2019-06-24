package backend.dto;

import backend.domain.Subject;
import backend.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.time.LocalDateTime;

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
  private RoleDTO role;
  private String mail;
  private byte semester;
  private CourseDTO course;

  public static UserDto toDto(User model) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(model, UserDto.class);
  }

  public static User toModel(UserDto dto) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(dto, User.class);
  }
}
