package backend.service;

import backend.domain.Lecture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LectureService {

    void signUp();

    void login();

    void logout();

    void edit();

    List<Lecture> getLectures();
}
