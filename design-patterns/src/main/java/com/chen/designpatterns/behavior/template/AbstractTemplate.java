package com.chen.designpatterns.behavior.template;

public abstract class AbstractTemplate {

    public void testTemplate() {

    }


    public void apply1() {
        System.out.print("------- 流程一--------");
    }

    public void apply2() {
        System.out.print("------- 流程一--------");
    }

    public abstract void apply();
}