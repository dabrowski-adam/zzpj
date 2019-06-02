package backend.service;

import backend.domain.Lecture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LectureService {

    void update(Lecture lecture);

    void add(Lecture lecture);

    void delete(Lecture lecture);

    List<Lecture> getLectures();
}
