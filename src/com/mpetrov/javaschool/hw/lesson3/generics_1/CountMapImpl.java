package com.mpetrov.javaschool.hw.lesson3.generics_1;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<E> implements CountMap<E> {
    private final Map<E, Integer> map;

    public CountMapImpl() {
        map = new HashMap<>();
    }

    @Override
    public void add(E e) {
        if (map.containsKey(e)) {
            map.put(e, map.get(e) + 1);
        } else map.put(e, 1);
    }

    @Override
    public int getCount(E e) {
        return map.get(e);
    }

    @Override
    public int remove(E e) {
        return map.remove(e);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<E> source) {
        map.putAll(source.toMap());
    }

    @Override
    public Map<E, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<E, Integer> destination) {
        destination.putAll(map);
    }
}
