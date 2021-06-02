package com.siemens.logistics.Configuration.dal;

import com.siemens.logistics.Configuration.model.table_models.countries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryDao extends JpaRepository<countries, Long> {
    @Query("SELECT t FROM countries t")
    List<countries> findAll();
}
