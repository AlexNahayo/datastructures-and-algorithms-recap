package com.nahayo.leetcode.arrays;

class MergeSortArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int [] merged = new int[m + n];

        int i = 0;
        int j  = 0;

        //this loop with compare elements in nums1 vs nums2 and store the smallerst in the the merged array
        int k = 0;
        while( i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];;
            }
        }

        //if there are any remaining values i.e. array nums1 is bigger, all elements in nums2 is smaller than nums1 etc.

        //remaining elements in nums1
        while (i < m) {
            merged[k++] =  nums1[i++];
        }

        //remaining elements in nums2
        while (j < n) {
            merged[k++] =  nums2[j++];
        }

        //copying remaining elements back to original array.
        for (int x = 0; x < m + n; x++) {
            nums1[x] = merged[x];
        }
    }
}
