package backend.service.impl;

import backend.domain.Attendance;
import backend.domain.Lecture;
import backend.domain.User;
import backend.dto.AttendanceDto;
import backend.dto.LectureDto;
import backend.dto.UserDto;
import backend.repositories.AttendancesRepository;
import backend.service.AttendanceService;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;
import org.checkerframework.checker.nullness.Opt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl implements AttendanceService {

  private final AttendancesRepository attendancesRepository;

  @Autowired
  public AttendanceServiceImpl(AttendancesRepository attendancesRepository) {
    this.attendancesRepository = attendancesRepository;
  }

  @Override
  public Optional<AttendanceDto> get(String attendanceId) {
    var attendance = attendancesRepository.findById(attendanceId);
    return attendance.map(AttendanceDto::toDto);
  }

  @Override
  public Optional<AttendanceDto> findByLectureAndStudent(LectureDto lecture, UserDto student) {
    var attendance = attendancesRepository.findByLectureAndStudent(LectureDto.toModel(lecture), UserDto.toModel(student));
    AttendanceDto dto = attendance != null ? AttendanceDto.toDto(attendance) : null;
    return Optional.ofNullable(dto);
  }

  @Override
  public void update(AttendanceDto attendanceDto) {
    attendancesRepository.findById(attendanceDto.getId())
        .ifPresent(x -> {
          attendancesRepository.deleteById(attendanceDto.getId());
          Attendance attendance = AttendanceDto.toModel(attendanceDto);
          attendancesRepository.save(attendance);
        });
  }

  @Override
  public void add(AttendanceDto attendanceDto) {
    Attendance attendance = AttendanceDto.toModel(attendanceDto);
    attendancesRepository.insert(attendance);
  }

  @Override
  public void delete(AttendanceDto attendanceDto) {
    attendancesRepository.deleteById(attendanceDto.getId());
  }

  @Override
  public List<AttendanceDto> getAttendances() {
    return attendancesRepository.findAll().stream().map(AttendanceDto::toDto).collect(Collectors.toList());
  }
}
