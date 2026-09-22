package com.app.ecom;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //    private List<User> userList = new ArrayList<>();

    @GetMapping("/api/users")
    public List<User> getAllUsers(){
        return userService.fetchAllUsers();
    }

    @GetMapping("/api/user/{id}")
    public User getUser(@PathVariable Long id){
        return userService.fetchUser(id);
    }

    @PostMapping("/api/users")
    public String  createUsers(@RequestBody User user){
        userService.addUser(user);
        return "User added";
    }
}
