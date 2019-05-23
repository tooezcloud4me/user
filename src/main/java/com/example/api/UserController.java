package com.example.api;

import com.example.model.User;
import com.example.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Api(description = "User API", produces = "application/json", tags = {"User"})
@RequestMapping(path = "/demo")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUser() {
        return userService.getAllUser();
    }

    @PostMapping(path = "/user/{id}")
    public @ResponseBody
    Optional<User> findByID(@PathVariable Integer id) {
        return userService.findUser(id);
    }

    @PutMapping(path = "/user/{id}")
    public @ResponseBody
    void updateUser(@PathVariable Integer id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping(path = "/user/{id}")
    public @ResponseBody
    void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}
