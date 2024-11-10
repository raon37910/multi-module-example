package com.raon.moduleapi.service;

import com.raon.moduleapi.exception.CustomException;
import com.raon.modulecommon.enums.CodeEnum;
import com.raon.modulecommon.service.CommonDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final CommonDemoService commonDemoService;

    public String save() {
        System.out.println(CodeEnum.SUCCESS.getCode());
        System.out.println(commonDemoService.commonService());
        return "save";
    }

    public String find() {
        return "find";
    }

    public String exception() {
        if(true)
            throw new CustomException(CodeEnum.UNKNOWN_ERROR);
        return "exception";
    }
}
