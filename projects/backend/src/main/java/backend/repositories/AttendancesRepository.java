package backend.repositories;

import backend.domain.Attendance;
import backend.domain.Lecture;
import backend.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttendancesRepository extends MongoRepository<Attendance, String> {
    public Optional<Attendance> findById(String id);
    public Attendance findByLectureAndStudent(Lecture lecture, User student);
    public Attendance findByLectureId(String id);
    public List<Attendance> findAll();
    public Attendance insert(Attendance attendance);
    public Attendance save(Attendance attendance);
    public void deleteById(String id);
}
