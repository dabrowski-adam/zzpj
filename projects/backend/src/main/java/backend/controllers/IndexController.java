package backend.controllers;

import backend.dto.LectureDto;
import backend.dto.SubjectDto;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

  /**
   * Index.
   * @return ResponseEntity Helpful API docs.
   */
  @GetMapping("/")
  public ResponseEntity<Map> index() {
    List<String> authors = List.of(
        "Mateusz Bujnowicz",
        "Adam Dąbrowski",
        "Michał Grzelak",
        "Kuba Mroczek",
        "Paweł Skowroński"
    );

    LectureDto lectureDto = new LectureDto();
    SubjectDto subjectDto = new SubjectDto();

    Map<String, Object> result = Map.of(
        "authors", authors,
        "lecture", lectureDto,
        "subject", subjectDto
    );

    return ResponseEntity.ok(result);
  }
}
