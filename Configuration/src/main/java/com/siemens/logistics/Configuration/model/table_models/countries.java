package com.siemens.logistics.Configuration.model.table_models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "VPR200_COUNTRYCODE")
@NamedQuery(name = "countries.findAll", query = "SELECT b FROM countries b")
@Data
public class countries {

    @Id
    @Column(name = "IATACODE")
    private String iataCode;

    @Column(name = "NAME")
    private String name;

    @Column(name = "HBSDEFAULTIN")
    private String hbsDefaultIn; //airportCode

    @Column(name = "HBSDEFAULTOUT")
    private String hbsDefaultOut;

    @Column(name = "CUSTDEFAULTIN")
    private String custDefaultIn;

    @Column(name = "CUSTDEFAULTOUT")
    private String custDefaultOut; //description

    @Column(name = "STATUS")
    private String status; //icaoDesignator

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "EVENTTIME")
    private String eventTime; //description

    @Column(name = "CUSTIMAGEDEFAULT")
    private String custImageDefault;

}
