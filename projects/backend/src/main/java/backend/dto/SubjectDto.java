package backend.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubjectDto implements Serializable {

  private String topic;
  private String key;
}
