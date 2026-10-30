package com.app.ecom;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private List<User> userList = new ArrayList<>();
//    private Long nextId = 1L;

//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    } //RequiredArgsConstructor will replace this

//    public List<User> fetchAllUsers(){
//        return userList;
//    }
    public List<User> fetchAllUsers(){
        return userRepository.findAll(); //using JPA repository
    }

//    public List<User> addUser(User user){
//        user.setId(nextId++);
//        userList.add(user);
//        return userList;
//    }
    public void addUser(User user){
//        user.setId(nextId++);
        userRepository.save(user); //using JPA

    }

    public Optional<User> fetchUser(Long id) {
//        for (User user: userList){
//            if(user.getId() == id){
//                return user;
//            }
//        }
//        return null;
//        return userList.stream()
//                .filter(user -> user.getId() == id)
//                .findFirst();
        return userRepository.findById(id); //using JPA
    }

    public boolean updateUser(Long id, User updatedUser){
//        return userList.stream()
//                .filter(user -> user.getId() == id)
//                .findFirst()
//                .map(existingUser ->{
//                    existingUser.setFirstName(updatedUser.getFirstName());
//                    existingUser.setLastName((updatedUser.getLastName()));
//                    return true;
//                })
//                .orElse(false);

        return userRepository.findById(id)
                .map(existingUser ->{
                    existingUser.setFirstName(updatedUser.getFirstName());
                    existingUser.setLastName((updatedUser.getLastName()));
                    userRepository.save(existingUser);
                    return true;
                })
                .orElse(false);
    }
}
