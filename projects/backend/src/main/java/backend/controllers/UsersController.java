package backend.controllers;

import backend.domain.User;
import backend.dto.UserDto;
import backend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@RestController
@RequestMapping("users")
public class UsersController {

  private final UserService userService;
  private final ModelMapper modelMapper;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;



  @Autowired
  public UsersController(UserService userService, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userService = userService;
    this.modelMapper = modelMapper;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @PostMapping("signup")
  public ResponseEntity signup(@RequestBody UserDto userDto) {
    var user = modelMapper.map(userDto, User.class);
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    userService.add(user);
    return ResponseEntity.ok().build();
  }

  @PutMapping("edit/{userId}")
  public ResponseEntity edit(@PathVariable String userId,
                             @RequestBody UserDto userDto) {
    var user = modelMapper.map(userDto,User.class);
    user.setId(userId);
    userService.update(user);
    return ResponseEntity.ok().build();
  }

  @PostMapping("forgot")
  public ResponseEntity forgot() {
    //TODO forgot pass logic
    return ResponseEntity.ok().build();
  }
}
