package com.web.market.controller;

import com.web.market.common.api.CommonResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionInterceptor {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommonResult<String> methodArgumentExceptionHandle(MethodArgumentNotValidException e) {
        if (e.getBindingResult().getFieldError() != null) {
            return CommonResult.failed(e.getBindingResult().getFieldError().getDefaultMessage());
        } else {
            return CommonResult.failed("Argument未知错误");
        }
    }

//    @ExceptionHandler(value = Exception.class)
//    public CommonResult<String> ExceptionHandle(Exception e) {
//        return CommonResult.failed(String.format("server error: %s", e.getMessage()));
//    }
}
