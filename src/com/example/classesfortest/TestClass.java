package com.example.classesfortest;

import java.util.*;

public class TestClass {

    private long size;

    private LinkedList<String> linkedList;
    private ArrayList<String> arrayList;
    private HashSet<String> hashSet;
    private LinkedHashSet<String> linkedHashSet;
    private TreeSet<String> treeSet;
    private HashMap<String, String> hashMap;
    private LinkedHashMap<String, String> linkedHashMap;
    private TreeMap<String, String> treeMap;

    private long startTime;
    private long estimatedTime;

    public TestClass(long size) {
        this.size = size;

        linkedList = new LinkedList<>();
        arrayList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            linkedList.add("Some element");
            arrayList.add("Some element");
        }

        hashSet = new HashSet<>();
        linkedHashSet = new LinkedHashSet<>();
        treeSet = new TreeSet<>();
        for (int i = 0; i < size; i++) {
            hashSet.add("Some element" + i);
            linkedHashSet.add("Some element" + i);
            treeSet.add("Some element" + i);
        }

        hashMap = new HashMap<>();
        linkedHashMap = new LinkedHashMap<>();
        treeMap = new TreeMap<>();

        for (int i = 0; i < size; i++) {
            hashMap.put("Some element" + i, "Some element");
            linkedHashMap.put("Some element" + i, "Some element");
            treeMap.put("Some element" + i, "Some element");
        }
    }

    public void compareAddForList(String element, int place) {

        System.out.println("Compare add for Lists");

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(place + i, element);
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time ArrayList: " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(place + i, element);
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time LinkedList: " + estimatedTime);
    }

    public void compareRemoveForList(int place) {

        System.out.println("Compare remove for lists");

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.remove(place - i - 1);
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time ArrayList: " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.remove(place - i - 1);
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time LinkedList: " + estimatedTime);
    }

    public void compareAddForListBegin(String element) {

        System.out.println("Compare add for lists begin");

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(0, element);
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time ArrayList: " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(0, element);
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time LinkedList: " + estimatedTime);
    }

    public void compareRemoveForListBegin() {

        System.out.println("Compare remove for lists begin");

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.remove(0);
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time ArrayList: " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.remove(0);
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time for LinkedList: " + estimatedTime);
    }

    public void compareRemoveForListEnd() {

        System.out.println("Compare remove for lists end");

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.remove(arrayList.size() - 1);
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time ArrayList: " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.remove(linkedList.size() - 1);
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time for LinkedList: " + estimatedTime);
    }


    public void compareAddForSet(String element) {

        System.out.println("Compare add for Sets");

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            hashSet.add(element + (i + size));
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time HashSet: " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedHashSet.add(element + (i + size));
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time LinkedHashSet: " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            treeSet.add(element + (i + size));
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time TreeSet: " + estimatedTime);
    }

    public void compareContainsForSet(String element) {

        System.out.println("Compare contains for Sets");

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            hashSet.contains(element + (5 * i));
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time HashSet: " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedHashSet.contains(element + (5 * i));
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time LinkedHashSet: " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            treeSet.contains(element + (5 * i));
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time TreeSet: " + estimatedTime);
    }

    public void compareRemoveForSet(String element) {

        System.out.println("Compare remove for Sets");

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            hashSet.remove(element + (3 * i + 1));
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time HashSet: " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedHashSet.remove(element + (3 * i + 1));
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time LinkedHashSet: " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            treeSet.remove(element + (3 * i + 1));
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time for TreeSet: " + estimatedTime);
    }

    public void comparePutForMap(String element) {

        System.out.println("Compare put for Maps");

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            hashMap.put(element + (size + i), element);
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time HashMap: " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedHashMap.put(element + (size + i), element);
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time LinkedHashMap: " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            treeMap.put(element + (size + i), element);
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time TreeMap: " + estimatedTime);
    }

    public void compareGetForMap(String element) {

        System.out.println("Compare get for Maps");

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            hashMap.get(element + (600000 - 1 - i * 3));
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time HashMap: " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedHashMap.get(element + (600000 - 1 - i * 3));
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time LinkedHashMap: " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            treeMap.get(element + (600000 - 1 - i * 3));
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time TreeMap: " + estimatedTime);
    }

    public void compareRemoveForMap(String element) {

        System.out.println("Compare remove for Maps");

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            hashMap.remove(element + (i * 3 + 19));
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time HashMap: " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedHashMap.remove(element + (i * 3 + 19));
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time LinkedHashMap " + estimatedTime);

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            treeMap.remove(element + (i * 3 + 19));
        }
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Time TreeMap: " + estimatedTime);

    }
}
