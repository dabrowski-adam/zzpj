package backend.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UsersController {

  @PostMapping("signup")
  public String signup() {
    return "User Signup Endpoint";
  }

  @PostMapping("login")
  public String login() {
    return "User Login Endpoint";
  }

  @DeleteMapping("logout")
  public String logout() {
    return "User Logout Endpoint";
  }

  @PutMapping("edit")
  public String edit() {
    return "User Edit Endpoint";
  }

  @PostMapping("forgot")
  public String forgot() {
    return "User Forgot Endpoint";
  }
}
