package backend.domain;

import org.springframework.data.annotation.Id;

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