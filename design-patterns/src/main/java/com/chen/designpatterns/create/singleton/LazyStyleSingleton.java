package com.chen.designpatterns.create.singleton;

/**
 * 懒汉式
 *
 * @author chenwenlin
 * @email 1205755403@qq.com
 * @date 2021/11/21 16:36
 */
public class LazyStyleSingleton {

}

/**
 * 懒汉式线程不安全
 */
class LazyNoSafe {
    private LazyNoSafe instance = null;

    public LazyNoSafe getInstance() {
        if (instance == null) {
            instance = new LazyNoSafe();
        }
        return instance;
    }
}

/**
 * 懒汉线程安全
 */
class LazySafe {
    private LazySafe instance = null;

    public synchronized LazySafe getInstance() {
        if (instance == null) {
            instance = new LazySafe();
        }
        return instance;
    }
}

/**
 * 双重锁检查 线程安全 记得volatile关键字
 */
class DoubleCheckLock {
    private volatile DoubleCheckLock instance = null;

    public DoubleCheckLock getInstance() {
        if (instance == null) {
            synchronized (this) {
                if (instance == null) {
                    instance = new DoubleCheckLock();
                }
            }
        }
        return instance;
    }
}

/**
 * 内部静态类 线程安全
 */
class InnerStaticClass {

    public static class InnerStaticClassHandler {
        public static final InnerStaticClass instance = new InnerStaticClass();
    }

    public InnerStaticClass getInstance() {
        return InnerStaticClassHandler.instance;
    }
}