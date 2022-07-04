package com.efimchick.ifmo.collections;

import java.util.*;

class MedianQueue implements Queue<Integer> {

    PriorityQueue<Integer> smaller;
    PriorityQueue<Integer> bigger;

    public MedianQueue() {
        smaller=new PriorityQueue<>(Collections.reverseOrder());
        bigger= new PriorityQueue<>();
    }


    @Override
    public int size() {
        return smaller.size()+bigger.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        if (smaller.size() >= bigger.size()) {
            return smaller.iterator();
        } else {
            return bigger.iterator();
        }
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return smaller.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }


    @Override
    public boolean add(Integer integer) {
        return false;
    }

    @Override
    public boolean offer(Integer integer) {
        if (bigger.size() > 0 && integer > bigger.peek()) {
            bigger.add(integer);
        } else {
            smaller.add(integer);
        }

        if (smaller.size() - bigger.size() == 2) {
            bigger.add(smaller.remove());
        } else if (bigger.size() - smaller.size() == 2) {
            smaller.add(bigger.remove());
        }
        return true;
    }

    @Override
    public Integer remove() {
        return null;
    }

    @Override
    public Integer poll() {
        if (smaller.size() >= bigger.size())
            return smaller.remove();
        else
            return bigger.remove();
    }

    @Override
    public Integer element() {
        return null;
    }

    @Override
    public Integer peek() {
        if (smaller.size() >= bigger.size()) {
            return smaller.peek();
        } else {
            return bigger.peek();
        }
    }

}
