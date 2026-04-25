package com.springboot.mongodb.dto;

import com.springboot.mongodb.entities.User;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String name;
    private String email;

    public UserDTO(){}

    public UserDTO(User obj) {
        id = obj.getId();
        email = obj.getEmail();
        name = obj.getName();
    }
}
