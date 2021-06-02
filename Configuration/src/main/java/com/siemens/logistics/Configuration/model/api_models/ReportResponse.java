package com.siemens.logistics.Configuration.model.api_models;

import com.siemens.logistics.common.models.BaseResponse;
import com.siemens.logistics.common.utils.DateTimeUtils;
import lombok.Data;

import java.util.Date;


@Data
public class ReportResponse extends BaseResponse {
    private String data;
    public ReportResponse(boolean isSuccess, int code, int subCode, String subCodeDetail, String data) {
        super(isSuccess, code, subCode, subCodeDetail, DateTimeUtils.getFormattedDate(new Date()));
        this.data = data;
    }
}