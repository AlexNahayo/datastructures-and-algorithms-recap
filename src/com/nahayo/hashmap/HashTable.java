package com.nahayo.hashmap;

import java.util.Arrays;

public class HashTable {
    String [] hashTableArray;

    //Todo -> Put, Get remove methods
    //put(k,v)
    //get(k) returns v
    //remove(k)
    // Key -> int
    // Value -> String
    // Collision -> chaining methods

    public void put(int key, String value){
        if(key > hashTableArray.length) {
            key = hash(key);
        }
        hashTableArray[key] = value;
    }

    public String get (int key){
        if (key > hashTableArray.length){
            throw new IndexOutOfBoundsException();
        }
        return hashTableArray[key];
    }
    public HashTable(int size) {
        hashTableArray = new String[size];
    }

    private int hash(int number){
        return number % hashTableArray.length;
    }

    @Override
    public String toString() {
        return  Arrays.toString(hashTableArray);
    }
}
