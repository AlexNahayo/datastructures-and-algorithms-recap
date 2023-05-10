package com.nahayo.queue;

import java.util.Arrays;

public class ArrayQueue {

    private final int[] array;
    private int front, back, count = 0;

    public ArrayQueue(int size) {
        array = new int[size];
    }

    public void enqueue(int item){
        if(count == array.length){
            throw new IllegalStateException();
        }
        else{
            array[back] = item;
            back = (back + 1) % array.length;
        }
        count++;
    }

    public int dequeue(){
        var item = array[front];
        array[front] = 0;
        front = (front + 1) % array.length;
        count--;
        return item;
    }

    public int peek(){
        return array[front];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == array.length;
    }

    @Override
    public String toString(){
        return Arrays.toString(array);
    }
}
