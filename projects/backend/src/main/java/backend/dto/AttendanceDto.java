package backend.dto;

import backend.domain.Attendance;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.modelmapper.ModelMapper;

@Getter
@AllArgsConstructor
public class AttendanceDto implements Serializable {
  String id;
  String lectureId;
  String studentId;

  public static AttendanceDto toDto(Attendance model) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(model, AttendanceDto.class);
  }

  public static Attendance toModel(AttendanceDto dto) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(dto, Attendance.class);
  }
}
