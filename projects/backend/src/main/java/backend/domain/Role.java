package backend.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Role {

    enum Type {
        LECTURER,
        STUDENT
    }

    @Id
    private String id;
    private Type type;

    public Role(Type type) {
        this.type = type;
    }
}
