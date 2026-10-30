package com.app.ecom.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity(name = "user_table") //name it in database as user_table
//@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //it will generate unique id whether it is passed on or not
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private UserRole role = UserRole.CUSTOMER;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true) // CascadeType.ALL -> propogating all CRUD operations, orphanRemoval-> delete address if user is not exists
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;




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
