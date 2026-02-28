package com.nahayo.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeRanks {

    /**Time 0(n log n) & Space O(n)**/
    public String[] findRelativeRanks(int[] score) {

        int n = score.length;
        String[] result = new String[n];

        // store indices
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // sort indices based on score descending
        Arrays.sort(indices, (a, b) -> score[b] - score[a]);

        // assign ranks
        for (int rank = 0; rank < n; rank++) {

            int originalIndex = indices[rank];

            if (rank == 0)
                result[originalIndex] = "Gold Medal";
            else if (rank == 1)
                result[originalIndex] = "Silver Medal";
            else if (rank == 2)
                result[originalIndex] = "Bronze Medal";
            else
                result[originalIndex] = String.valueOf(rank + 1);
        }

        return result;
    }

    /***
     ** Below was the original solution I came up with.
     ***/
    public String[] findRelativeRanksOriginal(int[] score) {

        //create an orginal map 1 which will track original postion of the scores
        // so that we can build the final array.
        Map<Integer, Integer> originaPosMap = new HashMap<>();

        //loop through score array and store key : value , were key is the score, so score[i]
        //and the value which is the index of a given score.
        int count = 0;
        for (int sc : score) {
            originaPosMap.put(sc, count++);
        }
        //now we have map 1 which has the stored positions

        // 1) we need sort the score array in decending order
        // 2) create a new map to store "key" as score and value as the podium ranking i.e. "Gold".

        //sorted the array.
        Arrays.sort(score);

        //created map for the score and ranking.
        Map<Integer, String> scoreAndRankMap = new HashMap<>();

        count = 0;
        //looping through score array in descending order and store score and rank.
        for( int i = score.length -1; i >= 0; i--) {
            if (count == 0) // Gold Medal.
                scoreAndRankMap.put(score[i], "Gold Medal");
            else if  (count == 1) // Silver Medal.
                scoreAndRankMap.put(score[i], "Silver Medal");
            else if (count == 2) // Bronze Medal.
                scoreAndRankMap.put(score[i], "Bronze Medal");
            else
                scoreAndRankMap.put(score[i], count + 1+"");
            count++;
        }

        String[] result = new String[score.length]; //created a new array for storing the final result.

        //iterate through scoreAndRankMap map and for each key, call the orginalMap and retrieve its position and store the value into that position in the result array
        scoreAndRankMap.forEach((k, v) -> {
            //using the key here retrieve the position and store value in result array
            int position = originaPosMap.get(k);
            result[position] = v;
        });

        return result;
    }
}
