package backend.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("subjects")
public class SubjectsController {
    @PostMapping("add")
    public String signup() {
        return "Subject Add Endpoint";
    }

    @PutMapping("edit")
    public String login() {
        return "Subject Edit Endpoint";
    }

    @DeleteMapping("delete")
    public String logout() {
        return "Subject Delete Endpoint";
    }

    @GetMapping("lectures")
    public String edit() {
        return "Subjects List Endpoint";
    }
}
