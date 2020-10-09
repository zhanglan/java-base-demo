package com.zl.pattern.proxy.cglib;

/**
 * @author zhanglan
 * @description
 * @date 2020-10-09
 */
public class Dao {

    public void add() {
        System.out.println("add...");
        div();
    }

    public void div() {
        System.out.println("div...");
    }
}
