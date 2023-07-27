package com.exen.testTask.service;

import com.exen.testTask.model.Users;
import com.exen.testTask.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepo userRepo;

    @Override
    public Long save(Users user) {
        long id = userRepo.save(user).getId();
        return id;
    }

    @Override
    public Users findById(long id) {
        return userRepo.findById(id).get();
    }

    @Override
    public Map<String, String> updateUser(long id) {
        Users user = userRepo.findById(id).get();

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

        return updateResponse;
    }
}
