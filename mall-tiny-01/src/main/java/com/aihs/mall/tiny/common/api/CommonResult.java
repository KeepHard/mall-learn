package com.aihs.mall.tiny.common.api;

import javax.xml.transform.Result;

public class CommonResult<T> {
    private long code;
    private String message;

    private T data;

    protected CommonResult(){

    }

    protected CommonResult(long code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResult<T> success(T data){
        return new CommonResult<>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }

    public static <T> CommonResult<T> success(T data,String message){
        return new CommonResult<>(ResultCode.SUCCESS.getCode(), message,data);
    }

    public static <T> CommonResult<T> failed(IErrorCode errorCode){
        return new CommonResult<>(errorCode.getCode(),errorCode.getMessage(),null);
    }

    public static <T> CommonResult<T> failed(String message){
        return new CommonResult<>(ResultCode.FIELD.getCode(), message,null);
    }

    public static <T> CommonResult<T> failed(){
        return failed(ResultCode.FIELD);
    }

    public static <T> CommonResult<T> validateFailed(){
        return failed(ResultCode.VALIDATE_FAILED);
    }

    public static <T> CommonResult<T> validateFailed(String message){
        return new CommonResult<>(ResultCode.VALIDATE_FAILED.getCode(), message,null);
    }

    public static <T> CommonResult<T> unauthorized(T data){
        return new CommonResult<>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    public static <T> CommonResult<T> forbidden(T data){
        return new CommonResult<>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
