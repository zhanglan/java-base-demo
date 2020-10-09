package com.zl.pattern.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author zhanglan
 * @description
 * @date 2020-10-09
 */
public class Client {
    public static void main(String[] args) {
        Dao subject = new Dao();
        IDao dao = (IDao) Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), new DaoProxy(subject));
        dao.add();
    }
}
