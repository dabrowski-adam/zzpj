package backend.dto;

import backend.domain.Role;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Getter
@Setter
public class RoleDto {


  private String type;

  public static RoleDto toDto(Role model) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(model, RoleDto.class);
  }

  public static Role toModel(RoleDto dto) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(dto, Role.class);
  }

}
