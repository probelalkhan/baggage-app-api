package com.siemens.logistics.TransportBags.model.api_models.fblb;

import com.siemens.logistics.TransportBags.model.table_models.FBLB;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetFBLBData {
    private List<FBLB> fblbList;
}
