package com.nahayo.linkedlists;

import java.awt.*;
import java.util.NoSuchElementException;

public class LinkedList {
    private int nodeCount;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;

    public void addLast(int item) {
        nodeCount++;
        Node node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    public void addFirst(int item) {
        nodeCount++;
        Node node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
    }

    public int indexOf(int value) {
        Node pointer;
        int count = 0;
        pointer = first;
        while (pointer != null) {
            if (value == pointer.value) {
                return count;
            } else {
                pointer = pointer.next;
                count++;
            }
        }
        return -1;
    }

    public boolean contains(int item) {
        if (indexOf(item) != -1) {
            return true;
        } else {
            return false;
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (nodeCount == 1) {
            first = last = null;
        } else {
            Node pointer = first;
            pointer = first.next;
            first.next = null;
            first = pointer;
        }
        nodeCount--;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else if (nodeCount == 1) {
            first = last = null;
        } else {
            Node pointer = first;
            while (pointer.next.next != null) {
                pointer = pointer.next;
            }
            last = pointer;
            pointer.next = null;
        }
        nodeCount--;
    }

    public int size() {
        return nodeCount;
    }

    private boolean isEmpty() {
        if (first == null) {
            return true;
        } else {
            return false;
        }
    }

    public int[] toArray() {
        int array[] = new int[nodeCount];
        Node pointer = first;
        for (int i = 0; i < array.length; i++) {
            array[i] = pointer.value;
            pointer = pointer.next;
        }
        return array;
    }

    public void reverse() {
        if (isEmpty()) {
            return;
        }
        else {
            Node previous = first;
            Node current = previous.next;
            System.out.println(current);
            while (current!=null) {
                Node next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            last = first;
            last.next = null;
            first = previous;
        }
    }
}