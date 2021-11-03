package com.example.projetJee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.example.projetJee.util.OID;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Observation implements Serializable {

    private OID _id;
    private String humidity = null;
    private String temperature = null;
    private String windSpeed = null;
    private String rain = null;
    private String date = null;
    private Indices indices = null;

    public ObjectId get_id() {
        return _id.$oid;
    }

    public Document getDocument() {
        Document document = new Document("_id", new ObjectId());
        document.append("humidity", humidity);
        document.append("temperature", temperature);
        document.append("windSpeed", windSpeed);
        document.append("rain", rain);
        document.append("date", date);
        document.append("indices", indices.getDocument());
        return document;
    }
}
