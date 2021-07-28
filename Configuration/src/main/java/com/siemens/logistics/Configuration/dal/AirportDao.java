package com.siemens.logistics.Configuration.dal;

import com.siemens.logistics.Configuration.model.table_models.airports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AirportDao extends JpaRepository<airports, Long> {
    @Query("SELECT t FROM airports t")
    List<airports> findAll();
}
