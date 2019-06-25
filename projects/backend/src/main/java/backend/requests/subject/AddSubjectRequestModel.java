package backend.requests.subject;

import javax.validation.constraints.NotNull;
import lombok.Getter;

public class AddSubjectRequestModel {
  @Getter
  @NotNull(message = "Topic of subject should be defined")
  private String topic;
}
