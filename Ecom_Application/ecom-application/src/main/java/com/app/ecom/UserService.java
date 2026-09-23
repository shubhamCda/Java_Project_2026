package com.app.ecom;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> userList = new ArrayList<>();
    private Long nextId = 1L;

    public List<User> fetchAllUsers(){
        return userList;
    }

    public List<User> addUser(User user){
        user.setId(nextId++);
        userList.add(user);
        return userList;
    }

    public Optional<User> fetchUser(Long id) {
//        for (User user: userList){
//            if(user.getId() == id){
//                return user;
//            }
//        }
//        return null;
        return userList.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }
}
