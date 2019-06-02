package backend.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class LecturesController {
    @PostMapping("/lectures/add")
    public String signup() {
        return "Lecture Add Endpoint";
    }

    @PutMapping("/lectures/edit")
    public String login() {
        return "Lecture Edit Endpoint";
    }

    @DeleteMapping("/lecture/delete")
    public String logout() {
        return "Lecture Delete Endpoint";
    }

    @GetMapping("/lecture/lectures")
    public String edit() {
        return "Lectures List Endpoint";
    }
}
