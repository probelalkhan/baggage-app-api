package com.siemens.logistics.Configuration.model.api_models.country;

import lombok.Data;
import javax.persistence.Column;

@Data
public class CountryDetails {

    private String iataCode;
    private String name;
    private String hbsDefaultIn;
    private String hbsDefaultOut;
    private String custDefaultIn;
    private String custDefaultOut;
    private String status;
    private String descr;
    private String eventTime;
    private String custImageDefault;
}
