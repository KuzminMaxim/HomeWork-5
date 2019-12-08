package com.example;

import java.util.LinkedList;

public class ComparisonLinkedListAndMyLinkedList {

    private int size;

    public ComparisonLinkedListAndMyLinkedList(int size) {
        this.size = size;
    }

    public void compareList() {

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        System.out.println();
        System.out.println("Compare add(Element):");
        compareAdd(myLinkedList, linkedList);

        System.out.println();
        System.out.println("Compare add(index,Element):");
        compareAddWithIndex(myLinkedList, linkedList);

        System.out.println();
        System.out.println("Compare indexOf(Element):");
        compareIndexOf(myLinkedList, linkedList);

        System.out.println();
        System.out.println("Compare remove(index):");
        compareRemove(myLinkedList, linkedList);
    }

    private void compareAdd(MyLinkedList<String> myLinkedList, LinkedList<String> linkedList) {

        long startTime;
        long estimatedTime;

        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            myLinkedList.add("Element " + i);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("MyLinkedList time: " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            linkedList.add("Element " + i);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList time: " + estimatedTime);
    }

    private void compareAddWithIndex(MyLinkedList<String> myLinkedList, LinkedList<String> linkedList) {

        long startTime;
        long estimatedTime;

        startTime = System.nanoTime();
        myLinkedList.add((size/2)/2, "Some element");
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("MyLinkedList time: " + estimatedTime);

        startTime = System.nanoTime();
        linkedList.add((size/2)/2, "Some element");
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList time: " + estimatedTime);
    }

    private void compareIndexOf(MyLinkedList<String> myLinkedList, LinkedList<String> linkedList) {

        long startTime;
        long estimatedTime;

        startTime = System.nanoTime();
        myLinkedList.indexOf("Some element");
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("MyLinkedList time: " + estimatedTime);

        startTime = System.nanoTime();
        linkedList.indexOf("Some element");
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList time: " + estimatedTime);
    }

    private void compareRemove(MyLinkedList<String> myLinkedList, LinkedList<String> linkedList) {

        long startTime;
        long estimatedTime;

        startTime = System.nanoTime();
        for (int i = 10000; i < 20000; i++) {
            myLinkedList.remove(i);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("MyLinkedList time: " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 10000; i < 20000; i++) {
            linkedList.remove(i);
        }
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList time: " + estimatedTime);
    }

}
