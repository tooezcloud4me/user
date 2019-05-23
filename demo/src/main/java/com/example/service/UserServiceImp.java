package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }


    @Override
    public void deleteUser(Integer id) {
        userRepository.findById(id).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.ok().build();
        });
    }

    @Override
    public void updateUser(Integer id, User user) {
        userRepository.findById(id).map(updateUser -> {
            updateUser.setName(user.getName());
            updateUser.setAddress(user.getAddress());
            updateUser.setPhone(user.getPhone());
            return userRepository.save(updateUser);
        });
    }

    @Override
    public Optional<User> findUser(Integer id) {
        return userRepository.findById(id);
    }
}
