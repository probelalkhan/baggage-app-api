package com.siemens.logistics.Configuration.model.api_models.country;
import com.siemens.logistics.common.models.BaseResponse;
import com.siemens.logistics.common.utils.DateTimeUtils;
import lombok.Data;

import java.util.Date;
@Data
public class CountryResponse extends BaseResponse{
    private GetCountryData data;
    public CountryResponse(boolean isSuccess, int code, int subCode, String subCodeDetail, GetCountryData data) {
        super(isSuccess, code, subCode, subCodeDetail, DateTimeUtils.getFormattedDate(new Date()));
        this.data = data;
    }
}
