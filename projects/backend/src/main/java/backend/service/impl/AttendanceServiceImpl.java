package backend.service.impl;

import backend.domain.Attendance;
import backend.dto.AttendanceDto;
import backend.dto.LectureDto;
import backend.dto.UserDto;
import backend.repositories.AttendancesRepository;
import backend.service.AttendanceService;
import backend.service.UserService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendanceServiceImpl implements AttendanceService {

  private final AttendancesRepository attendancesRepository;

  public static AttendanceDto toDto(Attendance model) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(model, AttendanceDto.class);
  }

  public static Attendance toModel(AttendanceDto dto) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(dto, Attendance.class);
  }

  @Autowired
  public AttendanceServiceImpl(AttendancesRepository attendancesRepository) {
    this.attendancesRepository = attendancesRepository;
  }

  @Override
  public Optional<AttendanceDto> get(String attendanceId) {
    var attendance = attendancesRepository.findById(attendanceId);
    return attendance.map(AttendanceServiceImpl::toDto);
  }

  @Override
  public Optional<AttendanceDto> findByLectureAndStudent(LectureDto lecture, UserDto student) {
    var attendance = attendancesRepository
        .findByLectureAndStudent(LectureServiceImpl.toModel(lecture), UserService.toModel(student));
    AttendanceDto dto = attendance != null ? toDto(attendance) : null;
    return Optional.ofNullable(dto);
  }

  @Override
  public void update(AttendanceDto attendanceDto) {
    attendancesRepository.findById(attendanceDto.getId())
        .ifPresent(x -> {
          attendancesRepository.deleteById(attendanceDto.getId());
          Attendance attendance = toModel(attendanceDto);
          attendancesRepository.save(attendance);
        });
  }

  @Override
  public void add(AttendanceDto attendanceDto) {
    Attendance attendance = toModel(attendanceDto);
    attendancesRepository.insert(attendance);
  }

  @Override
  public void delete(AttendanceDto attendanceDto) {
    attendancesRepository.deleteById(attendanceDto.getId());
  }

  @Override
  public List<AttendanceDto> getAttendances() {
    return attendancesRepository.findAll().stream().map(AttendanceServiceImpl::toDto)
        .collect(Collectors.toList());
  }
}
