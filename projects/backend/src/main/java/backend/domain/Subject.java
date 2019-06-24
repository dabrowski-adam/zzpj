package backend.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data

public class Subject {

  @Id
  private String id;
  private String topic;
  private String key;
  @DBRef
  private User lecturer;

  public Subject() {
  }

  /**
   * Subject.
   * @param topic Subject topic.
   * @param key Subject key.
   * @param lecturer Subject's lecturer.
   */
  public Subject(String topic, String key, User lecturer) {
    this.topic = topic;
    this.key = key;
    this.lecturer = lecturer;
  }
}
