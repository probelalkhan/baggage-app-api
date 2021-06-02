package com.siemens.logistics.flights.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class FlightAllocationModel {

    private  String id;
    private  String text;
    private  String start_date;
    private  String end_date;
    private  int duration;
    private  String type;
    private  String parent;

    //flight details
    private  String flightId;
    private  String carrier;
    private  String std;
    private  String etd;
}
