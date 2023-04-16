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
        } else {
            Node previous = first;
            Node current = previous.next;
            System.out.println(current);
            while (current != null) {
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

    public int getKthFromTheEnd(int k) {
        Node p1 = first;
        Node p2 = first;
        for (int i = 0; i <= k - 1; i++) {
            p2 = p2.next;
            if (p2 == null) {
                throw new IllegalArgumentException();
            }
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1.value;
    }

    public void printMiddle() {
        int size = 0;
        Node p1 = first;
        Node p2 = first;
        while (p1 != null) {
            p1 = p1.next;
            size++;
        }
        if (size % 2 == 0) {
            for (int i = 0; i < size / 2 - 1; i++) {
                p2 = p2.next;
            }
            System.out.println(p2.value);
            System.out.println(p2.next.value);
        } else {
            for (int i = 0; i < size / 2; i++) {
                p2 = p2.next;
            }
            System.out.println(p2.value);
        }
    }

    public void printMiddleInOnePass() {
        if (first == null) {
            throw new IllegalStateException();
        } else {
            Node p1 = first;
            Node p2 = first;
            while (p2 != last && p2.next != last) {
                p2 = p2.next.next;
                p1 = p1.next;
            }
            if (p2 == last) {
                System.out.println(p1.value);
            } else {
                System.out.println(p1.value);
                System.out.println(p1.next.value);
            }
        }
    }
}