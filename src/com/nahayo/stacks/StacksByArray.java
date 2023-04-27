package com.nahayo.stacks;

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

    public void printStack(){
        for (int i =0; i<stack.length;i++){
            System.out.println(stack[i]);
        }
    }
}
