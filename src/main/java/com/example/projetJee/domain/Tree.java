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
public class Tree implements Serializable {

    private OID _id;
    private String specie = null;
    private String length = null;
    private String age = null;
    private String branches = null;
    private String diameter = null;

    public ObjectId get_id() {
        return _id.$oid;
    }

    public Document getDocument() {
        Document document = new Document("_id", new ObjectId());
        if(specie != null) document.append("specie", specie);
        if(length != null) document.append("length", length);
        if(age != null) document.append("age", age);
        if(branches != null) document.append("branches", branches);
        if(diameter != null) document.append("diameter", diameter);
        return document;
    }


}
