package com.itself.common.exception;

import com.itself.common.Result.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 * @Author xxw
 * @Date 2023/07/12
 */
@Slf4j
@RestControllerAdvice //注入spring,进行通知
public class GlobalExceptionHandler {

    /**
     * 处理所有未知异常
     */
    @ExceptionHandler(Exception.class)
    public Response<Void> handleException(Exception exception){
        log.error(exception.getMessage(),exception);
       return Response.error(exception.getMessage());
    }

    /**
     * 处理所有业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public Response<Void> handleBusinessException(BusinessException exception){
        log.error(exception.getMessage(),exception);
        return Response.error(exception.getCode(),exception.getMessage());
    }
}
