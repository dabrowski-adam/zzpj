package backend.requests.lecture;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class AddLectureRequestModel {
  @NotNull(message = "Start of lecture should be defined")
  private LocalDateTime start;

  @NotNull(message = "End of lecture should be defined")
  private LocalDateTime end;
}
