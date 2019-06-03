package backend.repositories;

import backend.domain.Attendance;
import backend.domain.Lecture;
import backend.domain.User;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendancesRepository extends MongoRepository<Attendance, String> {


  Optional<Attendance> findById(String id);

  Attendance findByLectureAndStudent(Lecture lecture, User student);

  Attendance findByLectureId(String id);

  List<Attendance> findAll();

  Attendance insert(Attendance attendance);

  Attendance save(Attendance attendance);

  void deleteById(String id);
}
