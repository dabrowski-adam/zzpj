package backend.controllers;

import backend.service.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("subjects")
public class SubjectsController {

    private final SubjectService subjectService;
    private final ModelMapper modelMapper;

    @Autowired
    public SubjectsController(SubjectService subjectService, ModelMapper modelMapper) {
        this.subjectService = subjectService;
        this.modelMapper = modelMapper;
    }

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
