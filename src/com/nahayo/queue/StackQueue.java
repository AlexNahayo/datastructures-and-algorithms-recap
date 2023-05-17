package com.nahayo.queue;

import java.util.Stack;

public class StackQueue  {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public StackQueue() {
    }

    public void enqueue(int item){
        stack1.push(item);
    }

    public int dequeue(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        moveStack1ToStack2();
        return stack2.pop();
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int peek(){
        if(isEmpty()){
            throw new IllegalStateException();
        }
        moveStack1ToStack2();
        return stack2.peek();
    }

    private void moveStack1ToStack2() {
        if(stack2.isEmpty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
    }
}
