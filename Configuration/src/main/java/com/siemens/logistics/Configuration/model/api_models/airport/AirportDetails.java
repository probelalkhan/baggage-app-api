package com.siemens.logistics.Configuration.model.api_models.airport;

import lombok.Data;

import javax.persistence.Column;

@Data
public class AirportDetails {

    private String airportCode;
    private String acoIataCode;
    private String name;
    private String iataCode;
    private String ishome;
    private String hbsDefaultIn;
    private String hbsDefaultOut;
    private String custDefaultIn;
    private String custDefaultOut;
    private String status;
    private String descr;
    private String eventTime;
}
