package com.example.projetJee.util;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public final class MongoConnection {

    private static final String URI = "mongodb+srv://elyassgh:pOMU4X5cCV355LwR@mongocours.mazjj.mongodb.net/test?authSource=admin&replicaSet=atlas-n8zv4c-shard-0&readPreference=primary&appname=MongoDB%20Compass&ssl=true";
    private static MongoConnection instance;
    private MongoClient client;

    public MongoConnection(String uri) {
        try {
            this.client = MongoClients.create(uri);
            System.out.println("database connected successfully");
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public static MongoConnection getInstance() {
        if(instance == null ) instance = new MongoConnection(URI);
        return instance;
    }

    public MongoClient getClient() {
        return client;
    }

}
