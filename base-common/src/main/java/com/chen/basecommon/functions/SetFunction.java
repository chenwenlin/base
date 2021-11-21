package com.chen.basecommon.functions;

/**
 * 函数式接口 设置某个字段
 *
 * @Author chenwenlin
 * @Date 2021/9/12 16:25
 */
@FunctionalInterface
public interface SetFunction<T, R> {
    /**
     * 讲r值填充到T类型的某个字段中
     *
     * @param t 需要被设置属性的类
     * @param r 设置的属性值
     */
    void apply(T t, R r);
}