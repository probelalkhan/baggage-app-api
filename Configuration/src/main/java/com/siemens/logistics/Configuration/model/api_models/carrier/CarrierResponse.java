package com.siemens.logistics.Configuration.model.api_models.carrier;

import com.siemens.logistics.common.models.BaseResponse;
import com.siemens.logistics.common.utils.DateTimeUtils;
import lombok.Data;

import java.util.Date;

@Data
public class CarrierResponse extends BaseResponse {
    private GetCarrierData data;
    public CarrierResponse(boolean isSuccess, int code, int subCode, String subCodeDetail, GetCarrierData data) {
        super(isSuccess, code, subCode, subCodeDetail, DateTimeUtils.getFormattedDate(new Date()));
        this.data = data;
    }
}
