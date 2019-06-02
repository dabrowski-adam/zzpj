package backend.controllers;

import backend.repositories.LecturesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("lectures")
public class LecturesController {
    private LecturesRepository lecturesRepository;

    @Autowired
    public LecturesController(LecturesRepository lecturesRepository) {
        this.lecturesRepository = lecturesRepository;
    }

    @PostMapping("add")
    public String signup() {
        return "Lecture Add Endpoint";
    }

    @PutMapping("edit")
    public String login() {
        return "Lecture Edit Endpoint";
    }

    @DeleteMapping("delete")
    public String logout() {
        return "Lecture Delete Endpoint";
    }

    @GetMapping("lectures")
    public String edit() {
        return "Lectures List Endpoint";
    }
}
