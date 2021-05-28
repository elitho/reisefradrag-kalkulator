package com.elitho.travelDeduction.domain;

public class Travel {

    private int km;
    private int antall;

    public Travel() {
        // default
    }

    public Travel(int km, int antall) {
        this.km = km;
        this.antall = antall;
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
