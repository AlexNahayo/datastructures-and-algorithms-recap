package com.nahayo.stacks;


import java.util.EmptyStackException;

/**
 * Question:
 * Implement two stacks in one array. Support these operations:
 * push1() // to push in the first stack
 * push2() // to push in the second stack
 * pop1()
 * pop2()
 * isEmpty1()
 * isEmpty2()
 * isFull1()
 * isFull2()
 *
 * Make sure your implementation is space efficient.
 * (hint: do not allocate the same amount of space by dividing the array in half.)
 *
 * Below is a Class that tries to solve the above.
 *
 * @author  Alex Nahayo
 */
public class TwoStacks {

    int[] twoStackSize;

    int stack1Count = 0;

    int stack2Count = 0;

    public TwoStacks(int size) {
        if(!(size % 2 == 0)){
            throw new NumberFormatException();
        }
        else {
            twoStackSize = new int[size];
        }
    }

    public void push1(int item) {
        if (stack1Count < twoStackSize.length / 2) {
            twoStackSize[stack1Count] = item;
            stack1Count++;
        }
    }

    public void push2(int item){
        if(stack2Count < twoStackSize.length/2) {
            twoStackSize[twoStackSize.length / 2 + stack2Count] = item;
            stack2Count++;
        }
    }

    public int pop1(){
        if(stack1Count == 0 ){
            throw new EmptyStackException();
        }
        else {
            int popped1Item = peek1();
            twoStackSize[stack1Count - 1] = 0;
            stack1Count--;
            return popped1Item;
        }
    }

    public int pop2(){
        if(stack2Count == 0 ){
            throw new EmptyStackException();
        }
        else {
            int popped2Item = peek2();
            twoStackSize[twoStackSize.length/2 + stack2Count - 1] = 0;
            stack2Count--;
            return popped2Item;
        }
    }

    public boolean isEmpty1() {
        return stack1Count == 0;
    }

    public boolean isEmpty2(){
        return stack2Count ==0;
    }

    public boolean isFull1(){
        return stack1Count == twoStackSize.length/2;
    }

    public boolean isFull2(){
        return stack2Count == twoStackSize.length/2;
    }

    public void printStack(){
        for (int item : twoStackSize){
            System.out.print(" " +item + " ");
        }
    }

    public int peek1(){
        if (stack2Count ==0){
            throw new EmptyStackException();
        }
        else {
            return twoStackSize[stack1Count - 1];
        }
    }

    public int peek2(){
        if (stack2Count ==0){
            throw new EmptyStackException();
        }
        else {
            return twoStackSize[twoStackSize.length/2 + stack2Count - 1 ];
        }
    }
}
