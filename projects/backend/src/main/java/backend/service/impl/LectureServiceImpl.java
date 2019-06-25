package backend.service.impl;

import static java.util.stream.Collectors.toList;

import backend.domain.Lecture;
import backend.dto.LectureDto;
import backend.repositories.LecturesRepository;
import backend.service.LectureService;

import java.util.List;

import java.util.Optional;
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
  public void update(LectureDto lectureDto) {
    Lecture lecture = LectureDto.toModel(lectureDto);
    lecturesRepository.findById(lectureDto.getId())
        .ifPresent(x -> {
          lecturesRepository.deleteById(lecture.getId());
          lecturesRepository.save(lecture);
        });
  }

  @Override
  public void add(LectureDto lectureDto) {
    //TODO: Add some feedback, how do we know that this had succeded?
    Lecture lecture = LectureDto.toModel(lectureDto);
    lecturesRepository.insert(lecture);
  }

  @Override
  public void delete(LectureDto lectureDto) {
    lecturesRepository.deleteById(lectureDto.getId());
  }

  @Override
  public List<LectureDto> getLectures() {
    var lectures = lecturesRepository.findAll();
    return lectures.stream().map(LectureDto::toDto).collect(toList());
  }

  @Override
  public void open(String id, long pin) {
    lecturesRepository.findById(id)
        .ifPresent(x -> {
          x.setOpen(true);
          x.setPin(pin);
          LectureDto lectureDto = LectureDto.toDto(x);
          update(lectureDto);
        });
  }

  @Override
  public void close(String id) {
    lecturesRepository.findById(id)
        .ifPresent(x -> {
          x.setOpen(false);
          x.setChecked(true);
          LectureDto lectureDto = LectureDto.toDto(x);
          update(lectureDto);
        });
  }

  @Override
  public Optional<LectureDto> get(String lectureId) {
    var lecture = lecturesRepository.findById(lectureId);
    return lecture.map(LectureDto::toDto);
  }
}
