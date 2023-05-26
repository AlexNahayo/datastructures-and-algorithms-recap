package com.nahayo.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    public static final Map <Character,Integer> map2 = new HashMap<>();
    private static void addCharToValueAndCountToHashmap(String sentence){
        int count;
        for (int i = 0; i < sentence.length() ; i++) {
            count = 0;
            for (int j = 0; j < sentence.length(); j++) {
                if(sentence.charAt(i) == sentence.charAt(j)){
                    count++;
                }
            }
            map2.put(sentence.charAt(i),count);
        }
    }
    public static Character firstNonRepeatingChar(String sentence){
        addCharToValueAndCountToHashmap(sentence);
        char firstNonRepeatedChar = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if(map2.get(sentence.charAt(i)) == 1){
                firstNonRepeatedChar = sentence.charAt(i);
                break;
            }
        }
        return firstNonRepeatedChar;
    }

    public static Character firstRepeatingChar(String sentence){
        Set<Character> set = new HashSet<>();
        for(var ch : sentence.toCharArray()){
            if(set.contains(ch))
                return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
