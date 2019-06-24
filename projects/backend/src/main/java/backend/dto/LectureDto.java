package backend.dto;

import backend.domain.Lecture;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class LectureDto implements Serializable {

  private String id;
  private LocalDateTime start;
  private LocalDateTime end;
  private String key;
  private long pin;
  private boolean isOpen;
  private boolean isChecked;

  public static LectureDto toDto(Lecture model) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(model, LectureDto.class);
  }

  public static Lecture toModel(LectureDto dto) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(dto, Lecture.class);
  }

}
