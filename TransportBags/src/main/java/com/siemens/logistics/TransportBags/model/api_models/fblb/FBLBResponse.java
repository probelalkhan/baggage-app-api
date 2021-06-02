package com.siemens.logistics.TransportBags.model.api_models.fblb;

import com.siemens.logistics.common.models.BaseResponse;
import com.siemens.logistics.common.utils.DateTimeUtils;
import lombok.Data;

import java.util.Date;

@Data
public class FBLBResponse extends BaseResponse {
    private GetFBLBData data;
    public FBLBResponse(boolean isSuccess, int code, int subCode, String subCodeDetail, GetFBLBData data) {
        super(isSuccess, code, subCode, subCodeDetail, DateTimeUtils.getFormattedDate(new Date()));
        this.data = data;
    }
}
