package backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    @RequestMapping("/users/signup")
    public String signup() {
        return "User Signup Endpoint";
    }

    @RequestMapping("/users/login")
    public String login() {
        return "User Login Endpoint";
    }

    @RequestMapping("/users/logout")
    public String logout() {
        return "User Logout Endpoint";
    }

    @RequestMapping("/users/edit")
    public String edit() {
        return "User Edit Endpoint";
    }

    @RequestMapping("/users/forgot")
    public String forgot() {
        return "User Forgot Endpoint";
    }
}
