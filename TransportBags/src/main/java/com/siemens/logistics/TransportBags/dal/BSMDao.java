package com.siemens.logistics.TransportBags.dal;

import com.siemens.logistics.TransportBags.model.table_models.bsm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BSMDao extends JpaRepository<bsm, Long> {
    @Query("SELECT t FROM bsm t")
    List<bsm> findAll();
}
