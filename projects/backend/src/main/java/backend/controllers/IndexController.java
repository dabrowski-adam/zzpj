package backend.controllers;

import backend.dto.LectureDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public ResponseEntity<LectureDTO> index() {
        LectureDTO result = new LectureDTO();
        return ResponseEntity.ok(reslut);
    }
}
