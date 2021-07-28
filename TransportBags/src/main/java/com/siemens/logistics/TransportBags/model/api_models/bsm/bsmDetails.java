package com.siemens.logistics.TransportBags.model.api_models.bsm;

import lombok.Data;

import javax.persistence.Column;


@Data
public class bsmDetails {
    private String bagTagId;
    private String bsmId;
    private String hbsDirective;
    private String passengerName;
    private String sdtd;
    private String edtd;
    private String sddIn;
    private String sddOut;
    private String status;
    private String ClassT;
    private String bagType;
    private String designator;
    private String airportCode;
    private String loadingAllowed;
    private String received;
    private String eventTime;
    private String custImageDefault;
}
