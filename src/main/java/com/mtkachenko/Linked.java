package com.mtkachenko;

public interface Linked<T> {
    void addLast(T e);
    void addFirst(T e);
    int size();
    T getElementByIndex(int counter);
}
