package backend.dto;

import backend.domain.Lecture;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class LectureDTO implements Serializable {
    //TODO: Add remaining data
    private LocalDateTime start;
    private LocalDateTime end;
    private String key;
    private long pin;
    private boolean isOpen;
    private boolean isChecked;
}
