package com.siemens.logistics.Configuration.model.table_models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "VPR010_CARRIERCODE")
@NamedQuery(name = "carrier.findAll", query = "SELECT b FROM carrier b")
@Data
public class carrier {
    @Id
    @Column(name = "IATACODE")
    private String iataCode;

    @Column(name = "IATANAME")
    private String iataName;

    @Column(name = "ICAONAME")
    private String icaoName;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "EVENTTIME")
    private String eventTime;

    @Column(name = "HBSDEFAULTIN")
    private String hbsDefaultIn;

    @Column(name = "HBSDEFAULTOUT")
    private String hbsDefaultOut;

    @Column(name = "CUSTDEFAULTIN")
    private String custDefaultIn;

    @Column(name = "CUSTDEFAULTOUT")
    private String custDefaultOut;

    @Column(name = "MESCARRIERPOS")
    private String mesCarrierPos;

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "ACO_IATACODE")
    private String acoIataCode;

    @Column(name = "AFT_ID")
    private String aftId;

    @Column(name = "AHA_IDOOG")
    private String ahaIdoog;
}
