package com.siemens.logistics.TransportBags.model.table_models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "BAG_BAGS")
@NamedQuery(name = "BAG_BAGS.findAll", query = "SELECT b FROM BAG_BAGS b")
@Data
public class BAG_BAGS {
    @Id
    @Column(name = "BAG_FIRSTPOSTIME")
    private String bag_firstpostime;

    @Column(name = "BAG_LASTPOSTIME")
    private String bag_lastpostime;

    @Column(name = "PLC_ID")
    private String plc_id;

    @Column(name = "BAG_GID")
    private String bag_gid;

    @Column(name = "FIRST_LOCATION_ID")
    private Long first_location_id;

    @Column(name = "LAST_LOCATION_ID")
    private Long last_location_id;

    @Column(name = "BAG_STATUS")
    private String bag_status;

    @Column(name = "BAGTAGID_1")
    private String bagtagid_1;

    @Column(name = "BAGTAGID_2")
    private String bagtagid_2;

    @Column(name = "BAGTAGID_3")
    private String bagtagid_3;

    @Column(name = "HBS_LEVEL")
    private String hbs_level;

    @Column(name = "HBS_RESULT")
    private String hbs_result;

    @Column(name = "TRANSPORT_STATUS")
    private String transport_status;

    @Column(name = "EVENTTIME")
    private String eventtime;
}
