package backend.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import backend.requests.lecture.AddLectureRequestModel;
import backend.requests.lecture.UpdateLectureRequestModel;
import backend.utils.RandomLectureKeyGenerator;
import lombok.Data;

@Data
public class LectureDto implements Serializable {
  
  private String id;
  //TODO: Add remaining data
  private LocalDateTime start;
  private LocalDateTime end;
  private String key;
  private long pin;
  private boolean isOpen;
  private boolean isChecked;

  public static LectureDto parseFromAddLectureRequest(AddLectureRequestModel request) {
    LectureDto dto = new LectureDto();
    dto.start = request.getStart();
    dto.end = request.getEnd();
    dto.isOpen = false;
    dto.isChecked = false;
    dto.key = RandomLectureKeyGenerator.generate();
    return dto;
  }

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
