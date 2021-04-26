package com.mpetrov.javaschool.hw.lesson5.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

public class CacheInvocationHandler implements InvocationHandler {
    Object delegate;
    Map<Integer,Integer> cache;

    public CacheInvocationHandler(Object delegate, Map<Integer,Integer> cache) {
        this.delegate = delegate;
        this.cache = cache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.isAnnotationPresent(Cache.class)) {
            return method.invoke(delegate, args);
        }
        if (cache.containsKey((Integer)args[0])) return cache.get((Integer)args[0]);
        Object invoke = method.invoke(delegate, args);
        cache.put((Integer) args[0],(Integer) invoke);
        return invoke;
    }
}
