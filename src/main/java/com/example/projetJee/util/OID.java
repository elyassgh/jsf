package com.example.projetJee.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;

public class OID {
    @JsonProperty
    @JsonSerialize(using = ObjectIdJsonSerializer.class)
    public ObjectId $oid;

    public ObjectId getId() {
        return $oid;
    }

    public OID(ObjectId $oid) {
        this.$oid = $oid;
    }
}
