package com.tower.blog.exception;


import com.tower.blog.enums.ReturnCode;

public class BaseException extends RuntimeException {

    private final ReturnCode returnCode;

    public BaseException(ReturnCode returnCode) {
        this.returnCode = returnCode;
    }

    public ReturnCode getReturnCode() {
        return returnCode;
    }
}
