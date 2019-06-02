package backend.service.impl;

import backend.domain.Subject;
import backend.repositories.SubjectsRepository;
import backend.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleSubjectService implements SubjectService {

    private final SubjectsRepository subjectsRepository;

    @Autowired
    public SimpleSubjectService(SubjectsRepository subjectsRepository) {
        this.subjectsRepository = subjectsRepository;
    }

    @Override
    public void update(Subject subject) {
        subjectsRepository.findById(subject.getId())
                          .ifPresent(existingSubject -> {
                              existingSubject.setTopic(subject.getTopic());
                              existingSubject.setKey(subject.getKey());
                              subjectsRepository.save(existingSubject);
                          });
    }

    @Override
    public void add(Subject subject) {
        subjectsRepository.insert(subject);
    }

    @Override
    public void delete(Subject subject) {
        subjectsRepository.deleteById(subject.getId());
    }

    @Override
    public Subject get(String subjectId) {
        return subjectsRepository.findById(subjectId).orElse(null);
    }

    @Override
    public List<Subject> getSubjects() {
        return subjectsRepository.findAll();
    }
}
