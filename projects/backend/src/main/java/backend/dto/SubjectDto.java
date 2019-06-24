package backend.dto;

import java.io.Serializable;

import backend.requests.subject.AddSubjectRequestModel;
import backend.requests.subject.UpdateSubjectRequestModel;
import backend.utils.RandomKeyGenerator;
import lombok.Data;

@Data
public class SubjectDto implements Serializable {

  private String topic;
  private String key;

  public static SubjectDto parseFromAddSubjectRequest(AddSubjectRequestModel request) {
    SubjectDto dto = new SubjectDto();
    dto.topic = request.getTopic();
    dto.key = RandomKeyGenerator.generate();
    return dto;
  }

  public static SubjectDto parseFromUpdateSubjectRequest(UpdateSubjectRequestModel request) {
    SubjectDto dto = new SubjectDto();
    dto.topic = request.getTopic();
    dto.key = request.getKey();
    return dto;
  }
}
