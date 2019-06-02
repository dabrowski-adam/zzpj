package backend.service;

import backend.domain.Subject;

import java.util.List;

public interface SubjectService {

    void update(Subject subject);

    void add(Subject subject);

    void delete(Subject subject);

    Subject get(String subjectId);

    List<Subject> getSubjects();
}
