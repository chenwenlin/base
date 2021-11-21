package com.chen.designpatterns.create.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 饿汉式
 *
 * @Author chenwenlin
 * @Date 2021/11/21 16:46
 */
public class HungryStyleSingleton {
}

/**
 * 饿汉式 直接加载
 */
class HungryStyle {
    private static HungryStyle instance = new HungryStyle();

    public HungryStyle getInstance() {
        return instance;
    }
}

/**
 * 枚举方式
 */
enum EnumStyle {
    INSTANCE;

    /**
     * 线程池单利
     */
    private final ExecutorService executorService;

    EnumStyle() {
        this.executorService = new ThreadPoolExecutor(5, 10,
                0L, TimeUnit.MICROSECONDS, new LinkedBlockingDeque<>());
    }

    public ExecutorService getInstance() {
        return executorService;
    }
}
