package com.siemens.logistics.TransportBags.model.api_models.bsm;
import com.siemens.logistics.TransportBags.model.table_models.bsm;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class getBsmData {
    private List<bsm> bsmlist;
}
