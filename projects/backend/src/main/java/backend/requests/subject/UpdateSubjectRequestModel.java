package backend.requests.subject;

import javax.validation.constraints.NotNull;
import lombok.Getter;

public class UpdateSubjectRequestModel extends AddSubjectRequestModel {
  @Getter
  @NotNull(message = "key is required")
  private String key;
}
