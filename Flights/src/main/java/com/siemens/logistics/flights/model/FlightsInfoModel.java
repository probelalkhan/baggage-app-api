package com.siemens.logistics.flights.model;

import lombok.*;

@Data
@AllArgsConstructor
public class FlightsInfoModel {

    private String carrier;
    private String flight;
    private String std;
    private String etd;
    private String atd;
    private String operationalStatus;
    private String destination;
    private String stopOvers;
    private String codeShares;
    private String flightRiskLevel;
    private String aircraftStand;
    private String terminal;
    private String handlingAgent;
    private String aircraftType;
    private String comment;
    private String lastModifiedBy;
    private String lastModifiedOn;

}
