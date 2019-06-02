package backend.controllers;

import backend.domain.Subject;
import backend.dto.SubjectDTO;
import backend.service.SubjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    // TODO: Add validation mechanism
    @PostMapping("add")
    public ResponseEntity addSubject(@RequestBody SubjectDTO subjectDTO) {
        var subject = modelMapper.map(subjectDTO, Subject.class);
        subjectService.add(subject);
        return ResponseEntity.ok().build();
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
