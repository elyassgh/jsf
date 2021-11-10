package com.example.projetJee.bean;

import com.example.projetJee.domain.Forest;
import com.example.projetJee.domain.Zone;
import com.example.projetJee.service.ForestService;
import com.example.projetJee.util.StaticData;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
@Setter
public class ForestBean implements Serializable {

    @Inject
    private ForestService forestService;

    @Inject
    private UserBean userBean;

    @Inject
    private ZoneBean zoneSearchBean;

    private List<Forest> forests;

    private Forest selectedForest;
    private Zone selectedZone;

    @PostConstruct
    public void init() {
        this.forests = StaticData.getForests();
        // this.forests = this.forestService.findAll();
    }

    /*

    @PostUpdate
    public void reload() {
        this.forests = this.forestService.findAll();
    }

    */

    // Getters :

    public List<Forest> getForests() {
        if (forests == null) this.forests = new ArrayList<>();
        // this.forests = this.forestService.findAll();
        return forests;
    }

    public List<Zone> getZones() {
        return selectedForest.getZones();
    }

    public Zone getZone() {
        return this.selectedZone;
    }

    public Forest getForest() {
        if (selectedForest == null) this.selectedForest = new Forest();
        return selectedForest;
    }


    // Actions :

    public String toObservations(Forest forest, Zone zone) {
        this.selectedForest = forest;
        this.selectedZone = zone;
        zoneSearchBean.setZone(zone);
        zoneSearchBean.setObservations(zone.getObservations());
        return "/observation";
    }

    public String toFires(Forest forest, Zone zone) {
        this.selectedForest = forest;
        this.selectedZone = zone;
        return "/fire";
    }

}
