package com.chen.designpatterns.create.factory.abstractfactory;

/**
 * @Author chenwenlin
 * @Date 2021/11/21 17:41
 */
public interface AbstractFactory {
    Milk newMilk(String type);

    Drinks newDrinks(String type);
}

/**
 * 抽象产品1 牛奶
 */
interface Milk {

}

/**
 * 抽象产品2 饮料
 */
interface Drinks {

}

/**
 * 安徽具体工厂
 */
class AnHuiFactory implements AbstractFactory {
    @Override
    public Milk newMilk(String type) {
        if (type.equals("mengNiu")) {
            return new MengNiu();
        } else {
            return new YiLiMilk();
        }
    }

    @Override
    public Drinks newDrinks(String type) {
        if (type.equals("baishi")) {
            return new BaiShi();
        } else {
            return new Coco();
        }
    }
}

class JiangXiFactory implements AbstractFactory {

    @Override
    public Milk newMilk(String type) {
        if (type.equals("mengNiu")) {
            return new MengNiu();
        } else {
            return new YiLiMilk();
        }
    }

    @Override
    public Drinks newDrinks(String type) {
        if (type.equals("baishi")) {
            return new BaiShi();
        } else {
            return new Coco();
        }
    }
}

/**
 * 抽象产品1的具体产品1 伊利牛奶
 */
class YiLiMilk implements Milk {

}

/**
 * 抽象产品1的具体产品2
 */
class MengNiu implements Milk {

}

/**
 * 抽象产品1的具体产品1 百事可乐
 */
class BaiShi implements Drinks {

}

/**
 * 抽象产品2的具体产品1 可口可乐
 */
class Coco implements Drinks {

}

