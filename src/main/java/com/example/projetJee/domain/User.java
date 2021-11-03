package com.example.projetJee.domain;

import com.example.projetJee.util.OID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    private OID _id;
    private String username;
    private String email;
    private String password;

    public List<Object> getValues() {
        List<Object> values = new ArrayList<>();
        values.add(username);
        values.add(email);
        values.add(password);
        return values;
    }
}
