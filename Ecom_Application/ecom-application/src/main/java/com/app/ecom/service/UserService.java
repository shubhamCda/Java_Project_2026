package com.app.ecom.service;

import com.app.ecom.dto.AddressDTO;
import com.app.ecom.dto.UserRequest;
import com.app.ecom.dto.UserResponse;
import com.app.ecom.model.Address;
import com.app.ecom.model.User;
import com.app.ecom.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<UserResponse> fetchAllUsers(){

        return userRepository.findAll().stream()
                .map(this::mapToUserResponse)
                .collect(Collectors.toList());

//        return userRepository.findAll(); //using JPA repository
    }

//    public List<User> addUser(User user){
//        user.setId(nextId++);
//        userList.add(user);
//        return userList;
//    }
    public void addUser(UserRequest userRequest){
//        user.setId(nextId++);
        User user = new User();
        updateUserFromRequest(user, userRequest);
        userRepository.save(user); //using JPA

    }

    public Optional<UserResponse> fetchUser(Long id) {

        return userRepository.findById(id)
                .map(this::mapToUserResponse);

//        for (User user: userList){
//            if(user.getId() == id){
//                return user;
//            }
//        }
//        return null;
//        return userList.stream()
//                .filter(user -> user.getId() == id)
//                .findFirst();
//        return userRepository.findById(id); //using JPA
    }

    public boolean updateUser(Long id, UserRequest updatedUserRequest){
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
                    updateUserFromRequest(existingUser, updatedUserRequest);
                    userRepository.save(existingUser);
                    return true;
                })
                .orElse(false);


    }

    private void updateUserFromRequest(User user, UserRequest userRequest){
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());

        if (userRequest.getAddress() != null){
            Address address = new Address();
            address.setStreet(userRequest.getAddress().getStreet());
            address.setCity(userRequest.getAddress().getCity());
            address.setState(userRequest.getAddress().getState());
            address.setCountry(userRequest.getAddress().getCountry());
            address.setZipcode(userRequest.getAddress().getZipcode());
        }
    }
    private UserResponse mapToUserResponse(User user){

        UserResponse response = new UserResponse();
        response.setId(String.valueOf(user.getId()));
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setRole(user.getRole());

        if (user.getAddress() != null){
            AddressDTO addressDTO = new AddressDTO();
            addressDTO.setStreet(user.getAddress().getStreet());
            addressDTO.setCity(user.getAddress().getCity());
            addressDTO.setState(user.getAddress().getState());
            addressDTO.setZipcode(user.getAddress().getZipcode());

            response.setAddress(addressDTO);
        }
        return response;
    }
}
