package com.mpetrov.javaschool.hw.lesson2.text.app;

import java.util.Iterator;
import java.util.List;

public class ReverseCollection<T> implements Iterator<T>, Iterable<T> {
    private int count;
    private final List<T> collection;

    public ReverseCollection(List<T> collection) {
        this.collection = collection;
        count = collection.size();
    }

    @Override
    public boolean hasNext() {
        return count > 0;
    }

    @Override
    public T next() {
        count--;
        return collection.get(count);
    }

    @Override
    public Iterator<T> iterator() {
        return this;
    }
}
