package com.nahayo.heap;

public class Heap {
    int [] elements;

    int count;

    public Heap(int size) {
       elements = new int[size];
    }

    public void insert(int element) {
        //when heap is empty, then just add element to the first position in the array
        if (count == 0) {
            elements[0] = element;
        }
        //when the heap is full the just through an exception
        else if (count == elements.length) {
            throw new IndexOutOfBoundsException();
        }
        else {

            //loop through array until you get into the next available slot.
            for (int i = 1; i < elements.length ; i++) {
                //check for correct insertion
                if (elements[i] == 0  && elements[i] >= element) {
                    elements[i] = element;
                    break;
                }
                else {

                }
            }
            count++;

            //given a fixed sized heap
            //1) check is Left Child exists (using LC formula "parent * 2 + 1")
            //1) a check if parent child.vale in greater than new element.value
        }

    }
}
