package com.nahayo.sort;

public class MergeSort {
    public static void sort (int[] array) {
        if (array.length < 2) {
            return;
        }
        //divide this array into half
        var middle =  array.length / 2 ;

        int[] left = new int[middle];
        for (int i = 0; i < middle ; i++) {
            left[i] =  array[i];
        }
        int[] right = new int[array.length - middle];
        for (int i = middle; i < array.length ; i++) {
            right[i - middle] =  array[i];
        }
        //sort each half using recursion
        sort(left);
        sort(right);
        //merge the result
        merge(left, right, array);
    }
    private static void merge(int left[], int right[], int result[]) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        //in case where for example left partition has 3 items and right partition has 30 items.
        //copy the remaining items in our result array
        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }
    }
}
