package backend.service;

import backend.domain.Lecture;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface LectureService {

  void update(Lecture lecture);

  void add(Lecture lecture);

  void delete(Lecture lecture);

  List<Lecture> getLectures();

  void open(String id, long pin);

  void close(String id);

  Lecture get(String id);
}
