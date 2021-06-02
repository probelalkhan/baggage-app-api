package com.siemens.logistics.TransportBags.model.api_models.bsm;

import com.siemens.logistics.TransportBags.model.api_models.bags.GetBagsData;
import com.siemens.logistics.common.models.BaseResponse;
import com.siemens.logistics.common.utils.DateTimeUtils;
import lombok.Data;

import java.util.Date;

@Data
public class BSMResponse extends BaseResponse {
    private getBsmData bsmData;
    private GetBagsData bagsData;

    public BSMResponse(boolean isSuccess, int code, int subCode, String subCodeDetail, getBsmData data) {
        super(isSuccess, code, subCode, subCodeDetail, DateTimeUtils.getFormattedDate(new Date()));
        this.bsmData = data;
    }

    public BSMResponse(boolean isSuccess, int code, int subCode, String subCodeDetail,GetBagsData  data) {
        super(isSuccess, code, subCode, subCodeDetail, DateTimeUtils.getFormattedDate(new Date()));
        this.bagsData = data;
    }
}
