package com.nahayo.search;

public class Search {
    public int linearSearch(int [] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearchRec(int [] array, int target) {
        return binarySearchRec(array, target, 0, array.length -1);
    }

    private int binarySearchRec(int [] array, int target, int left, int right) {

        if (right < left) {
            return -1;
        }

        int middle = (left + right) / 2;
        //check if time at middle is equal to target?
        if (array[middle] == target) {
            return middle;
        }
        //check value is in the left partition
        if (target < array[middle]) {
            return binarySearchRec(array, target, left, middle -1);
        }
        //check value is in the right partition
        return binarySearchRec(array, target, middle + 1, right);
    }


    public int binarySearch(int [] array, int target) {
        var left = 0;
        var right = array.length - 1;

        while (left <= right) {
            var middle = (left + right) / 2;

            if (array[middle] == target) {
                return middle; //we will return index of item here if it exists otherwise
            }

            if (target < array[middle]) {
                 right= middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
