package backend.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AttendanceDto implements Serializable {
  String lectureId;
  String studentId;
}
