package backend.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lectures")
public class LectureController {
    @PostMapping("/add")
    public String signup() {
        return "Lecture Add Endpoint";
    }

    @PutMapping("/edit")
    public String login() {
        return "Lecture Edit Endpoint";
    }

    @DeleteMapping("/delete")
    public String logout() {
        return "Lecture Delete Endpoint";
    }

    @GetMapping
    public String getLectures() {
        return "Lectures List Endpoint";
    }
}
