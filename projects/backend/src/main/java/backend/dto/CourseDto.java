package backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {
  private String name;
  private String departmentCode;
  private String description;
  private byte semester;
}
