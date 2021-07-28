package com.siemens.logistics.TransportBags.services;

import com.siemens.logistics.TransportBags.dal.BSMDao;
import com.siemens.logistics.TransportBags.dal.FBLBDao;
import com.siemens.logistics.TransportBags.model.table_models.bsm;
import com.siemens.logistics.TransportBags.model.table_models.FBLB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FBLBService {
    @Autowired
    FBLBDao fblbDao;

    @Autowired
    BSMDao bsmDao;

    public List<FBLB> getALLFBLB(){
        List<FBLB> fblbList=fblbDao.findAll();
        return fblbList;
    }

    public List<bsm> getALLBSM(){
        List<bsm> bsmList=bsmDao.findAll();
        return bsmList;
    }
}