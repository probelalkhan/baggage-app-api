package com.siemens.logistics.TransportBags.model.api_models.fblb;

import lombok.Data;

import javax.persistence.Column;

@Data
public class FBLBDetails {
    private String FLIGHT;
    private String FIRST_BAG_RECLAIM_CAROUSEL;
    private String FIRSTBAGTIME;
    private String LAST_BAG_RECLAIM_CAROUSEL;
    private String STA;
    private String LASTBAGTIME;
    private String DURATION;
}
