package com.tower.blog.base;


import com.tower.blog.enums.ReturnCode;

import java.io.Serializable;

public class BaseResponse implements Serializable {

    private String code;
    private String message;
    private Object data;

    public BaseResponse() {
    }

    public BaseResponse success(){
        this.setCode(ReturnCode.SUCCESS.val());
        this.setMessage(ReturnCode.SUCCESS.msg());
        return this;
    }
    public BaseResponse success(String message){
        this.setCode(ReturnCode.SUCCESS.val());
        this.setMessage(message);
        return this;
    }
    public BaseResponse success(String code,String message){
        this.setCode(code);
        this.setMessage(message);
        return this;
    }

    public BaseResponse fail(){
        this.setCode(ReturnCode.FAIL.val());
        this.setMessage(ReturnCode.FAIL.msg());
        return this;
    }

    public BaseResponse fail(String message){
        this.setCode(ReturnCode.FAIL.val());
        this.message=message;
        return this;
    }

    public BaseResponse fail(String code,String message){
        this.code=code;
        this.message=message;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BaseResponse data(Object object){
        this.data=object;
        return this;
    }
}
