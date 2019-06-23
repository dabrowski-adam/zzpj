package backend.controllers;

import backend.domain.User;
import backend.dto.UserDto;
import backend.service.UserService;
import org.modelmapper.ModelMapper;
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
  private final ModelMapper modelMapper;
  private final PasswordEncoder passwordEncoder;

  /**
   * Constructor.
   * @param userService user service
   * @param modelMapper model mapper
   * @param passwordEncoder password encoder
   */
  @Autowired
  public UsersController(UserService userService,
                         ModelMapper modelMapper,
                         PasswordEncoder passwordEncoder) {
    this.userService = userService;
    this.modelMapper = modelMapper;
    this.passwordEncoder = passwordEncoder;
  }

  /**
   * User sign up.
   * @param userDto user Data
   * @return ResponseEntity
   */
  @PostMapping("signup")
  public ResponseEntity signup(@RequestBody UserDto userDto) {
    var user = modelMapper.map(userDto, User.class);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userService.add(user);
    return ResponseEntity.ok().build();
  }

  /**
   * Editing user.
   * @param userId id of user
   * @param userDto data of user
   * @return
   */
  @PutMapping("edit/{userId}")
  public ResponseEntity edit(@PathVariable String userId,
                             @RequestBody UserDto userDto) {
    var user = modelMapper.map(userDto, User.class);
    user.setId(userId);
    userService.update(user);
    return ResponseEntity.ok().build();
  }

  @PostMapping("forgot")
  public ResponseEntity forgot() {
    // TODO forgot pass logic
    return ResponseEntity.badRequest().build();
  }
}
