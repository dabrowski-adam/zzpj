package backend.requests.subject;

import backend.requests.lecture.AddLectureRequestModel;
import lombok.Getter;

import javax.validation.constraints.NotNull;


public class UpdateSubjectRequestModel extends AddSubjectRequestModel {
  @Getter
  @NotNull(message = "key is required")
  private String key;
}
