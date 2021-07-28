package com.siemens.logistics.common.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    private boolean isSuccess;
    private int code;
    private int subCode;
    private String subCodeDetail;
    private String timeStamp;
}
