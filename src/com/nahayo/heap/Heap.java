package com.nahayo.heap;

public class Heap {
    private final int [] elements;

    private int size;

    public Heap(int size) {
       elements = new int[size];
    }

    public void insert(int element) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        elements[size++] = element;
        bubbleUp();
    }

    public boolean isFull() {
        return size == elements.length;
    }
    private void bubbleUp() {
        var index = size - 1;
        while (index > 0 && elements[index] > elements[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }
    private int parent(int index) {
        return (index - 1 ) / 2 ;
    }

    private void swap(int first, int second) {
        var temp = elements[first];
        elements[first] = elements [second];
        elements[second] = temp;
    }
}
