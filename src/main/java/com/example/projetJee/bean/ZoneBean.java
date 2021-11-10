package com.example.projetJee.bean;

import com.example.projetJee.domain.Observation;
import com.example.projetJee.domain.Zone;
import com.example.projetJee.service.ForestService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
@Setter
public class ZoneBean implements Serializable {

    @Inject
    private ForestService forestService;

    private Zone zone;
    private List<Observation> observations;

    private ObjectId forestId;

    private String xIndex;
    private String yIndex;

    public String getxIndex() {
        if (zone.getXindex() != null) return zone.getXindex();
        return "";
    }

    public String getyIndex() {
        if (zone.getYindex() != null) return zone.getYindex();
        return "";
    }


    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }

    public Zone getZone() {
        if (zone == null) this.zone = new Zone();
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    // Actions :

    public String renderObservations() {
        // zone = findZoneInForestByIndices(forestId, xIndex, yIndex);
        return "/observation";
    }

    public String toIndices(Observation observation) {
        // indicesBean.selectedIndices = observation.getIndices();
        return "/indices";
    }
}
