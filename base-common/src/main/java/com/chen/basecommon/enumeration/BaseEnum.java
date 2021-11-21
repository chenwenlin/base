package com.chen.basecommon.enumeration;


/**
 * 枚举类型实现该类，使用 EnumUtil解析
 *
 * @author hao.Li
 * @author cyfm
 * @author qingkang
 * @date 2018-09-05
 */
public interface BaseEnum<T> {
    /**
     * 获取代码
     *
     * @return {@link T}
     */
    T getCode();
}
