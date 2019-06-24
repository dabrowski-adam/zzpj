package backend.requests.lecture;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotNull;


public class UpdateLectureRequestModel extends AddLectureRequestModel {
  @Getter
  @NotNull(message = "ID is required")
  private String id;

  @Getter
  @NotNull(message = "key is required")
  private String key;

  @Getter
  @NotNull(message = "pin is required")
  private long pin;

  @Getter
  @NotNull(message = "isOpen is required")
  private boolean isOpen;

  @Getter
  @NotNull(message = "isChecked is required")
  private boolean isChecked;
}
