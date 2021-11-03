package com.example.projetJee.domain;

import com.example.projetJee.util.OID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Fire implements Serializable {

    private OID _id;
    //@JsonProperty( "burnedsurface")
    private String burnedSurface = null;
    private String date = null;

    public ObjectId get_id() {
        return _id.$oid;
    }

    public Document getDocument() {
        Document document = new Document("_id", new ObjectId());
        document.append("burnedSurface", burnedSurface);
        document.append("date", date);
        return document;
    }

}
