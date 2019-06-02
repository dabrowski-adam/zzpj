package backend.domain;

import org.springframework.data.annotation.Id;

public class Lecturer {

    @Id
    public String id;

    public String name;

    public String surname;

}
