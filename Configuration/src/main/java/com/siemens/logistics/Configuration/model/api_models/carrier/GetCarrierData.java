package com.siemens.logistics.Configuration.model.api_models.carrier;
import com.siemens.logistics.Configuration.model.table_models.carrier;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetCarrierData {
    private List<carrier> carriersList;
}
