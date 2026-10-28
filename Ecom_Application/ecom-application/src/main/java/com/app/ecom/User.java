package com.app.ecom;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
//@Entity(name = "user_table")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //it will generate unique id whether it is passed on or not
    private long id;
    private String firstName;
    private String lastName;

    //default constructor is needed to create instances of entity class during the retrieval of data from the database w/o this JPA won't able to create or instantiate any instances
//    public User() {
//    }
//
//    public User(long id, String firstName, String lastName) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
}
