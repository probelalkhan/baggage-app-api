package com.siemens.logistics.TransportBags.model.table_models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "FBLB")
@NamedQuery(name = "FBLB.findAll", query = "SELECT b FROM FBLB b")
@Data
public class FBLB {

    @Id
    @Column(name = "FLIGHT")
    private String FLIGHT;

    @Column(name = "FIRST_BAG_RECLAIM_CAROUSEL")
    private String FIRST_BAG_RECLAIM_CAROUSEL;

    @Column(name = "FIRSTBAGTIME")
    private String FIRSTBAGTIME;

    @Column(name = "LAST_BAG_RECLAIM_CAROUSEL")
    private String LAST_BAG_RECLAIM_CAROUSEL;

    @Column(name = "LASTBAGTIME")
    private String LASTBAGTIME;

    @Column(name = "STA")
    private String STA;

    @Column(name = "DURATION")
    private String DURATION;
}
