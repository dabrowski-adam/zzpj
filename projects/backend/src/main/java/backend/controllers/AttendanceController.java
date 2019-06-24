package backend.controllers;

import backend.domain.Attendance;
import backend.service.AttendanceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("attendances")
public class AttendanceController {

  private final AttendanceService attendanceService;

  @Autowired
  public AttendanceController(AttendanceService attendanceService) {
    this.attendanceService = attendanceService;
  }

  // TODO: Add validation mechanism

  /**
   * Delete attendance.
   *
   * @param attendanceId Attendance id.
   * @return ResponseEntity
   */
  @DeleteMapping("delete/{attendanceId}")
  public ResponseEntity deleteSubject(@PathVariable String attendanceId) {
    var attendance = attendanceService.get(attendanceId);
    attendanceService.delete(attendance);
    return ResponseEntity.ok()
        .build();
  }

  /**
   * Get attendance.
   *
   * @param attendanceId Attendance id.
   * @return ResponseEntity
   */
  @GetMapping("{attendanceId}")
  public ResponseEntity getSubject(@PathVariable String attendanceId) {
    var attendance = attendanceService.get(attendanceId);
    return ResponseEntity.ok(attendance);
  }

  @GetMapping
  public ResponseEntity<List<Attendance>> getSubjects() {
    var attendances = attendanceService.getAttendances();
    return ResponseEntity.ok(attendances);
  }
}
