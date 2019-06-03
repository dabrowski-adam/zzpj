package backend.controllers;

import backend.dto.LectureDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

  @GetMapping("/")
  public ResponseEntity<LectureDto> index() {
    LectureDto result = new LectureDto();
    return ResponseEntity.ok(result);
  }
}
