package com.chen.basecommon.net;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Objects;

/**
 * 请求返回结果通用载体
 *
 * @Author chenwenlin
 * @Date 2021/11/17 13:57
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class DataResponse<T> implements Serializable {

    /**
     * 响应业务码
     */
    private String code;
    /**
     * 响应信息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data;

    public DataResponse(ResponseCode responseCode, T data) {
        Objects.requireNonNull(responseCode, "响应码不能为空");
        this.data = data;
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }

    /**
     * 响应ok
     *
     * @param data 返回数据
     * @param <T>  数据类型
     */
    public static <T> DataResponse<T> ok(T data) {
        return new DataResponse<T>(NetworkCode.OK, data);
    }

    public static <T> DataResponse<T> ok() {
        return new DataResponse<T>(NetworkCode.OK, null);
    }

    public static <T> DataResponse<T> failed(ResponseCode responseCode, String message) {
        return new DataResponse<T>(responseCode, null).setMessage(message);
    }

    public static <T> DataResponse<T> failed(ResponseCode responseCode) {
        return new DataResponse<T>(responseCode, null);
    }

    public static <T> DataResponse<T> failed(String message) {
        return new DataResponse<T>().setMessage(message);
    }
}