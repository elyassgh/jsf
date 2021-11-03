package com.example.projetJee.util;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private final String dbName;
    private final String collectionName;
    public List<String> attributes;

    MongoConnection connection = MongoConnection.getInstance();
    MongoClient mongoClient = connection.getClient();

    public Model(String dbName, String collectionName, List<String> attributes) {
        this.dbName = dbName;
        this.collectionName = collectionName;
        this.attributes = attributes;
    }

    public String create(List<Object> values) {
        ObjectId id = new ObjectId();
        Document document = new Document("_id", id);
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) == null) continue;
            document.append(attributes.get(i), values.get(i));
        }
        mongoClient.getDatabase(dbName).getCollection(collectionName).insertOne(document);
        return findById(id);
    }

    public String findByAttribute(String attribute, String value) {
        return mongoClient.getDatabase(dbName).getCollection(collectionName)
                .find(Filters.eq(attribute, value)).first().toJson();
    }

    public String findById(ObjectId id) {
        return mongoClient.getDatabase(dbName).getCollection(collectionName)
                .find(Filters.eq("_id", id)).first().toJson();
    }

    public List<String> findAll() {
        List<String> result = new ArrayList<>();
        FindIterable<Document> iterDoc = mongoClient.getDatabase(dbName).getCollection(collectionName).find();
        for (Document document : iterDoc) {
            result.add(document.toJson());
        }
        return result;
    }

    public String update(ObjectId id, List<Object> values) {

        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) == null) continue;
            mongoClient.getDatabase(dbName).getCollection(collectionName)
                    .updateOne(Filters.eq("_id", id), Updates.set(attributes.get(i), values.get(i)));
        }

        return findById(id);
    }

    public String delete(ObjectId id) {
        return mongoClient.getDatabase(dbName).getCollection(collectionName)
                .findOneAndDelete(Filters.eq("_id", id)).toJson();
    }


}
