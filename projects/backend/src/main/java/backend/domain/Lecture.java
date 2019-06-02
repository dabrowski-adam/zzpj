package backend.domain;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Lecture {

    @Id
    public String id;

    //TODO: Add dependency on subject

    public LocalDateTime start;

    public LocalDateTime end;

    //TODO: Add dependency on lecturer

    long pin;

    boolean open;

    boolean checked;
}
