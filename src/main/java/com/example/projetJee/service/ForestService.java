package com.example.projetJee.service;


import com.example.projetJee.domain.Forest;
import com.example.projetJee.model.ForestModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public final class ForestService {

    private static ForestService instance;

    public static ForestService getInstance() {
        if (instance == null) instance = new ForestService();
        return instance;
    }

    private ForestService() {
    }

    ForestModel model = ForestModel.getInstance();
    ObjectMapper objectMapper = new ObjectMapper();

    public Forest save(Forest forest) throws JsonProcessingException {
        return objectMapper.readValue(model.create(forest.getValues()), Forest.class);
    }

    public List<Forest> findAll() {
        System.out.println("findAll invoked");
        List<Forest> forests = new ArrayList<>();
        model.findAll().forEach(forest -> {
            try {
                forests.add(objectMapper.readValue(forest, Forest.class));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        return forests;
    }

    public Forest findById(ObjectId id) throws JsonProcessingException {
        return objectMapper.readValue(model.findById(id), Forest.class);
    }

    public Forest update(ObjectId id, Forest forest) throws JsonProcessingException {
        return objectMapper.readValue(model.update(id, forest.getValues()), Forest.class);
    }

    public Forest delete(ObjectId id) throws JsonProcessingException {
        return objectMapper.readValue(model.delete(id), Forest.class);
    }

}

