package backend.service;

import backend.domain.Attendance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttendanceService {
  void update(Attendance attendance);

  void add(Attendance attendance);

  void delete(Attendance attendance);

  List<Attendance> getAttendances();

  Attendance get(String attendanceId);
}
