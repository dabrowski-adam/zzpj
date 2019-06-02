package backend.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Subject {
    @Id
    private String id;
    private String topic;
    private String key;

    public Subject(String topic, String key) {
        this.topic = topic;
        this.key = key;
    }
}