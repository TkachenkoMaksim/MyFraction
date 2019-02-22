package com.mtkachenko;

import java.util.Arrays;

public class StackApp<T>{
    private int size;
    private Object[] array;
    private int top;

    public StackApp(int s){
        size = s;
        array = new Object[s];
        top = -1;
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public void push(T a){
        int i = ++top;
        array[i] = a;
    }

    public Object pop(){
        if (isEmpty()){
           System.out.println("Stack is empty");
           return null;
        } else {
            return array[top--];
        }
    }

    public Object pick(){
        if (isEmpty()){
            return null;
        } else {
           return array[top];
        }
    }

    @Override
    public boolean equals(Object o){
        StackApp<?> stackApp = (StackApp<?>) o;
        return Arrays.equals(array, stackApp.array);
    }

    @Override
    public int hashCode(){
        return Arrays.hashCode(array);
    }

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder("StackApp{");
        sb.append("array=").append(Arrays.toString(array));
        sb.append('}');
        return sb.toString();
    }

    public int getSize(){
        return size;
    }

    public Object[] getArray(){
        return array;
    }

    public int getTop(){
        return top;
    }
}
