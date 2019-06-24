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
    lecturesRepository.findById(lecture.getId())
        .ifPresent(x -> {
          lecturesRepository.deleteById(lecture.getId());
          lecturesRepository.save(lecture);
        });
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

  @Override
  public void open(String id, long pin) {
    lecturesRepository.findById(id)
        .ifPresent(x -> {
          x.setOpen(true);
          x.setPin(pin);
          update(x);
        });
  }

  @Override
  public void close(String id) {
    lecturesRepository.findById(id)
        .ifPresent(x -> {
          x.setOpen(false);
          x.setChecked(true);
          update(x);
        });
  }
}
