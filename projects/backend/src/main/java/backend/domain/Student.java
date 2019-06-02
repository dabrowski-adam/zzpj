package backend.domain;

import org.springframework.data.annotation.Id;

public class Student {

    @Id
    public String id;
    public String name;
    public String surname;
    public String password;

    public Student(String name, String surname, String password) {
        this.name = name;
        this.surname = surname;
        this.password = password;
    }
}