package com.elitho.travelDeduction.dto;

public class TravelDeductionResponseDTO {
    private double reisefradrag;

    public TravelDeductionResponseDTO() {
        // default
    }

    public TravelDeductionResponseDTO(double reisefradrag) {
        this.reisefradrag = reisefradrag;
    }

    public double getReisefradrag() {
        return reisefradrag;
    }

    public void setReisefradrag(double reisefradrag) {
        this.reisefradrag = reisefradrag;
    }
}
