package com.sxdx.springmvc.handler;

import com.sxdx.springmvc.entity.response.Response;
import com.sxdx.springmvc.entity.response.ResponseCode;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: spring-all
 * @description: 全局异常处理器
 * @author: garnett
 * @create: 2020-03-18 21:40
 **/

@ControllerAdvice
class MyExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    Response handleUnknownException(Exception e) {
        return new Response(ResponseCode.INTERNAL_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = HttpMessageNotReadableException.class)
    @ResponseBody
    Response handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return new Response(ResponseCode.MISSING_REQUEST_BODY);
    }
}
