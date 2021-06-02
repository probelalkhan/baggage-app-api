package com.siemens.logistics.user_management.model.api_models.user;

import com.siemens.logistics.common.models.BaseResponse;
import com.siemens.logistics.common.utils.DateTimeUtils;
import lombok.Data;

import java.util.Date;

@Data
public class GetUserResponse extends BaseResponse {
    private UserModel data;

    public GetUserResponse(boolean isSuccess, int code, int subCode, String subCodeDetail, UserModel data) {
        super(isSuccess, code, subCode, subCodeDetail, DateTimeUtils.getFormattedDate(new Date()));
        this.data = data;
    }
}
