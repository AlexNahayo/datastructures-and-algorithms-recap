package com.nahayo.stacks;

import java.util.EmptyStackException;

public class StacksByArray<T> {
    private int count = 0;
    int[] stack;
    public StacksByArray() {
         stack = new int[0];
    }
    //push
    public void push(int item){
        count++;
        int[] biggerStack = new int[count];
        for (int i=0; i<stack.length;i++){
            biggerStack[i] =  stack[i];
        }
        stack = biggerStack;
        stack[count - 1] = item;
    }
    //pop
    public int pop(){
        if (count <= 0){
            throw new EmptyStackException();
        }
        else {
            count--;
            int poppedItem;
            int[] smallerStack = new int[count];
            for (int i=0; i<smallerStack.length;i++){
                smallerStack[i] =  stack[i];
            }
            poppedItem = stack[stack.length -1];
            stack = smallerStack;
            return poppedItem;
        }
    }
    public void printStack(){
        for (int i =0; i<stack.length;i++){
            System.out.println(stack[i]);
        }
    }
}
