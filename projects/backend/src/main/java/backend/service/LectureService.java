package backend.service;

import backend.domain.Lecture;

import backend.dto.LectureDto;
import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface LectureService {

  void update(LectureDto lectureDto);

  void add(LectureDto lectureDto);

  void delete(LectureDto lectureDto);

  List<LectureDto> getLectures();

  void open(String id, long pin);

  void close(String id);

  Optional<LectureDto> get(String id);
}
