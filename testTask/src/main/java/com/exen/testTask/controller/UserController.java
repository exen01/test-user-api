package com.exen.testTask.controller;

import com.exen.testTask.model.User;
import com.exen.testTask.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUser(@PathVariable String userId) {
        return userService.findById(Long.parseLong(userId));
    }

    @PostMapping
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Object> updateUserStatus(@PathVariable String userId) {
        return userService.updateUser(Long.parseLong(userId));
    }
}
