package com.chen.designpatterns.create.factory.simplefactory;

/**
 * 简单工程
 *
 * @Author chenwenlin
 * @Date 2021/11/21 17:17
 */
public class SimpleFactory {
}
/**
 * 具体工厂
 */
class Factory {

    public void create(Integer product) {
        switch (product) {
            case 0:
                new Product1().create();
                break;
            case 1:
                new Product2().create();
        }
    }
}
/**
 * 抽象产品
 */
interface Product {
    void create();
}
/**
 * 具体产品1
 */
class Product1 implements Product {
    @Override
    public void create() {
        System.out.print("----------创建产品一----------");
    }
}
/**
 * 具体产品2
 */
class Product2 implements Product {
    @Override
    public void create() {
        System.out.print("----------创建产品二----------");
    }
}