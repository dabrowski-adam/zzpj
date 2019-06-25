package backend.controllers;

import static java.util.stream.Collectors.toList;

import backend.dto.LectureDto;
import backend.requests.lecture.AddLectureRequestModel;
import backend.requests.lecture.UpdateLectureRequestModel;
import backend.service.LectureService;
import java.util.List;
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
@RequestMapping("/lectures")
public class LectureController {

  private final LectureService lectureService;

  @Autowired
  public LectureController(LectureService lectureService) {
    this.lectureService = lectureService;
  }

  /**
   * Add a new lecture.
   * @param request Lecture data.
   * @return ResponseEntity
   */
  @PostMapping("add")
  public ResponseEntity addLecture(@Valid @RequestBody AddLectureRequestModel request) {
    LectureDto lectureDto = LectureDto.parseFromAddLectureRequest(request);
    lectureService.add(lectureDto);
    return ResponseEntity.ok()
        .build();
  }

  /**
   * Update an existing lecture.
   * @param request Lecture data.
   * @return ResponseEntity
   */
  @PutMapping("update/{lectureId}")
  public ResponseEntity updateLecture(@PathVariable String lectureId,
  @Valid @RequestBody UpdateLectureRequestModel request) {
    LectureDto lectureDto = LectureDto.parseFromUpdateLectureRequest(request);
    lectureDto.setId(lectureId);
    lectureService.update(lectureDto);
    return ResponseEntity.ok()
        .build();
  }

  /**
   * Delete a lecture.
   *
   * @param lectureDto Lecture data.
   * @return ResponseEntity
   */
  @DeleteMapping("delete")
  public ResponseEntity deleteLecture(@RequestBody LectureDto lectureDto) {
    lectureService.delete(lectureDto);
    return ResponseEntity.ok()
        .build();
  }

  /**
   * Get a list of all Lectures.
   *
   * @return ResponseEntity
   */
  @GetMapping
  public ResponseEntity<List<LectureDto>> getLectures() {
    var lectureDtos = lectureService.getLectures();
    return ResponseEntity.ok(lectureDtos);
  }

  /**
   * Open the lecture.
   *
   * @param lectureId lecture id
   * @return ResponseEntity
   */
  @PutMapping("open/{lectureId}")
  public ResponseEntity openLecture(@PathVariable String lectureId, @RequestBody long pin) {
    this.lectureService.open(lectureId, pin);

    return ResponseEntity.ok()
        .build();
  }

  /**
   * Close the lecture.
   *
   * @param lectureId lecture id
   * @return ResponseEntity
   */
  @PutMapping("close/{lectureId}")
  public ResponseEntity closeLecture(@PathVariable String lectureId) {
    this.lectureService.close(lectureId);

    return ResponseEntity.ok()
        .build();
  }

}
