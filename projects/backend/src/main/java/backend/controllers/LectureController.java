package backend.controllers;

import static java.util.stream.Collectors.toList;

import backend.dto.LectureDto;
import backend.service.LectureService;
import java.util.List;
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
@RequestMapping("/lectures")
public class LectureController {

  private final LectureService lectureService;

  @Autowired
  public LectureController(LectureService lectureService) {
    this.lectureService = lectureService;
  }

  //TODO: Add validation mechanism

  /**
   * Add a new lecture.
   *
   * @param lectureDto Lecture data.
   * @return ResponseEntity
   */
  @PostMapping("add")
  public ResponseEntity addLecture(@RequestBody LectureDto lectureDto) {
    var lecture = LectureDto.toModel(lectureDto);
    lectureService.add(lecture);
    return ResponseEntity.ok().build();
  }

  //TODO: Add validation mechanism

  /**
   * Update an existing lecture.
   *
   * @param lectureDto Lecture data.
   * @return ResponseEntity
   */
  @PutMapping("update/{lectureId}")
  public ResponseEntity updateLecture(@PathVariable String lectureId,
      @RequestBody LectureDto lectureDto) {
    var lecture = LectureDto.toModel(lectureDto);
    lecture.setId(lectureId);
    lectureService.update(lecture);
    return ResponseEntity.ok().build();
  }

  //TODO: Add validation mechanism

  /**
   * Delete a lecture.
   *
   * @param lectureDto Lecture data.
   * @return ResponseEntity
   */
  @DeleteMapping("delete")
  public ResponseEntity deleteLecture(@RequestBody LectureDto lectureDto) {
    var lecture = LectureDto.toModel(lectureDto);
    lectureService.delete(lecture);
    return ResponseEntity.ok().build();
  }

  /**
   * Get a list of all Lectures.
   *
   * @return ResponseEntity
   */
  @GetMapping
  public ResponseEntity<List<LectureDto>> getLectures() {
    var lectureDtos = lectureService.getLectures().stream()
        .map(LectureDto::toDto)
        .collect(toList());
    return ResponseEntity.ok(lectureDtos);
  }
}
