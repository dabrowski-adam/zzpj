package backend.controllers;

import backend.dto.LectureDTO;
import backend.dto.SubjectDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class IndexController {

    @GetMapping("/")
    public ResponseEntity<Map> index() {
        List<String> authors = List.of(
                "Mateusz Bujnowicz",
                "Adam Dąbrowski",
                "Michał Grzelak",
                "Kuba Mroczek",
                "Paweł Skowroński"
        );

        LectureDTO lectureDTO = new LectureDTO();
        SubjectDTO subjectDTO = new SubjectDTO();

        Map<String, Object> result = Map.of(
                "authors", authors,
                "lecture", lectureDTO,
                "subject", subjectDTO
        );

        return ResponseEntity.ok(result);
    }
}
