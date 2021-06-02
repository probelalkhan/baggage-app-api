package com.siemens.logistics.TransportBags.model.api_models.bags;

import com.siemens.logistics.common.models.BaseResponse;
import com.siemens.logistics.common.utils.DateTimeUtils;
import lombok.Data;

import java.util.Date;

@Data
public class BagsResponse extends BaseResponse {
    private GetBagsData data;
    public BagsResponse(boolean isSuccess, int code, int subCode, String subCodeDetail, GetBagsData data) {
        super(isSuccess, code, subCode, subCodeDetail, DateTimeUtils.getFormattedDate(new Date()));
        this.data = data;
    }
}
