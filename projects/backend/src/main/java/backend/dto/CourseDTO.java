package backend.dto;

import lombok.Data;

@Data
public class CourseDTO {
    private String name;
    private String departmentCode;
    private String description;
    private byte semester;
}
