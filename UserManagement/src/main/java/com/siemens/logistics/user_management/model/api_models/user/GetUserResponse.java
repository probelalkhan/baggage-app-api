package com.siemens.logistics.user_management.model.api_models.user;

import com.siemens.logistics.common.models.BaseResponse;
import com.siemens.logistics.common.utils.DateTimeUtils;
import com.siemens.logistics.user_management.model.v2.User;
import lombok.Data;

import java.util.Date;

@Data
public class GetUserResponse extends BaseResponse {
    private User data;

    public GetUserResponse(boolean isSuccess, int code, int subCode, String subCodeDetail, User data) {
        super(isSuccess, code, subCode, subCodeDetail, DateTimeUtils.getFormattedDate(new Date()));
        this.data = data;
    }
}
