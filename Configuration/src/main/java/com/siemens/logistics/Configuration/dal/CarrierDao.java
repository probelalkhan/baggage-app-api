package com.siemens.logistics.Configuration.dal;

import com.siemens.logistics.Configuration.model.table_models.carrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarrierDao extends JpaRepository<carrier, Long> {
    @Query("SELECT t FROM carrier t")
    List<carrier> findAll();
}
