package backend.service;

import backend.dto.SubjectDto;
import java.util.List;
import java.util.Optional;

public interface SubjectService {

  void update(SubjectDto subjectDto);

  void add(SubjectDto subjectDto);

  void delete(SubjectDto subjectDto);

  Optional<SubjectDto> get(String subjectId);

  List<SubjectDto> getSubjects();
}
