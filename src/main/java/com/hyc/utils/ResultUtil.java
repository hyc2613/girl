package com.hyc.utils;

import com.hyc.domain.Result;

/**
 * Created by hyc26 on 2018-10-27.
 */
public class ResultUtil {

    private ResultUtil(){

    }

    public static Result createSucessResult(Object data) {
        Result result = new Result();
        result.setCode(1);
        result.setMsg("处理成功！");
        result.setData(data);
        return result;
    }

    public static Result createFailResult(Integer code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static Result createFailResult(Integer code, String msg) {
        return createFailResult(code, msg, null);
    }

}


