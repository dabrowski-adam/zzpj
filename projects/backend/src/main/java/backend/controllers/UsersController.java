package backend.controllers;

import backend.dto.UserDto;
import backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UsersController {

  private final UserService userService;
  private final PasswordEncoder passwordEncoder;

  /**
   * Constructor.
   *
   * @param userService user service
   * @param passwordEncoder password encoder
   */
  @Autowired
  public UsersController(UserService userService,
      PasswordEncoder passwordEncoder) {
    this.userService = userService;
    this.passwordEncoder = passwordEncoder;
  }

  /**
   * User sign up.
   *
   * @param userDto user Data
   * @return ResponseEntity
   */
  @PostMapping("signup")
  public ResponseEntity signup(@RequestBody UserDto userDto) {
    userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
    userService.add(userDto);
    return ResponseEntity.ok().build();
  }

  /**
   * Editing user.
   *
   * @param userId id of user
   * @param userDto data of user
   */
  @PutMapping("edit/{userId}")
  public ResponseEntity edit(@PathVariable String userId,
      @RequestBody UserDto userDto) {
    userDto.setId(userId);
    userService.update(userDto);
    return ResponseEntity.ok().build();
  }

  @PostMapping("forgot")
  public ResponseEntity forgot() {
    return ResponseEntity.badRequest().build();
  }
}
