package com.siemens.logistics.Configuration.model.api_models.airport;

import com.siemens.logistics.common.models.BaseResponse;
import com.siemens.logistics.common.utils.DateTimeUtils;
import lombok.Data;

import java.util.Date;

@Data
public class AirportResponse extends BaseResponse {
    private GetAirportData data;
    public AirportResponse(boolean isSuccess, int code, int subCode, String subCodeDetail, GetAirportData data) {
        super(isSuccess, code, subCode, subCodeDetail, DateTimeUtils.getFormattedDate(new Date()));
        this.data = data;
    }
}
