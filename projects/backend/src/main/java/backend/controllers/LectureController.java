package backend.controllers;

import backend.dto.LectureDTO;
import backend.service.LectureService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public String signup() {
        return "Lecture Add Endpoint";
    }

    @PutMapping("/edit")
    public String login() {
        return "Lecture Edit Endpoint";
    }

    @DeleteMapping("/delete")
    public String logout() {
        return "Lecture Delete Endpoint";
    }

    @GetMapping
    public ResponseEntity<List<LectureDTO>> getLectures() {
        var results = lectureService.getLectures().stream()
                .map(x -> modelMapper.map(x, LectureDTO.class))
                .collect(toList());
        return ResponseEntity.ok(results);
    }
}
