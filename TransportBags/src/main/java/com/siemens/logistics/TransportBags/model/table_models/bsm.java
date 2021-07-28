package com.siemens.logistics.TransportBags.model.table_models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "bsm")
@NamedQuery(name = "bsm.findAll", query = "SELECT b FROM bsm b")
@Data
public class bsm {

    @Id
    @Column(name = "BAGTAGID")
    private String bagTagId;

    @Column(name = "BSM_ID")
    private String bsmId;

    @Column(name = "HBSDIRECTIVE")
    private String hbsDirective;

    @Column(name = "PASSENGERNAME")
    private String passengerName;

    @Column(name = "SDTD")
    private String sdtd;

    @Column(name = "EDTD")
    private String edtd;

    @Column(name = "SDDIN")
    private String sddIn;

    @Column(name = "SDDOUT")
    private String sddOut;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CLASS")
    private String ClassT;

    @Column(name = "BAGTYPE")
    private String bagType;

    @Column(name = "DESIGNATOR")
    private String designator;

    @Column(name = "AIRPORTCODE")
    private String airportCode;

    @Column(name = "LOADINGALLOWED")
    private String loadingAllowed;

    @Column(name = "RECEIVED")
    private String received;

    @Column(name = "EVENTTIME")
    private String eventTime;

    @Column(name = "CUSTIMAGEDEFAULT")
    private String custImageDefault;

}
