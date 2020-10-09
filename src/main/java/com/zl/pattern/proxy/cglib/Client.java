package com.zl.pattern.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author zhanglan
 * @description
 * @date 2020-10-09
 */
public class Client {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        enhancer.setCallback(new DaoProxy());
        Dao dao = (Dao) enhancer.create();
        dao.add();
    }

}
