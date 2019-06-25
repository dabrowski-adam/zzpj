package backend.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

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

}
