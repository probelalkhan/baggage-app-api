package com.siemens.logistics.TransportBags.model.table_models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "SAMPLETABLE")
@NamedQuery(name = "SampleTable.findAll", query = "SELECT b FROM SampleTable b")
@Data
public class SampleTable {

    @Id
    @Column(name = "BAGID")
    private Long bagid;

    @Column(name = "STARTDATE")
    private String startdate;

    @Column(name = "DETAILS")
    private String details;
}
