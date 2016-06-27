package com.sectong.constant;

/**
 * Created by xueyong on 16/6/27.
 * demo.
 */
public enum APIEm {

    SUCCESS(2000,"操作成功!"),
    FAIL(2001, "操作失败");

    private int code;
    private String message;

    APIEm(int code, String message) {
        this.code = code;
        this.message = message;
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
}
