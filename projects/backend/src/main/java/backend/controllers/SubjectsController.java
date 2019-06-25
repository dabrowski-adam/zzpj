package backend.controllers;

import backend.domain.Subject;
import backend.dto.SubjectDto;
import backend.requests.subject.AddSubjectRequestModel;
import backend.requests.subject.UpdateSubjectRequestModel;
import backend.service.SubjectService;
import java.util.List;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  /**
   * Add subject.
   * @param request Subject data.
   * @return ResponseEntity
   */
  @PostMapping("add")
  public ResponseEntity addSubject(@Valid @RequestBody AddSubjectRequestModel request) {
    SubjectDto subjectDto = SubjectDto.parseFromAddSubjectRequest(request);
    var subject = modelMapper.map(subjectDto, Subject.class);
    subjectService.add(subject);
    return ResponseEntity.ok().build();
  }

  // TODO: Add validation mechanism
  /**
   * Update subject.
   * @param subjectId Subject id.
   * @param request Subject data.
   * @return ResponseEntity
   */
  @PutMapping("update/{subjectId}")
  public ResponseEntity updateSubject(@PathVariable String subjectId,
                                      @Valid @RequestBody UpdateSubjectRequestModel request) {
    SubjectDto subjectDto = SubjectDto.parseFromUpdateSubjectRequest(request);
    var subject = modelMapper.map(subjectDto, Subject.class);
    subject.setId(subjectId);
    subjectService.update(subject);
    return ResponseEntity.ok().build();
  }

  // TODO: Add validation mechanism
  /**
   * Delete subject.
   * @param subjectId Subject id.
   * @return ResponseEntity
   */
  @DeleteMapping("delete/{subjectId}")
  public ResponseEntity deleteSubject(@PathVariable String subjectId) {
    var subject = subjectService.get(subjectId);
    subjectService.delete(subject);
    return ResponseEntity.ok().build();
  }

  @GetMapping("{subjectId}")
  public ResponseEntity getSubject(@PathVariable String subjectId) {
    var subject = subjectService.get(subjectId);
    return ResponseEntity.ok(subject);
  }

  @GetMapping
  public ResponseEntity<List<Subject>> getSubjects() {
    var subjects = subjectService.getSubjects();
    return ResponseEntity.ok(subjects);
  }
}
