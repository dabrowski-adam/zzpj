package backend.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Course {

    @Id
    private String id;
    private String name;
    private String departmentCode;
    private String description;
    private byte semester;

    public Course(String name, String departmentCode, String description, byte semester) {
        this.name = name;
        this.departmentCode = departmentCode;
        this.description = description;
        this.semester = semester;
    }
}
