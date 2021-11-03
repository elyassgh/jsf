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
public class Indices implements Serializable {

    private OID _id;
    private String ffmc = null;
    private String dmc = null;
    private String dc = null;
    private String isi = null;

    public ObjectId get_id() {
        return _id.$oid;
    }

    public Document getDocument() {
        Document document = new Document("_id", new ObjectId());
        document.append("ffmc", ffmc);
        document.append("dmc", dmc);
        document.append("dc", dc);
        document.append("isi", isi);
        return document;
    }
}
