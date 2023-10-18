package com.nahayo.queue;

import com.nahayo.heap.Heap;

public class PriorityQueueWithHeap {
    private Heap heap = new Heap(10);
    public void enqueue(int item) {
        heap.insert(item);
    }
    public int dequeue() {
        return heap.remove();
    }
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
