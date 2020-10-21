package com.example.edu.utils;

/**
 * @ProjectName: edu
 * @PackageName: com.example.edu.utils
 * @ClassName: ResultUtils
 * @Date: 2020年04月15日 22:27
 * @Author: zhanggeyang
 * @Description:
 **/

public class ResultUtils<T> {

    //成功返回
    public static Result successful(Object o){
        Result objectResult = new Result<>();
        objectResult.setCode(StatusCode.OK);
        objectResult.setFlag(true);
        objectResult.setData(o);
        objectResult.setMessage("success");
        return objectResult;
    }

    public static Result successful(String msg){
        Result objectResult = new Result<>();
        objectResult.setMessage(msg);
        return objectResult;
    }
    //失败返回
    public static Result failure(String msg){
        Result objectResult = new Result<>();
        objectResult.setCode(StatusCode.ERROR);
        objectResult.setFlag(false);
        objectResult.setMessage(msg);
        return objectResult;
    }


}
