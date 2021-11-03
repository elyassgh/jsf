package com.example.projetJee.model;


import com.example.projetJee.util.Model;

import java.util.Arrays;

public final class ForestModel extends Model {

    private static ForestModel instance;

    public static ForestModel getInstance() {
        if (instance == null) instance = new ForestModel();
        return instance;
    }

    public ForestModel() {
        super("forecast", "forest", Arrays.asList("name", "location", "surface", "zones"));
    }
}
