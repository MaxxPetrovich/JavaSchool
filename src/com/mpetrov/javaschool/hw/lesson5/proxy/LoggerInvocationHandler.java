package com.mpetrov.javaschool.hw.lesson5.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggerInvocationHandler implements InvocationHandler {
    Object delegate;

    public LoggerInvocationHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.isAnnotationPresent(Logging.class)) {
            return method.invoke(delegate, args);
        }
        Long before = System.currentTimeMillis();
        Object invoke = method.invoke(delegate, args);
        Long after = System.currentTimeMillis();
        System.out.println("Время выполнения метода" + (after - before));
        return invoke;
    }
}
