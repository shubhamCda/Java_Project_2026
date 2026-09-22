package com.app.ecom;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //    private List<User> userList = new ArrayList<>();

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getAllUsers(){
//        return ResponseEntity.ok(userService.fetchAllUsers());
        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);
    }


    @GetMapping("/api/user/{id}")
    public User getUser(@PathVariable Long id){
        return userService.fetchUser(id);
    }

    @PostMapping("/api/users")
    public ResponseEntity<String>  createUsers(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>("User created",HttpStatus.CREATED);
    }
}
