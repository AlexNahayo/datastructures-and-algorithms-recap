package com.nahayo.sort;

public class InsertionSort {
    public static void sort(int array[]) {
        for (int i = 1; i < array.length; i++) {
            var current =  array[i];
            //inner loop to check all previous items and check if they are greater than current.
            var j = i - 1;
            while (j >= 0 && array[j] > current) { //shifting of elements happens here
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }
}
