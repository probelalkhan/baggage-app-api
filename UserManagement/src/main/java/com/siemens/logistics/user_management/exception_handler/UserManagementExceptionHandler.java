package com.siemens.logistics.user_management.exception_handler;

import com.siemens.logistics.common.exception.GenericException;
import com.siemens.logistics.common.models.ErrorResponse;
import com.siemens.logistics.common.utils.ErrorJsonParser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserManagementExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {GenericException.class})
    protected ResponseEntity<Object> handleGenericException(RuntimeException ex, WebRequest request) {

        GenericException exception = ((GenericException) ex);

        ErrorResponse responseBody = null;

        if (exception.getErrorBody() != null)
            responseBody = exception.getErrorBody();
        else {
            //IMPORTANT - CHANGE THE ERROR FILE NAME FOR EVERY MODULE
            responseBody = ErrorJsonParser.getErrorResponse("userManagementErrors", "en", exception.getCode(), exception.getSubCode());
        }

        try {
            logger.error("Caught generic exception with title: " + responseBody.getErrorTitle());
        } catch (Exception e) {
            logger.error("Caught generic exception!!");
        }
        logger.error("Error response returned for the request");

        return handleExceptionInternal(exception, responseBody,
                new HttpHeaders(), exception.getErrorCode(), request);
    }
}