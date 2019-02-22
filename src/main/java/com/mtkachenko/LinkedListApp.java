package com.mtkachenko;

import java.util.Iterator;
import java.util.Objects;

public class LinkedListApp<T> implements Linked<T>, Iterable<T>, DescendingIterator<T>{
    private Node<T> fstNode;
    private Node<T> lstNode;
    private int size = 0;

    public LinkedListApp() {
        lstNode = new Node<T>(null, fstNode, null);
        fstNode = new Node<T>(null, null,lstNode);
    }

    @Override
    public void addLast(T e) {
        Node<T> prev = lstNode;
        prev.setCurrentElement(e);
        lstNode = new Node<T>(null, prev, null);
        prev.setNextElement(lstNode);
        size++;
    }

    @Override
    public void addFirst(T e) {
        Node<T> next = fstNode;
        next.setCurrentElement(e);
        fstNode = new Node<T>(null, null, next);
        next.setPrevElement(fstNode);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T getElementByIndex(int counter) {
        Node<T> target = fstNode.getNextElement();
        for (int i = 0; i < counter; i++){
            target = getNextElement(target);
        }
        return target.getCurrentElement();
    }
        private Node<T> getNextElement(Node<T> current){
        return current.getNextElement();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int counter = 0;
            @Override
            public boolean hasNext() {return counter < size;} public void remove() {}
            @Override
            public T next() {return getElementByIndex(counter++);}
        };
    }

    @Override
    public Iterator<T> descendingIterator() {
        return new Iterator<T>() {
            int counter = size - 1;
            @Override
            public boolean hasNext() {return counter >= 0;} public void remove() {}
            @Override
            public T next() {return getElementByIndex(counter--);}
        };
    }

    public class Node<T> {
        private T currentElement;
        private Node<T> nextElement;
        private Node<T> prevElement;
        public Node(T currentElement, Node<T> prevElement, Node<T> nextElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }
        public T getCurrentElement() {
            return currentElement;
        }

        public void setCurrentElement(T currentElement) {
            this.currentElement = currentElement;
        }

        public Node<T> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<T> nextElement) {
            this.nextElement = nextElement;
        }

        public void setPrevElement(Node<T> prevElement) {
            this.prevElement = prevElement;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedListApp<?> that = (LinkedListApp<?>) o;
        return size == that.size &&
                Objects.equals(fstNode, that.fstNode) &&
                Objects.equals(lstNode, that.lstNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fstNode, lstNode, size);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LinkedListApp{");
        sb.append("fstNode=").append(fstNode);
        sb.append(", lstNode=").append(lstNode);
        sb.append(", size=").append(size);
        sb.append('}');
        return sb.toString();
    }

    public Node<T> getFstNode() {
        return fstNode;
    }

    public Node<T> getLstNode() {
        return lstNode;
    }
}
