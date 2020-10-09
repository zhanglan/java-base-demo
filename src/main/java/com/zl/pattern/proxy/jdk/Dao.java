package com.zl.pattern.proxy.jdk;

/**
 * @author zhanglan
 * @description
 * @date 2020-10-09
 */
public class Dao implements IDao {
    @Override
    public void add() {
        System.out.println("add...");
        div();
    }

    @Override
    public void div() {
        System.out.println("div...");
    }
}
