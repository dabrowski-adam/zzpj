package backend.controllers;

import backend.domain.Lecture;
import backend.dto.LectureDTO;
import backend.service.LectureService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

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
    @PostMapping("add")
    public ResponseEntity addLecture(@RequestBody LectureDTO lectureDTO) {
        var lecture = modelMapper.map(lectureDTO, Lecture.class);
        lectureService.add(lecture);
        return ResponseEntity.ok().build();
    }

    //TODO: Add validation mechanism
    @PutMapping("update")
    public ResponseEntity updateLecture(@RequestBody LectureDTO lectureDTO) {
        var lecture = modelMapper.map(lectureDTO, Lecture.class);
        lectureService.update(lecture);
        return ResponseEntity.ok().build();
    }

    //TODO: Add validation mechanism
    @DeleteMapping("delete")
    public ResponseEntity deleteLecture(@RequestBody LectureDTO lectureDTO) {
        var lecture = modelMapper.map(lectureDTO, Lecture.class);
        lectureService.delete(lecture);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<LectureDTO>> getLectures() {
        var lectureDTOS = lectureService.getLectures().stream()
                .map(x -> modelMapper.map(x, LectureDTO.class))
                .collect(toList());
        return ResponseEntity.ok(lectureDTOS);
    }
}
