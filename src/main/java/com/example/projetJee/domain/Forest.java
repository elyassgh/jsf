package com.example.projetJee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.example.projetJee.util.OID;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Forest implements Serializable {

    private OID _id = null;
    private String name = null;
    private String location = null;
    private String surface = null;
    private List<Zone> zones = null;

    public ObjectId get_id() {
        return _id.$oid;
    }

    public List<Object> getValues() {
        List<Object> values = new ArrayList<>();
        values.add(name);
        values.add(location);
        values.add(surface);
        List<Document> zonesDocuments = zones.stream().map(Zone::getDocument).collect(Collectors.toList());
        values.add(zonesDocuments);
        return values;
    }

}
