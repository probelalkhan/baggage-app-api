package com.siemens.logistics.TransportBags.model.api_models.bags;

import com.siemens.logistics.TransportBags.model.table_models.BAG_BAGS;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetBagsData {
    private List<BAG_BAGS> bag_bagsList;
}
