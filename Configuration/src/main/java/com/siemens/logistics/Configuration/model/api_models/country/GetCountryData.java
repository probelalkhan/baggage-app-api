package com.siemens.logistics.Configuration.model.api_models.country;

import com.siemens.logistics.Configuration.model.table_models.countries;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetCountryData {
    private List<countries> countryList;
}
