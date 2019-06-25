package backend.dto;

import backend.domain.Course;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class CourseDto {

  private String name;
  private String departmentCode;
  private String description;
  private byte semester;

  public static CourseDto toDto(Course model) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(model, CourseDto.class);
  }

  public static Course toModel(CourseDto dto) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(dto, Course.class);
  }
}
