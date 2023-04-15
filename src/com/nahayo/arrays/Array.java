package com.nahayo.arrays;

public class Array {
    private int size;
    private int array[] = new int[size];
    private int count = 0;
    public Array(int size) {
        this.size = size;
    }

    public void print(){
        for (int i =0; i<array.length;i++){
            System.out.println(array[i]);
        }
    }

    public void insert(int item){
        count++;
        if(array.length > count){
            array[count - 1] = item;
        }
        else {
            int biggerArray[] = new int[count*2];
            for (int i=0; i<array.length;i++){
                biggerArray[i] =  array[i];
            }
            array = biggerArray;
            array[count - 1] = item;
        }
    }

    public void removeAt(int index) {
        if(index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        for(int i = index; i<count;i++) {
            array[i] = array[i + 1];
        }
        count--;
    }

    public int indexOf(int item) {
        for( int i = 0; i<count; i++){
            if(item == array[i]){
                return i;
            }
        }
        return -1;
    }

    public int max(){
        if(count == 0) {
            return -1;
        }
        int maxNumber = 0;
        for(int i =0; i<count; i++){
            if(array[i] > maxNumber){
                maxNumber = array[i];
            }
        }
        return maxNumber;
    }

    public void intersect(int [] secondArray){
        for (int i = 0;i<secondArray.length;i++){
            for (int j = 0; j < count; j++) {
                if(secondArray[i] == array[j]){
                    System.out.println(array[j]+ " ");
                }
            }
        }
    }

    public Array reverse(){
        Array reversedArray = new Array(count);
        for (int i = count - 1; i >= 0 ; i--) {
            reversedArray.insert(array[i]);
        }
        return reversedArray;
    }

    public void insertAt(int item, int index){
        int newArray[] = new int[count+ 1];
        for(int i  = 0; i<newArray.length ; i++){
            if( i <= index - 1 )
                newArray[i] = array[i];
            else if (i == index ){
                newArray[i] =  item;
            }
            else
                newArray[i] = array[i - 1 ];
        }
        array = newArray;
    }
}