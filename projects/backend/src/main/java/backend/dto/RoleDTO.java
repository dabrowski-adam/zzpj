package backend.dto;

import backend.domain.Role;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class RoleDTO {

    /**
     * @brief Possible values : LECTURER, STUDENT
     */
    private String type;

    public static RoleDTO toDto(Role model) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(model, RoleDTO.class);
    }

    public static Role toModel(CourseDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Role.class);
    }

}
