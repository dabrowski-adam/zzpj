package backend.controllers;

import backend.domain.Attendance;
import backend.domain.Lecture;
import backend.domain.User;
import backend.dto.AttendanceDto;
import backend.service.AttendanceService;
import backend.service.LectureService;
import backend.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("attendances")
public class AttendanceController {

  private final AttendanceService attendanceService;
  private final LectureService lectureService;
  private final UserService userService;

  /**
   * AttendanceController constructor.
   *
   * @param attendanceService attendance service
   * @param lectureService lecture service
   * @param userService user service
   */
  @Autowired
  public AttendanceController(AttendanceService attendanceService, LectureService lectureService,
      UserService userService) {
    this.attendanceService = attendanceService;
    this.lectureService = lectureService;
    this.userService = userService;
  }

  // TODO: Add validation mechanism

  /**
   * Delete attendance.
   *
   * @param attendanceId Attendance id.
   * @return ResponseEntity
   */
  @DeleteMapping("delete/{attendanceId}")
  public ResponseEntity deleteAttendance(@PathVariable String attendanceId) {
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
  public ResponseEntity getAttendance(@PathVariable String attendanceId) {
    var attendance = attendanceService.get(attendanceId);
    return ResponseEntity.ok(attendance);
  }

  @GetMapping
  public ResponseEntity<List<Attendance>> getAttendances() {
    var attendances = attendanceService.getAttendances();
    return ResponseEntity.ok(attendances);
  }

  /**
   * Check attendance.
   *
   * @param lectureId Lecture id
   * @param attendanceDto attendance data
   * @return ResponseEntity
   */
  @PostMapping("check/{lectureId}")
  public ResponseEntity checkAttendance(@PathVariable String lectureId,
      @RequestBody AttendanceDto attendanceDto) {
    Lecture lecture = lectureService.get(lectureId);
    User student = userService.get(attendanceDto.getStudentId());

    if (lecture != null && student != null) {
      Attendance attendance = attendanceService.findByLectureAndStudent(lecture, student);

      if (attendance == null) {
        attendance = new Attendance(lecture, student, (byte) 0);

        attendanceService.add(attendance);

        return ResponseEntity.ok()
            .build();
      }

      return ResponseEntity.badRequest()
          .build();
    }

    return ResponseEntity.badRequest()
        .build();
  }
}
