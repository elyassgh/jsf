package com.example.projetJee.bean;

import com.example.projetJee.domain.*;
import com.example.projetJee.service.ForestService;
import com.example.projetJee.util.StaticData;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class ForestBean implements Serializable {

    @Inject
    private ForestService forestService;

    private List<Forest> forests;

    private Forest selectedForest;
    private Zone selectedZone;
    private List<Observation> selectedObservations;
    private List<Fire> selectedFires;
    private Indices selectedIndices;

/*    @PostConstruct
    public void init() {
        this.forests = this.data.getForests();
    }*/

/*    @PostUpdate
    public void reload() {
        this.forests = this.forestService.findAll();
    }*/

    // Getters :

    public List<Forest> getForests() {
        if(forests == null) this.forests = new ArrayList<>();
        //this.forests = data.getForests();
        // this.forests = this.forestService.findAll();
        this.forests = StaticData.getForests();
        return forests;
    }

    public List<Observation> getObservations() {
        return selectedObservations;
    }

/*    public Zone getZone() {
        if (selectedZone == null) selectedZone = new Zone();
        return selectedZone;
    }

    public Forest getForest() {
        if (selectedForest != null) this.selectedForest = new Forest();
        return selectedForest;
    }*/


    // Actions :

    public String toObservations(Zone zone) {
        this.selectedObservations = zone.getObservations();
        return "/observation";
    }

    public String toFires(Zone zone) {
        this.selectedFires = zone.getFires();
        return "/fire";
    }

    public String toIndices(Observation observation) {
        this.selectedIndices = observation.getIndices();
        return "/indices";
    }
}
