package backend.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import backend.requests.lecture.AddLectureRequestModel;
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
    dto.setStart(request.getStart());
    dto.setEnd(request.getEnd());
    dto.setOpen(false);
    dto.setChecked(false);
    dto.setKey(RandomLectureKeyGenerator.generate());
    return dto;
  }
}
