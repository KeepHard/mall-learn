package com.aihs.mall.tiny.common.api;

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
}
