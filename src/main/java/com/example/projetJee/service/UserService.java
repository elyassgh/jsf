package com.example.projetJee.service;

import com.example.projetJee.domain.User;
import com.example.projetJee.model.UserModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ejb.Stateless;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class UserService {

    UserModel model = UserModel.getInstance();
    ObjectMapper objectMapper = new ObjectMapper();

    public User save(User user) throws JsonProcessingException {
        return objectMapper.readValue(this.model.create(user.getValues()), User.class);
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        this.model.findAll().forEach(user -> {
            try {
                users.add(objectMapper.readValue(user, User.class));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        return users;
    }

    public User findById(ObjectId id) throws JsonProcessingException {
        return objectMapper.readValue(this.model.findById(id), User.class);
    }

    public User findByAttribute(String attribute, String value) throws JsonProcessingException {
        return objectMapper.readValue(this.model.findByAttribute(attribute, value), User.class);
    }

    public User update(ObjectId id, User user) throws JsonProcessingException {
        return objectMapper.readValue(this.model.update(id, user.getValues()), User.class);
    }

    public User delete(ObjectId id) throws JsonProcessingException {
        return objectMapper.readValue(this.model.delete(id), User.class);
    }


}
