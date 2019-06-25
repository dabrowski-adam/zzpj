package backend.controllers;

import backend.domain.Attendance;
import backend.dto.AttendanceDto;
import backend.dto.LectureDto;
import backend.dto.UserDto;
import backend.service.AttendanceService;
import backend.service.LectureService;
import backend.service.UserService;
import backend.service.impl.AttendanceServiceImpl;
import backend.service.impl.LectureServiceImpl;
import java.util.List;
import java.util.Optional;
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

  /**
   * Delete attendance.
   *
   * @param attendanceId Attendance id.
   * @return ResponseEntity
   */
  @DeleteMapping("delete/{attendanceId}")
  public ResponseEntity deleteAttendance(@PathVariable String attendanceId) {
    var attendance = attendanceService.get(attendanceId);
    attendance.ifPresent(attendanceService::delete);
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
  public ResponseEntity<List<AttendanceDto>> getAttendances() {
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
    Optional<LectureDto> lecture = lectureService.get(lectureId);
    Optional<UserDto> student = userService.get(attendanceDto.getStudentId());

    //TODO: Reractor this code
    if (lecture != null && student != null) {
      Optional<AttendanceDto> newAttendanceDto = attendanceService
          .findByLectureAndStudent(lecture.get(), student.get());

      if (!newAttendanceDto.isPresent()) {
        Attendance attendance = new Attendance(LectureServiceImpl.toModel(lecture.get()),
            UserService.toModel(student.get()), (byte) 0);

        attendanceService.add(AttendanceServiceImpl.toDto(attendance));

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
