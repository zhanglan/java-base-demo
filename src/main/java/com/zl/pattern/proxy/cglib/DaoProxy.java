package com.zl.pattern.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhanglan
 * @description
 * @date 2020-10-09
 */
public class DaoProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("proxy before...");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("proxy after...");
        return result;
    }
}
