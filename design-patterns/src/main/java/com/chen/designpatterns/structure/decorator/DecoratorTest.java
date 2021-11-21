package com.chen.designpatterns.structure.decorator;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 装饰测试
 * 模拟奶茶添加芝士、珍珠
 * 具体奶茶为：珍珠奶茶、杨枝甘露
 * 加料：芝士、珍珠
 *
 * @Author chenwenlin
 * @Date 2021/11/21 20:45
 */
public class DecoratorTest {
    public static void main(String[] args) {
        // 珍珠奶茶
        BubbleTea bubbleTea = new BubbleTea();
        // 添加芝士
        MilkTea milkTea = new Cheese(bubbleTea);
        System.out.println("制作的奶茶的价格为：" + milkTea.getPrice());
    }
}


/**
 * 抽象构建奶茶
 */
interface MilkTea {
    // 制作奶茶
    void make();

    Integer getPrice();
}

// 珍珠奶茶
class BubbleTea implements MilkTea {

    @Override
    public void make() {
        System.out.println("----------制作珍珠奶茶----------");
    }

    @Override
    public Integer getPrice() {
        return 10;
    }
}

// 杨枝甘露
class PoplarTwigNectar implements MilkTea {

    @Override
    public void make() {
        System.out.println("----------制作杨枝甘露----------");
    }

    @Override
    public Integer getPrice() {
        return 15;
    }
}

// 抽象装饰
abstract class SmallMaterial implements MilkTea {

    protected final MilkTea milkTea;

    public SmallMaterial(MilkTea milkTea) {
        this.milkTea = milkTea;
    }

    @Override
    public void make() {
        milkTea.make();
    }
}

// 芝士
class Cheese extends SmallMaterial {

    public Cheese(MilkTea milkTea) {
        super(milkTea);
    }

    @Override
    public void make() {
        super.make();
        System.out.println("加点芝士小料");
    }

    @Override
    public Integer getPrice() {
        return super.milkTea.getPrice() + 3;
    }
}

// 珍珠
class Pearl extends SmallMaterial {

    public Pearl(MilkTea milkTea) {
        super(milkTea);
    }

    @Override
    public void make() {
        super.make();
        System.out.println("加点珍珠小料");
    }

    @Override
    public Integer getPrice() {
        return super.milkTea.getPrice() + 1;
    }


}







