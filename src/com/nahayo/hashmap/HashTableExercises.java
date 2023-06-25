package com.nahayo.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashTableExercises {

    public static int mostFrequent(int [] elements){
        Map<Integer, Integer> mappedElementsWithTally = mapElementsToOccurrenceTally(elements);
        Map.Entry<Integer,Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : mappedElementsWithTally.entrySet()){
            if(maxEntry == null || entry.getValue() > maxEntry.getValue()){
                maxEntry = entry;
            }
        }
        return maxEntry != null ? maxEntry.getKey() : -1;
    }

    public static int countPairsWithDiff(int [] elements, int k){
        Map<Integer,Integer> mapPairs = new HashMap<>();
        for (int l : elements){
            for (int m : elements) {
                if( l - m == k){
                    mapPairs.put(l,m);
                }
            }
        }
        return mapPairs.size();
    }

    public static Map<Integer,Integer> twoSum(int [] elements, int target){
        Map<Integer,Integer> twoSumIndexes = new HashMap<>();
        int x = -1, y = -1 ;
        outer : for (int l : elements){
            x++;
            for (int m : elements) {
                y++;
                if( l + m == target){
                    twoSumIndexes.put(x,y);
                    break outer;
                }
            }
            y = -1;
        }
        return twoSumIndexes;
    }

    private static Map<Integer, Integer>  mapElementsToOccurrenceTally(int [] elements){
        Map<Integer, Integer> mostFrequentTally = new HashMap<>();
        for (int k : elements) {
            int count = 0;
            int element;
            element = k;
            for (int i : elements) {
                if (element == i) {
                    count++;
                }
            }
            mostFrequentTally.put(k, count);
        }
        return mostFrequentTally;
    }
}
