package com.mpetrov.javaschool.hw.lesson3.generics_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtils {
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {

        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {

        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T> source, T e) {

        return source.indexOf(e);
    }

    public static <T> List<T> limit(List<? extends T> source, int size) {

        return source.stream().limit(size).collect(Collectors.toList());
    }

    public static <T> void add(List<? super T> source, T e) {

        source.add(e);
    }

    public static <T> void removeAll(List<? extends T> removeFrom, List<? super T> c2) {

        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? extends T> c1, List<? super T> c2) {

        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<? super T> c2) {

        return c1.stream().anyMatch(c2::contains);
    }

    public static <T extends Number> List<? extends Number> range(List<? extends Number> list, T min, T max) {
        return list.stream().filter(e -> e.doubleValue() >= (double)min && e.doubleValue() <= (double)max)
                .collect(Collectors.toList());
    }

    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<T> comparator) {

        return list.stream().filter(e -> comparator.compare(e, min) >= 0 && comparator.compare(e, max) <= 0)
                .collect(Collectors.toList());
    }

}
