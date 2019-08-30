package com.tower.blog.enums;

public enum ReturnCode {

    /** 操作成功 */

    //SUCCESS("SUCCESS_CODE", "SUCCESS_MSG"),
    SUCCESS("200", "操作成功"),

    /** 操作失败 */
    //FAIL("FAIL_CODE", "FAIL_MSG");
    FAIL("500", "操作失败"),

    NULLVALUE("500","参数不能为空");

    private String val;
    private String msg;

    private ReturnCode(String value, String msg){
        this.val = value;
        this.msg = msg;
    }

    public String val() {
        return val;
    }

    public String msg() {
        return msg;
    }

}
