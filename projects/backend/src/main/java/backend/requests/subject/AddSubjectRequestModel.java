package backend.requests.subject;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class AddSubjectRequestModel {
  @Getter
  @NotNull(message = "Topic of subject should be defined")
  private String topic;
}
