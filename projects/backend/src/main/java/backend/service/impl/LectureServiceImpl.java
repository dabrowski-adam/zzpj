package backend.service.impl;

import backend.domain.Lecture;
import backend.service.LectureService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class LectureServiceImpl implements LectureService {
    @Override
    public void signUp() {

    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }

    @Override
    public void edit() {

    }

    @Override
    public List<Lecture> getLectures() {
        Lecture lecture = new Lecture(null, null, LocalDateTime.MIN,
                LocalDateTime.MAX, "1", 123, false, false);
        Lecture lecture1 = new Lecture(null, null, LocalDateTime.MIN,
                LocalDateTime.MAX, "1", 123, false, false);

        var list = Arrays.asList(lecture, lecture1);
        return list;
    }
}
