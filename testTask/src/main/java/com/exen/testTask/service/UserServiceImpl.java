package com.exen.testTask.service;

import com.exen.testTask.exception.UserExistingEmailException;
import com.exen.testTask.exception.UserNotFoundException;
import com.exen.testTask.model.User;
import com.exen.testTask.repo.UserRepo;
import com.exen.testTask.response.ResponseHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepo userRepo;

    @Override
    public ResponseEntity<Object> save(User user) {
        String newUserEmail = user.getEmail();
        Optional<User> userFromDb = userRepo.findByEmail(newUserEmail);

        if (userFromDb.isPresent() && newUserEmail.equals(userFromDb.get().getEmail())) {
            throw new UserExistingEmailException("User with this email already exists");
        }

        long id = userRepo.save(user).getId();
        return ResponseHandler.responseBuilder("User saved successfully", HttpStatus.OK, id);
    }

    @Override
    public ResponseEntity<Object> findById(long id) {
        if (!userRepo.findById(id).isPresent()) {
            throw new UserNotFoundException("User does not exist");
        }

        return ResponseHandler.responseBuilder("User found", HttpStatus.OK, userRepo.findById(id).get());
    }

    @Override
    public ResponseEntity<Object> updateUser(long id) {
        if (!userRepo.findById(id).isPresent()) {
            throw new UserNotFoundException("User does not exist");
        }

        User user = userRepo.findById(id).get();

        Map<String, String> updateResponse = new HashMap<>();
        updateResponse.put("id", String.valueOf(user.getId()));
        updateResponse.put("previous status", user.getStatus());

        if (user.getStatus().equalsIgnoreCase("offline")) {
            user.setStatus("online");
            updateResponse.put("current status", user.getStatus());
        } else {
            user.setStatus("offline");
            updateResponse.put("current status", user.getStatus());
        }

        userRepo.save(user);

        return ResponseHandler.responseBuilder("User was updated successfully", HttpStatus.OK, updateResponse);
    }
}
