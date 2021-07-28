package com.siemens.logistics.TransportBags.dal;

import com.siemens.logistics.TransportBags.model.table_models.BAG_BAGS;
import com.siemens.logistics.TransportBags.model.table_models.SampleTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BagsDao extends JpaRepository<BAG_BAGS, Long> {
    @Query("SELECT t FROM BAG_BAGS t WHERE t.bagtagid_1= ?1 AND t.bag_firstpostime>=to_timestamp(?2,'dd-mm-yyyy hh24:mi:ss') AND t.bag_lastpostime<=to_timestamp(?3,'dd-mm-yyyy hh24:mi:ss')")
    List<BAG_BAGS> findByTaggid(String bagtagid_1,String start,String end);

    @Query("SELECT t FROM BAG_BAGS t WHERE t.bag_gid= ?1 AND t.bag_firstpostime>=to_timestamp(?2,'dd-mm-yyyy hh24:mi:ss') AND t.bag_lastpostime<=to_timestamp(?3,'dd-mm-yyyy hh24:mi:ss')")
    List<BAG_BAGS> findBygid(String gid,String start,String end);

    @Query("SELECT t FROM BAG_BAGS t WHERE t.bag_gid=?1 AND t.bag_firstpostime>=to_timestamp(?2,'dd-mm-yyyy hh24:mi:ss') AND t.bag_lastpostime<=to_timestamp(?3,'dd-mm-yyyy hh24:mi:ss')")
    List<BAG_BAGS> findAllByDates(String gid,String start, String end);

    @Query("SELECT t FROM BAG_BAGS t")
    List<BAG_BAGS> findAll();

    @Query("SELECT t FROM BAG_BAGS t WHERE bagtagid_1=?1 AND t.bag_firstpostime>=to_timestamp(?2,'dd-mm-yyyy hh24:mi:ss') AND t.bag_lastpostime<=to_timestamp(?3,'dd-mm-yyyy hh24:mi:ss')")
    List<BAG_BAGS> findByBaggidAndDates(String bagtagid,String start, String end);

    @Query("SELECT t FROM BAG_BAGS t WHERE bagtagid_1=?1 AND t.bag_gid=?2 AND t.bag_firstpostime>=to_timestamp(?3,'dd-mm-yyyy hh24:mi:ss') AND t.bag_lastpostime<=to_timestamp(?4,'dd-mm-yyyy hh24:mi:ss')")
    List<BAG_BAGS> findByBaggidAndDates(String tagid,String gid,String start, String end);

    @Query("SELECT t FROM BAG_BAGS t WHERE t.bag_firstpostime>=to_timestamp(?1,'dd-mm-yyyy hh24:mi:ss') AND t.bag_lastpostime<=to_timestamp(?2,'dd-mm-yyyy hh24:mi:ss')")
    List<BAG_BAGS> findByBaggidAndDates(String start, String end);


}
