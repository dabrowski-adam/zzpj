package backend.dto;

import backend.domain.Lecture;
import backend.requests.lecture.AddLectureRequestModel;
import backend.requests.lecture.UpdateLectureRequestModel;
import backend.utils.RandomKeyGenerator;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class LectureDto implements Serializable {

  private String id;
  private LocalDateTime start;
  private LocalDateTime end;
  private String key;
  private long pin;
  private boolean isOpen;
  private boolean isChecked;

  public static LectureDto toDto(Lecture model) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(model, LectureDto.class);
  }

  public static Lecture toModel(LectureDto dto) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(dto, Lecture.class);
  }

  /**
   * Parse Add Lecture Request.
   * @param request Add Lecture Request.
   * @return LectureDto
   */
  public static LectureDto parseFromAddLectureRequest(AddLectureRequestModel request) {
    LectureDto dto = new LectureDto();
    dto.start = request.getStart();
    dto.end = request.getEnd();
    dto.isOpen = false;
    dto.isChecked = false;
    dto.key = RandomKeyGenerator.generate();
    return dto;
  }

  /**
   * Parse Update Lecture Request.
   * @param request Update Lecture Request.
   * @return LectureDto
   */
  public static LectureDto parseFromUpdateLectureRequest(UpdateLectureRequestModel request) {
    LectureDto dto = new LectureDto();
    dto.id = request.getId();
    dto.start = request.getStart();
    dto.end = request.getEnd();
    dto.key = request.getKey();
    dto.pin = request.getPin();
    dto.isOpen = request.isOpen();
    dto.isChecked = request.isChecked();
    return dto;
  }

}
