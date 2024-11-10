package com.raon.moduleapi.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.raon.modulecommon.enums.CodeEnum;
import lombok.*;

// 공통 규격 정의
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> {
    private String returnCode;
    private String returnMessage;
    private T info;

    public CommonResponse(CodeEnum codeEnum) {
        setReturnCode(codeEnum.getCode());
        setReturnMessage(codeEnum.getMessage());
    }

    public CommonResponse(T info) {
        this(CodeEnum.SUCCESS);
        setInfo(info);
    }

    public CommonResponse(CodeEnum codeEnum, T info) {
        this(codeEnum);
        setInfo(info);
    }
}
