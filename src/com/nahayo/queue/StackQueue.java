package com.nahayo.queue;

import java.util.Stack;

public class StackQueue  {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    int stack1Count, stack2Count;

    public StackQueue() {

    }

    public void enqueue(int item){
        while(!stack2.empty()){
            stack1.add(stack2.pop());
        }
            stack1.add(item);
        // To do if count < 2 do xxx
    }

    public int dequeue(){
        while(!stack1.empty()){
            stack2.add(stack1.pop());
        }
        return stack2.pop();
    }
// TO DO - peak, isEmpty, isFull methods

// Using this method for testing atm
    public void printQueue(){
        while (!stack2.isEmpty()){
            System.out.print(stack2.pop() +  " ");
        }

        while (!stack1.isEmpty()){
            System.out.print(stack1.pop() +  " ");
        }

    }
}
