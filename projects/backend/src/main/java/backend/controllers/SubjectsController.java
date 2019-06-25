package backend.controllers;

import backend.domain.Subject;
import backend.dto.SubjectDto;
import backend.requests.subject.AddSubjectRequestModel;
import backend.requests.subject.UpdateSubjectRequestModel;
import backend.service.SubjectService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
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

  @Autowired
  public SubjectsController(SubjectService subjectService) {
    this.subjectService = subjectService;
  }

  /**
   *  Add subject.
   *
   * @param request
   * @return
   */
  @PostMapping("add")
  public ResponseEntity addSubject(@Valid @RequestBody AddSubjectRequestModel request) {
    SubjectDto subjectDto = SubjectDto.parseFromAddSubjectRequest(request);
    subjectService.add(subjectDto);
    return ResponseEntity.ok().build();
  }

  /**
   * Update subject.
   *
   * @param subjectId
   * @param request
   * @return
   */
  @PutMapping("update/{subjectId}")
  public ResponseEntity updateSubject(@PathVariable String subjectId, @Valid @RequestBody UpdateSubjectRequestModel request) {
    SubjectDto subjectDto = SubjectDto.parseFromUpdateSubjectRequest(request);
    subjectDto.setId(subjectId);
    subjectService.update(subjectDto);
    return ResponseEntity.ok().build();
  }

  /**
   * Delete subject.
   *
   * @param subjectId Subject id.
   * @return ResponseEntity
   */
  @DeleteMapping("delete/{subjectId}")
  public ResponseEntity deleteSubject(@PathVariable String subjectId) {
    Optional<SubjectDto> subject = subjectService.get(subjectId);
    subject.ifPresent(subjectService::delete);
    return ResponseEntity.ok().build();
  }

  @GetMapping("{subjectId}")
  public ResponseEntity getSubject(@PathVariable String subjectId) {
    var subject = subjectService.get(subjectId);
    return ResponseEntity.ok(subject);
  }

  @GetMapping
  public ResponseEntity<List<SubjectDto>> getSubjects() {
    var subjects = subjectService.getSubjects();
    return ResponseEntity.ok(subjects);
  }
}
