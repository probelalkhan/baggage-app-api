package com.siemens.logistics.user_management.model.api_models.user;

import com.siemens.logistics.common.models.BaseResponse;
import com.siemens.logistics.common.utils.DateTimeUtils;
import lombok.Data;

import java.util.Date;

@Data
public class AddUserResponse extends BaseResponse {
    private AddUserResponseData data;

    public AddUserResponse(boolean isSuccess, int code, int subCode, String subCodeDetail, AddUserResponseData data) {
        super(isSuccess, code, subCode, subCodeDetail, DateTimeUtils.getFormattedDate(new Date()));
        this.data = data;
    }
}
