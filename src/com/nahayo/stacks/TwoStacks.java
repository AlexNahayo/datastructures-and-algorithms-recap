package com.nahayo.stacks;


/**
 * Question:
 * Implement two stacks in one array. Support these operations:
 * push1() // to push in the first
 * stackpush2() // to push in the second stack
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

    public void push1(int item){
        if(stack1Count < twoStackSize.length/2)
            twoStackSize[stack1Count] = item;
            stack1Count++;
        }

    public void push2(int item){
        if(stack2Count < twoStackSize.length/2) {
            twoStackSize[twoStackSize.length / 2 + stack2Count] = item;
            stack2Count++;
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
            System.out.println(item);
        }
    }

    //Todo - pop1 and pop2 methods as well as some more tests. 
}
