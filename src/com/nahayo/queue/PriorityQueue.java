package com.nahayo.queue;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items;
    private int count;
    private int temp;

    public PriorityQueue() {
        items = new int[4];
    }

    public void add(int item){
        if(isFull()){
            items = resizeArrayToBeBigger();
        }
        int i;
        for ( i = count - 1; i >=0 ; i--) {
            if(items[i] > item){
                items[i + 1] = items[i];
            }
            else {
                break;
            }
        }
        items[i +1] = item;
        count++;
    }

    private boolean isFull(){
        return count == items.length;
    }

    private boolean isEmpty(){
        return count == 0;
    }

    public int remove(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        else {
            int removedItem = items[--count];
            items =  resizeArrayToBeSmaller();
            return removedItem;
        }
    }

    private int[] resizeArrayToBeBigger(){
        int[] moreItems = new int[count + 1];
        for (int i = 0; i < count ; i++) {
            moreItems[i] = items[i];
        }
        return moreItems;
    }

    private int[] resizeArrayToBeSmaller(){
        int[] lessItems = new int[count];
        for (int i = 0; i < count ; i++) {
            lessItems[i] = items[i];
        }
        return lessItems;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
