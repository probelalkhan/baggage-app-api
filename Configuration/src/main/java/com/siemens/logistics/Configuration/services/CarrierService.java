package com.siemens.logistics.Configuration.services;

import com.siemens.logistics.Configuration.dal.CarrierDao;
import com.siemens.logistics.Configuration.model.table_models.carrier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrierService {
    @Autowired
    CarrierDao carrierDao;

    public List<carrier> getAllCarriers() {
        List<carrier> carrierList = carrierDao.findAll();

        return carrierList;
    }
}
