package com.siemens.logistics.Configuration.model.api_models.airport;

import com.siemens.logistics.Configuration.model.table_models.airports;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetAirportData {
    private List<airports> airportsList;
}
