package com.example;

import java.util.Iterator;

public interface MyListIterator<E> extends Iterator<E> {

    boolean hasNext();

    E next();

    int nextInd();

    void remove();

}
