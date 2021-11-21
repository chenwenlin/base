package com.chen.basecommon.net;

/**
 * 响应码接口, 主要用于为各业务定义各自的错误响应码
 *
 * @author chenwenlin
 */
public interface ResponseCode {

    /**
     * 通讯或业务相关的响应码
     *
     * @return 返回响应码
     */
    String getCode();

    /**
     * 通讯或业务相关的响应消息
     *
     * @return 返回响应消息
     */
    String getMessage();

}
