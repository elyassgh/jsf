package com.example.projetJee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.example.projetJee.util.OID;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Zone implements Serializable {

    private OID _id;
    private String xindex = null;
    private String yindex = null;
    private String surface = null;
    private List<Tree> trees = null;
    private List<Observation> observations = null;
    private List<Fire> fires = null;

    public ObjectId get_id() {
        return _id.$oid;
    }

    public Document getDocument() {
        Document document = new Document("_id", new ObjectId());
        document.append("xindex", xindex);
        document.append("yindex", yindex);
        document.append("surface", surface);
        List<Document> treesDocuments = null;
        if (trees != null) treesDocuments = trees.stream().map(Tree::getDocument).collect(Collectors.toList());
        document.append("trees", treesDocuments);
        List<Document> observationsDocuments = null;
        if (observations != null)
            observationsDocuments = observations.stream().map(Observation::getDocument).collect(Collectors.toList());
        document.append("observations", observationsDocuments);
        List<Document> firesDocuments = null;
        if (fires != null) firesDocuments = fires.stream().map(Fire::getDocument).collect(Collectors.toList());
        document.append("fires", firesDocuments);
        return document;
    }

}
