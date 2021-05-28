package com.elitho.travelDeduction.dto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.elitho.travelDeduction.domain.TravelDeduction;

public class TravelDeductionDTO {
    private List<TravelDTO> arbeidsreiser;
    private List<TravelDTO> besoeksreiser;
    private double utgifterBomFergeEtc;

    public TravelDeductionDTO() {
        // default
    }

    public TravelDeduction toDomain() {
        return new TravelDeduction(
            Stream.ofNullable(arbeidsreiser)
                .flatMap(List::stream)
                .map(TravelDTO::toDomain)
                .collect(Collectors.toList()),
            Stream.ofNullable(besoeksreiser)
                .flatMap(List::stream)
                .map(TravelDTO::toDomain)
                .collect(Collectors.toList()),
            utgifterBomFergeEtc);
    }

    public List<TravelDTO> getArbeidsreiser() {
        return arbeidsreiser;
    }

    public void setArbeidsreiser(List<TravelDTO> arbeidsreiser) {
        this.arbeidsreiser = arbeidsreiser;
    }

    public List<TravelDTO> getBesoeksreiser() {
        return besoeksreiser;
    }

    public void setBesoeksreiser(List<TravelDTO> besoeksreiser) {
        this.besoeksreiser = besoeksreiser;
    }

    public double getUtgifterBomFergeEtc() {
        return utgifterBomFergeEtc;
    }

    public void setUtgifterBomFergeEtc(double utgifterBomFergeEtc) {
        this.utgifterBomFergeEtc = utgifterBomFergeEtc;
    }
}
