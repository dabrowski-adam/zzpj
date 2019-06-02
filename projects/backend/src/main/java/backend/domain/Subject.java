package backend.domain;

import org.springframework.data.annotation.Id;

public class Subject {

    @Id
    public String id;

    public String department;

    long semester;



}