package backend.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
public class Attendance {

  @Id
  private String id;
  @DBRef
  private Lecture lecture;
  @DBRef
  private User student;
  //TODO: Extract to separate type e.g Rating
  private byte rating;

  /**
   * Student's presence at a certain lecture.
   * @param lecture Lecture data.
   * @param student Student data.
   * @param rating Attendance rating.
   */
  public Attendance(Lecture lecture, User student, byte rating) {
    this.lecture = lecture;
    this.student = student;
    this.rating = rating;
  }
}
