package com.zl.pattern.proxy.jdk;

import lombok.var;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zhanglan
 * @description
 * @date 2020-10-09
 */
public class DaoProxy implements InvocationHandler {
    private Object subject;

    public DaoProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy before...");
        Object result = method.invoke(subject, args);
        System.out.println("proxy after...");
        return result;
    }
}
