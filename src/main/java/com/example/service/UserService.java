package com.example.service;

import com.example.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUser();

    void saveUser(User user);

    void deleteUser(Integer id);

    void updateUser(Integer id, User user);

    Optional<User> findUser(Integer id);
}
