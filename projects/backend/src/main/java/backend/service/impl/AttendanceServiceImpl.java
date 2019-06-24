package backend.service.impl;

import backend.domain.Attendance;
import backend.repositories.AttendancesRepository;
import backend.service.AttendanceService;

import java.util.List;

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
  public void update(Attendance attendance) {
    attendancesRepository.findById(attendance.getId())
        .ifPresent(x -> {
          attendancesRepository.deleteById(attendance.getId());
          attendancesRepository.save(attendance);
        });
  }

  @Override
  public void add(Attendance attendance) {
    attendancesRepository.insert(attendance);
  }

  @Override
  public void delete(Attendance attendance) {
    attendancesRepository.deleteById(attendance.getId());
  }

  @Override
  public List<Attendance> getAttendances() {
    return null;
  }
}
