package com.efimchick.ifmo.collections;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class PairStringList implements List<String> {

    ArrayList<String> arrayList;

    public PairStringList() {
        arrayList=new ArrayList<>();
    }

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return arrayList.contains(o);
    }

    @Override
    public Iterator<String> iterator() {
        return arrayList.iterator();
    }

    @Override
    public Object[] toArray() {
        return arrayList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) arrayList.toArray();
    }

    @Override
    public boolean add(String s) {

        arrayList.add(s);
        arrayList.add(s);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        arrayList.remove(o);
        return arrayList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return arrayList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        c.forEach(s -> {
            arrayList.add(s);
            arrayList.add(s);
        });
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {

        AtomicInteger tmp= new AtomicInteger();
        if(index%2!=0)
            tmp.getAndIncrement();

        c.forEach(s -> {
            arrayList.add(index+ tmp.get(),s);
            arrayList.add(index+ tmp.get(),s);
            tmp.getAndIncrement();
            tmp.getAndIncrement();
        });

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return arrayList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return arrayList.retainAll(c);
    }

    @Override
    public void clear() {
        arrayList.clear();
    }

    @Override
    public String get(int index) {
        return arrayList.get(index);
    }

    @Override
    public String set(int index, String element) {
        if(index%2==0)
            arrayList.set(index+1,element);
        else
            arrayList.set(index-1,element);
        return arrayList.set(index,element);
    }

    @Override
    public void add(int index, String element) {
        if(index%2==0){
            arrayList.add(index,element);
            arrayList.add(index,element);
            return;
        }
        arrayList.add(index + 1, element);
        arrayList.add(index + 1, element);

    }

    @Override
    public String remove(int index) {
        if (index%2==0){
            arrayList.remove(index+1);
            return arrayList.remove(index);
        }
        arrayList.remove(index-1);
        return arrayList.remove(index-1);
    }

    @Override
    public int indexOf(Object o) {
        return arrayList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return arrayList.lastIndexOf(o);
    }

    @Override
    public ListIterator<String> listIterator() {
        return arrayList.listIterator();
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return arrayList.listIterator(index);
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return arrayList.subList(fromIndex,toIndex);
    }
}
