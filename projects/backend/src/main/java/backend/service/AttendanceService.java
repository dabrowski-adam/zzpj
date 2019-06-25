package backend.service;

import backend.domain.Attendance;
import backend.domain.Lecture;
import backend.domain.User;

import backend.dto.AttendanceDto;
import backend.dto.LectureDto;
import backend.dto.UserDto;
import java.util.List;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface AttendanceService {

  void update(AttendanceDto attendanceDto);

  void add(AttendanceDto attendanceDto);

  void delete(AttendanceDto attendanceDto);

  List<AttendanceDto> getAttendances();

  Optional<AttendanceDto> get(String attendanceId);

  Optional<AttendanceDto> findByLectureAndStudent(LectureDto lecture, UserDto student);
}
