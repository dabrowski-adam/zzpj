package backend.dto;

import backend.domain.Course;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class CourseDTO {

    private String name;
    private String departmentCode;
    private String description;
    private byte semester;

    public static CourseDTO toDto(Course model) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(model, CourseDTO.class);
    }

    public static Course toModel(CourseDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Course.class);
    }
}
