package com.nahayo.heap;

public class Heap {
    private final int[] elements;

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

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        var root = elements[0];
        elements[0] = elements[--size];
        bubbleDown();
        return root;
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index)) {
            return true;
        }
        var isValid = elements[index] >= leftChild(index);
        if (hasRightChild(index)) {
            isValid &= elements[index] >= rightChild(index);
        }
        return isValid;
    }

    private int largerChildIndex(int index) {
        if (!hasLeftChild(index)) {
            return index; //always fill our nodes from left to right
        }
        if (!hasRightChild(index))  {
            return leftChildIndex(index);
        }
        return (leftChild(index) > rightChild(index)) ?
                leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) <= size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) <= size;
    }

    private int leftChild(int index) {
        return elements[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return elements[rightChildIndex(index)];
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

    public void bubbleDown() {
        int index = 0;
        while (index <= size && !isValidParent(index)) {
            int largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int first, int second) {
        var temp = elements[first];
        elements[first] = elements[second];
        elements[second] = temp;
    }

    public int max() {
        if(isEmpty()){
            throw new IllegalStateException();
        }
        return elements[0];
    }
}
