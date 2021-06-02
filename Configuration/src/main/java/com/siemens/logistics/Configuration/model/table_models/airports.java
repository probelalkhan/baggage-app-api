package com.siemens.logistics.Configuration.model.table_models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "VPR030_AIRPORTDATA")
@NamedQuery(name = "airports.findAll", query = "SELECT b FROM airports b")
@Data
public class airports {

    @Id
    @Column(name = "AIRPORTCODE")
    private String airportCode;

    @Column(name = "ACO_IATACODE")
    private String acoIataCode;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IATACODE")
    private String iataCode;

    @Column(name = "ISHOME")
    private String ishome; //is home

    @Column(name = "HBSDEFAULTIN")
    private String hbsDefaultIn;

    @Column(name = "HBSDEFAULTOUT")
    private String hbsDefaultOut;

    @Column(name = "CUSTDEFAULTIN")
    private String custDefaultIn;

    @Column(name = "CUSTDEFAULTOUT")
    private String custDefaultOut;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "EVENTTIME")
    private String eventTime;

    @Column(name = "DESCR")
    private String descr; //description
}
