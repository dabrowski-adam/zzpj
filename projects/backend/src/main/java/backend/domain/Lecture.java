package backend.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.LocalDateTime;

@Data
public class Lecture {
    @Id
    private String id;
    @DBRef
    private Subject subject;
    @DBRef
    private User lecturer;
    private LocalDateTime start;
    private LocalDateTime end;
    private String key;
    private long pin;
    private boolean isOpen;
    private boolean isChecked;

    public Lecture(Subject subject, User lecturer, LocalDateTime start, LocalDateTime end, String key, long pin, boolean isOpen, boolean isChecked) {
        this.subject = subject;
        this.lecturer = lecturer;
        this.start = start;
        this.end = end;
        this.key = key;
        this.pin = pin;
        this.isOpen = isOpen;
        this.isChecked = isChecked;
    }
}
