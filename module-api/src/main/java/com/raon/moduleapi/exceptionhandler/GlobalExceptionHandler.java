package com.raon.moduleapi.exceptionhandler;

import com.raon.moduleapi.exception.CustomException;
import com.raon.moduleapi.response.CommonResponse;
import com.raon.modulecommon.enums.CodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public CommonResponse handleCustomException(CustomException e) {
        return CommonResponse.builder()
                .returnCode(e.getReturnCode())
                .returnMessage(e.getReturnMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public CommonResponse handleException(Exception e) {
        return CommonResponse.builder()
                .returnCode(CodeEnum.UNKNOWN_ERROR.getCode())
                .returnMessage(CodeEnum.UNKNOWN_ERROR.getMessage())
                .build();
    }
}
