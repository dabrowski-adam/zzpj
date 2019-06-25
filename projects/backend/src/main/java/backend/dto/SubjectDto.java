package backend.dto;

import backend.domain.Subject;
import backend.requests.subject.AddSubjectRequestModel;
import backend.requests.subject.UpdateSubjectRequestModel;
import backend.utils.RandomKeyGenerator;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class SubjectDto implements Serializable {

  private String topic;
  private String key;

  public static SubjectDto toDto(Subject model) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(model, SubjectDto.class);
  }

  public static Subject toModel(SubjectDto dto) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(dto, Subject.class);
  }

  /**
   * Parse Add Subject Request.
   * @param request Add Subject Request.
   * @return Subject Dto
   */

  public static SubjectDto parseFromAddSubjectRequest(AddSubjectRequestModel request) {
    SubjectDto dto = new SubjectDto();
    dto.topic = request.getTopic();
    dto.key = RandomKeyGenerator.generate();
    return dto;
  }

  /**
   * Parse Update Subject Request.
   * @param request Update Subject Request.
   * @return Subject Dto
   */
  public static SubjectDto parseFromUpdateSubjectRequest(UpdateSubjectRequestModel request) {
    SubjectDto dto = new SubjectDto();
    dto.topic = request.getTopic();
    dto.key = request.getKey();
    return dto;
  }
}
