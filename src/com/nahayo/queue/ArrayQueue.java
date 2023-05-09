package com.nahayo.queue;

public class ArrayQueue {

    private final int[] array;
    private int front, back, count = 0;

    public ArrayQueue(int size) {
        array = new int[size];
    }

    public void enqueue(int item){
        if(count > array.length){
            throw new IndexOutOfBoundsException();
        }
        else{
            array[count] = item;
            back = count;
        }
        count++;
    }

    public void dequeue(){
        if(isEmpty()){
            // Need to find out what exception can be thrown here!
        }
        else {
            ++front;
        }
    }

    public int peek(){
        return array[front];
    }

    public boolean isEmpty(){
        return front ==  back;
    }

    public boolean isFull(){
        return back == array.length - 1;
    }

    public void printArrayQueue(){
        for (int i = front; i <= back ; i++) {
            System.out.println(array[i]);
        }
    }
}
