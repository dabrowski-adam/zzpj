package backend.controllers;

import static java.util.stream.Collectors.toList;

import backend.domain.Lecture;
import backend.dto.LectureDto;
import backend.service.LectureService;

import java.util.List;

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
@RequestMapping("/lectures")
public class LectureController {

  private final LectureService lectureService;
  private final ModelMapper modelMapper;

  @Autowired
  public LectureController(LectureService lectureService, ModelMapper modelMapper) {
    this.lectureService = lectureService;
    this.modelMapper = modelMapper;
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
    var lecture = modelMapper.map(lectureDto, Lecture.class);
    lectureService.add(lecture);
    return ResponseEntity.ok()
        .build();
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
    var lecture = modelMapper.map(lectureDto, Lecture.class);
    lecture.setId(lectureId);
    lectureService.update(lecture);
    return ResponseEntity.ok()
        .build();
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
    var lecture = modelMapper.map(lectureDto, Lecture.class);
    lectureService.delete(lecture);
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
    var lectureDtos = lectureService.getLectures()
        .stream()
        .map(x -> modelMapper.map(x, LectureDto.class))
        .collect(toList());
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
