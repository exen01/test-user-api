package com.exen.testTask.controller;

import com.exen.testTask.model.Users;
import com.exen.testTask.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    @GetMapping
    public Users getUser() {
        return new Users(1L, "test", "test", "test@test.com", "image", "offline");
    }

    @PostMapping
    public long addUser(@RequestBody Users user) {
        return userService.save(user);
    }
}
