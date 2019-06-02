package backend.service.impl;

import backend.domain.Lecture;
import backend.repositories.LecturesRepository;
import backend.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class LectureServiceImpl implements LectureService {

    private final LecturesRepository lecturesRepository;

    @Autowired
    public LectureServiceImpl(LecturesRepository lecturesRepository) {
        this.lecturesRepository = lecturesRepository;
    }

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
        return lecturesRepository.findAll();
    }
}
