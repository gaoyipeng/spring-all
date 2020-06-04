package com.sxdx.springmvc.entity.response;

import java.io.Serializable;

public class Response<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    public Response() {
        this(ResponseCode.SUCCESS);
    }

    public Response(int code) {
        this(code, null);
    }

    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }

    public Response<T> withData(T t) {
        this.data = t;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

