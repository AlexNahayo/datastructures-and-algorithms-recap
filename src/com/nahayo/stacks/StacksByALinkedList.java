package com.nahayo.stacks;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class StacksByALinkedList {
    private int count = 0;

    LinkedList<Integer> stack;

    public StacksByALinkedList() {
     stack =  new LinkedList<>();
    }

    public void push(int item){
       stack.add(item);
        count++;
    }

    public int pop(){
        if (count <= 0){
            throw new EmptyStackException();
        }
        count--;
       return stack.removeLast();
    }

    public int peek() {
        if (count <= 0){
            throw new EmptyStackException();
        }
      return stack.getLast();
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public void printStack(){
        for (int i : stack ) {
            System.out.println(stack.get(i));
        }
    }
}
