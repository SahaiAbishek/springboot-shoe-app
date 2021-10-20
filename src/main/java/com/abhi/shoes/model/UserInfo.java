package com.abhi.shoes.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="user_info")
@Data
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public UserInfo(){}

    public UserInfo(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName  = lastName;
        this.email     = email;
    }
}
