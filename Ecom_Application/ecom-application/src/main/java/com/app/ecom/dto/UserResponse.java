package com.app.ecom.dto;

import com.app.ecom.model.UserRole;
import lombok.Data;

@Data
public class UserResponse {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private UserRole role;
    private AddressDTO address;
}
