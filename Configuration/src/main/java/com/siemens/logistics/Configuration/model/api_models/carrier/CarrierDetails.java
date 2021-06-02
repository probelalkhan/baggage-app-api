package com.siemens.logistics.Configuration.model.api_models.carrier;

import lombok.Data;

import javax.persistence.Column;

@Data
public class CarrierDetails {
    private String iataCode;
    private String iataName;
    private String icaoName;
    private String name;
    private String status;
    private String eventTime;
    private String hbsDefaultIn;
    private String hbsDefaultOut;
    private String custDefaultIn;
    private String custDefaultOut;
    private String mesCarrierPos;
    private String descr;
    private String acoIataCode;
    private String aftId;
    private String ahaIdoog;
}
