package com.hyc.aspect;

import com.hyc.domain.Result;
import com.hyc.exception.GirlException;
import com.hyc.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hyc26 on 2018-10-27.
 */
@ControllerAdvice
public class GirlHandler {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result handleException(Exception e) {
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.createFailResult(girlException.getCode(), girlException.getMessage());
        }
        return ResultUtil.createFailResult(0, e.getMessage());
    }

}
