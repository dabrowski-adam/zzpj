package backend.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class SubjectDto implements Serializable {

  private String topic;
  private String key;
}
