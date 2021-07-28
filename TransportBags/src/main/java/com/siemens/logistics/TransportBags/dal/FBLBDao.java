package com.siemens.logistics.TransportBags.dal;

import com.siemens.logistics.TransportBags.model.table_models.FBLB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FBLBDao extends JpaRepository<FBLB, Long> {
    @Query("SELECT t FROM FBLB t")
    List<FBLB> findAll();
}
