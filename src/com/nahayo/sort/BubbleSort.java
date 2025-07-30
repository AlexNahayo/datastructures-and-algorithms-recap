package com.nahayo.sort;

public class BubbleSort {

    public void sort (int[] array) {
        boolean isSorted;
        for (int i = 0; i < array.length; i++) {
            //to compare ever two items of
            isSorted = true;
            for (int j = 1; j < array.length - i; j++) {
                //compare with previous item
                if (array[j] < array[j -1]) {
                    swamp(array, j, j - 1);
                    isSorted = false;
                }
            }
            if (isSorted)
                return;
        }
    }

    private void swamp(int [] array, int index1, int index2) {
        var temp =  array[index1];
        array[index1] = array[index2];
        array[index2]  = temp;
    }
}
