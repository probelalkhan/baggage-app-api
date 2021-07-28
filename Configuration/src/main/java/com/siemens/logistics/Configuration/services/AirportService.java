package com.siemens.logistics.Configuration.services;

import com.siemens.logistics.Configuration.dal.AirportDao;
import com.siemens.logistics.Configuration.model.table_models.airports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    @Autowired
    AirportDao airportDao;

    public List<airports> getAllAirports() {
        List<airports> airportsList = airportDao.findAll();
        System.out.println("From service "+airportDao.findAll());

        return airportsList;
    }
}

