package com.nahayo.sort;

public class SelectionSort {
    public static void sort (int[] array) {
        for (int i = 0; i < array.length; i++) {
            var minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                    swamp(array, minIndex, i);
                }
            }

        }
    }

    private static void swamp(int [] array, int index1, int index2) {
        var temp =  array[index1];
        array[index1] = array[index2];
        array[index2]  = temp;
    }

}
