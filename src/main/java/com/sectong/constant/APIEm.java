package com.sectong.constant;

/**
 * Created by xueyong on 16/6/27.
 * demo.
 */
public enum APIEm {

    SUCCESS(2000,"success"),
    NOTBINDING(2002, "user has not yet binding mac"),
    FAIL(2001, "failed");

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
