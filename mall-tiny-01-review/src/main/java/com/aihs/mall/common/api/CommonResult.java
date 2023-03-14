package com.aihs.mall.common.api;

public class CommonResult<T> {
    private long code;
    private String message;

    private T data;

    private CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> CommonResult<T> success(T data){
        return new CommonResult<>(CommonCode.SUCCESS.getCode(),CommonCode.SUCCESS.getMessage(),data);
    }

    public static <T> CommonResult<T> success(T data,String message){
        return new CommonResult<>(CommonCode.SUCCESS.getCode(), message,data);
    }

    public static <T> CommonResult<T> response(long code,String message,T data){
        return new CommonResult<>(code,message,data);
    }

    public static <T> CommonResult<T> response(IErrorCode iErrorCode,T data){
        return new CommonResult<>(iErrorCode.getCode(),iErrorCode.getMessage(),data);
    }

    public static <T> CommonResult<T> failed(){
        return new CommonResult<>(CommonCode.FAILED.getCode(), CommonCode.FAILED.getMessage(), null);
    }

    public static <T> CommonResult<T> failed(T data){
        return new CommonResult<>(CommonCode.FAILED.getCode(), CommonCode.FAILED.getMessage(), data);
    }
    public static <T> CommonResult<T> failed(IErrorCode iErrorCode){
        return new CommonResult<>(iErrorCode.getCode(),iErrorCode.getMessage(),null);
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
