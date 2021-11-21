package com.chen.basecommon.net;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * 通讯响应码定义, 这里全都是业务码, 非 Http Header 的响应码
 * <p>
 * Http Header 的 code 由 Http 容器自行定义返回
 *
 * @author itfinally
 */

@Getter
@AllArgsConstructor
public enum NetworkCode implements ResponseCode, Serializable {

    // 通讯相关的响应代码 200 - 599 段

    OK("200", "请求成功"),
    BAD_REQUEST("400", "语义有误或参数错误"),
    UNAUTHORIZED("401", "未登录"),
    NOT_FOUND("404", "资源不存在"),
    FORBIDDEN("403", "用户未授权"),
    TIMEOUT("408", "请求超时"),
    CONFLICT("409", "资源存在重复或冲突"),
    TOO_MANY_REQUESTS("429", "请求过于频繁"),
    SERVER_ERROR("500", "服务异常"),

    // APP 相关的响应代码 600 - 659 段

    LOGIN_FAILED("600", "登陆失败, 请检查输入的登陆信息是否正确"),
    LOGIN_TIMEOUT("601", "登陆信息已过期, 请重新登陆"),
    LOGIN_DUPLICATED("602", "您的账户已被其他用户登陆"),
    LOGIN_DISABLE("603", "登陆失败, 该账户已被禁用"),
    APP_UPGRADE("610", "目前存在新版本, 请更新 APP");

    private final String code;

    private final String message;
}