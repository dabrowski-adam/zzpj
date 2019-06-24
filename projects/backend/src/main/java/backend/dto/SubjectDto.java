package backend.dto;

import backend.domain.Subject;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.io.Serializable;

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
}
