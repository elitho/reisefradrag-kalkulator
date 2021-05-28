package com.elitho.travelDeduction.domain;

import java.util.List;

public class TravelDeduction {

    private List<Travel> arbeidsreiser;
    private List<Travel> besoeksreiser;
    private double utgifterBomFergeEtc;

    public TravelDeduction() {
        // default
    }

    public TravelDeduction(List<Travel> arbeidsreiser, List<Travel> besoeksreiser,
                           double utgifterBomFergeEtc) {
        this.arbeidsreiser = arbeidsreiser;
        this.besoeksreiser = besoeksreiser;
        this.utgifterBomFergeEtc = utgifterBomFergeEtc;
    }

    public List<Travel> getArbeidsreiser() {
        return arbeidsreiser;
    }

    public void setArbeidsreiser(List<Travel> arbeidsreiser) {
        this.arbeidsreiser = arbeidsreiser;
    }

    public List<Travel> getBesoeksreiser() {
        return besoeksreiser;
    }

    public void setBesoeksreiser(List<Travel> besoeksreiser) {
        this.besoeksreiser = besoeksreiser;
    }

    public double getUtgifterBomFergeEtc() {
        return utgifterBomFergeEtc;
    }

    public void setUtgifterBomFergeEtc(double utgifterBomFergeEtc) {
        this.utgifterBomFergeEtc = utgifterBomFergeEtc;
    }
}
