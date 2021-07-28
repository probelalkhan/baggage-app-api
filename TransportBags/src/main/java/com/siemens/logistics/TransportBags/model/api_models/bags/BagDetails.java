package com.siemens.logistics.TransportBags.model.api_models.bags;

import lombok.Data;

import javax.persistence.Column;

@Data
public class BagDetails {

    private String bag_firstpostime;
    private String bag_lastpostime;
    private String plc_id;
    private String bag_gid;
    private Long first_location_id;
    private Long last_location_id;
    private String bag_status;
    private String bagtagid_1;
    private String bagtagid_2;
    private String bagtagid_3;
    private String hbs_level;
    private String hbs_result;
    private String transport_status;
    private String eventtime;
}
