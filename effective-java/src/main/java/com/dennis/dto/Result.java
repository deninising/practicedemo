package com.dennis.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Result<T> implements Serializable {
    /**
     * 成功时返回的默认消息：ok
     */
    private static final String MSG_OK = "ok";
    /**
     * 出错时返回的默认消息：error
     */
    private static final String MSG_ERROR = "error";

    private String msg;
    private Integer code;
    private T data;

    public Result() {
    }

    private Result(String msg, Integer code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static <T> Result<T> ok() {
        return createResult(MSG_OK, 200, null);
    }

    public static <T> Result<T> ok(String msg) {
        return createResult(msg, 200, null);
    }

    public static <T> Result<T> ok(T data) {
        return createResult(MSG_OK, 200, data);
    }

    public static <T> Result<T> ok(String msg, T data) {
        return createResult(msg, 200, data);
    }

    public static <T> Result<T> error() {
        return createResult(MSG_ERROR, 500, null);
    }

    public static <T> Result<T> error(String msg) {
        return createResult(msg, 500, null);
    }

    public static <T> Result<T> error(String msg, Integer code) {
        return createResult(msg, code, null);
    }

    private static <T> Result<T> createResult(String msg, Integer code, T data) {
        return new Result<T>(msg, code, data);
    }
}
