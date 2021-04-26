package com.mpetrov.javaschool.hw.lesson5.Task1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class ReflectionHelper {
    public static void printAllMethods(Object object) {
        System.out.println("All methods from class " + object.getClass().getName());

        Method[] methods = object.getClass().getMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            System.out.println(method.getName());
        }
    }

    public static void printAllGetters(Object object) {
        System.out.println("All getters from class " + object.getClass().getName());

        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (isGetter(method)) System.out.println(method.getName());
        }
    }

    public static void checkStringConstants(Object object) throws IllegalAccessException {
        System.out.println("All constants with incorrect values from class " + object.getClass().getName());
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getModifiers() == (Modifier.PUBLIC + Modifier.STATIC + Modifier.FINAL)
                    && field.getType() == String.class) {
                if (field.getName() != field.get(object)) System.out.println(field.getName());
            }
        }
    }

    public static void assign(Object to, Object from) throws InvocationTargetException, IllegalAccessException {
        Method[] toMethods = to.getClass().getMethods();
        Method[] fromMethods = from.getClass().getMethods();
        Map<String, Method> toSetters = new HashMap<>();

        for (Method method : toMethods) {
            if (isSetter(method)) toSetters.put(getTrimmedPropertyName(method), method);
        }
        for (Method method : fromMethods) {
            String trimmedName = getTrimmedPropertyName(method);
            if (isGetter(method)
                    && toSetters.containsKey(trimmedName)
                    && ((toSetters.get(trimmedName).getParameterTypes()[0] == method.getReturnType())
                    || (toSetters.get(trimmedName).getParameterTypes()[0]
                    == method.getReturnType().getSuperclass()))) {
                toSetters.get(trimmedName).invoke(to, method.invoke(from, null));
            }
        }
    }

    public static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) return false;
        if (method.getParameterTypes().length != 0) return false;
        if (void.class.equals(method.getReturnType())) return false;
        return true;
    }

    public static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) return false;
        if (method.getParameterTypes().length != 1) return false;
        return true;
    }

    public static String getTrimmedPropertyName(Method method) {
        return method.getName().substring(3);
    }
}
