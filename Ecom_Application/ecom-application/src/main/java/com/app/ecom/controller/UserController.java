package com.app.ecom.controller;

import com.app.ecom.model.User;
import com.app.ecom.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor //Base url path for all handler methods
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    //    private List<User> userList = new ArrayList<>();

//    @GetMapping("/api/users")
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
//        return ResponseEntity.ok(userService.fetchAllUsers());
        return new ResponseEntity<>(userService.fetchAllUsers(), HttpStatus.OK);
    }


//    @GetMapping("/api/users/{id}")
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
//        User user = userService.fetchUser(id);
//        if (user == null)
//            return ResponseEntity.notFound    ().build();
//
//        return new ResponseEntity<>(user, HttpStatus.OK);

        return userService.fetchUser(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

//    @PostMapping("/api/users")
    @PostMapping
    public ResponseEntity<String>  createUsers(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<>("User created",HttpStatus.CREATED);
    }

//    @PutMapping("/api/users/{id}")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User updatedUser){
        boolean updated = userService.updateUser(id,updatedUser);
        if (updated)
            return ResponseEntity.ok("User updated successfully.");
        return ResponseEntity.notFound().build();
    }
}
