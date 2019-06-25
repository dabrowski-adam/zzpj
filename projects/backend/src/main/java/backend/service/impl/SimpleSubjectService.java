package backend.service.impl;

import static java.util.stream.Collectors.toList;

import backend.domain.Subject;
import backend.dto.SubjectDto;
import backend.repositories.SubjectsRepository;
import backend.service.SubjectService;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleSubjectService implements SubjectService {

  private final SubjectsRepository subjectsRepository;

  public static SubjectDto toDto(Subject model) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(model, SubjectDto.class);
  }

  public static Subject toModel(SubjectDto dto) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(dto, Subject.class);
  }

  @Autowired
  public SimpleSubjectService(SubjectsRepository subjectsRepository) {
    this.subjectsRepository = subjectsRepository;
  }

  @Override
  public void update(SubjectDto subjectDto) {
    Subject subject = toModel(subjectDto);
    subjectsRepository.findById(subject.getId()).ifPresent(existingSubject -> {
      existingSubject.setTopic(subject.getTopic());
      existingSubject.setKey(subject.getKey());
      subjectsRepository.save(existingSubject);
    });
  }

  @Override
  public void add(SubjectDto subjectDto) {
    Subject subject = toModel(subjectDto);
    subjectsRepository.insert(subject);
  }

  @Override
  public void delete(SubjectDto subjectDto) {
    Subject subject = toModel(subjectDto);
    subjectsRepository.deleteById(subject.getId());
  }

  @Override
  public Optional<SubjectDto> get(String subjectId) {
    Optional<Subject> subject = subjectsRepository.findById(subjectId);
    return subject.map(SimpleSubjectService::toDto);
  }

  @Override
  public List<SubjectDto> getSubjects() {
    var subjects = subjectsRepository.findAll();
    var subjectsDtos = subjects.stream().map(SimpleSubjectService::toDto).collect(toList());
    return subjectsDtos;
  }
}
