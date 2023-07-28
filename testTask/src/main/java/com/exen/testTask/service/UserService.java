package com.exen.testTask.service;

import com.exen.testTask.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Object> save(User user);
    ResponseEntity<Object> findById(long id);
    ResponseEntity<Object> updateUser(long id);
}
