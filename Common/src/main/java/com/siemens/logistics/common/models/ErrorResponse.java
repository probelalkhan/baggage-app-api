package com.siemens.logistics.common.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.siemens.logistics.common.utils.DateTimeUtils;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ErrorResponse {
    //true or false
    private boolean isSuccess;
    //Same as HTTP error code Eg. 400
    private int code;
    //Specific code of error. Eg. 1
    private int subCode;
    //Error name, Eg. token_expired
    private String subCodeDetail;
    //Error title to be shown to the user
    private String errorTitle;
    //Error description to be shown to the user
    private String errorDescription;
    //Timestamp of the request
    private String timeStamp;

    public ErrorResponse() {
        this.timeStamp = DateTimeUtils.getFormattedDate(new Date());
    }

    //Data if any
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<SubError> data;

    @Data
    private class SubError {
        private String errorCode;
        private String errorMessage;
    }
}
