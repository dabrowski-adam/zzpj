package backend.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    @PostMapping("/users/signup")
    public String signup() {
        return "User Signup Endpoint";
    }

    @PostMapping("/users/login")
    public String login() {
        return "User Login Endpoint";
    }

    @DeleteMapping("/users/logout")
    public String logout() {
        return "User Logout Endpoint";
    }

    @PutMapping("/users/edit")
    public String edit() {
        return "User Edit Endpoint";
    }

    @PostMapping("/users/forgot")
    public String forgot() {
        return "User Forgot Endpoint";
    }
}
