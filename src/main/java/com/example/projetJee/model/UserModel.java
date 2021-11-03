package com.example.projetJee.model;

import com.example.projetJee.util.Model;

import java.util.Arrays;

public final class UserModel extends Model {

    private static UserModel instance;

    public static UserModel getInstance() {
        if( instance != null) instance = new UserModel();
        return instance;
    }

    public UserModel() {
        super("forecast", "users", Arrays.asList("username", "email", "password"));
    }

}
