package backend.domain;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
public class User {

  @Id
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
  @DBRef
  private Role role;
  //TODO: As separate type e.g Contact
  private String mail;
  private byte semester;
  @DBRef
  private Course course;

  /**
   * User.
   * @param name First name.
   * @param surname Last name.
   * @param password Password.
   * @param indexNumber Student ID.
   * @param isActive Active status.
   * @param activationToken Activation token.
   * @param resetToken Reset token.
   * @param resetPass Reset pass.
   * @param creationDate Date created.
   * @param role Role.
   * @param mail E-mail.
   * @param semester Semester.
   * @param course Course.
   */
  public User(String name, String surname, String password, String indexNumber,
      boolean isActive, String activationToken, String resetToken, boolean resetPass,
      LocalDateTime creationDate, Role role, String mail, byte semester, Course course) {
    this.name = name;
    this.surname = surname;
    this.password = password;
    this.indexNumber = indexNumber;
    this.isActive = isActive;
    this.activationToken = activationToken;
    this.resetToken = resetToken;
    this.resetPass = resetPass;
    this.creationDate = creationDate;
    this.role = role;
    this.mail = mail;
    this.semester = semester;
    this.course = course;
  }
}
