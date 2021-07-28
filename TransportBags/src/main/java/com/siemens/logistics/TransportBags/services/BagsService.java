package com.siemens.logistics.TransportBags.services;

import com.siemens.logistics.TransportBags.dal.BagsDao;
import com.siemens.logistics.TransportBags.model.api_models.bags.BagDetails;
import com.siemens.logistics.TransportBags.model.table_models.BAG_BAGS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BagsService {
    @Autowired
    BagsDao bagsDao;


    public List<BAG_BAGS> getAllBags() {
        List<BAG_BAGS> bagsList = bagsDao.findAll();

        return bagsList;
    }


    public List<BAG_BAGS> getBagsbybagidAndDates(String tagid,String gid, String start,String end) {
        List<BAG_BAGS> bagsList;
        if(gid.compareTo("null")==0 && tagid.compareTo("null")==0)
            bagsList = bagsDao.findByBaggidAndDates(start,end);
        else{
            if(gid.compareTo("null")!=0 && tagid.compareTo("null")==0)
                bagsList = bagsDao.findAllByDates(gid,start,end);
            else if(gid.compareTo("null")==0 && tagid.compareTo("null")!=0)
                bagsList = bagsDao.findByBaggidAndDates(tagid,start,end);
            else
                bagsList = bagsDao.findByBaggidAndDates(tagid,gid,start,end);
        }
        return bagsList;
    }

    public List<BAG_BAGS> getBagsbybagid(String tagid,String bagid, String start, String end) {
        List<BAG_BAGS> bagsList;
        if(tagid.compareTo("null")==0)
            bagsList = bagsDao.findBygid(bagid,start,end);
        else
            bagsList = bagsDao.findByTaggid(tagid,start,end);
        return bagsList;
    }

    private BagDetails convertUserTableToDetails(BAG_BAGS bag_bags){
        BagDetails details = new BagDetails();
        details.setBag_gid(bag_bags.getBag_gid());
        details.setBag_firstpostime(bag_bags.getBag_firstpostime());
        details.setBag_lastpostime(bag_bags.getBag_lastpostime());
        details.setBag_status(bag_bags.getBag_status());
        details.setBagtagid_1(bag_bags.getBagtagid_1());

        details.setBagtagid_2(bag_bags.getBagtagid_2());
        details.setBagtagid_3(bag_bags.getBagtagid_3());
        details.setEventtime(bag_bags.getEventtime());
        details.setHbs_level(bag_bags.getHbs_level());
        details.setHbs_result(bag_bags.getHbs_result());

        details.setFirst_location_id(bag_bags.getFirst_location_id());
        details.setLast_location_id(bag_bags.getLast_location_id());
        details.setPlc_id(bag_bags.getPlc_id());
        details.setTransport_status(bag_bags.getTransport_status());

        return details;
    }
}
