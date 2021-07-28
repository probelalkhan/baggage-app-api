package com.siemens.logistics.TransportBags.dal;

import com.siemens.logistics.TransportBags.model.table_models.SampleTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SampleDao extends JpaRepository<SampleTable, Long> {
    @Query("SELECT t FROM SampleTable t WHERE t.bagid= ?1 AND t.startdate= ?2")
    List<SampleTable> findByBagid(long bagid, String startdate);

    @Query("SELECT t.bagid FROM SampleTable t ")
    List<Long> findAllByBagid();

    @Query("SELECT t FROM SampleTable t WHERE t.bagid= ?1 ")
    List<SampleTable> findByBagid(long bagid);


}
