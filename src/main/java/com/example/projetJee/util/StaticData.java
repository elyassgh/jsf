package com.example.projetJee.util;

import com.example.projetJee.domain.*;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@Data
public class StaticData {


    public static List<Forest> getForests() {

        List<Forest> forests = new ArrayList<>();

        Forest forest = new Forest(new OID(new ObjectId()), "forest name", "canada", "23.55", new ArrayList<>());

        List<Zone> zones = new ArrayList<>();

        List<Tree> trees = new ArrayList<>();
        trees.add(new Tree(new OID(new ObjectId()), "unknown", "12", "3", "yes", "0"));
        trees.add(new Tree(new OID(new ObjectId()), "specieX", null, "3", "yes", null));
        trees.add(new Tree(new OID(new ObjectId()), null, "12", null, null, "0"));
        trees.add(new Tree(new OID(new ObjectId()), "specieY", "12", "5", null, "0"));
        trees.add(new Tree(new OID(new ObjectId()), null, null, "15", null, null));

        List<Observation> observations = new ArrayList<>();
        observations.add(new Observation(new OID(new ObjectId()), "53", "23", "32", "50", "2021-11-01",new Indices(new OID(new ObjectId()), "20" ,"34", "12" , "69")));
        observations.add(new Observation(new OID(new ObjectId()), "15", "11", "19", "23", "2021-11-02",new Indices(new OID(new ObjectId()), "20" ,"34", "12" , "69")));
        observations.add(new Observation(new OID(new ObjectId()), "90", "43", "32", "11", "2021-11-03",new Indices(new OID(new ObjectId()), "20" ,"34", "12" , "69")));
        observations.add(new Observation(new OID(new ObjectId()), "32", "15", "34", "32", "2021-11-04",new Indices(new OID(new ObjectId()), "20" ,"34", "12" , "69")));

        List<Fire> fires = new ArrayList<>();
        fires.add(new Fire(new OID(new ObjectId()), "0", "2021-11-01"));
        fires.add(new Fire(new OID(new ObjectId()), "0", "2021-11-02"));
        fires.add(new Fire(new OID(new ObjectId()), "5", "2021-11-03"));
        fires.add(new Fire(new OID(new ObjectId()), "12", "2021-11-04"));


        zones.add(new Zone(new OID(new ObjectId()),"A", "0", "15", trees, observations, fires));
        zones.add(new Zone(new OID(new ObjectId()),"A", "1", "30", trees, observations, null));

        forest.setZones(zones);

        forests.add(forest);

        return forests;

    }
}
