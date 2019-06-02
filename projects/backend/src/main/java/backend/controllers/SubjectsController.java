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

    // TODO: Add validation mechanism
    @PutMapping("update/{subjectId}")
    public ResponseEntity updateSubject(@PathVariable String subjectId, @RequestBody SubjectDTO subjectDTO) {
        var subject = modelMapper.map(subjectDTO, Subject.class);
        subject.setId(subjectId);
        subjectService.update(subject);
        return ResponseEntity.ok().build();
    }

    // TODO: Add validation mechanism
    @DeleteMapping("delete/{subjectId}")
    public ResponseEntity deleteSubject(@PathVariable String subjectId) {
        var subject = subjectService.get(subjectId);
        subjectService.delete(subject);
        return ResponseEntity.ok().build();
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
