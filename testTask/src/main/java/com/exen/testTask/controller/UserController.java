package com.exen.testTask.controller;

import com.exen.testTask.model.Users;
import com.exen.testTask.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    @GetMapping("/{userId}")
    public Users getUser(@PathVariable String userId) {
        return userService.findById(Long.parseLong(userId));
    }

    @PostMapping
    public long addUser(@RequestBody Users user) {
        return userService.save(user);
    }

    @PutMapping("/{userId}")
    public Map<String, String> updateUserStatus(@PathVariable String userId) {
        return userService.updateUser(Long.parseLong(userId));
    }
}
