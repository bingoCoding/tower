package com.tower.blog.config;

import com.tower.blog.base.BaseResponse;
import com.tower.blog.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(BaseException.class)
    @ResponseBody
    public BaseResponse handleStudentException(HttpServletRequest request, BaseException ex) {
        BaseResponse response;
        logger.error("StudentException code:{},msg:{}",ex.getReturnCode().val(),ex.getReturnCode().msg());
        response = new BaseResponse().fail(ex.getReturnCode().val(),ex.getReturnCode().msg());
        return response;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse handleException(HttpServletRequest request, Exception ex) {
        BaseResponse response;
        logger.error("exception error:{}",ex);
        response = new BaseResponse().fail();
        return response;
    }


}
