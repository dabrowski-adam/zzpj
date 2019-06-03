package backend.service.impl;

import backend.domain.Lecture;
import backend.repositories.LecturesRepository;
import backend.service.LectureService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectureServiceImpl implements LectureService {

  private final LecturesRepository lecturesRepository;

  @Autowired
  public LectureServiceImpl(LecturesRepository lecturesRepository) {
    this.lecturesRepository = lecturesRepository;
  }

  @Override
  public void update(Lecture lecture) {
    lecturesRepository.findById(lecture.getId()).ifPresent(lecturesRepository::insert);
  }

  @Override
  public void add(Lecture lecture) {
    //TODO: Add some feedback, how do we know that this had succeded?
    lecturesRepository.insert(lecture);
  }

  @Override
  public void delete(Lecture lecture) {
    lecturesRepository.deleteById(lecture.getId());
  }

  @Override
  public List<Lecture> getLectures() {
    return lecturesRepository.findAll();
  }
}
