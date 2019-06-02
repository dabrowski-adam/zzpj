package backend.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubjectDTO implements Serializable {

    private String topic;
    private String key;
}
