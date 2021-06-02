package com.siemens.logistics.Configuration.services;

import com.siemens.logistics.Configuration.dal.CountryDao;
import com.siemens.logistics.Configuration.model.table_models.countries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryDao countryDao;

    public List<countries> getAllCountries() {
        List<countries> countryList = countryDao.findAll();

        return countryList;
    }
}
