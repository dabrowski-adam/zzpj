package backend.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("subjects")
public class SubjectsController {

  @PostMapping("add")
  public String signup() {
    return "Subject Add Endpoint";
  }

  @PutMapping("edit")
  public String login() {
    return "Subject Edit Endpoint";
  }

  @DeleteMapping("delete")
  public String logout() {
    return "Subject Delete Endpoint";
  }

  @GetMapping("lectures")
  public String edit() {
    return "Subjects List Endpoint";
  }
}
