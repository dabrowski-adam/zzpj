package backend.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class SubjectsController {
    @PostMapping("/subjects/add")
    public String signup() {
        return "Subject Add Endpoint";
    }

    @PutMapping("/subjects/edit")
    public String login() {
        return "Subject Edit Endpoint";
    }

    @DeleteMapping("/subjects/delete")
    public String logout() {
        return "Subject Delete Endpoint";
    }

    @GetMapping("/subjects/lectures")
    public String edit() {
        return "Subjects List Endpoint";
    }
}
