package com.efimchick.ifmo.collections;

import java.util.*;

class SortedByAbsoluteValueIntegerSet implements Set<Integer> {

    SortedSet<Integer> sortedSet;

    public SortedByAbsoluteValueIntegerSet() {
        sortedSet=new TreeSet<>(Comparator.comparingInt(Math::abs));
    }

    @Override
    public int size() {
        return sortedSet.size();
    }

    @Override
    public boolean isEmpty() {
        return sortedSet.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return sortedSet.contains(o);
    }

    @Override
    public Iterator<Integer> iterator() {
        return sortedSet.iterator();
    }

    @Override
    public Object[] toArray() {
        return sortedSet.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) sortedSet.toArray();
    }

    @Override
    public boolean add(Integer integer) {
        return sortedSet.add(integer);
    }

    @Override
    public boolean remove(Object o) {
        return sortedSet.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return sortedSet.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return sortedSet.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return sortedSet.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return sortedSet.removeAll(c);
    }

    @Override
    public void clear() {
        sortedSet.clear();
    }
}
