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

    public void remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        elements[0] = elements[--size];
        int index = 0;
        while(index <= size && !isValidParent(index)){
            int largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private boolean isValidParent(int index) {
        return elements[index] >= leftChildIndex(index) &&
                elements[index] >= rightChild(index);
    }

    private int largerChildIndex(int index) {
        return (leftChild(index) > rightChild(index)) ?
                        leftChildIndex(index) : rightChildIndex(index);
    }

    private int leftChild(int index) {
        return elements[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return elements[leftChildIndex(index)];
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void bubbleUp() {
        var index = size - 1;
        while (index > 0 && elements[index] > elements[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void bubbleDown() {
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
        elements[first] = elements[second];
        elements[second] = temp;
    }
}
