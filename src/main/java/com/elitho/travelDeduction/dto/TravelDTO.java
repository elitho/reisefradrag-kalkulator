package com.elitho.travelDeduction.dto;

import com.elitho.travelDeduction.domain.Travel;

public class TravelDTO {

    private int km;
    private int antall;

    public TravelDTO() {
        // default
    }

    public Travel toDomain() {
        return new Travel(km, antall);
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getAntall() {
        return antall;
    }

    public void setAntall(int antall) {
        this.antall = antall;
    }
}
