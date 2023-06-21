package com.nahayo.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashTableExercises {

    public static int mostFrequent(int [] elements){
        Map<Integer, Integer> mappedElementsWithTally = mapElementsToOccurrenceTally(elements);
        System.out.println(mappedElementsWithTally);
        int unique = 0 ;
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
            int element;
            element = l;
            for (int m : elements) {
                if( l - m == k){
                    mapPairs.put(l,m);
                }
            }
        }
        return mapPairs.size();
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
