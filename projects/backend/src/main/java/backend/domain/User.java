package backend.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;

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

    public User(String name, String surname, String password, String indexNumber, boolean isActive, String activationToken, String resetToken, boolean resetPass, LocalDateTime creationDate, Role role, String mail, byte semester, Course course) {
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
