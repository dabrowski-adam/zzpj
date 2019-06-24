package backend.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
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
}
