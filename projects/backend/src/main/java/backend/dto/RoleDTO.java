package backend.dto;

import lombok.Data;

@Data
public class RoleDTO {

    /**
     * @brief Possible values : LECTURER, STUDENT
     */
    private String type;
}
