package com.chen.basecommon.base;


import java.util.Optional;

/**
 * 枚举类型实现该类
 *
 * @author chenwenlin
 * @email chenwenlin@yingzi.com
 * @date 2021/11/17 14:14
 */
public interface BaseEnum<T> {
    /**
     * 根据代码获取枚举
     *
     * @param code 枚举
     * @return {@link T}
     */
    Optional<BaseEnum<T>> getByCode(T code);
}