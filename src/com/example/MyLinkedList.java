package com.example;

import java.lang.reflect.Array;
import java.util.*;

public class MyLinkedList<E> implements ILinkedList<E> {

    private int size;
    private MyNode<E> first;
    private MyNode<E> last;

    public MyLinkedList(){}

    @Override
    public void add(E element) {
        MyNode<E> newNode;
        if (size == 0){
            newNode = new MyNode<>(element, null, null);
            first = newNode;
            first.nextNode = newNode;
        } else {
            newNode = new MyNode<>(element, last, null);
            last.nextNode = newNode;
        }
        last = newNode;
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (!checkIndexScope(index)){
            System.out.println("Index " + index + " is incorrect!");
        } else {
            MyNode<E> myNode;
            if (index == 0){
                myNode = new MyNode<>(element, null, first);
                first.previousNode = myNode;
                first = myNode;
            } else if (index == size){
                myNode = new MyNode<>(element, last, null);
                last.nextNode = myNode;
                last = myNode;
            } else {
                MyNode<E> current = getNode(index);
                MyNode<E> previous = current.previousNode;
                current.previousNode = new MyNode<>(element, previous, current);
                previous.nextNode = current.previousNode;
            }
            size++;
        }
    }

    @Override
    public void clear() {
        for (MyNode<E> x = first; x != null; ) {
            MyNode<E> next = x.nextNode;
            x.element = null;
            x.nextNode = null;
            x.previousNode = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if(!checkIndexScopeForGet(index)){
            System.out.println("Index " + index + " is incorrect!");
            return null;
        } else {
            MyNode<E> current = getNode(index);
                return current.element;
        }
    }

    @Override
    public int indexOf(E element) {
        MyNode<E> current = first;
        for (int i = 0; i < size; i++){
            if (current.element == element){
                return i;
            } else {
                current = current.nextNode;
            }
        }
        System.out.println("Element " + element +" is not found!");
        return -1;
    }

    @Override
    public E remove(int index) {
        if (!checkIndexScopeForGet(index)){
            System.out.println("Index " + index + " is incorrect!");
            return null;
        } else {

            MyNode<E> current = getNode(index);
            MyNode<E> previous;
            MyNode<E> next;

            if(index == 0){
                first = first.nextNode;
            } else if (index == (size - 1)) {
                last = current.previousNode;
            } else {
                previous = current.previousNode;
                next = current.nextNode;
                previous.nextNode = next;
                next.previousNode = current.previousNode;
            }
            E result = current.element;
            current.element = null;
            current.nextNode = null;
            current.previousNode = null;
            size -= 1;
            return result;
        }
    }

    @Override
    public E set(int index, E element) {
        if(!checkIndexScope(index)){
            System.out.println("Index " + index + " is incorrect!");
            return null;
        } else {
            MyNode<E> current = getNode(index);
            E changedElement = current.element;
            current.element = element;
            return changedElement;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for(MyNode<E> f = first; f != null; f = f.nextNode) {
            result[i++] = f.element;
        }
        return result;
    }

    @Override
    public <T> T[] toArray(T[] object) {
        int i = 0;
        if (object.length < size){
            object = (T[]) Array.newInstance(object.getClass().getComponentType(), size);
        } else object[size] = null;
        Object[] result = object;
        for (MyNode<E> f = first; f != null; f = f.nextNode){
            result[i++] = f.element;
        }
        return object;
    }


    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        if(size() == 0){
            result = new StringBuilder("List is empty!");
        } else {
            MyNode<E> current = first;
            for (int i = 0; i < (size() - 1); i++) {
                result.append(current.element.toString()).append("; ");
                current = current.nextNode;
            }
            result.append(current.element.toString());
        }
        return result.toString();
    }

    private boolean checkIndexScope(int value){
        return (value >= 0)
                &&(value<=size);
    }

    private boolean checkIndexScopeForGet(int value){
        return (value >= 0)
                &&(value<size);
    }

       private MyNode<E> getNode(int index){
        if (index<(size >> 1)){
            MyNode myNode = first;
            for(int i = 0; i < index; i++){
                myNode = myNode.nextNode;
            }
            return myNode;
        } else {
            MyNode myNode = last;
            for (int i = size - 1; i > index; i--)
                myNode = myNode.previousNode;
            return myNode;
        }
    }

    @Override
    public Iterator<E> iterator(){
        return new MyIterator<E>(0);
    }
    public Iterator<E> iterator(int index){
        return new MyIterator<E>(index);
    }
    public MyListIterator<E> myIter(int index){
        checkIndexScope(index);
        return new MyIterator<E>(index);
    }

    private class MyIterator<E> implements MyListIterator{
        private int currentIndex;
        private int nextIndex;
        private MyNode<E> nextElement;
        private MyNode<E> currentElement;
        private int iterSize;

        public MyIterator(int index){
            iterSize = size;
            nextIndex = index;
            if(iterSize == 0){
                nextElement = null;
            }
            else{
                nextElement = (MyNode<E>)getNode(nextIndex);
            }
        }

        public boolean hasNext(){
            return nextIndex < iterSize;
        }

        public E next() {
            if (!hasNext()) {
                System.out.println("Next element not found!");
                return null;
            }
            else{
                currentIndex = nextIndex;
                nextIndex += 1;
                currentElement = nextElement;
                nextElement = nextElement.nextNode;
                return currentElement.element;
            }
        }

        public int nextInd(){
            if (!hasNext()){
                return -1;
            }
            else return nextIndex;
        }

        public void remove(){
            if (currentElement == null){
                throw new NoSuchElementException("The element not found");
            }
            if(currentIndex == nextIndex
                    && hasNext()){
                nextIndex += 1;
                nextElement = nextElement.nextNode;
                iterSize -= 1;
            }
            MyLinkedList.this.remove(currentIndex);
            currentElement = null;
        }
    }

    private class MyNode<E>{
        private E element;
        private MyNode<E> previousNode;
        private MyNode<E> nextNode;

        public MyNode(E element, MyNode<E> previousNode, MyNode<E> nextNode) {
            this.element = element;
            this.previousNode = previousNode;
            this.nextNode = nextNode;
        }
    }

}
