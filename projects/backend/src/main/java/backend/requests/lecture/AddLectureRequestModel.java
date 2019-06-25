package backend.requests.lecture;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AddLectureRequestModel {
  @NotNull(message = "Start of lecture should be defined")
  private LocalDateTime start;

  @NotNull(message = "End of lecture should be defined")
  private LocalDateTime end;
}
