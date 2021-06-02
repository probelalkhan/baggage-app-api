package com.siemens.logistics.user_management.model.api_models.user;

import com.siemens.logistics.common.models.BaseResponse;
import com.siemens.logistics.common.utils.DateTimeUtils;
import lombok.Data;

import java.util.Date;

@Data
public class GetAllUsersResponse extends BaseResponse {
    private GetAllUsersResponseData data;

    public GetAllUsersResponse(boolean isSuccess, int code, int subCode, String subCodeDetail, GetAllUsersResponseData data) {
        super(isSuccess, code, subCode, subCodeDetail, DateTimeUtils.getFormattedDate(new Date()));
        this.data = data;
    }
}
