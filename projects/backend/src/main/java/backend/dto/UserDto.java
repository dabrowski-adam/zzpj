package backend.dto;

import backend.domain.Course;
import backend.domain.Role;

import java.io.Serializable;
import java.time.LocalDateTime;

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
  private Role role;
  private String mail;
  private byte semester;
  private Course course;
}
