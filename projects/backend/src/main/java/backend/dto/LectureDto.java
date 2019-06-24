package backend.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class LectureDto implements Serializable {
  
  private String id;
  private LocalDateTime start;
  private LocalDateTime end;
  private String key;
  private long pin;
  private boolean isOpen;
  private boolean isChecked;
}
